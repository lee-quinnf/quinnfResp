create table t_user (
   id bigint(32) not null auto_increment comment '客户编号(主键)',
   name varchar(32) not null comment '客户名称(公司名称)',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table t_account (
   id bigint(32) not null auto_increment comment '客户编号(主键)',
   money decimal not null comment '金额',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into t_account values (1, 150);
insert into t_account values (2, 150);