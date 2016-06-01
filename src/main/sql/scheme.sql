CREATE DATABASE seckill;
USE seckill;
CREATE TABLE `seckill` (
  `id`          BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `name`        VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  `number`      INT          NOT NULL
  COMMENT '商品数量',
  `start_time`  TIMESTAMP    NOT NULL
  COMMENT '秒杀开始时间',
  end_time    TIMESTAMP    NOT NULL
  COMMENT '秒杀结束时间',

  'create_time' TIMESTAMP    NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)

)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀库存表';

INSERT INTO
  seckill.seckill (name, number, start_time, end_time)
VALUES
  ('1000元秒杀iphone6', 100, '2016-02-03 11:00:00', '2016-02-04 11:00:00'),
  ('500元秒杀ipad2', 200, '2016-02-03 11:00:00', '2016-02-04 11:00:00'),
  ('400元秒杀小米4', 300, '2016-02-03 11:00:00', '2016-02-04 11:00:00'),
  ('200元秒杀红米NOTE', 400, '2016-02-03 11:00:00', '2016-02-04 11:00:00');

CREATE TABLE success_killed (
  'seckill_id' BIGINT NOT NULL COMMENT '秒杀商品ID',
  'user_phone' BIGINT NOT NULL COMMENT '用户手机号',
  'state' TINYINT NOT NULL DEFAULT -1 COMMENT '状态标示 -1表示无效， 0表示成功，1表示已付款',
  'create_time' TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀成功明细表';