
    alter table slsys.goods 
        drop 
        foreign key FK5DF9756B1A65721;

    alter table slsys.order 
        drop 
        foreign key FK651874EE47B060F;

    alter table slsys.order 
        drop 
        foreign key FK651874E4C2E4AC9;

    alter table slsys.order_detail 
        drop 
        foreign key FK23AE5A6232347F3D;

    alter table slsys.order_detail 
        drop 
        foreign key FK23AE5A623F0478A9;

    alter table slsys.order_detail 
        drop 
        foreign key FK23AE5A628341E1AB;

    alter table slsys.order_detail 
        drop 
        foreign key FK23AE5A62AAB13278;

    alter table slsys.price 
        drop 
        foreign key FK65FB1498341E1AB;

    alter table slsys.price 
        drop 
        foreign key FK65FB149AAB13278;

    alter table slsys.user 
        drop 
        foreign key FK36EBCBCE5FAA7;

    alter table slsys.user_info 
        drop 
        foreign key FK1437D8A2A2A6540B;

    alter table slsys.user_info 
        drop 
        foreign key FK1437D8A2B210BE87;

    drop table if exists slsys.company;

    drop table if exists slsys.goods;

    drop table if exists slsys.goods_type;

    drop table if exists slsys.order;

    drop table if exists slsys.order_detail;

    drop table if exists slsys.price;

    drop table if exists slsys.role;

    drop table if exists slsys.sale_mode;

    drop table if exists slsys.user;

    drop table if exists slsys.user_info;

    create table slsys.company (
        id bigint not null auto_increment,
        name longtext not null comment '公司名称',
        phone varchar(32) comment '公司电话',
        address longtext comment '公司地址',
        url longtext comment '公司LOGO',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.goods (
        id bigint not null auto_increment,
        type_id bigint comment '物资类别',
        name varchar(255) comment '物资名称',
        spec varchar(255) comment '物资规格',
        brand varchar(255) comment '物资品牌',
        provider longtext comment '物资供应商',
        url longtext comment '物资图片',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.goods_type (
        id bigint not null auto_increment,
        name longtext comment '物资类别',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.order (
        id bigint not null auto_increment,
        purchase bigint comment '买家用户',
        sale bigint comment '卖家用户',
        order_code varchar(64) comment '订单编号',
        sum_money double precision default 0 comment '计算金额',
        money double precision default 0 comment '交易金额',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.order_detail (
        id bigint not null auto_increment,
        goods_id bigint comment '物资ID',
        order_detail_code bigint comment '订单编号',
        sale_mode_id bigint comment '销售模式',
        num integer default 0 comment '项目数量',
        price double precision default 0 comment '项目单价',
        sum_money double precision default 0 comment '计算金额',
        money double precision default 0 comment '交易金额',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        order_code bigint comment '订单详情ID',
        primary key (id)
    );

    create table slsys.price (
        id bigint not null auto_increment,
        goods_id bigint comment '物资ID',
        sale_mode_id bigint comment '销售模式ID',
        price double precision default 0 comment '单位单价',
        weight double precision default 0 comment '单位重量',
        money double precision default 0 comment '组合单价',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.role (
        id bigint not null auto_increment,
        name varchar(128) not null comment '角色名称',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.sale_mode (
        id bigint not null auto_increment,
        name longtext comment '销售模式',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.user (
        id bigint not null auto_increment,
        role_id bigint not null comment '用户角色',
        username varchar(100) not null comment '用户名称',
        password varchar(255) not null comment '用户密码',
        phone varchar(20) comment '用户电话',
        url longtext comment '角色头像',
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    create table slsys.user_info (
        id bigint not null,
        user_id bigint not null,
        company_id bigint,
        create_date datetime default CURRENT_TIMESTAMP comment '创建时间',
        update_date datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
        state integer default 1 comment '数据状态(1:有效；0删除)',
        primary key (id)
    );

    alter table slsys.goods 
        add index FK5DF9756B1A65721 (type_id), 
        add constraint FK5DF9756B1A65721 
        foreign key (type_id) 
        references slsys.goods_type (id);

    alter table slsys.order 
        add index FK651874EE47B060F (sale), 
        add constraint FK651874EE47B060F 
        foreign key (sale) 
        references slsys.user_info (id);

    alter table slsys.order 
        add index FK651874E4C2E4AC9 (purchase), 
        add constraint FK651874E4C2E4AC9 
        foreign key (purchase) 
        references slsys.user_info (id);

    alter table slsys.order_detail 
        add index FK23AE5A6232347F3D (order_code), 
        add constraint FK23AE5A6232347F3D 
        foreign key (order_code) 
        references slsys.order (id);

    alter table slsys.order_detail 
        add index FK23AE5A623F0478A9 (order_detail_code), 
        add constraint FK23AE5A623F0478A9 
        foreign key (order_detail_code) 
        references slsys.order (id);

    alter table slsys.order_detail 
        add index FK23AE5A628341E1AB (goods_id), 
        add constraint FK23AE5A628341E1AB 
        foreign key (goods_id) 
        references slsys.goods (id);

    alter table slsys.order_detail 
        add index FK23AE5A62AAB13278 (sale_mode_id), 
        add constraint FK23AE5A62AAB13278 
        foreign key (sale_mode_id) 
        references slsys.sale_mode (id);

    alter table slsys.price 
        add index FK65FB1498341E1AB (goods_id), 
        add constraint FK65FB1498341E1AB 
        foreign key (goods_id) 
        references slsys.goods (id);

    alter table slsys.price 
        add index FK65FB149AAB13278 (sale_mode_id), 
        add constraint FK65FB149AAB13278 
        foreign key (sale_mode_id) 
        references slsys.sale_mode (id);

    alter table slsys.user 
        add index FK36EBCBCE5FAA7 (role_id), 
        add constraint FK36EBCBCE5FAA7 
        foreign key (role_id) 
        references slsys.role (id);

    alter table slsys.user_info 
        add index FK1437D8A2A2A6540B (company_id), 
        add constraint FK1437D8A2A2A6540B 
        foreign key (company_id) 
        references slsys.company (id);

    alter table slsys.user_info 
        add index FK1437D8A2B210BE87 (user_id), 
        add constraint FK1437D8A2B210BE87 
        foreign key (user_id) 
        references slsys.user (id);
