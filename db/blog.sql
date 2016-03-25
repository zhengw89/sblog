use blog;

drop view if exists v_tag_post;

drop table if exists t_user;
drop table if exists t_tag;
drop table if exists t_post;
drop table if exists t_post_tag;

CREATE TABLE `t_user` (
  `USER_ID` varchar(36) NOT NULL,
  `DisplayName` varchar(100) NOT NULL,
  `Password` varchar(36) NOT NULL,
  `CreateTime` datetime NOT NULL,
  `UpdateTime` datetime NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_tag` (
  `TAG_ID` varchar(36) NOT NULL,
  `TAG_Name` varchar(100) NOT NULL,
  `CreateTime` datetime NOT NULL,
  `UpdateTime` datetime NOT NULL,
  PRIMARY KEY (`TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_post` (
  `POST_ID` varchar(36) NOT NULL,
  `POST_Stauts` int NOT NULL,
  `POST_Title` varchar(100) NOT NULL,
  `POST_Content` text NOT NULL,
  `POST_RenderedContent` text NOT NULL,
  `POST_PublishTime` datetime NULL,
  `CreateTime` datetime NOT NULL,
  `UpdateTime` datetime NOT NULL,
  PRIMARY KEY (`POST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_post_tag` (
  `PT_ID` varchar(36) NOT NULL,
  `POST_ID` varchar(36) NOT NULL,
  `TAG_ID` varchar(36) NOT NULL,
  `CreateTime` datetime NOT NULL,
  `UpdateTime` datetime NOT NULL,
  PRIMARY KEY (`PT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW t_tag_post AS
SELECT Tag.TAG_ID,Tag.TAG_Name,Post.POST_ID,Post.POST_Title,Post.POST_Stauts,Post.POST_PublishTime 
FROM t_post Post
INNER JOIN t_post_tag PostTag ON Post.POST_ID = PostTag.POST_ID
INNER JOIN t_tag Tag ON PostTag.TAG_ID = Tag.TAG_ID;

insert into t_user values ('admin','Administrator','123',now(),now());