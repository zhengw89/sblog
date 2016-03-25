package com.sblog.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sblog.beans.PostTag;
import com.sblog.beans.Tag;
import com.sblog.beans.Post;
import com.sblog.beans.PostStatus;
import com.sblog.repositories.IPostRepository;
import com.sblog.repositories.IPostTagRepository;
import com.sblog.repositories.ITagRepository;

@Service("postService")
@Transactional
public class PostService extends BaseService implements IPostService {
	
	@Autowired
	private IPostRepository postRepository;
	
	@Autowired
	private IPostTagRepository postTagRepository;
	
	@Autowired
	private ITagRepository tagRepository;

	@Cacheable(value = POST_CACHE_NAME, key = "#root.methodName")
	public List<Post> getLatestPublishedPosts(int count) {
		return this.postRepository.getLatest(PostStatus.Published, count);
	}

	@Cacheable(value = POST_CACHE_NAME, key = "#root.methodName")
	public List<Post> getAllPublishedPosts() {
		return this.postRepository.get(PostStatus.Published);
	}

	@Cacheable(value = POST_CACHE_NAME, key = "#postId")
	public Post getPostById(String postId) {
		if(postId == null) return null;
		Post post =  this.postRepository.getByPostId(postId);
		
		if(post != null){
			List<Tag> tags = this.tagRepository.getByPost(postId);
			post.setTags(tags);
		}
		
		return post;
	}

	@Cacheable(value = POST_CACHE_NAME, key = "#tagId")
	public List<Post> getPublishedPostsByTag(String tagId) {
		if(tagId == null) return null;
		return this.postRepository.getByTag(tagId, PostStatus.Published);
	}

	@Caching(evict = {
			@CacheEvict(value = POST_CACHE_NAME, allEntries = true),
			@CacheEvict(value = ITagService.TAG_CACHE_NAME, allEntries = true)
	})
	public boolean createPost(String title, String content, String[] tagIds) {
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
				this.postTagRepository.create(new PostTag(postId, tagId));
			}
		}
		
		return this.postRepository.create(post);
	}

	@Cacheable(value = POST_CACHE_NAME, key = "#root.methodName")
	public List<Post> getAll() {
		return this.postRepository.get();
	}
	
	@Caching(evict = {
			@CacheEvict(value = POST_CACHE_NAME, allEntries = true),
			@CacheEvict(value = ITagService.TAG_CACHE_NAME, allEntries = true)
	})
	public boolean editPost(String id, String title, String content, String[] tagIds){
		if(id == null || title == null || content == null)return false;
		
		Post post = this.postRepository.getByPostId(id);
		post.setContent(content);
		post.setRenderedContent(new PegDownProcessor().markdownToHtml(content));
		post.setTitle(title);
		post.setUpdateTime(new Date());
		
		this.postTagRepository.deleteByPost(id);
		if(tagIds != null){
			for (String tagId : tagIds) {
				this.postTagRepository.create(new PostTag(id, tagId));
			}
		}
		
		return this.postRepository.update(post);
	}

	@Caching(evict = {
			@CacheEvict(value = POST_CACHE_NAME, allEntries = true),
			@CacheEvict(value = ITagService.TAG_CACHE_NAME, allEntries = true)
	})
	public boolean deletePost(String postId) {
		if(postId == null) return false;
		if(!this.postRepository.exists(postId)) return true;
		
		this.postRepository.delete(postId);
		this.postTagRepository.deleteByPost(postId);
		
		return true;
	}

}
