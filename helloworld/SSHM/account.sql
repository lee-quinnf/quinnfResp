create table account (
   id bigint(32) not null auto_increment comment '客户编号(主键)',
   name varchar(32) not null comment '客户名称',
   money decimal default null comment '客户金额', 
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
 
 
 