create table ceam_commercial
(
    id          bigint       not null
        primary key,
    title       varchar(64)  not null comment '广告标题',
    link        varchar(255) not null comment '所广告的商品页面或者活动页面链接地址',
    url         varchar(255) not null comment '广告宣传图片',
    position    int          null comment '广告位置：1则是首页',
    description varchar(255) null comment '活动内容',
    start_time  datetime     null comment '广告开始时间',
    end_time    datetime     null comment '广告结束时间',
    deleted     tinyint(1)   null,
    add_time    datetime     null,
    add_by      bigint       null,
    upd_time    datetime     null,
    upd_by      bigint       null,
    status      int          null comment '1启用，0禁用'
)
    comment '广告表';

create table ceam_coupon
(
    id          bigint auto_increment
        primary key,
    name        varchar(63) charset utf8mb3               not null comment '优惠券名称',
    description varchar(127) charset utf8mb3 default ''   null comment '优惠券介绍，通常是显示优惠券使用限制文字',
    tag         varchar(63) charset utf8mb3  default ''   null comment '优惠券标签，例如新人专用',
    total       int                          default 0    not null comment '优惠券数量，如果是0，则是无限量',
    discount    decimal(10, 2)               default 0.00 null comment '优惠金额，',
    min         decimal(10, 2)               default 0.00 null comment '最少消费金额才能使用优惠券。',
    limit_num   smallint                     default 1    null comment '用户领券限制数量，如果是0，则是不限制；默认是1，限领一张.',
    type        smallint                     default 0    null comment '优惠券赠送类型，如果是0则通用券，用户领取；如果是1，则是注册赠券；如果是2，则是优惠券码兑换；',
    status      smallint                     default 0    null comment '优惠券状态，如果是0则是正常可用；如果是1则是过期; 如果是2则是下架。',
    goods_type  smallint                     default 0    null comment '商品限制类型，如果0则全商品，如果是1则是类目限制，如果是2则是商品限制。',
    goods_value varchar(255) charset utf8mb3 default '[]' null comment '商品限制值，goods_type如果是0则空集合，如果是1则是类目集合，如果是2则是商品集合。',
    code        varchar(63) charset utf8mb3               null comment '优惠券兑换码',
    time_type   smallint                     default 0    null comment '有效时间限制，如果是0，则基于领取时间的有效天数days；如果是1，则start_time和end_time是优惠券有效期；',
    days        smallint                     default 0    null comment '基于领取时间的有效天数days。',
    start_time  date                                      null comment '使用券开始时间',
    end_time    date                                      null comment '使用券截至时间',
    add_time    datetime                                  null comment '创建时间',
    upd_time    datetime                                  null comment '更新时间',
    deleted     tinyint(1)                   default 0    null comment '逻辑删除'
)
    comment '优惠券信息及规则表' row_format = COMPACT;

create table ceam_customer_coupon
(
    id          bigint auto_increment
        primary key,
    customer_id bigint       null,
    coupon_id   bigint       null,
    status      int          null,
    used_time   datetime     null,
    start_time  datetime     null,
    end_time    datetime     null,
    order_sn    varchar(100) null,
    add_time    datetime     null,
    upd_time    datetime     null,
    deleted     tinyint(1)   null
);

create table ceam_customer_info
(
    id bigint null
);

create table ceam_customer_level
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) charset utf8mb3 default ''   not null comment '会员名称',
    money      decimal(10, 2)               default 0.00 not null comment '购买金额',
    valid_date int                          default 0    not null comment '有效时间',
    is_forever tinyint(1)                   default 0    not null comment '是否为永久会员',
    is_pay     tinyint(1)                   default 0    not null comment '是否购买,1购买,0不购买',
    is_show    tinyint(1)                   default 0    not null comment '是否显示 1显示,0隐藏',
    grade      int                          default 0    not null comment '会员等级',
    discount   decimal(10, 2)               default 0.00 not null comment '享受折扣',
    image      varchar(255) charset utf8mb3 default ''   not null comment '会员卡背景',
    icon       varchar(255) charset utf8mb3 default ''   not null comment '会员图标',
    remark     varchar(255) charset utf8mb3              null comment '说明',
    add_time   datetime                                  not null comment '添加时间',
    upd_time   datetime                                  null,
    deleted    tinyint(1)                   default 0    not null
)
    comment '设置用户等级表' row_format = DYNAMIC;

create table ceam_footprints
(
    id          bigint auto_increment
        primary key,
    customer_id bigint     default 0 not null comment '用户表的用户ID',
    goods_id    bigint     default 0 not null comment '浏览商品ID',
    add_time    datetime             null comment '创建时间',
    upd_time    datetime             null comment '更新时间',
    deleted     tinyint(1) default 0 null comment '逻辑删除'
)
    comment '用户浏览足迹表' row_format = COMPACT;

create table ceam_goods
(
    id            bigint auto_increment
        primary key,
    goods_sn      varchar(36)    null comment '商品编号',
    name          varchar(128)   null comment '商品名称',
    category_id   bigint         null comment '分类ID',
    brand_id      bigint         null comment '品牌ID',
    stock         int            null comment '库存',
    price         varchar(100)   null comment '价格',
    marking_price decimal(12, 2) null comment '市场价',
    member_price  decimal(12, 2) null comment '会员价',
    sort_order    int            null comment '排序',
    is_new        tinyint(1)     null comment '是否新品首发，如果设置则可以在新品首发页面展示',
    is_hot        tinyint(1)     null comment '是否人气推荐，如果设置则可以在人气推荐页面展示',
    pic_url       varchar(255)   null,
    goods_type    int            null comment '商品类型',
    sales         int            null comment '销量',
    status        int            null comment '1上架，2下架',
    deleted       tinyint(1)     null,
    add_time      datetime       null
)
    comment '商品信息表';

create table ceam_goods_bargain
(
    id                bigint unsigned auto_increment comment '砍价产品ID'
        primary key,
    goods_id          bigint unsigned                      not null comment '关联产品ID',
    title             varchar(255)                         not null comment '砍价活动名称',
    pic_url           varchar(150)                         not null comment '砍价活动图片',
    unit_name         varchar(16)                          null comment '单位名称',
    stock             int unsigned                         null comment '库存',
    sales             int unsigned                         null comment '销量',
    images            varchar(2000)                        not null comment '砍价产品轮播图',
    start_time        datetime                             not null comment '砍价开启时间',
    end_time          datetime                             not null comment '砍价结束时间',
    store_name        varchar(255)                         null comment '砍价产品名称',
    price             decimal(8, 2) unsigned               null comment '砍价金额',
    min_price         decimal(8, 2) unsigned               null comment '砍价商品最低价',
    num               int unsigned                         null comment '每次购买的砍价产品数量',
    bargain_max_price decimal(8, 2) unsigned               null comment '用户每次砍价的最大金额',
    bargain_min_price decimal(8, 2) unsigned               null comment '用户每次砍价的最小金额',
    bargain_num       int unsigned            default '1'  not null comment '用户每次砍价的次数',
    status            tinyint unsigned        default '1'  not null comment '砍价状态 0(到砍价时间不自动开启)  1(到砍价时间自动开启时间)',
    description       varchar(255)                         null comment '砍价详情',
    give_integral     decimal(10, 2) unsigned default 0.00 not null comment '反多少积分',
    info              varchar(255)                         null comment '砍价活动简介',
    cost              decimal(8, 2) unsigned               null comment '成本价',
    sort              int unsigned            default '0'  not null comment '排序',
    deleted           tinyint unsigned        default '0'  not null comment '是否删除 0未删除 1删除',
    add_time          datetime                             null comment '添加时间',
    upd_time          datetime                             null,
    rule              varchar(255)                         null comment '砍价规则',
    look              int unsigned            default '0'  null comment '砍价产品浏览量',
    share             int unsigned            default '0'  null comment '砍价产品分享量'
)
    comment '砍价表' charset = utf8mb3
                     row_format = DYNAMIC;

create table ceam_goods_brand
(
    id               bigint auto_increment
        primary key,
    name             varchar(255)   default ''   not null comment '品牌商名称',
    brands_desc      varchar(255)   default ''   not null comment '品牌商简介',
    pic_url          varchar(255)   default ''   not null comment '品牌商页的品牌商图片',
    sort_order       int            default 50   null,
    floor_price      decimal(10, 2) default 0.00 null comment '品牌商的商品低价，仅用于页面展示',
    add_time         datetime                    null comment '创建时间',
    upde_time        datetime                    null comment '更新时间',
    share_url        varchar(255)                null comment '分享二维码图片',
    add_by           bigint                      null comment '管理用户id',
    deleted          tinyint(1)     default 0    null comment '逻辑删除',
    commpany         varchar(128)                null,
    auto_update_good tinyint(1)                  null comment '自动监控更新商品',
    shop_url         varchar(255)                null comment '店铺url地址',
    default_cate_id  bigint                      null comment '默认的商品类别id',
    default_pages    int                         null comment '默认商品页面数',
    add_precent      int                         null comment '店铺商品溢价',
    address          varchar(127)                null comment '提货地址',
    longitude        decimal(10, 7)              null comment '经度',
    latitude         decimal(10, 7)              null comment '纬度',
    fetch_time_rules varchar(255)                null comment '提货时间配置'
)
    comment '品牌商表' row_format = COMPACT;

create table ceam_goods_category
(
    id        bigint auto_increment comment '商品分类表ID'
        primary key,
    pid       bigint                       not null comment '父id',
    cate_name varchar(100)                 not null comment '分类名称',
    sort      mediumint                    null comment '排序',
    pic       varchar(128)     default ''  null comment '图标',
    is_show   tinyint(1)       default 1   null comment '是否推荐',
    add_time  datetime                     null comment '添加时间',
    upd_time  datetime                     null,
    deleted   tinyint unsigned default '0' null comment '删除状态'
)
    comment '商品分类表' charset = utf8mb3
                         row_format = DYNAMIC;

create index add_time
    on ceam_goods_category (add_time);

create index is_base
    on ceam_goods_category (is_show);

create index pid
    on ceam_goods_category (pid);

create index sort
    on ceam_goods_category (sort);

create table ceam_goods_collect
(
    id          bigint auto_increment
        primary key,
    customer_id bigint     default 0 not null comment '用户表的用户ID',
    value_id    int        default 0 not null comment '如果type=0，则是商品ID；如果type=1，则是专题ID',
    type        int        default 0 not null comment '收藏类型，如果type=0，则是商品ID；如果type=1，则是专题ID',
    add_time    datetime             null comment '创建时间',
    upd_time    datetime             null comment '更新时间',
    deleted     tinyint(1) default 0 null comment '逻辑删除'
)
    comment '收藏表' row_format = COMPACT;

create index goods_id
    on ceam_goods_collect (value_id);

create index user_id
    on ceam_goods_collect (customer_id);

create table ceam_goods_seckill
(
    id            bigint unsigned auto_increment comment '商品秒杀产品表id'
        primary key,
    goods_id      bigint unsigned                     not null comment '商品id',
    pic_url       varchar(255) charset utf8mb3        not null comment '推荐图',
    images        varchar(2000) charset utf8mb3       not null comment '轮播图',
    title         varchar(255) charset utf8mb3        not null comment '活动标题',
    info          varchar(255) charset utf8mb3        not null comment '简介',
    price         decimal(10, 2) unsigned             null comment '价格',
    cost          decimal(8, 2) unsigned default 0.00 null comment '成本',
    origin_price  decimal(10, 2) unsigned             null comment '原价',
    give_integral decimal(10, 2) unsigned             null comment '返多少积分',
    sort          int unsigned                        not null comment '排序',
    stock         int unsigned                        not null comment '库存',
    sales         int unsigned           default '0'  not null comment '销量',
    unit_name     varchar(16) charset utf8mb3         not null comment '单位名',
    description   varchar(255) charset utf8mb3        null comment '内容',
    start_time    date                                not null comment '开始时间',
    end_time      date                                not null comment '结束时间',
    add_time      datetime                            not null comment '添加时间',
    upd_time      datetime                            null,
    status        int unsigned                        not null comment '产品状态',
    deleted       tinyint unsigned       default '0'  not null comment '删除 0未删除1已删除',
    max_num       int unsigned                        not null comment '最多秒杀几个',
    is_show       tinyint unsigned       default '1'  not null comment '显示',
    time_id       int unsigned           default '0'  null comment '时间段id',
    spec_type     tinyint(1)                          null comment '规格 0单 1多',
    temp_id       int                                 null comment '运费模板id'
)
    comment '商品秒杀产品表' row_format = DYNAMIC;

create index add_time
    on ceam_goods_seckill (add_time);

create index is_del
    on ceam_goods_seckill (deleted);

create index is_show
    on ceam_goods_seckill (status);

create index product_id
    on ceam_goods_seckill (goods_id);

create index sort
    on ceam_goods_seckill (sort);

create index start_time
    on ceam_goods_seckill (start_time, end_time);

create table ceam_role_menu
(
    id      bigint unsigned auto_increment comment '角色映射对应菜单的标识id'
        primary key,
    role_id bigint unsigned not null comment '角色ID',
    menu_id bigint unsigned not null comment '菜单ID-只对应根菜单'
);

create index security_role_menu_security_menu_info_id_fk
    on ceam_role_menu (menu_id);

create index security_role_menu_security_user_role_id_fk
    on ceam_role_menu (role_id);

create table ceam_sys_dept
(
    id       bigint auto_increment comment 'ID'
        primary key,
    name     varchar(255) charset utf8mb3 not null comment '名称',
    pid      bigint                       not null comment '上级部门',
    enabled  tinyint(1)                   not null comment '状态',
    add_time datetime                     null comment '创建日期',
    upd_time datetime                     null,
    deleted  tinyint(1) default 0         null
)
    comment '部门' row_format = COMPACT;

create table ceam_sys_dict
(
    id       bigint auto_increment
        primary key,
    name     varchar(255)         not null comment '字典名称',
    remark   varchar(255)         null comment '描述',
    add_time datetime             null comment '创建日期',
    upd_time datetime             null,
    deleted  tinyint(1) default 0 null
)
    comment '数据字典';

create table ceam_sys_dict_detail
(
    id       bigint auto_increment
        primary key,
    label    varchar(255)         not null comment '字典标签',
    value    varchar(255)         not null comment '字典值',
    sort     varchar(255)         null comment '排序',
    dict_id  bigint               null comment '字典id',
    add_time datetime             null comment '创建日期',
    upd_time datetime             null,
    deleted  tinyint(1) default 0 null
)
    comment '数据字典详情';

create table ceam_sys_job
(
    id       bigint auto_increment comment 'ID'
        primary key,
    name     varchar(255)         not null comment '岗位名称',
    enabled  tinyint(1)           not null comment '岗位状态',
    dept_id  bigint               null comment '部门ID',
    add_time datetime             null comment '创建日期',
    upd_time datetime             null,
    deleted  tinyint(1) default 0 null
)
    comment '岗位' charset = utf8mb3
                   row_format = COMPACT;

create table ceam_sys_menu
(
    id             bigint auto_increment comment 'ID'
        primary key,
    i_frame        bit                                      null comment '是否外链',
    name           varchar(255) charset utf8mb3             null comment '菜单名称',
    component      varchar(255) charset utf8mb3             null comment '组件',
    pid            bigint                                   not null comment '上级菜单ID',
    sort           bigint                                   not null comment '排序',
    icon           varchar(255) charset utf8mb3             null comment '图标',
    path           varchar(255) charset utf8mb3             null comment '链接地址',
    cache          bit                         default b'0' null comment '缓存',
    hidden         bit                         default b'0' null comment '是否隐藏',
    component_name varchar(20) charset utf8mb3 default '-'  null comment '组件名称',
    add_time       datetime                                 null comment '创建日期',
    permission     varchar(255) charset utf8mb3             null comment '权限',
    type           int                                      null comment '类型',
    upd_time       datetime                                 null,
    deleted        tinyint(1)                  default 0    null
)
    row_format = COMPACT;

create index FKqcf9gem97gqa5qjm4d3elcqt5
    on ceam_sys_menu (pid);

create table ceam_sys_role
(
    id          bigint auto_increment
        primary key,
    name        varchar(63)  not null comment '角色名称',
    description varchar(255) null comment '角色描述',
    enabled     tinyint(1)   not null comment '是否启用',
    data_scope  varchar(255) null comment '数据权限',
    permission  varchar(255) null comment '功能权限',
    level       int          null comment '角色级别',
    deleted     tinyint(1)   null comment '逻辑删除',
    add_by      bigint       null,
    update_time datetime     null,
    add_time    datetime     null,
    constraint name_UNIQUE
        unique (name)
)
    comment '角色表' row_format = COMPACT;

create table ceam_sys_user
(
    id              bigint auto_increment comment '唯一标识'
        primary key,
    username        varchar(63)          not null comment '用户名称',
    password        varchar(63)          not null comment '用户密码',
    sex             int                  null comment '性别：0 未知， 1男， 1 女',
    birthday        datetime             null comment '生日',
    last_login_time datetime             null comment '最近一次登录时间',
    last_login_ip   varchar(63)          null comment '最近一次登录IP地址',
    user_level      int                  null comment '用户层级 0 普通用户，1 VIP用户，2 区域代理用户',
    nickname        varchar(63)          null comment '用户昵称或网络名称',
    phone_num       varchar(20)          null comment '用户手机号码',
    avatar          varchar(255)         null comment '用户头像图片',
    weixin_openid   varchar(63)          null comment '微信登录openid',
    share_user_id   bigint               null,
    status          int                  not null comment '0 可用, 1 禁用, 2 注销',
    add_time        datetime             null,
    update_time     datetime             null,
    deleted         tinyint(1)           not null comment '逻辑删除',
    dept_id         bigint               null,
    attention       tinyint(1) default 0 null
)
    comment '用户表';

create table ceam_user_role
(
    id      bigint unsigned auto_increment comment '用户 映射 角色的关系id'
        primary key,
    user_id bigint not null,
    role_id bigint not null
);

