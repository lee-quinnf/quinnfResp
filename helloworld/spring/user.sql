create table user (
   id bigint(32) not null auto_increment comment '客户编号(主键)',
   username varchar(32) not null comment '客户名称',
   sex varchar(32) not null comment '客户性别',
   birthday date not null comment '生日',
   address varchar(32) not null comment '地址',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

set names gbk;

insert into user values (1, '王五', 'man', '1992-11-12', 'shengzhen');
insert into user values (null, '王五', 'man', '1992-11-12', 'shengzhen');
