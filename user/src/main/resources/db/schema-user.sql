
-- 用户基本信息表

create table if not exists users (
  `id`           bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
  `user_name`    varchar(64)   DEFAULT null COMMENT '用户名',
  `mobile`       varchar(32)   DEFAULT null COMMENT '手机号',
  `email`        varchar(32)   DEFAULT null COMMENT '邮箱',
  `password`     varchar(32)   DEFAULT null COMMENT '密码',
  `qq_token`     varchar(128)  DEFAULT null COMMENT 'qqToken',
  `weixin_token` varchar(128)  DEFAULT null COMMENT '微信Token',
  `weibo_token`  varchar(128)  DEFAULT null COMMENT '微博Token',
  `nickname`     varchar(64)   DEFAULT null COMMENT '昵称',
  `type`         integer       DEFAULT null COMMENT '用户类型, 1:管理员, 2:普通用户',
  `status`       integer       DEFAULT null COMMENT '状态',
  `gender`       integer       DEFAULT null COMMENT '性别',
  `birthday`     datetime      DEFAULT null COMMENT '出生年月',
  `image`        varchar(256)  DEFAULT null COMMENT '头像地址',
  `created_at`   datetime      DEFAULT null COMMENT '创建时间',
  `updated_at`   datetime      DEFAULT null COMMENT '更新时间',
  PRIMARY KEY (`id`)
);

-- qq登录信息表

create table if not exists qq_token_models (
  `id`                     bigint(20)      unsigned NOT NULL AUTO_INCREMENT,
  `user_id`                bigint(20)      DEFAULT null,
  `ret`                    varchar(128)    DEFAULT null,
  `pay_token`              varchar(128)    DEFAULT null,
  `pf`                     varchar(128)    DEFAULT null,
  `query_authority_cost`   varchar(128)    DEFAULT null,
  `authority_cost`         varchar(128)    DEFAULT null,
  `open_id`                varchar(128)    DEFAULT null,
  `expirse_in`             varchar(128)    DEFAULT null,
  `pf_key`                 varchar(128)    DEFAULT null,
  `msg`                    varchar(128)    DEFAULT null,
  `access_token`           varchar(128)    DEFAULT null,
  `login_cost`             varchar(128)    DEFAULT null,
  `created_at`             datetime        DEFAULT null,
  `updated_at`             datetime        DEFAULT null,
  PRIMARY KEY (`id`)
);

-- qq详细信息表

create table if not exists qq_token_models (
  `id`                     bigint(20)      unsigned NOT NULL AUTO_INCREMENT,
  `user_id`                bigint(20)      DEFAULT null,
  `is_yellow_year_vip`     tinyint         DEFAULT null,
  `ret`                    varchar(128)    DEFAULT null,
  `figureurl_qq_1`         varchar(256)    DEFAULT null,
  `level`                  varchar(128)    DEFAULT null,
  `figureurl_qq_2`         varchar(256)    DEFAULT null,
  `nickname`               varchar(128)    DEFAULT null,
  `yellow_vip_level`       varchar(128)    DEFAULT null,
  `is_lost`                tinyint         DEFAULT null,
  `msg`                    varchar(128)    DEFAULT null,
  `city`                   varchar(128)    DEFAULT null,
  `figureurl_1`            varchar(256)    DEFAULT null,
  `vip`                    varchar(128)    DEFAULT null,
  `figureurl_2`            varchar(256)    DEFAULT null,
  `province`               varchar(128)    DEFAULT null,
  `is_yellow_vip`          tinyint         DEFAULT null,
  `gender`                 integer         DEFAULT null,
  `figureurl`              varchar(256)    DEFAULT null,
  `created_at`             datetime        DEFAULT null,
  `updated_at`             datetime        DEFAULT null,
  PRIMARY KEY (`id`)
);
