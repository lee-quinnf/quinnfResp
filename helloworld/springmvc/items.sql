create table items (
   id int(32) not null auto_increment comment '客户编号(主键)',
   name varchar(20) not null comment '姓名',
   price decimal not null comment '价格',
   pic varchar(30) not null comment '图片',
   createtime TIMESTAMP not null comment '创建时间',
   detail varchar(40) not null comment '详情',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;