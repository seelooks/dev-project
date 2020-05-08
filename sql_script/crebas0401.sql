/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/4/1/周一 17:25:01                         */
/*==============================================================*/


drop table if exists base_device_tag;

drop table if exists base_device_tag_cg;

drop table if exists base_device_type;

drop table if exists base_divice_static_info;

drop table if exists base_storeroom;

drop table if exists commTable;

drop table if exists dyn_device_dynamic_info;

/*==============================================================*/
/* Table: base_device_tag                                       */
/*==============================================================*/
create table base_device_tag
(
   id                   varchar(32) not null comment 'id',
   tag_name             varchar(64) comment '标签（分组）名称',
   tag_type             int comment '分组类型（钻机类型、设备部件、资产、特种设备）',
   create_by            varchar(32) comment '创建人员',
   create_date          datetime comment '创建时间',
   update_by            varchar(32) comment '修改人员',
   update_date          datetime comment '修改时间',
   create_user_org      varchar(32) comment '创建人员组织机构',
   update_user_org      varchar(32) comment '修改人员组织机构',
   
   primary key (id)
);

alter table base_device_tag comment '设备（标签）标签管理';

/*==============================================================*/
/* Table: base_device_tag_cg                                    */
/*==============================================================*/
create table base_device_tag_cg
(
   id                   varchar(32) not null comment 'id',
   div_static_id        varchar(32) comment '设备静态数据id',
   div_tag_id           varchar(32) comment '设备标签id',
   create_by            varchar(32) comment '创建人员',
   create_date          datetime comment '创建时间',
   update_by            varchar(32) comment '修改人员',
   update_date          datetime comment '修改时间',
   create_user_org      varchar(32) comment '创建人员组织机构',
   update_user_org      varchar(32) comment '修改人员组织机构',
   
   primary key (id)
);

alter table base_device_tag_cg comment '设备标签中间表';

/*==============================================================*/
/* Table: base_device_type                                      */
/*==============================================================*/
create table base_device_type
(
   id                   varchar(32) not null comment 'id',
   type_code            varchar(36) comment '类型编号',
   parent_id            varchar(36) comment '父类型编号',
   parent_ids           varchar(500) comment '父类型编号s',
   type_name            varchar(36) comment '类型名称',
   create_by            varchar(32) comment '创建人员',
   create_date          datetime comment '创建时间',
   update_by            varchar(32) comment '修改人员',
   update_date          datetime comment '修改时间',
   create_user_org      varchar(32) comment '创建人员组织机构',
   update_user_org      varchar(32) comment '修改人员组织机构',
   
   primary key (id)
);

alter table base_device_type comment 'base_设备类型';

/*==============================================================*/
/* Table: base_divice_static_info                               */
/*==============================================================*/
create table base_divice_static_info
(
   id                   varchar(32) not null comment 'id',
   dev_code             varchar(64) comment '设备编号',
   dev_self_code        varchar(64) comment '设备自编号',
   dev_name             varchar(64) comment '设备名称',
   norm                 varchar(64) comment '规格型号',
   goout_num            varchar(128) comment '出厂编号（机身号）',
   factory              varchar(64) comment '生产厂家',
   units                varchar(64) comment '计量单位',
   production_date      datetime comment '生产日期',
   comes_on_data        datetime comment '投产日期',
   devi_situation       int comment '设备情况',
   tech_situation       int comment '技术情况',
   use_situation        int comment '使用情况',
   deposit_address      varchar(128) comment '存放地点',
   mark                 varchar(64) comment '贴牌编号',
   rfid_code            varchar(64) comment 'RFID标签号',
   gps_code             varchar(64) comment 'GSP标签号',
   primary key (id)
);

alter table base_divice_static_info comment 'base_设备静态基础信息（设备档案）';

/*==============================================================*/
/* Table: base_storeroom                                        */
/*==============================================================*/
create table base_storeroom
(
   id                   varchar(32) not null comment 'id',
   storeroom_code       varchar(32) comment '库房代码',
   storeroom_name       varchar(64) comment '库房名称',
   org_id               varchar(32) comment '所属单位(组织机构节点)',
   address              varchar(64) comment '库房地址',
   create_by            varchar(32) comment '创建人员',
   create_date          datetime comment '创建时间',
   update_by            varchar(32) comment '修改人员',
   update_date          datetime comment '修改时间',
   create_user_org      varchar(32) comment '创建人员组织机构',
   update_user_org      varchar(32) comment '修改人员组织机构',
   
   primary key (id)
);

alter table base_storeroom comment '库房管理';

/*==============================================================*/
/* Table: commTable                                             */
/*==============================================================*/
create table commTable
(
   create_by            varchar(32) comment '创建人员',
   create_date          datetime comment '创建时间',
   update_by            varchar(32) comment '修改人员',
   update_date          datetime comment '修改时间',
   create_user_org      varchar(32) comment '创建人员组织机构',
   update_user_org      varchar(32) comment '修改人员组织机构',
   remarks              varchar(255) comment '备注',
   reserved1            int comment '预留字段1',
   reserved2            int comment '预留字段2',
   reserved3            varchar(32) comment '预留字段3',
   reserved4            varchar(32) comment '预留字段4',
   reserved5            float comment '预留字段5',
   reserved6            float comment '预留字段6',
   reserved7            datetime comment '预留字段7',
   reserved8            varchar(255) comment '预留字段8'
);

alter table commTable comment '通用功能表';

/*==============================================================*/
/* Table: dyn_device_dynamic_info                               */
/*==============================================================*/
create table dyn_device_dynamic_info
(
   id                   varchar(32) not null comment 'id',
   dev_id               varchar(32) comment 'id（和静态数据对应）',
   asset_belongs_unit   varchar(32) comment '资产所属单位F_org',
   using_unit           varchar(32) comment '设备使用单位F_org',
   save_address         varchar(32) comment '设备存放地址F_org',
   use_situ             int comment '设备使用情况',
   tecg_situ            int comment '设备技术情况',
   devi_situ            int comment '设备情况',
   create_by            varchar(32) comment '创建人员',
   create_date          datetime comment '创建时间',
   update_by            varchar(32) comment '修改人员',
   update_date          datetime comment '修改时间',
   create_user_org      varchar(32) comment '创建人员组织机构',
   update_user_org      varchar(32) comment '修改人员组织机构',
   
   primary key (id)
);

alter table dyn_device_dynamic_info comment 'dyn_设备动态信息';

