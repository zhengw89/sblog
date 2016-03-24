package com.sblog.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sblog.beans.PostTag;
import com.sblog.beans.Post;
import com.sblog.beans.PostStatus;
import com.sblog.repositories.IPostRepository;
import com.sblog.repositories.IPostTagRepository;

@Service("postService")
@Transactional
public class PostService extends BaseService implements IPostService {
	
	@Autowired
	private IPostRepository postRepository;
	
	@Autowired
	private IPostTagRepository postTagRepository;

	public List<Post> getLatestPublishedPosts(int count) {
		return this.postRepository.getLatest(PostStatus.Published, count);
	}

	public List<Post> getAllPublishedPosts() {
		return this.postRepository.get(PostStatus.Published);
	}

	public Post getPostById(String postId) {
		if(postId == null) return null;
		return this.postRepository.getByPostId(postId);
	}

	public List<Post> getPublishedPostsByTag(String tagId) {
		if(tagId == null) return null;
		return this.postRepository.getByTag(tagId, PostStatus.Published);
	}

	public boolean CreatePost(String title, String content, String[] tagIds) {
		if(title == null || content == null) return false;
		
		String postId = UUID.randomUUID().toString();
		Post post = new Post();
		post.setContent(content);
		post.setCreateTime(new Date());
		post.setId(postId);
		post.setPublishTime(new Date());
		post.setRenderedContent(new PegDownProcessor().markdownToHtml(content));
		post.setStatus(PostStatus.Published);
		post.setTitle(title);
		post.setUpdateTime(new Date());
		
		if(tagIds != null){
			for (String tagId : tagIds) {
				postTagRepository.create(new PostTag(postId, tagId));
			}
		}
		
		return this.postRepository.create(post);
	}

	public List<Post> getAll() {
		return this.postRepository.get();
	}

}
