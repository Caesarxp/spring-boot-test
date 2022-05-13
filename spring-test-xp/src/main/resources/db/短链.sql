CREATE TABLE `tp_shorturl_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `original_url` varchar(512) DEFAULT NULL COMMENT '原链接',
  `url_name` varchar(64) DEFAULT NULL COMMENT '链接名称',
  `short_url` varchar(16) DEFAULT NULL COMMENT '短链接',
  `url_status` int(11) DEFAULT NULL COMMENT '申请状态：0-失效，1-有效',
  `create_time` datetime DEFAULT NULL COMMENT '生成时间',
  `by_time` datetime DEFAULT NULL COMMENT '截止时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '审核原因',
  `platform_code` varchar(16) DEFAULT NULL COMMENT '平台标识',
  `app_id` varchar(50) DEFAULT NULL COMMENT '应用id',
  `app_name` varchar(32) DEFAULT NULL COMMENT '应用名称',
  `extend` varchar(16) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='短链';

CREATE TABLE `tp_shorturl_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `service_origin` varchar(50) DEFAULT NULL COMMENT '应用类型-服务来源  SELF-自有能力，THIRD-第三方',
  `app_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
  `shorturl_num` varchar(16) DEFAULT NULL COMMENT '短链个数',
  `send_num` bigint(11) DEFAULT NULL COMMENT '下发量',
  `click_num` bigint(16) DEFAULT NULL COMMENT '点击数量',
  `click_rate` bigint(16) DEFAULT NULL COMMENT '点击率',
  `platform_code` varchar(16) DEFAULT NULL COMMENT '平台标识',
  `app_id` varchar(50) DEFAULT NULL COMMENT '应用id',
  `report_time` date DEFAULT NULL COMMENT '日期',
  `extend` varchar(16) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='短链数据统计';

