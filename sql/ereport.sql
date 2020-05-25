/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.16-log : Database - ereport
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ereport` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ereport`;

/*Table structure for table `databasesource` */

DROP TABLE IF EXISTS `databasesource`;

CREATE TABLE `databasesource` (
  `datasource_id` varchar(255) DEFAULT NULL COMMENT '数据源的id',
  `url` varchar(255) DEFAULT NULL COMMENT '连接信息',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) DEFAULT NULL COMMENT '密码',
  `code` varchar(255) DEFAULT NULL COMMENT '暂留字段',
  `databasetype` varchar(255) DEFAULT NULL COMMENT '数据库类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `databasesource` */

/*Table structure for table `db_info` */

DROP TABLE IF EXISTS `db_info`;

CREATE TABLE `db_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '数据源名称',
  `db_name` varchar(64) DEFAULT NULL COMMENT '数据库名称',
  `db_ip` varchar(64) DEFAULT NULL COMMENT '数据库服务器ip',
  `db_port` varchar(64) DEFAULT NULL COMMENT '数据库端口',
  `db_user` varchar(64) DEFAULT NULL COMMENT '数据库账号',
  `db_passwd` varchar(64) DEFAULT NULL COMMENT '密码',
  `db_driver_class_name` varchar(64) DEFAULT NULL COMMENT 'jdbc驱动',
  `url` varchar(128) DEFAULT NULL COMMENT '连接字符串',
  `db_type` varchar(32) DEFAULT NULL COMMENT '数据库类型 mysql oracle sqlserver',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `db_info` */

insert  into `db_info`(`id`,`name`,`db_name`,`db_ip`,`db_port`,`db_user`,`db_passwd`,`db_driver_class_name`,`url`,`db_type`,`remark`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`) values (1,'测试数据源1','test2','192.168.0.109','3306','root','dz007','com.mysql.jdbc.Driver','jdbc:mysql://localhost:3306/ereport?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull','mysql',NULL,NULL,NULL,NULL,NULL,'0'),(2,'测试数据源2','test3','192.168.0.109','3306','root','dz007','com.mysql.jdbc.Driver','jdbc:mysql://localhost:3306/ereport?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull','mysql',NULL,NULL,NULL,NULL,NULL,'0'),(3,'测试','test4','127.0.0.1','1521',NULL,NULL,'oracle.jdbc.OracleDriver','jdbc:oracle:thin:@10.1.255.200:1521:orcl','oracle',NULL,NULL,NULL,NULL,NULL,'0'),(4,'ERP数据源t6','dhh','192.168.0.109','1433','sa','as','com.microsoft.sqlserver.jdbc.SQLServerDriver','jdbc:sqlserver://192.168.0.189:1433; DatabaseName=sample','mysql',NULL,NULL,NULL,1,'2020-04-22 16:57:58','0');

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values ('RuoyiScheduler','__TASK_CLASS_NAME__3','DEFAULT','0/20 * * * * ?','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values ('DongzheScheduler','__TASK_CLASS_NAME__3','DEFAULT',NULL,'com.dongzhe.quartz.util.ScheduleJob','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0!com.boshland.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0#com.boshland.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0h��xpt\0\0pppt\00/20 * * * * ?t\0系统默认（有参数）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0bTaskt\0\nryNoParamspt\01t\01x\0'),('RuoyiScheduler','__TASK_CLASS_NAME__3','DEFAULT',NULL,'com.dongzhe.quartz.util.ScheduleJob','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0!com.boshland.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0#com.boshland.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminppt\0\0pppt\00/20 * * * * ?t\0系统默认（有参数）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0bTaskt\0\nryNoParamst\0\0t\01t\01x\0');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values ('DongzheScheduler','STATE_ACCESS'),('DongzheScheduler','TRIGGER_ACCESS'),('RuoyiScheduler','STATE_ACCESS'),('RuoyiScheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`sched_name`,`instance_name`,`last_checkin_time`,`checkin_interval`) values ('DongzheScheduler','DESKTOP-I5S59CH1587545810064',15875477800,15000),('RuoyiScheduler','DESKTOP-6V2VLT71549865885139',15498661600,15000);

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`) USING BTREE,
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values ('RuoyiScheduler','__TASK_CLASS_NAME__3','DEFAULT','__TASK_CLASS_NAME__3','DEFAULT',NULL,1549864080000,-1,5,'PAUSED','CRON',1549864080000,0,NULL,-1,'��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0!com.boshland.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0#com.boshland.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0h��xpt\0\0pppt\00/20 * * * * ?t\0系统默认（有参数）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0bTaskt\0\nryNoParamspt\01t\01x\0');

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`config_id`,`config_name`,`config_key`,`config_value`,`config_type`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2018-03-16 11:33:00','admin','2019-03-14 16:24:31','蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','初始化密码 123456');

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`parent_id`,`ancestors`,`dept_name`,`order_num`,`leader`,`phone`,`email`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`) values (100,0,'0','知味轩',0,'知味轩','13000000000','ry@qq.com','0','0','admin','2020-04-20 15:33:00','admin','2020-04-20 15:42:05'),(101,100,'0,100','潍坊总部',1,'涨总','13000000000','1128846@qq.com','0','0','admin','2020-04-20 15:33:00','admin','2020-04-20 15:42:05'),(102,100,'0,100','青岛分公司',5,'若依','15888888888','ry@qq.com','0','0','admin','2020-04-20 15:33:00','ry','2020-04-20 15:42:05'),(103,101,'0,100,101','质量部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2020-04-20 15:33:00','admin','2020-04-20 15:42:05'),(105,101,'0,100,101','财务部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2020-04-20 15:33:00','ry','2020-04-20 15:42:05'),(106,101,'0,100,101','运维部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2020-04-20 15:33:00','ry','2020-04-20 15:42:05'),(108,102,'0,100,102','技术部',1,'若依','15888888888','ry@qq.com','0','0','admin','2020-04-20 15:33:00','ry','2020-04-20 15:42:05'),(109,102,'0,100,102','财务部',2,'若依','15888888888','ry@qq.com','0','0','admin','2020-04-20 15:33:00','ry','2020-04-20 15:42:05'),(127,102,'0,100,102','物流部门',3,'张三','13800138000','13800138000@139.com','0','0','admin','2020-04-20 16:37:39','',NULL);

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`dict_code`,`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,'男','0','sys_user_sex','','','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(10,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统默认是'),(11,2,'否','N','sys_yes_no','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统默认否'),(12,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知'),(13,2,'公告','2','sys_notice_type','','success','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','公告'),(14,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(15,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','关闭状态'),(16,1,'新增','1','sys_oper_type','','info','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','新增操作'),(17,2,'修改','2','sys_oper_type','','info','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','修改操作'),(18,3,'删除','3','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','删除操作'),(19,4,'授权','4','sys_oper_type','','primary','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','授权操作'),(20,5,'导出','5','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','导出操作'),(21,6,'导入','6','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','导入操作'),(22,7,'强退','7','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','强退操作'),(23,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','生成操作'),(24,8,'清空数据','9','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','清空操作'),(25,1,'成功','0','sys_common_status','','primary','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(26,2,'失败','1','sys_common_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态');

/*Table structure for table `sys_dict_type` */

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE KEY `dict_type` (`dict_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

/*Data for the table `sys_dict_type` */

insert  into `sys_dict_type`(`dict_id`,`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'用户性别','sys_user_sex','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','任务状态列表'),(5,'系统是否','sys_yes_no','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统是否列表'),(6,'通知类型','sys_notice_type','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知类型列表'),(7,'通知状态','sys_notice_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知状态列表'),(8,'操作类型','sys_oper_type','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','操作类型列表'),(9,'系统状态','sys_common_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','登录状态列表');

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(50) DEFAULT NULL COMMENT '方法参数',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

/*Data for the table `sys_job` */

/*Table structure for table `sys_job_log` */

DROP TABLE IF EXISTS `sys_job_log`;

CREATE TABLE `sys_job_log` (
  `job_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(50) DEFAULT NULL COMMENT '方法参数',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

/*Data for the table `sys_job_log` */

/*Table structure for table `sys_logininfor` */

DROP TABLE IF EXISTS `sys_logininfor`;

CREATE TABLE `sys_logininfor` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

/*Data for the table `sys_logininfor` */

insert  into `sys_logininfor`(`info_id`,`login_name`,`ipaddr`,`login_location`,`browser`,`os`,`status`,`msg`,`login_time`) values (1,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','退出成功','2020-04-20 16:20:49'),(2,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-20 16:20:51'),(3,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','退出成功','2020-04-20 16:39:42'),(4,'zhongcl','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-20 16:39:50'),(5,'zhongcl','127.0.0.1','内网IP','Firefox 7','Windows 10','0','退出成功','2020-04-20 16:40:02'),(6,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-20 16:40:05'),(7,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-20 16:54:11'),(8,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-21 16:10:55'),(9,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-21 17:08:24'),(10,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 08:58:19'),(11,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 09:22:30'),(12,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 09:37:34'),(13,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 11:39:06'),(14,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 12:03:37'),(15,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 12:07:58'),(16,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 12:11:15'),(17,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 14:06:20'),(18,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 14:16:11'),(19,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 14:42:16'),(20,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 14:49:41'),(21,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 15:44:24'),(22,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:15:41'),(23,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:20:28'),(24,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:21:52'),(25,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:38:34'),(26,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:47:11'),(27,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:55:19'),(28,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 16:57:25'),(29,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','退出成功','2020-04-22 17:22:54'),(30,'admin','127.0.0.1','内网IP','Firefox 7','Windows 10','0','登录成功','2020-04-22 17:22:59');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1276 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`parent_id`,`order_num`,`url`,`menu_type`,`visible`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统管理',0,10,'#','M','0','','fa fa-gear','admin','2018-03-16 11:33:00','admin','2019-07-30 10:02:59','系统管理目录'),(2,'系统监控',0,11,'#','M','1','','fa fa-video-camera','admin','2018-03-16 11:33:00','admin','2019-11-29 09:09:10','系统监控目录'),(3,'系统工具',0,12,'#','M','0','','fa fa-bars','admin','2018-03-16 11:33:00','admin','2020-02-20 18:41:00','系统工具目录'),(100,'用户管理',1,1,'/system/user','C','0','system:user:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','用户管理菜单'),(101,'角色管理',1,3,'/system/role','C','0','system:role:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:11:41','角色管理菜单'),(102,'菜单管理',1,8,'/system/menu','C','0','system:menu:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:14:22','菜单管理菜单'),(103,'部门管理',1,4,'/system/dept','C','0','system:dept:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:13:08','部门管理菜单'),(104,'岗位管理',1,5,'/system/post','C','0','system:post:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:13:19','岗位管理菜单'),(105,'字典管理',1,9,'/system/dict','C','0','system:dict:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:14:42','字典管理菜单'),(106,'参数设置',1,10,'/system/config','C','0','system:config:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:14:57','参数设置菜单'),(107,'通知公告',1195,1,'/system/notice','C','0','system:notice:view','#','admin','2018-03-16 11:33:00','admin','2019-07-30 16:00:49','通知公告菜单'),(108,'日志管理',1,7,'#','M','0','','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:14:11','日志管理菜单'),(109,'在线用户',2,1,'/monitor/online','C','0','monitor:online:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','在线用户菜单'),(110,'定时任务',2,2,'/monitor/job','C','0','monitor:job:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','定时任务菜单'),(111,'数据监控',2,3,'/monitor/data','C','0','monitor:data:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','数据监控菜单'),(112,'服务监控',2,3,'/monitor/server','C','0','monitor:server:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','服务监控菜单'),(113,'表单构建',3,1,'/tool/build','C','0','tool:build:view','#','admin','2018-03-16 11:33:00','admin','2020-02-22 12:03:45','表单构建菜单'),(114,'代码生成',3,2,'/tool/gen','C','0','tool:gen:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','代码生成菜单'),(115,'系统接口',3,3,'/tool/swagger','C','1','tool:swagger:view','#','admin','2018-03-16 11:33:00','admin','2019-11-29 09:04:34','系统接口菜单'),(500,'操作日志',108,1,'/monitor/operlog','C','0','monitor:operlog:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','操作日志菜单'),(501,'登录日志',108,2,'/monitor/logininfor','C','0','monitor:logininfor:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','登录日志菜单'),(1000,'用户查询',100,1,'#','F','0','system:user:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1001,'用户新增',100,2,'#','F','0','system:user:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1002,'用户修改',100,3,'#','F','0','system:user:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1003,'用户删除',100,4,'#','F','0','system:user:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1004,'用户导出',100,5,'#','F','0','system:user:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1005,'重置密码',100,6,'#','F','0','system:user:resetPwd','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1006,'角色查询',101,1,'#','F','0','system:role:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1007,'角色新增',101,2,'#','F','0','system:role:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1008,'角色修改',101,3,'#','F','0','system:role:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1009,'角色删除',101,4,'#','F','0','system:role:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1010,'角色导出',101,5,'#','F','0','system:role:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1011,'菜单查询',102,1,'#','F','0','system:menu:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1012,'菜单新增',102,2,'#','F','0','system:menu:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1013,'菜单修改',102,3,'#','F','0','system:menu:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1014,'菜单删除',102,4,'#','F','0','system:menu:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1015,'部门查询',103,1,'#','F','0','system:dept:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1016,'部门新增',103,2,'#','F','0','system:dept:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1017,'部门修改',103,3,'#','F','0','system:dept:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1018,'部门删除',103,4,'#','F','0','system:dept:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1019,'岗位查询',104,1,'#','F','0','system:post:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1020,'岗位新增',104,2,'#','F','0','system:post:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1021,'岗位修改',104,3,'#','F','0','system:post:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1022,'岗位删除',104,4,'#','F','0','system:post:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1023,'岗位导出',104,5,'#','F','0','system:post:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1024,'字典查询',105,1,'#','F','0','system:dict:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1025,'字典新增',105,2,'#','F','0','system:dict:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1026,'字典修改',105,3,'#','F','0','system:dict:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1027,'字典删除',105,4,'#','F','0','system:dict:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1028,'字典导出',105,5,'#','F','0','system:dict:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1029,'参数查询',106,1,'#','F','0','system:config:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1030,'参数新增',106,2,'#','F','0','system:config:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1031,'参数修改',106,3,'#','F','0','system:config:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1032,'参数删除',106,4,'#','F','0','system:config:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1033,'参数导出',106,5,'#','F','0','system:config:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1034,'公告查询',107,1,'#','F','0','system:notice:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1035,'公告新增',107,2,'#','F','0','system:notice:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1036,'公告修改',107,3,'#','F','0','system:notice:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1037,'公告删除',107,4,'#','F','0','system:notice:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1038,'操作查询',500,1,'#','F','0','monitor:operlog:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1039,'操作删除',500,2,'#','F','0','monitor:operlog:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1040,'详细信息',500,3,'#','F','0','monitor:operlog:detail','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1041,'日志导出',500,4,'#','F','0','monitor:operlog:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1042,'登录查询',501,1,'#','F','0','monitor:logininfor:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1043,'登录删除',501,2,'#','F','0','monitor:logininfor:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1044,'日志导出',501,3,'#','F','0','monitor:logininfor:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1045,'在线查询',109,1,'#','F','0','monitor:online:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1046,'批量强退',109,2,'#','F','0','monitor:online:batchForceLogout','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1047,'单条强退',109,3,'#','F','0','monitor:online:forceLogout','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1048,'任务查询',110,1,'#','F','0','monitor:job:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1049,'任务新增',110,2,'#','F','0','monitor:job:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1050,'任务修改',110,3,'#','F','0','monitor:job:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1051,'任务删除',110,4,'#','F','0','monitor:job:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1052,'状态修改',110,5,'#','F','0','monitor:job:changeStatus','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1053,'任务详细',110,6,'#','F','0','monitor:job:detail','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1054,'任务导出',110,7,'#','F','0','monitor:job:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1055,'生成查询',114,1,'#','F','0','tool:gen:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1056,'生成代码',114,2,'#','F','0','tool:gen:code','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1267,'公告管理',0,4,'#','M','0','','fa fa-bell-o','admin','2020-04-22 09:09:06','',NULL,''),(1268,'报表数据源',0,1,'#','M','0','','fa fa-cubes','admin','2020-04-22 09:10:56','',NULL,''),(1269,'数据源管理',1268,1,'/client/datasource','C','0','client:datasource:view','#','admin','2020-04-22 09:11:28','admin','2020-04-22 15:45:54',''),(1270,'数据源测试',1268,1,'/client/test','C','0','client:test:view','#','admin','2020-04-22 09:12:14','admin','2020-04-22 09:12:27',''),(1271,'查询',1270,1,'#','F','0','client:test:list','#','admin','2020-04-22 09:26:35','',NULL,''),(1272,'查询',1269,1,'#','F','0','client:datasource:list','#','admin','2020-04-22 15:46:21','',NULL,''),(1273,'修改',1269,3,'#','F','0','client:datasource:edit','#','admin','2020-04-22 15:47:11','admin','2020-04-22 15:48:15',''),(1274,'删除',1269,4,'#','F','0','client:datasource:remove','#','admin','2020-04-22 15:47:34','admin','2020-04-22 15:48:21',''),(1275,'新增',1269,2,'#','F','0','client:datasource:add','#','admin','2020-04-22 15:48:04','',NULL,'');

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`notice_id`,`notice_title`,`notice_type`,`notice_content`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'温馨提醒：boshland管理系统上线了','2','新版本内容','0','admin','2018-03-16 11:33:00','admin','2019-02-11 14:38:38','管理员');

/*Table structure for table `sys_oper_log` */

DROP TABLE IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(255) DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

/*Data for the table `sys_oper_log` */

insert  into `sys_oper_log`(`oper_id`,`title`,`business_type`,`method`,`operator_type`,`oper_name`,`dept_name`,`oper_url`,`oper_ip`,`oper_location`,`oper_param`,`status`,`error_msg`,`oper_time`) values (1,'用户管理',1,'com.dongzhe.web.controller.system.SysUserController.addSave()',1,'admin','质量部','/system/user/add','127.0.0.1','内网IP','{\r\n  \"deptId\" : [ \"108\" ],\r\n  \"loginName\" : [ \"zhongcl\" ],\r\n  \"userName\" : [ \"仲崇利\" ],\r\n  \"password\" : [ \"123456\" ],\r\n  \"email\" : [ \"17915512@qq.com\" ],\r\n  \"phonenumber\" : [ \"13455265880\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"\" ],',0,NULL,'2020-04-20 16:31:55'),(2,'岗位管理',1,'com.dongzhe.web.controller.system.SysPostController.addSave()',1,'admin','质量部','/system/post/add','127.0.0.1','内网IP','{\r\n  \"postName\" : [ \"开发岗\" ],\r\n  \"postCode\" : [ \"ope\" ],\r\n  \"postSort\" : [ \"3\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"技术开发岗\" ]\r\n}',0,NULL,'2020-04-20 16:32:44'),(3,'用户管理',2,'com.dongzhe.web.controller.system.SysUserController.editSave()',1,'admin','质量部','/system/user/edit','127.0.0.1','内网IP','{\r\n  \"userId\" : [ \"121\" ],\r\n  \"deptId\" : [ \"108\" ],\r\n  \"userName\" : [ \"仲崇利\" ],\r\n  \"email\" : [ \"17915512@qq.com\" ],\r\n  \"phonenumber\" : [ \"13455265880\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"\" ],\r\n  \"postIds\" : [ \"9\" ]\r\n}',0,NULL,'2020-04-20 16:33:01'),(4,'用户管理',2,'com.dongzhe.web.controller.system.SysUserController.editSave()',1,'admin','质量部','/system/user/edit','127.0.0.1','内网IP','{\r\n  \"userId\" : [ \"121\" ],\r\n  \"deptId\" : [ \"108\" ],\r\n  \"userName\" : [ \"仲崇利\" ],\r\n  \"email\" : [ \"17915512@qq.com\" ],\r\n  \"phonenumber\" : [ \"13455265880\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"\" ],\r\n  \"postIds\" : [ \"9\" ]\r\n}',0,NULL,'2020-04-20 16:33:04'),(5,'角色管理',1,'com.dongzhe.web.controller.system.SysRoleController.addSave()',1,'admin','质量部','/system/role/add','127.0.0.1','内网IP','{\r\n  \"roleName\" : [ \"物流经理\" ],\r\n  \"roleKey\" : [ \"wl\" ],\r\n  \"roleSort\" : [ \"1\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"物流经理\" ],\r\n  \"menuIds\" : [ \"\" ]\r\n}',0,NULL,'2020-04-20 16:34:05'),(6,'角色管理',1,'com.dongzhe.web.controller.system.SysRoleController.addSave()',1,'admin','质量部','/system/role/add','127.0.0.1','内网IP','{\r\n  \"roleName\" : [ \"物流员\" ],\r\n  \"roleKey\" : [ \"wly\" ],\r\n  \"roleSort\" : [ \"6\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"\" ],\r\n  \"menuIds\" : [ \"\" ]\r\n}',0,NULL,'2020-04-20 16:34:47'),(7,'角色管理',2,'com.dongzhe.web.controller.system.SysRoleController.editSave()',1,'admin','质量部','/system/role/edit','127.0.0.1','内网IP','{\r\n  \"roleId\" : [ \"19\" ],\r\n  \"roleName\" : [ \"物流经理\" ],\r\n  \"roleKey\" : [ \"wl\" ],\r\n  \"roleSort\" : [ \"5\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"物流经理\" ],\r\n  \"menuIds\" : [ \"\" ]\r\n}',0,NULL,'2020-04-20 16:34:51'),(8,'用户管理',2,'com.dongzhe.web.controller.system.SysUserController.editSave()',1,'admin','质量部','/system/user/edit','127.0.0.1','内网IP','{\r\n  \"userId\" : [ \"121\" ],\r\n  \"deptId\" : [ \"108\" ],\r\n  \"userName\" : [ \"仲崇利\" ],\r\n  \"email\" : [ \"17915512@qq.com\" ],\r\n  \"phonenumber\" : [ \"13455265880\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"20\" ],\r\n  \"postIds\" : [ \"9\" ]\r\n}',0,NULL,'2020-04-20 16:35:09'),(9,'岗位管理',1,'com.dongzhe.web.controller.system.SysPostController.addSave()',1,'admin','质量部','/system/post/add','127.0.0.1','内网IP','{\r\n  \"postName\" : [ \"物流员\" ],\r\n  \"postCode\" : [ \"wl\" ],\r\n  \"postSort\" : [ \"4\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"\" ]\r\n}',0,NULL,'2020-04-20 16:35:31'),(10,'用户管理',2,'com.dongzhe.web.controller.system.SysUserController.editSave()',1,'admin','质量部','/system/user/edit','127.0.0.1','内网IP','{\r\n  \"userId\" : [ \"121\" ],\r\n  \"deptId\" : [ \"108\" ],\r\n  \"userName\" : [ \"仲崇利\" ],\r\n  \"email\" : [ \"17915512@qq.com\" ],\r\n  \"phonenumber\" : [ \"13455265880\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"20\" ],\r\n  \"postIds\" : [ \"10\" ]\r\n}',0,NULL,'2020-04-20 16:35:44'),(11,'用户管理',1,'com.dongzhe.web.controller.system.SysUserController.addSave()',1,'admin','质量部','/system/user/add','127.0.0.1','内网IP','{\r\n  \"deptId\" : [ \"109\" ],\r\n  \"loginName\" : [ \"zcl\" ],\r\n  \"userName\" : [ \"zhongcl\" ],\r\n  \"password\" : [ \"123456\" ],\r\n  \"email\" : [ \"sd_zcl@163.com\" ],\r\n  \"phonenumber\" : [ \"13455265881\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"19\" ]',0,NULL,'2020-04-20 16:36:52'),(12,'部门管理',1,'com.dongzhe.web.controller.system.SysDeptController.addSave()',1,'admin','质量部','/system/dept/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"102\" ],\r\n  \"deptName\" : [ \"物流部门\" ],\r\n  \"orderNum\" : [ \"3\" ],\r\n  \"leader\" : [ \"张三\" ],\r\n  \"phone\" : [ \"13800138000\" ],\r\n  \"email\" : [ \"13800138000@139.com\" ],\r\n  \"status\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-20 16:37:39'),(13,'用户管理',2,'com.dongzhe.web.controller.system.SysUserController.editSave()',1,'admin','质量部','/system/user/edit','127.0.0.1','内网IP','{\r\n  \"userId\" : [ \"122\" ],\r\n  \"deptId\" : [ \"127\" ],\r\n  \"userName\" : [ \"zhongcl\" ],\r\n  \"email\" : [ \"sd_zcl@163.com\" ],\r\n  \"phonenumber\" : [ \"13455265881\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"19\" ],\r\n  \"postIds\" : [ \"10\" ]\r\n}',0,NULL,'2020-04-20 16:38:03'),(14,'菜单管理',3,'com.dongzhe.web.controller.system.SysMenuController.remove()',1,'admin','质量部门','/system/menu/remove/117','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 09:07:52'),(15,'菜单管理',3,'com.dongzhe.web.controller.system.SysMenuController.remove()',1,'admin','质量部门','/system/menu/remove/116','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 09:08:00'),(16,'菜单管理',3,'com.dongzhe.web.controller.system.SysMenuController.remove()',1,'admin','质量部门','/system/menu/remove/4','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 09:08:12'),(17,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"0\" ],\r\n  \"menuType\" : [ \"M\" ],\r\n  \"menuName\" : [ \"公告管理\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"\" ],\r\n  \"orderNum\" : [ \"4\" ],\r\n  \"icon\" : [ \"fa fa-bell-o\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 09:09:06'),(18,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"0\" ],\r\n  \"menuType\" : [ \"M\" ],\r\n  \"menuName\" : [ \"报表数据源\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"fa fa-cubes\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 09:10:56'),(19,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1268\" ],\r\n  \"menuType\" : [ \"C\" ],\r\n  \"menuName\" : [ \"数据源管理\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 09:11:28'),(20,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1268\" ],\r\n  \"menuType\" : [ \"C\" ],\r\n  \"menuName\" : [ \"数据源测试\" ],\r\n  \"url\" : [ \"/client/test\" ],\r\n  \"perms\" : [ \"client:test\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 09:12:14'),(21,'菜单管理',2,'com.dongzhe.web.controller.system.SysMenuController.editSave()',1,'admin','质量部门','/system/menu/edit','127.0.0.1','内网IP','{\r\n  \"menuId\" : [ \"1270\" ],\r\n  \"parentId\" : [ \"1268\" ],\r\n  \"menuType\" : [ \"C\" ],\r\n  \"menuName\" : [ \"数据源测试\" ],\r\n  \"url\" : [ \"/client/test\" ],\r\n  \"perms\" : [ \"client:test:view\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"#\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 09:12:27'),(22,'角色管理',2,'com.dongzhe.web.controller.system.SysRoleController.editSave()',1,'admin','质量部门','/system/role/edit','127.0.0.1','内网IP','{\r\n  \"roleId\" : [ \"1\" ],\r\n  \"roleName\" : [ \"管理员\" ],\r\n  \"roleKey\" : [ \"admin\" ],\r\n  \"roleSort\" : [ \"1\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"管理员\" ],\r\n  \"menuIds\" : [ \"107,1034,1035,1036,1037,1268,1269,1270,1,100,1000,1001,1002,1003,1004,1005,101,1006,',0,NULL,'2020-04-22 09:13:27'),(23,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin',NULL,'/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1270\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"查询\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"client:test:list\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 09:26:35'),(24,'菜单管理',2,'com.dongzhe.web.controller.system.SysMenuController.editSave()',1,'admin','质量部门','/system/menu/edit','127.0.0.1','内网IP','{\r\n  \"menuId\" : [ \"1269\" ],\r\n  \"parentId\" : [ \"1268\" ],\r\n  \"menuType\" : [ \"C\" ],\r\n  \"menuName\" : [ \"数据源管理\" ],\r\n  \"url\" : [ \"/client/datasource\" ],\r\n  \"perms\" : [ \"\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"#\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:45:21'),(25,'菜单管理',2,'com.dongzhe.web.controller.system.SysMenuController.editSave()',1,'admin','质量部门','/system/menu/edit','127.0.0.1','内网IP','{\r\n  \"menuId\" : [ \"1269\" ],\r\n  \"parentId\" : [ \"1268\" ],\r\n  \"menuType\" : [ \"C\" ],\r\n  \"menuName\" : [ \"数据源管理\" ],\r\n  \"url\" : [ \"/client/datasource\" ],\r\n  \"perms\" : [ \"client:datasource:view\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"#\" ],\r\n  \"visible\" : [ \"0',0,NULL,'2020-04-22 15:45:54'),(26,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1269\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"查询\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"client:datasource:list\" ],\r\n  \"orderNum\" : [ \"1\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:46:21'),(27,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1269\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"修改\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"client:datasource:edit\" ],\r\n  \"orderNum\" : [ \"2\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:47:11'),(28,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1269\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"删除\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"client:datasource:remove\" ],\r\n  \"orderNum\" : [ \"3\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:47:34'),(29,'菜单管理',1,'com.dongzhe.web.controller.system.SysMenuController.addSave()',1,'admin','质量部门','/system/menu/add','127.0.0.1','内网IP','{\r\n  \"parentId\" : [ \"1269\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"新增\" ],\r\n  \"url\" : [ \"\" ],\r\n  \"perms\" : [ \"client:datasource:add\" ],\r\n  \"orderNum\" : [ \"2\" ],\r\n  \"icon\" : [ \"\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:48:04'),(30,'菜单管理',2,'com.dongzhe.web.controller.system.SysMenuController.editSave()',1,'admin','质量部门','/system/menu/edit','127.0.0.1','内网IP','{\r\n  \"menuId\" : [ \"1273\" ],\r\n  \"parentId\" : [ \"1269\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"修改\" ],\r\n  \"url\" : [ \"#\" ],\r\n  \"perms\" : [ \"client:datasource:edit\" ],\r\n  \"orderNum\" : [ \"3\" ],\r\n  \"icon\" : [ \"#\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:48:15'),(31,'菜单管理',2,'com.dongzhe.web.controller.system.SysMenuController.editSave()',1,'admin','质量部门','/system/menu/edit','127.0.0.1','内网IP','{\r\n  \"menuId\" : [ \"1274\" ],\r\n  \"parentId\" : [ \"1269\" ],\r\n  \"menuType\" : [ \"F\" ],\r\n  \"menuName\" : [ \"删除\" ],\r\n  \"url\" : [ \"#\" ],\r\n  \"perms\" : [ \"client:datasource:remove\" ],\r\n  \"orderNum\" : [ \"4\" ],\r\n  \"icon\" : [ \"#\" ],\r\n  \"visible\" : [ \"0\" ]\r\n}',0,NULL,'2020-04-22 15:48:21'),(32,'角色管理',2,'com.dongzhe.web.controller.system.SysRoleController.editSave()',1,'admin','质量部门','/system/role/edit','127.0.0.1','内网IP','{\r\n  \"roleId\" : [ \"1\" ],\r\n  \"roleName\" : [ \"管理员\" ],\r\n  \"roleKey\" : [ \"admin\" ],\r\n  \"roleSort\" : [ \"1\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"管理员\" ],\r\n  \"menuIds\" : [ \"107,1034,1035,1036,1037,1268,1269,1272,1275,1273,1274,1270,1271,1,100,1000,1001,1002',0,NULL,'2020-04-22 15:48:47'),(33,'数据源管理',1,'com.dongzhe.web.controller.client.DbInfoController.addSave()',1,'admin','质量部门','/client/datasource/add','127.0.0.1','内网IP','{\r\n  \"id\" : [ \"\" ],\r\n  \"dbType\" : [ \"mysql\" ],\r\n  \"dbIp\" : [ \"localhost\" ],\r\n  \"dbPort\" : [ \"3306\" ],\r\n  \"dbUser\" : [ \"guorun\" ],\r\n  \"dbPasswd\" : [ \"er3456t8.\" ]\r\n}',0,NULL,'2020-04-22 16:25:53'),(34,'数据源管理',3,'com.dongzhe.web.controller.client.DbInfoController.remove()',1,'admin','质量部门','/client/datasource/remove/5','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:26:10'),(35,'数据源管理',1,'com.dongzhe.web.controller.client.DbInfoController.addSave()',1,'admin','质量部门','/client/datasource/add','127.0.0.1','内网IP','{\r\n  \"id\" : [ \"\" ],\r\n  \"dbType\" : [ \"mysql\" ],\r\n  \"dbIp\" : [ \"localhost\" ],\r\n  \"dbPort\" : [ \"3306\" ],\r\n  \"dbUser\" : [ \"root\" ],\r\n  \"dbPasswd\" : [ \"er3456t8.\" ],\r\n  \"dbName\" : [ \"guorun\" ]\r\n}',0,NULL,'2020-04-22 16:36:17'),(36,'数据源管理',3,'com.dongzhe.web.controller.client.DbInfoController.remove()',1,'admin','质量部门','/client/datasource/remove/6','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:38:45'),(37,'数据源管理',1,'com.dongzhe.web.controller.client.DbInfoController.addSave()',1,'admin','质量部门','/client/datasource/add','127.0.0.1','内网IP','{\r\n  \"id\" : [ \"\" ],\r\n  \"name\" : [ \"测试\" ],\r\n  \"dbType\" : [ \"mysql\" ],\r\n  \"dbIp\" : [ \"127.0.0.1\" ],\r\n  \"dbPort\" : [ \"3306\" ],\r\n  \"dbUser\" : [ \"root\" ],\r\n  \"dbPasswd\" : [ \"er3456t8.\" ],\r\n  \"dbName\" : [ \"guorun\" ]\r\n}',0,NULL,'2020-04-22 16:39:18'),(38,'数据源管理',1,'com.dongzhe.web.controller.client.DbInfoController.addSave()',1,'admin','质量部门','/client/datasource/add','127.0.0.1','内网IP','{\r\n  \"id\" : [ \"\" ],\r\n  \"name\" : [ \"测试\" ],\r\n  \"dbType\" : [ \"mysql\" ],\r\n  \"dbIp\" : [ \"\" ],\r\n  \"dbPort\" : [ \"\" ],\r\n  \"dbUser\" : [ \"\" ],\r\n  \"dbPasswd\" : [ \"\" ],\r\n  \"dbName\" : [ \"\" ]\r\n}',0,NULL,'2020-04-22 16:39:40'),(39,'数据源管理',3,'com.dongzhe.web.controller.client.DbInfoController.remove()',1,'admin','质量部门','/client/datasource/remove/8','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:39:46'),(40,'数据源管理',3,'com.dongzhe.web.controller.client.DbInfoController.remove()',1,'admin','质量部门','/client/datasource/remove/7','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:40:03'),(41,'数据源管理',2,'com.dongzhe.web.controller.client.DbInfoController.editSave()',1,'admin','质量部门','/client/datasource/edit','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:53:40'),(42,'数据源管理',2,'com.dongzhe.web.controller.client.DbInfoController.editSave()',1,'admin','质量部门','/client/datasource/edit','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:53:57'),(43,'数据源管理',2,'com.dongzhe.web.controller.client.DbInfoController.editSave()',1,'admin','质量部门','/client/datasource/edit','127.0.0.1','内网IP','{ }',0,NULL,'2020-04-22 16:56:40'),(44,'数据源管理',2,'com.dongzhe.web.controller.client.DbInfoController.editSave()',1,'admin','质量部门','/client/datasource/edit','127.0.0.1','内网IP','{\r\n  \"id\" : [ \"4\" ],\r\n  \"name\" : [ \"ERP数据源t6\" ],\r\n  \"dbType\" : [ \"mysql\" ],\r\n  \"dbIp\" : [ \"192.168.0.109\" ],\r\n  \"dbPort\" : [ \"1433\" ],\r\n  \"dbUser\" : [ \"sa\" ],\r\n  \"dbPasswd\" : [ \"as\" ],\r\n  \"dbName\" : [ \"dhh\" ]\r\n}',0,NULL,'2020-04-22 16:58:05');

/*Table structure for table `sys_post` */

DROP TABLE IF EXISTS `sys_post`;

CREATE TABLE `sys_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

/*Data for the table `sys_post` */

insert  into `sys_post`(`post_id`,`post_code`,`post_name`,`post_sort`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'ceo','董事长',1,'0','admin','2020-04-20 16:06:22','ry','2018-03-16 11:33:00',''),(2,'seo','销售岗',2,'0','admin','2020-04-20 16:06:22','admin','2019-11-29 11:33:59',''),(9,'ope','开发岗',3,'0','admin','2020-04-20 16:32:44','',NULL,'技术开发岗'),(10,'wl','物流员',4,'0','admin','2020-04-20 16:35:30','',NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`data_scope`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'管理员','admin',1,'1','0','0','admin','2018-03-16 11:33:00','admin','2020-04-22 15:48:47','管理员'),(2,'普通角色','common',2,'2','0','2','admin','2018-03-16 11:33:00','admin','2019-08-12 14:48:45','普通角色'),(13,'销售人员','3',4,'1','0','0','admin','2019-08-02 10:57:14','admin','2020-04-20 15:54:39','销售人员'),(14,'销售经理','5',3,'1','0','0','admin','2019-08-02 11:01:17','admin','2020-04-20 15:54:12','销售经理'),(19,'物流经理','wl',5,'1','0','0','admin','2020-04-20 16:34:05','admin','2020-04-20 16:34:51','物流经理'),(20,'物流员','wly',6,'1','0','0','admin','2020-04-20 16:34:47','',NULL,NULL);

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

/*Data for the table `sys_role_dept` */

insert  into `sys_role_dept`(`role_id`,`dept_id`) values (2,100),(2,101),(2,103);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (1,1),(1,2),(1,3),(1,100),(1,101),(1,102),(1,103),(1,104),(1,105),(1,106),(1,107),(1,108),(1,109),(1,110),(1,111),(1,112),(1,113),(1,114),(1,115),(1,500),(1,501),(1,1000),(1,1001),(1,1002),(1,1003),(1,1004),(1,1005),(1,1006),(1,1007),(1,1008),(1,1009),(1,1010),(1,1011),(1,1012),(1,1013),(1,1014),(1,1015),(1,1016),(1,1017),(1,1018),(1,1019),(1,1020),(1,1021),(1,1022),(1,1023),(1,1024),(1,1025),(1,1026),(1,1027),(1,1028),(1,1029),(1,1030),(1,1031),(1,1032),(1,1033),(1,1034),(1,1035),(1,1036),(1,1037),(1,1038),(1,1039),(1,1040),(1,1041),(1,1042),(1,1043),(1,1044),(1,1045),(1,1046),(1,1047),(1,1048),(1,1049),(1,1050),(1,1051),(1,1052),(1,1053),(1,1054),(1,1055),(1,1056),(1,1268),(1,1269),(1,1270),(1,1271),(1,1272),(1,1273),(1,1274),(1,1275),(2,1),(2,2),(2,3),(2,100),(2,101),(2,102),(2,103),(2,104),(2,105),(2,106),(2,107),(2,108),(2,109),(2,110),(2,111),(2,112),(2,113),(2,114),(2,115),(2,500),(2,501),(2,1000),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1008),(2,1009),(2,1010),(2,1011),(2,1012),(2,1013),(2,1014),(2,1015),(2,1016),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1031),(2,1032),(2,1033),(2,1034),(2,1035),(2,1036),(2,1037),(2,1038),(2,1039),(2,1040),(2,1041),(2,1042),(2,1043),(2,1044),(2,1045),(2,1046),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,1057),(3,1),(3,100),(3,101),(3,102),(3,103),(3,104),(3,105),(3,106),(3,107),(3,108),(3,500),(3,501),(3,1000),(3,1001),(3,1002),(3,1003),(3,1004),(3,1005),(3,1006),(3,1007),(3,1008),(3,1009),(3,1010),(3,1011),(3,1012),(3,1013),(3,1014),(3,1015),(3,1016),(3,1017),(3,1018),(3,1019),(3,1020),(3,1021),(3,1022),(3,1023),(3,1024),(3,1025),(3,1026),(3,1027),(3,1028),(3,1029),(3,1030),(3,1031),(3,1032),(3,1033),(3,1034),(3,1035),(3,1036),(3,1037),(3,1038),(3,1039),(3,1040),(3,1041),(3,1042),(3,1043),(3,1044),(18,1105),(18,1106),(18,1107),(18,1108),(18,1109),(18,1110),(18,1111),(18,1112),(18,1113),(18,1114),(18,1115),(18,1116),(18,1117),(18,1118),(18,1119),(18,1120),(18,1152),(18,1153),(18,1154),(18,1155),(18,1156),(18,1158),(18,1196),(18,1197),(18,1198),(18,1200),(18,1201),(18,1202),(18,1203),(18,1204);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `sample_group_id` int(11) DEFAULT NULL COMMENT '采样分组标识',
  `is_leader` varchar(255) DEFAULT NULL COMMENT '是否组长（1：是）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`dept_id`,`login_name`,`user_name`,`user_type`,`email`,`phonenumber`,`sex`,`avatar`,`password`,`salt`,`status`,`del_flag`,`login_ip`,`login_date`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`,`sample_group_id`,`is_leader`) values (1,103,'admin','超级管理员','00','15801590000@qq.com','15801590000','0','2020/02/19/4dc143804aa6caf768fbf3f34b3039c8.jpg','29c67a30398638269fe600f73a054934','111111','0','0','127.0.0.1','2020-04-22 17:23:00','admin','2018-03-16 11:33:00','ry','2020-04-22 17:22:59','管理员',NULL,NULL),(2,105,'ry','普通管理员','00','ry@qq.com','15666666666','1','','29c67a30398638269fe600f73a054934','111111','0','2','127.0.0.1','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','测试员',NULL,NULL),(121,108,'zhongcl','仲崇利','00','17915512@qq.com','13455265880','0','','48c40601ef10cc3826d44a3e4e8c849f','7f3916','0','0','127.0.0.1','2020-04-20 16:39:51','admin','2020-04-20 16:31:55','admin','2020-04-20 16:39:50','',NULL,NULL),(122,127,'zcl','zhongcl','00','sd_zcl@163.com','13455265881','0','','332c2c86ff45a3eb146dd5fa79982e60','8c1f8a','0','0','',NULL,'admin','2020-04-20 16:36:52','admin','2020-04-20 16:38:03','',NULL,NULL);

/*Table structure for table `sys_user_online` */

DROP TABLE IF EXISTS `sys_user_online`;

CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

/*Data for the table `sys_user_online` */

insert  into `sys_user_online`(`sessionId`,`login_name`,`dept_name`,`ipaddr`,`login_location`,`browser`,`os`,`status`,`start_timestamp`,`last_access_time`,`expire_time`) values ('77c377eb-2d9e-48e7-b7fb-9e652f8907bd','admin','质量部门','127.0.0.1','内网IP','Firefox 7','Windows 10','on_line','2020-04-22 17:22:55','2020-04-22 17:26:45',1800000);

/*Table structure for table `sys_user_post` */

DROP TABLE IF EXISTS `sys_user_post`;

CREATE TABLE `sys_user_post` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `post_id` int(11) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

/*Data for the table `sys_user_post` */

insert  into `sys_user_post`(`user_id`,`post_id`) values (1,1),(2,2),(121,10),(122,10);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (2,3),(3,3),(121,20),(122,19);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
