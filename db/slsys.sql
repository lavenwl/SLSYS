/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/10/26 20:11:40                          */
/*==============================================================*/


/*==============================================================*/
/* Table: role                                             */
/*==============================================================*/
create table slsys.role
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   name                 national varchar(128) not null comment '角色名称',
   url              national varchar(500) comment '图片路径',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.role comment '用户角色表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create unique index Index_1 on slsys.role
(
   id
);

/*==============================================================*/
/* Table: user                                             */
/*==============================================================*/
create table slsys.user
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   username             national varchar(100) not null comment '用户名
            
            ',
   password             national varchar(255) not null comment '密码',
   phone                national varchar(20) comment '手机号',
   role_id              bigint(32) not null comment '用户角色',
   url              national varchar(500) comment '图片路径',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.user comment '用户基本数据表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.user
(
   id
);

/*==============================================================*/
/* Table: company                                            */
/*==============================================================*/
create table slsys.company
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   name         national varchar(256) comment '公司名称',
   phone                national varchar(32) comment '公司电话',
   address              national varchar(256) comment '公司地址',
   url              national varchar(500) comment '图片路径',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.company comment '单位表
';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.company
(
   id
);

/*==============================================================*/
/* Table: goods                                              */
/*==============================================================*/
create table slsys.goods
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   name                 national varchar(255) comment '物资名称',
   type_id              bigint(32) comment '物资类别',
   spec                 national varchar(255) comment '物资规格',
   brand                national varchar(255) comment '物资品牌',
   provider             varchar(256) comment '供应商',
   url              national varchar(500) comment '图片路径',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.goods comment '物资表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.goods
(
   id
);

/*==============================================================*/
/* Table: goods_type                                         */
/*==============================================================*/
create table slsys.goods_type
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   name                 varchar(256) comment '物资种类',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.goods_type comment '物资类别表
';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.goods_type
(
   id
);

/*==============================================================*/
/* Table: item                                               */
/*==============================================================*/
create table slsys.item
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   order_id             bigint(32) comment '订单ID',
   goods_id             bigint(32) comment '物资ID',
   num                  int(32) comment '项目数量',
   sale_mode_id         bigint(32) comment '项目价格',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.item comment '订单项目表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.item
(
   id
);

/*==============================================================*/
/* Table: order                                              */
/*==============================================================*/
create table slsys.order
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   sale                 bigint(32) comment '销售方',
   purchase             bigint(32) comment '采购方',
   sum_money            decimal(11,4) default 0.00000000 comment '合计金额',
   money                decimal(11,4) default 0.00000000 comment '交易金额',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.order comment '订单表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.order
(
   id
);

/*==============================================================*/
/* Table: sale_mode                                          */
/*==============================================================*/
create table slsys.sale_mode
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   name                 national varchar(256) comment '销售方式',
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.sale_mode comment '销售模式表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.sale_mode
(
   id
);

/*==============================================================*/
/* Table: user_info                                          */
/*==============================================================*/
create table slsys.user_info
(
   id                   bigint(32) not null AUTO_INCREMENT comment '唯一索引',
   user_id              bigint(32) not null,
   company_id           bigint(32) not null,
   create_date          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_date          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   state                int(32) default 1 comment '数据状态（是否有效）',primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;  

alter table slsys.user_info comment '批发模块用户数据表';



/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on slsys.user_info
(
   id
);

alter table slsys.user add constraint fk_user foreign key (role_id)
      references slsys.role (id);

alter table slsys.goods add constraint fk_goods foreign key (type_id)
      references slsys.goods_type (id);

alter table slsys.item add constraint fk_item foreign key (goods_id)
      references slsys.goods (id);

alter table slsys.item add constraint fk_item_1 foreign key (sale_mode_id)
      references slsys.sale_mode (id);

alter table slsys.item add constraint fk_item_2 foreign key (order_id)
      references slsys.order (id);

alter table slsys.order add constraint fk_order foreign key (sale)
      references slsys.user_info (id);

alter table slsys.order add constraint fk_order_1 foreign key (purchase)
      references slsys.user_info (id);

alter table slsys.user_info add constraint fk_user_info foreign key (id)
      references slsys.company (id);

alter table slsys.user_info add constraint FK_fk_user_info_1 foreign key (user_id)
      references slsys.user (id) on delete restrict on update restrict;
