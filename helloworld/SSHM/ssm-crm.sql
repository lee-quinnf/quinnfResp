create table base_dict (
   dict_id bigint(32) not null auto_increment,
   dict_type_code varchar(32) not null,
   dict_type_name varchar(32) default null, 
   dict_item_name varchar(32) default null, 
   dict_item_code varchar(32) default null, 
   dict_sort varchar(32) default null, 
   dict_enable varchar(32) default null, 
   dict_memo varchar(32) default null, 
   PRIMARY KEY (`dict_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;		
 		
create table customer (
   cust_id bigint(32) not null auto_increment,
   cust_name varchar(32) not null,
   cust_user_id varchar(32) default null, 
   cust_create_id varchar(32) default null, 
   cust_source varchar(32) default null, 
   cust_industry varchar(32) default null, 
   cust_level varchar(32) default null,    
   cust_linkman varchar(32) default null, 
   cust_phone varchar(32) default null, 
   cust_mobile varchar(32) default null, 
   cust_zipcode varchar(32) default null, 
   cust_address varchar(32) default null, 
   cust_createtime varchar(32) default null, 
   PRIMARY KEY (`cust_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;			