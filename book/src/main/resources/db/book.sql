

CREATE TABLE IF NOT EXISTS `items` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`  BIGINT(20)  NULL,
    `book_id`  BIGINT(20)  NULL,
    `type`  BIGINT(20)  NULL,
    `status`  BIGINT(20)  NULL,
    `image`  VARCHAR(512)  NULL,
    `date`  DATETIME  NULL,
    `note`  VARCHAR(512)  NULL,
    `consume_type`  BIGINT(20)  NULL,
    `amount`  BIGINT(20)  NULL,
    `longitude`  VARCHAR(512)  NULL,
    `latitude`  VARCHAR(512)  NULL,
    `created_at`  DATETIME  NULL,
    `updated_at`  DATETIME  NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `account_reminds` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id`  BIGINT(20)  NULL,
  `book_id`  BIGINT(20)  NULL,
  `type`  BIGINT(20)  NULL,
  `status`  BIGINT(20)  NULL,
  `name`  VARCHAR(512)  NULL,
  `end_time`  DATETIME  NULL,
  `remind_time`  DATETIME  NULL,
  `repeat_time`  BIGINT(20)  NULL,
  `amount`  BIGINT(20)  NULL,
  `is_auto_mark`  TINYINT(1)  NULL,
  `consume_type`  BIGINT(20)  NULL,
  `created_at`  DATETIME  NULL,
  `updated_at`  DATETIME  NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `books` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id`  BIGINT(20)  NULL,
  `type`  BIGINT(20)  NULL,
  `name`  VARCHAR(512)  NULL,
  `is_default`  TINYINT(1)  NULL,
  `status`  BIGINT(20)  NULL,
  `budget`  BIGINT(20)  NULL,
  `settlement_time`  DATETIME  NULL,
  `id_remind`  TINYINT(1)  NULL,
  `color`  VARCHAR(512)  NULL,
  `store_type`  BIGINT(20)  NULL,
  `created_at`  DATETIME  NULL,
  `updated_at`  DATETIME  NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `consume_types` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(512)  NULL,
  `status`  BIGINT(20)  NULL,
  `image`  VARCHAR(512)  NULL,
  `created_at`  DATETIME  NULL,
  `updated_at`  DATETIME  NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `feed_backs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id`  BIGINT(20)  NULL,
  `status`  BIGINT(20)  NULL,
  `content`  VARCHAR(512)  NULL,
  `created_at`  DATETIME  NULL,
  `updated_at`  DATETIME  NULL,
  PRIMARY KEY (`id`)
);