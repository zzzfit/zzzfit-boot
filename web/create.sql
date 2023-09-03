alter table alliance_dians
    drop foreign key FKatywp75m2f1lsrbahfhomurv9;
alter table alliance_dians
    drop foreign key FKgkfn0chcjdvacpf0l2ss1murc;
alter table appointment
    drop foreign key FK4r7cwqrwsavnyebiybpeyt350;
alter table attendance
    drop foreign key FKlsi77buto2iknunetxvp2vtw3;
alter table class_teachers
    drop foreign key FKceaoqs9sgq46ox0qlmpptgi6h;
alter table class_teachers
    drop foreign key FK7d3xlbrpue44wny4fghbxqmc;
alter table organization
    drop foreign key FKc30yedjwp9qw1f3nn2ytda7tj;
alter table role_authority
    drop foreign key FKqbri833f7xop13bvdje3xxtnw;
alter table role_authority
    drop foreign key FK2052966dco7y9f97s1a824bj1;
alter table user_role
    drop foreign key FKa68196081fvovjhkek5m97n3y;
alter table user_role
    drop foreign key FK859n2jvi8ivhui0rl0esws6o;
drop table if exists address;
drop table if exists address_seq;
drop table if exists alliance;
drop table if exists alliance_dians;
drop table if exists alliance_seq;
drop table if exists appointment;
drop table if exists appointment_seq;
drop table if exists attendance;
drop table if exists attendance_seq;
drop table if exists authority;
drop table if exists authority_seq;
drop table if exists campaign;
drop table if exists campaign_seq;
drop table if exists class;
drop table if exists class_seq;
drop table if exists class_teachers;
drop table if exists contract;
drop table if exists contract_seq;
drop table if exists coupon;
drop table if exists coupon_seq;
drop table if exists course;
drop table if exists course_seq;
drop table if exists device;
drop table if exists device_seq;
drop table if exists dian;
drop table if exists dian_seq;
drop table if exists franchisee;
drop table if exists franchisee_seq;
drop table if exists invitation;
drop table if exists invitation_seq;
drop table if exists invoice;
drop table if exists invoice_seq;
drop table if exists lead;
drop table if exists lead_seq;
drop table if exists member_card_seq;
drop table if exists member_card;
drop table if exists oauth2authorization;
drop table if exists oauth2authorization_seq;
drop table if exists oauth2authorization_consent;
drop table if exists oauth2registered_client_seq;
drop table if exists oauth2registered_client;
drop table if exists order;
drop table if exists order_seq;
drop table if exists organization;
drop table if exists organization_seq;
drop table if exists payment;
drop table if exists payment_seq;
drop table if exists role;
drop table if exists role_authority;
drop table if exists role_seq;
drop table if exists tenant;
drop table if exists tenant_seq;
drop table if exists user;
drop table if exists user_role;
drop table if exists user_seq;
drop table if exists voucher;
drop table if exists voucher_seq;
create table address
(
    latitude    float(53),
    longitude   float(53),
    id          bigint not null,
    city        varchar(255),
    district    varchar(255),
    postal_code varchar(255),
    province    varchar(255),
    street      varchar(255),
    primary key (id)
) engine=InnoDB;
create table address_seq
(
    next_val bigint
) engine=InnoDB;
insert into address_seq
values (1);
create table alliance
(
    deleted     bit,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table alliance_dians
(
    alliance_id bigint not null,
    dians_id    bigint not null
) engine=InnoDB;
create table alliance_seq
(
    next_val bigint
) engine=InnoDB;
insert into alliance_seq
values (1);
create table appointment
(
    class_id bigint,
    id       bigint not null,
    primary key (id)
) engine=InnoDB;
create table appointment_seq
(
    next_val bigint
) engine=InnoDB;
insert into appointment_seq
values (1);
create table attendance
(
    check_in_time datetime(6),
    class_id      bigint,
    id            bigint not null,
    primary key (id)
) engine=InnoDB;
create table attendance_seq
(
    next_val bigint
) engine=InnoDB;
insert into attendance_seq
values (1);
create table authority
(
    deleted     bit,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    name        varchar(63) not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table authority_seq
(
    next_val bigint
) engine=InnoDB;
insert into authority_seq
values (1);
create table campaign
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table campaign_seq
(
    next_val bigint
) engine=InnoDB;
insert into campaign_seq
values (1);
create table class
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table class_seq
(
    next_val bigint
) engine=InnoDB;
insert into class_seq
values (1);
create table class_teachers
(
    class_id    bigint not null,
    teachers_id bigint not null,
    primary key (class_id, teachers_id)
) engine=InnoDB;
create table contract
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table contract_seq
(
    next_val bigint
) engine=InnoDB;
insert into contract_seq
values (1);
create table coupon
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table coupon_seq
(
    next_val bigint
) engine=InnoDB;
insert into coupon_seq
values (1);
create table course
(
    id   bigint not null,
    tags varchar(255),
    primary key (id)
) engine=InnoDB;
create table course_seq
(
    next_val bigint
) engine=InnoDB;
insert into course_seq
values (1);
create table device
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table device_seq
(
    next_val bigint
) engine=InnoDB;
insert into device_seq
values (1);
create table dian
(
    business_hour_end   time(6),
    business_hour_start time(6),
    deleted             bit,
    shop_area           float(23),
    status              tinyint check (status between 0 and 3),
    created_at          datetime(6) not null,
    created_by          bigint      not null,
    id                  bigint      not null,
    updated_at          datetime(6) not null,
    updated_by          bigint      not null,
    description         varchar(255),
    equipment_info      varchar(255),
    primary key (id)
) engine=InnoDB;
create table dian_seq
(
    next_val bigint
) engine=InnoDB;
insert into dian_seq
values (1);
create table franchisee
(
    deleted     bit,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table franchisee_seq
(
    next_val bigint
) engine=InnoDB;
insert into franchisee_seq
values (1);
create table invitation
(
    deleted     bit,
    when        time(6)     not null,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table invitation_seq
(
    next_val bigint
) engine=InnoDB;
insert into invitation_seq
values (1);
create table invoice
(
    paid_amount   decimal(12, 2) not null,
    id            bigint         not null,
    number        varchar(16)    not null,
    download_link varchar(255),
    primary key (id)
) engine=InnoDB;
create table invoice_seq
(
    next_val bigint
) engine=InnoDB;
insert into invoice_seq
values (1);
create table lead
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table lead_seq
(
    next_val bigint
) engine=InnoDB;
insert into lead_seq
values (1);
create table member_card_seq
(
    next_val bigint
) engine=InnoDB;
insert into member_card_seq
values (1);
create table member_card
(
    end_date    date,
    paid_amount decimal(12, 2),
    start_date  date,
    id          bigint not null,
    primary key (id)
) engine=InnoDB;
create table oauth2authorization
(
    access_token_expires_at       datetime(6),
    access_token_issued_at        datetime(6),
    authorization_code_expires_at datetime(6),
    authorization_code_issued_at  datetime(6),
    device_code_expires_at        datetime(6),
    device_code_issued_at         datetime(6),
    oidc_id_token_expires_at      datetime(6),
    oidc_id_token_issued_at       datetime(6),
    refresh_token_expires_at      datetime(6),
    refresh_token_issued_at       datetime(6),
    user_code_expires_at          datetime(6),
    user_code_issued_at           datetime(6),
    access_token_scopes           varchar(100),
    access_token_type             varchar(100),
    authorization_grant_type      varchar(100) not null,
    id                            varchar(100) not null,
    registered_client_id          varchar(100) not null,
    principal_name                varchar(200) not null,
    authorized_scopes             varchar(1000),
    access_token_value            varbinary(255),
    refresh_token_value           varbinary(255),
    access_token_metadata         tinyblob,
    attributes                    blob,
    authorization_code_metadata   tinyblob,
    authorization_code_value      tinyblob,
    device_code_metadata          tinyblob,
    device_code_value             tinyblob,
    oidc_id_token_metadata        tinyblob,
    oidc_id_token_value           tinyblob,
    refresh_token_metadata        tinyblob,
    state                         blob,
    user_code_metadata            tinyblob,
    user_code_value               tinyblob,
    primary key (id)
) engine=InnoDB;
create table oauth2authorization_seq
(
    next_val bigint
) engine=InnoDB;
insert into oauth2authorization_seq
values (1);
create table oauth2authorization_consent
(
    registered_client_id varchar(100)  not null,
    principal_name       varchar(200)  not null,
    authorities          varchar(1000) not null,
    primary key (registered_client_id, principal_name)
) engine=InnoDB;
create table oauth2registered_client_seq
(
    next_val bigint
) engine=InnoDB;
insert into oauth2registered_client_seq
values (1);
create table oauth2registered_client
(
    client_id_issued_at           datetime(6)  not null,
    client_secret_expires_at      datetime(6),
    client_id                     varchar(100),
    id                            varchar(100) not null,
    client_name                   varchar(200),
    client_secret                 varchar(200),
    authorization_grant_types     varchar(1000),
    client_authentication_methods varchar(1000),
    post_logout_redirect_uris     varchar(1000),
    redirect_uris                 varchar(1000),
    scopes                        varchar(1000),
    client_settings               varchar(2000),
    token_settings                varchar(2000),
    primary key (id)
) engine=InnoDB;
create table order
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table order_seq
(
    next_val bigint
) engine=InnoDB;
insert into order_seq
values (1);
create table organization
(
    deleted     bit,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    parent_id   bigint,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    name        varchar(63) not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table organization_seq
(
    next_val bigint
) engine=InnoDB;
insert into organization_seq
values (1);
create table payment
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table payment_seq
(
    next_val bigint
) engine=InnoDB;
insert into payment_seq
values (1);
create table role
(
    deleted     bit,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    name        varchar(63) not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table role_authority
(
    authority_id bigint not null,
    role_id      bigint not null,
    primary key (authority_id, role_id)
) engine=InnoDB;
create table role_seq
(
    next_val bigint
) engine=InnoDB;
insert into role_seq
values (1);
create table tenant
(
    deleted     bit,
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    name        varchar(63) not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;
create table tenant_seq
(
    next_val bigint
) engine=InnoDB;
insert into tenant_seq
values (1);
create table user
(
    birthday    date,
    deleted     bit,
    gender      tinyint check (gender between 0 and 1),
    created_at  datetime(6) not null,
    created_by  bigint      not null,
    id          bigint      not null,
    updated_at  datetime(6) not null,
    updated_by  bigint      not null,
    email       varchar(31),
    mobile      varchar(31),
    type        varchar(31) not null,
    nickname    varchar(63),
    username    varchar(63) not null,
    avatar_url  varchar(255),
    description varchar(255),
    password    varchar(255),
    primary key (id)
) engine=InnoDB;
create table user_role
(
    role_id bigint not null,
    user_id bigint not null,
    primary key (role_id, user_id)
) engine=InnoDB;
create table user_seq
(
    next_val bigint
) engine=InnoDB;
insert into user_seq
values (1);
create table voucher
(
    id bigint not null,
    primary key (id)
) engine=InnoDB;
create table voucher_seq
(
    next_val bigint
) engine=InnoDB;
insert into voucher_seq
values (1);
alter table alliance_dians
    add constraint UK_n1j77f5bspvh7p1326wlq0saq unique (dians_id);
alter table appointment
    add constraint UK_5wnjrqs6gkbnr8v7v5hd0dwjv unique (class_id);
alter table attendance
    add constraint UK_j82sopqp9enibyd77a9grec6v unique (class_id);
alter table authority
    add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);
alter table class_teachers
    add constraint UK_f0wgu57ke72f85a3q3wlekqa0 unique (teachers_id);
alter table organization
    add constraint UK_8j5y8ipk73yx2joy9yr653c9t unique (name);
alter table role
    add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table tenant
    add constraint UK_dcxf3ksi0gyn1tieeq0id96lm unique (name);
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table user
    add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user
    add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile);
alter table user
    add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table alliance_dians
    add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian (id);
alter table alliance_dians
    add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance (id);
alter table appointment
    add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class (id);
alter table attendance
    add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class (id);
alter table class_teachers
    add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user (id);
alter table class_teachers
    add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class (id);
alter table organization
    add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization (id);
alter table role_authority
    add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority (id);
alter table role_authority
    add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role (id);
alter table user_role
    add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
alter table user_role
    add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);
alter table alliance_dians drop foreign key FKatywp75m2f1lsrbahfhomurv9;
alter table alliance_dians drop foreign key FKgkfn0chcjdvacpf0l2ss1murc;
alter table appointment drop foreign key FK4r7cwqrwsavnyebiybpeyt350;
alter table attendance drop foreign key FKlsi77buto2iknunetxvp2vtw3;
alter table class_attendants drop foreign key FKrdli3t5or5k5di3qgxevcx3m3;
alter table class_attendants drop foreign key FKbsnc7t6muwellwmo80sgskjr;
alter table class_teachers drop foreign key FKceaoqs9sgq46ox0qlmpptgi6h;
alter table class_teachers drop foreign key FK7d3xlbrpue44wny4fghbxqmc;
alter table organization drop foreign key FKc30yedjwp9qw1f3nn2ytda7tj;
alter table role_authority drop foreign key FKqbri833f7xop13bvdje3xxtnw;
alter table role_authority drop foreign key FK2052966dco7y9f97s1a824bj1;
alter table user_role drop foreign key FKa68196081fvovjhkek5m97n3y;
alter table user_role drop foreign key FK859n2jvi8ivhui0rl0esws6o;
drop table if exists address;
drop table if exists address_seq;
drop table if exists alliance;
drop table if exists alliance_dians;
drop table if exists alliance_seq;
drop table if exists appointment;
drop table if exists appointment_seq;
drop table if exists attendance;
drop table if exists attendance_seq;
drop table if exists authority;
drop table if exists authority_seq;
drop table if exists campaign;
drop table if exists campaign_seq;
drop table if exists class;
drop table if exists class_attendants;
drop table if exists class_seq;
drop table if exists class_teachers;
drop table if exists contract;
drop table if exists contract_seq;
drop table if exists coupon;
drop table if exists coupon_seq;
drop table if exists course;
drop table if exists course_seq;
drop table if exists device;
drop table if exists device_seq;
drop table if exists dian;
drop table if exists dian_seq;
drop table if exists franchisee;
drop table if exists franchisee_seq;
drop table if exists invitation;
drop table if exists invitation_seq;
drop table if exists invoice;
drop table if exists invoice_seq;
drop table if exists lead;
drop table if exists lead_seq;
drop table if exists member_card_seq;
drop table if exists member_card;
drop table if exists oauth2authorization;
drop table if exists oauth2authorization_seq;
drop table if exists oauth2authorization_consent;
drop table if exists oauth2registered_client_seq;
drop table if exists oauth2registered_client;
drop table if exists order;
drop table if exists order_seq;
drop table if exists organization;
drop table if exists organization_seq;
drop table if exists payment;
drop table if exists payment_seq;
drop table if exists role;
drop table if exists role_authority;
drop table if exists role_seq;
drop table if exists tenant;
drop table if exists tenant_seq;
drop table if exists user;
drop table if exists user_role;
drop table if exists user_seq;
drop table if exists voucher;
drop table if exists voucher_seq;
create table address (latitude float(53), longitude float(53), id bigint not null, city varchar(255), district varchar(255), postal_code varchar(255), province varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table alliance (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table alliance_dians (alliance_id bigint not null, dians_id bigint not null) engine=InnoDB;
create table alliance_seq (next_val bigint) engine=InnoDB;
insert into alliance_seq values ( 1 );
create table appointment (class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table attendance (check_in_time datetime(6), class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table attendance_seq (next_val bigint) engine=InnoDB;
insert into attendance_seq values ( 1 );
create table authority (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table authority_seq (next_val bigint) engine=InnoDB;
insert into authority_seq values ( 1 );
create table campaign (id bigint not null, primary key (id)) engine=InnoDB;
create table campaign_seq (next_val bigint) engine=InnoDB;
insert into campaign_seq values ( 1 );
create table class (id bigint not null, primary key (id)) engine=InnoDB;
create table class_attendants (attendants_id bigint not null, class_id bigint not null, primary key (attendants_id, class_id)) engine=InnoDB;
create table class_seq (next_val bigint) engine=InnoDB;
insert into class_seq values ( 1 );
create table class_teachers (class_id bigint not null, teachers_id bigint not null, primary key (class_id, teachers_id)) engine=InnoDB;
create table contract (id bigint not null, primary key (id)) engine=InnoDB;
create table contract_seq (next_val bigint) engine=InnoDB;
insert into contract_seq values ( 1 );
create table coupon (id bigint not null, primary key (id)) engine=InnoDB;
create table coupon_seq (next_val bigint) engine=InnoDB;
insert into coupon_seq values ( 1 );
create table course (id bigint not null, tags varchar(255), primary key (id)) engine=InnoDB;
create table course_seq (next_val bigint) engine=InnoDB;
insert into course_seq values ( 1 );
create table device (id bigint not null, primary key (id)) engine=InnoDB;
create table device_seq (next_val bigint) engine=InnoDB;
insert into device_seq values ( 1 );
create table dian (business_hour_end time(6), business_hour_start time(6), deleted bit, shop_area float(23), status tinyint check (status between 0 and 3), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), equipment_info varchar(255), primary key (id)) engine=InnoDB;
create table dian_seq (next_val bigint) engine=InnoDB;
insert into dian_seq values ( 1 );
create table franchisee (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table franchisee_seq (next_val bigint) engine=InnoDB;
insert into franchisee_seq values ( 1 );
create table invitation (deleted bit, when time(6) not null, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table invitation_seq (next_val bigint) engine=InnoDB;
insert into invitation_seq values ( 1 );
create table invoice (paid_amount decimal(12,2) not null, id bigint not null, number varchar(16) not null, download_link varchar(255), primary key (id)) engine=InnoDB;
create table invoice_seq (next_val bigint) engine=InnoDB;
insert into invoice_seq values ( 1 );
create table lead (id bigint not null, primary key (id)) engine=InnoDB;
create table lead_seq (next_val bigint) engine=InnoDB;
insert into lead_seq values ( 1 );
create table member_card_seq (next_val bigint) engine=InnoDB;
insert into member_card_seq values ( 1 );
create table member_card (end_date date, paid_amount decimal(12,2), start_date date, id bigint not null, primary key (id)) engine=InnoDB;
create table oauth2authorization (access_token_expires_at datetime(6), access_token_issued_at datetime(6), authorization_code_expires_at datetime(6), authorization_code_issued_at datetime(6), device_code_expires_at datetime(6), device_code_issued_at datetime(6), oidc_id_token_expires_at datetime(6), oidc_id_token_issued_at datetime(6), refresh_token_expires_at datetime(6), refresh_token_issued_at datetime(6), user_code_expires_at datetime(6), user_code_issued_at datetime(6), access_token_scopes varchar(100), access_token_type varchar(100), authorization_grant_type varchar(100) not null, id varchar(100) not null, registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorized_scopes varchar(1000), access_token_value varbinary(255), refresh_token_value varbinary(255), access_token_metadata tinyblob, attributes blob, authorization_code_metadata tinyblob, authorization_code_value tinyblob, device_code_metadata tinyblob, device_code_value tinyblob, oidc_id_token_metadata tinyblob, oidc_id_token_value tinyblob, refresh_token_metadata tinyblob, state blob, user_code_metadata tinyblob, user_code_value tinyblob, primary key (id)) engine=InnoDB;
create table oauth2authorization_seq (next_val bigint) engine=InnoDB;
insert into oauth2authorization_seq values ( 1 );
create table oauth2authorization_consent (registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorities varchar(1000) not null, primary key (registered_client_id, principal_name)) engine=InnoDB;
create table oauth2registered_client_seq (next_val bigint) engine=InnoDB;
insert into oauth2registered_client_seq values ( 1 );
create table oauth2registered_client (client_id_issued_at datetime(6) not null, client_secret_expires_at datetime(6), client_id varchar(100), id varchar(100) not null, client_name varchar(200), client_secret varchar(200), authorization_grant_types varchar(1000), client_authentication_methods varchar(1000), post_logout_redirect_uris varchar(1000), redirect_uris varchar(1000), scopes varchar(1000), client_settings varchar(2000), token_settings varchar(2000), primary key (id)) engine=InnoDB;
create table order (id bigint not null, primary key (id)) engine=InnoDB;
create table order_seq (next_val bigint) engine=InnoDB;
insert into order_seq values ( 1 );
create table organization (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, parent_id bigint, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table organization_seq (next_val bigint) engine=InnoDB;
insert into organization_seq values ( 1 );
create table payment (id bigint not null, primary key (id)) engine=InnoDB;
create table payment_seq (next_val bigint) engine=InnoDB;
insert into payment_seq values ( 1 );
create table role (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table role_authority (authority_id bigint not null, role_id bigint not null, primary key (authority_id, role_id)) engine=InnoDB;
create table role_seq (next_val bigint) engine=InnoDB;
insert into role_seq values ( 1 );
create table tenant (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table tenant_seq (next_val bigint) engine=InnoDB;
insert into tenant_seq values ( 1 );
create table user (birthday date, deleted bit, gender tinyint check (gender between 0 and 1), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, email varchar(31), mobile varchar(31), type varchar(31) not null, nickname varchar(63), username varchar(63) not null, avatar_url varchar(255), description varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id)) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
create table voucher (id bigint not null, primary key (id)) engine=InnoDB;
create table voucher_seq (next_val bigint) engine=InnoDB;
insert into voucher_seq values ( 1 );
alter table alliance_dians add constraint UK_n1j77f5bspvh7p1326wlq0saq unique (dians_id);
alter table appointment add constraint UK_5wnjrqs6gkbnr8v7v5hd0dwjv unique (class_id);
alter table attendance add constraint UK_j82sopqp9enibyd77a9grec6v unique (class_id);
alter table authority add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);
alter table class_attendants add constraint UK_3rvr68kjhvwec9m2lwqsd4i5s unique (attendants_id);
alter table class_teachers add constraint UK_f0wgu57ke72f85a3q3wlekqa0 unique (teachers_id);
alter table organization add constraint UK_8j5y8ipk73yx2joy9yr653c9t unique (name);
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table tenant add constraint UK_dcxf3ksi0gyn1tieeq0id96lm unique (name);
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile);
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table alliance_dians add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian (id);
alter table alliance_dians add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance (id);
alter table appointment add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class (id);
alter table attendance add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class (id);
alter table class_attendants add constraint FKrdli3t5or5k5di3qgxevcx3m3 foreign key (attendants_id) references user (id);
alter table class_attendants add constraint FKbsnc7t6muwellwmo80sgskjr foreign key (class_id) references class (id);
alter table class_teachers add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user (id);
alter table class_teachers add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class (id);
alter table organization add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization (id);
alter table role_authority add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority (id);
alter table role_authority add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role (id);
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);
alter table alliance_dians drop foreign key FKatywp75m2f1lsrbahfhomurv9;
alter table alliance_dians drop foreign key FKgkfn0chcjdvacpf0l2ss1murc;
alter table appointment drop foreign key FK4r7cwqrwsavnyebiybpeyt350;
alter table attendance drop foreign key FKlsi77buto2iknunetxvp2vtw3;
alter table class_attendants drop foreign key FKrdli3t5or5k5di3qgxevcx3m3;
alter table class_attendants drop foreign key FKbsnc7t6muwellwmo80sgskjr;
alter table class_teachers drop foreign key FKceaoqs9sgq46ox0qlmpptgi6h;
alter table class_teachers drop foreign key FK7d3xlbrpue44wny4fghbxqmc;
alter table organization drop foreign key FKc30yedjwp9qw1f3nn2ytda7tj;
alter table role_authority drop foreign key FKqbri833f7xop13bvdje3xxtnw;
alter table role_authority drop foreign key FK2052966dco7y9f97s1a824bj1;
alter table user_role drop foreign key FKa68196081fvovjhkek5m97n3y;
alter table user_role drop foreign key FK859n2jvi8ivhui0rl0esws6o;
drop table if exists address;
drop table if exists address_seq;
drop table if exists alliance;
drop table if exists alliance_dians;
drop table if exists alliance_seq;
drop table if exists appointment;
drop table if exists appointment_seq;
drop table if exists attendance;
drop table if exists attendance_seq;
drop table if exists authority;
drop table if exists authority_seq;
drop table if exists campaign;
drop table if exists campaign_seq;
drop table if exists class;
drop table if exists class_attendants;
drop table if exists class_seq;
drop table if exists class_teachers;
drop table if exists contract;
drop table if exists contract_seq;
drop table if exists coupon;
drop table if exists coupon_seq;
drop table if exists course;
drop table if exists course_seq;
drop table if exists device;
drop table if exists device_seq;
drop table if exists dian;
drop table if exists dian_seq;
drop table if exists franchisee;
drop table if exists franchisee_seq;
drop table if exists invitation;
drop table if exists invitation_seq;
drop table if exists invoice;
drop table if exists invoice_seq;
drop table if exists lead;
drop table if exists lead_seq;
drop table if exists member_card_seq;
drop table if exists member_card;
drop table if exists oauth2authorization;
drop table if exists oauth2authorization_seq;
drop table if exists oauth2authorization_consent;
drop table if exists oauth2registered_client_seq;
drop table if exists oauth2registered_client;
drop table if exists order;
drop table if exists order_seq;
drop table if exists organization;
drop table if exists organization_seq;
drop table if exists payment;
drop table if exists payment_seq;
drop table if exists role;
drop table if exists role_authority;
drop table if exists role_seq;
drop table if exists tenant;
drop table if exists tenant_seq;
drop table if exists user;
drop table if exists user_role;
drop table if exists user_seq;
drop table if exists voucher;
drop table if exists voucher_seq;
create table address (latitude float(53), longitude float(53), id bigint not null, city varchar(255), district varchar(255), postal_code varchar(255), province varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table alliance (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table alliance_dians (alliance_id bigint not null, dians_id bigint not null) engine=InnoDB;
create table alliance_seq (next_val bigint) engine=InnoDB;
insert into alliance_seq values ( 1 );
create table appointment (class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table attendance (check_in_time datetime(6), class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table attendance_seq (next_val bigint) engine=InnoDB;
insert into attendance_seq values ( 1 );
create table authority (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table authority_seq (next_val bigint) engine=InnoDB;
insert into authority_seq values ( 1 );
create table campaign (id bigint not null, primary key (id)) engine=InnoDB;
create table campaign_seq (next_val bigint) engine=InnoDB;
insert into campaign_seq values ( 1 );
create table class (id bigint not null, primary key (id)) engine=InnoDB;
create table class_attendants (attendants_id bigint not null, class_id bigint not null, primary key (attendants_id, class_id)) engine=InnoDB;
create table class_seq (next_val bigint) engine=InnoDB;
insert into class_seq values ( 1 );
create table class_teachers (class_id bigint not null, teachers_id bigint not null, primary key (class_id, teachers_id)) engine=InnoDB;
create table contract (id bigint not null, primary key (id)) engine=InnoDB;
create table contract_seq (next_val bigint) engine=InnoDB;
insert into contract_seq values ( 1 );
create table coupon (id bigint not null, primary key (id)) engine=InnoDB;
create table coupon_seq (next_val bigint) engine=InnoDB;
insert into coupon_seq values ( 1 );
create table course (id bigint not null, tags varchar(255), primary key (id)) engine=InnoDB;
create table course_seq (next_val bigint) engine=InnoDB;
insert into course_seq values ( 1 );
create table device (id bigint not null, primary key (id)) engine=InnoDB;
create table device_seq (next_val bigint) engine=InnoDB;
insert into device_seq values ( 1 );
create table dian (business_hour_end time(6), business_hour_start time(6), deleted bit, shop_area float(23), status tinyint check (status between 0 and 3), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), equipment_info varchar(255), primary key (id)) engine=InnoDB;
create table dian_seq (next_val bigint) engine=InnoDB;
insert into dian_seq values ( 1 );
create table franchisee (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table franchisee_seq (next_val bigint) engine=InnoDB;
insert into franchisee_seq values ( 1 );
create table invitation (deleted bit, when time(6) not null, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table invitation_seq (next_val bigint) engine=InnoDB;
insert into invitation_seq values ( 1 );
create table invoice (paid_amount decimal(12,2) not null, id bigint not null, number varchar(16) not null, download_link varchar(255), primary key (id)) engine=InnoDB;
create table invoice_seq (next_val bigint) engine=InnoDB;
insert into invoice_seq values ( 1 );
create table lead (id bigint not null, primary key (id)) engine=InnoDB;
create table lead_seq (next_val bigint) engine=InnoDB;
insert into lead_seq values ( 1 );
create table member_card_seq (next_val bigint) engine=InnoDB;
insert into member_card_seq values ( 1 );
create table member_card (end_date date, paid_amount decimal(12,2), start_date date, id bigint not null, primary key (id)) engine=InnoDB;
create table oauth2authorization (access_token_expires_at datetime(6), access_token_issued_at datetime(6), authorization_code_expires_at datetime(6), authorization_code_issued_at datetime(6), device_code_expires_at datetime(6), device_code_issued_at datetime(6), oidc_id_token_expires_at datetime(6), oidc_id_token_issued_at datetime(6), refresh_token_expires_at datetime(6), refresh_token_issued_at datetime(6), user_code_expires_at datetime(6), user_code_issued_at datetime(6), access_token_scopes varchar(100), access_token_type varchar(100), authorization_grant_type varchar(100) not null, id varchar(100) not null, registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorized_scopes varchar(1000), access_token_value varbinary(255), refresh_token_value varbinary(255), access_token_metadata tinyblob, attributes blob, authorization_code_metadata tinyblob, authorization_code_value tinyblob, device_code_metadata tinyblob, device_code_value tinyblob, oidc_id_token_metadata tinyblob, oidc_id_token_value tinyblob, refresh_token_metadata tinyblob, state blob, user_code_metadata tinyblob, user_code_value tinyblob, primary key (id)) engine=InnoDB;
create table oauth2authorization_seq (next_val bigint) engine=InnoDB;
insert into oauth2authorization_seq values ( 1 );
create table oauth2authorization_consent (registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorities varchar(1000) not null, primary key (registered_client_id, principal_name)) engine=InnoDB;
create table oauth2registered_client_seq (next_val bigint) engine=InnoDB;
insert into oauth2registered_client_seq values ( 1 );
create table oauth2registered_client (client_id_issued_at datetime(6) not null, client_secret_expires_at datetime(6), client_id varchar(100), id varchar(100) not null, client_name varchar(200), client_secret varchar(200), authorization_grant_types varchar(1000), client_authentication_methods varchar(1000), post_logout_redirect_uris varchar(1000), redirect_uris varchar(1000), scopes varchar(1000), client_settings varchar(2000), token_settings varchar(2000), primary key (id)) engine=InnoDB;
create table order (id bigint not null, primary key (id)) engine=InnoDB;
create table order_seq (next_val bigint) engine=InnoDB;
insert into order_seq values ( 1 );
create table organization (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, parent_id bigint, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table organization_seq (next_val bigint) engine=InnoDB;
insert into organization_seq values ( 1 );
create table payment (id bigint not null, primary key (id)) engine=InnoDB;
create table payment_seq (next_val bigint) engine=InnoDB;
insert into payment_seq values ( 1 );
create table role (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table role_authority (authority_id bigint not null, role_id bigint not null, primary key (authority_id, role_id)) engine=InnoDB;
create table role_seq (next_val bigint) engine=InnoDB;
insert into role_seq values ( 1 );
create table tenant (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table tenant_seq (next_val bigint) engine=InnoDB;
insert into tenant_seq values ( 1 );
create table user (birthday date, deleted bit, gender tinyint check (gender between 0 and 1), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, email varchar(31), mobile varchar(31), type varchar(31) not null, nickname varchar(63), username varchar(63) not null, avatar_url varchar(255), description varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id)) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
create table voucher (id bigint not null, primary key (id)) engine=InnoDB;
create table voucher_seq (next_val bigint) engine=InnoDB;
insert into voucher_seq values ( 1 );
alter table alliance_dians add constraint UK_n1j77f5bspvh7p1326wlq0saq unique (dians_id);
alter table appointment add constraint UK_5wnjrqs6gkbnr8v7v5hd0dwjv unique (class_id);
alter table attendance add constraint UK_j82sopqp9enibyd77a9grec6v unique (class_id);
alter table authority add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);
alter table class_attendants add constraint UK_3rvr68kjhvwec9m2lwqsd4i5s unique (attendants_id);
alter table class_teachers add constraint UK_f0wgu57ke72f85a3q3wlekqa0 unique (teachers_id);
alter table organization add constraint UK_8j5y8ipk73yx2joy9yr653c9t unique (name);
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table tenant add constraint UK_dcxf3ksi0gyn1tieeq0id96lm unique (name);
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile);
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table alliance_dians add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian (id);
alter table alliance_dians add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance (id);
alter table appointment add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class (id);
alter table attendance add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class (id);
alter table class_attendants add constraint FKrdli3t5or5k5di3qgxevcx3m3 foreign key (attendants_id) references user (id);
alter table class_attendants add constraint FKbsnc7t6muwellwmo80sgskjr foreign key (class_id) references class (id);
alter table class_teachers add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user (id);
alter table class_teachers add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class (id);
alter table organization add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization (id);
alter table role_authority add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority (id);
alter table role_authority add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role (id);
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);
alter table alliance_dians drop foreign key FKatywp75m2f1lsrbahfhomurv9;
alter table alliance_dians drop foreign key FKgkfn0chcjdvacpf0l2ss1murc;
alter table appointment drop foreign key FK4r7cwqrwsavnyebiybpeyt350;
alter table attendance drop foreign key FKlsi77buto2iknunetxvp2vtw3;
alter table class_attendants drop foreign key FKrdli3t5or5k5di3qgxevcx3m3;
alter table class_attendants drop foreign key FKbsnc7t6muwellwmo80sgskjr;
alter table class_teachers drop foreign key FKceaoqs9sgq46ox0qlmpptgi6h;
alter table class_teachers drop foreign key FK7d3xlbrpue44wny4fghbxqmc;
alter table organization drop foreign key FKc30yedjwp9qw1f3nn2ytda7tj;
alter table role_authority drop foreign key FKqbri833f7xop13bvdje3xxtnw;
alter table role_authority drop foreign key FK2052966dco7y9f97s1a824bj1;
alter table user_role drop foreign key FKa68196081fvovjhkek5m97n3y;
alter table user_role drop foreign key FK859n2jvi8ivhui0rl0esws6o;
drop table if exists address;
drop table if exists address_seq;
drop table if exists alliance;
drop table if exists alliance_dians;
drop table if exists alliance_seq;
drop table if exists appointment;
drop table if exists appointment_seq;
drop table if exists attendance;
drop table if exists attendance_seq;
drop table if exists authority;
drop table if exists authority_seq;
drop table if exists campaign;
drop table if exists campaign_seq;
drop table if exists class;
drop table if exists class_attendants;
drop table if exists class_seq;
drop table if exists class_teachers;
drop table if exists contract;
drop table if exists contract_seq;
drop table if exists coupon;
drop table if exists coupon_seq;
drop table if exists course;
drop table if exists course_seq;
drop table if exists device;
drop table if exists device_seq;
drop table if exists dian;
drop table if exists dian_seq;
drop table if exists franchisee;
drop table if exists franchisee_seq;
drop table if exists invitation;
drop table if exists invitation_seq;
drop table if exists invoice;
drop table if exists invoice_seq;
drop table if exists lead;
drop table if exists lead_seq;
drop table if exists member_card_seq;
drop table if exists member_card;
drop table if exists oauth2authorization;
drop table if exists oauth2authorization_seq;
drop table if exists oauth2authorization_consent;
drop table if exists oauth2registered_client_seq;
drop table if exists oauth2registered_client;
drop table if exists order;
drop table if exists order_seq;
drop table if exists organization;
drop table if exists organization_seq;
drop table if exists payment;
drop table if exists payment_seq;
drop table if exists role;
drop table if exists role_authority;
drop table if exists role_seq;
drop table if exists tenant;
drop table if exists tenant_seq;
drop table if exists user;
drop table if exists user_role;
drop table if exists user_seq;
drop table if exists voucher;
drop table if exists voucher_seq;
create table address (latitude float(53), longitude float(53), id bigint not null, city varchar(255), district varchar(255), postal_code varchar(255), province varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table alliance (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table alliance_dians (alliance_id bigint not null, dians_id bigint not null) engine=InnoDB;
create table alliance_seq (next_val bigint) engine=InnoDB;
insert into alliance_seq values ( 1 );
create table appointment (class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table attendance (check_in_time datetime(6), class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table attendance_seq (next_val bigint) engine=InnoDB;
insert into attendance_seq values ( 1 );
create table authority (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table authority_seq (next_val bigint) engine=InnoDB;
insert into authority_seq values ( 1 );
create table campaign (id bigint not null, primary key (id)) engine=InnoDB;
create table campaign_seq (next_val bigint) engine=InnoDB;
insert into campaign_seq values ( 1 );
create table class (id bigint not null, primary key (id)) engine=InnoDB;
create table class_attendants (attendants_id bigint not null, class_id bigint not null, primary key (attendants_id, class_id)) engine=InnoDB;
create table class_seq (next_val bigint) engine=InnoDB;
insert into class_seq values ( 1 );
create table class_teachers (class_id bigint not null, teachers_id bigint not null, primary key (class_id, teachers_id)) engine=InnoDB;
create table contract (id bigint not null, primary key (id)) engine=InnoDB;
create table contract_seq (next_val bigint) engine=InnoDB;
insert into contract_seq values ( 1 );
create table coupon (id bigint not null, primary key (id)) engine=InnoDB;
create table coupon_seq (next_val bigint) engine=InnoDB;
insert into coupon_seq values ( 1 );
create table course (id bigint not null, tags varchar(255), primary key (id)) engine=InnoDB;
create table course_seq (next_val bigint) engine=InnoDB;
insert into course_seq values ( 1 );
create table device (id bigint not null, primary key (id)) engine=InnoDB;
create table device_seq (next_val bigint) engine=InnoDB;
insert into device_seq values ( 1 );
create table dian (business_hour_end time(6), business_hour_start time(6), deleted bit, shop_area float(23), status tinyint check (status between 0 and 3), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), equipment_info varchar(255), primary key (id)) engine=InnoDB;
create table dian_seq (next_val bigint) engine=InnoDB;
insert into dian_seq values ( 1 );
create table franchisee (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table franchisee_seq (next_val bigint) engine=InnoDB;
insert into franchisee_seq values ( 1 );
create table invitation (deleted bit, when time(6) not null, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table invitation_seq (next_val bigint) engine=InnoDB;
insert into invitation_seq values ( 1 );
create table invoice (paid_amount decimal(12,2) not null, id bigint not null, number varchar(16) not null, download_link varchar(255), primary key (id)) engine=InnoDB;
create table invoice_seq (next_val bigint) engine=InnoDB;
insert into invoice_seq values ( 1 );
create table lead (id bigint not null, primary key (id)) engine=InnoDB;
create table lead_seq (next_val bigint) engine=InnoDB;
insert into lead_seq values ( 1 );
create table member_card_seq (next_val bigint) engine=InnoDB;
insert into member_card_seq values ( 1 );
create table member_card (end_date date, paid_amount decimal(12,2), start_date date, id bigint not null, primary key (id)) engine=InnoDB;
create table oauth2authorization (access_token_expires_at datetime(6), access_token_issued_at datetime(6), authorization_code_expires_at datetime(6), authorization_code_issued_at datetime(6), device_code_expires_at datetime(6), device_code_issued_at datetime(6), oidc_id_token_expires_at datetime(6), oidc_id_token_issued_at datetime(6), refresh_token_expires_at datetime(6), refresh_token_issued_at datetime(6), user_code_expires_at datetime(6), user_code_issued_at datetime(6), access_token_scopes varchar(100), access_token_type varchar(100), authorization_grant_type varchar(100) not null, id varchar(100) not null, registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorized_scopes varchar(1000), access_token_value varbinary(255), refresh_token_value varbinary(255), access_token_metadata tinyblob, attributes blob, authorization_code_metadata tinyblob, authorization_code_value tinyblob, device_code_metadata tinyblob, device_code_value tinyblob, oidc_id_token_metadata tinyblob, oidc_id_token_value tinyblob, refresh_token_metadata tinyblob, state blob, user_code_metadata tinyblob, user_code_value tinyblob, primary key (id)) engine=InnoDB;
create table oauth2authorization_seq (next_val bigint) engine=InnoDB;
insert into oauth2authorization_seq values ( 1 );
create table oauth2authorization_consent (registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorities varchar(1000) not null, primary key (registered_client_id, principal_name)) engine=InnoDB;
create table oauth2registered_client_seq (next_val bigint) engine=InnoDB;
insert into oauth2registered_client_seq values ( 1 );
create table oauth2registered_client (client_id_issued_at datetime(6) not null, client_secret_expires_at datetime(6), client_id varchar(100), id varchar(100) not null, client_name varchar(200), client_secret varchar(200), authorization_grant_types varchar(1000), client_authentication_methods varchar(1000), post_logout_redirect_uris varchar(1000), redirect_uris varchar(1000), scopes varchar(1000), client_settings varchar(2000), token_settings varchar(2000), primary key (id)) engine=InnoDB;
create table order (id bigint not null, primary key (id)) engine=InnoDB;
create table order_seq (next_val bigint) engine=InnoDB;
insert into order_seq values ( 1 );
create table organization (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, parent_id bigint, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table organization_seq (next_val bigint) engine=InnoDB;
insert into organization_seq values ( 1 );
create table payment (id bigint not null, primary key (id)) engine=InnoDB;
create table payment_seq (next_val bigint) engine=InnoDB;
insert into payment_seq values ( 1 );
create table role (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table role_authority (authority_id bigint not null, role_id bigint not null, primary key (authority_id, role_id)) engine=InnoDB;
create table role_seq (next_val bigint) engine=InnoDB;
insert into role_seq values ( 1 );
create table tenant (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table tenant_seq (next_val bigint) engine=InnoDB;
insert into tenant_seq values ( 1 );
create table user (birthday date, deleted bit, gender tinyint check (gender between 0 and 1), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, email varchar(31), mobile varchar(31), type varchar(31) not null, nickname varchar(63), username varchar(63) not null, avatar_url varchar(255), description varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id)) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
create table voucher (id bigint not null, primary key (id)) engine=InnoDB;
create table voucher_seq (next_val bigint) engine=InnoDB;
insert into voucher_seq values ( 1 );
alter table alliance_dians add constraint UK_n1j77f5bspvh7p1326wlq0saq unique (dians_id);
alter table appointment add constraint UK_5wnjrqs6gkbnr8v7v5hd0dwjv unique (class_id);
alter table attendance add constraint UK_j82sopqp9enibyd77a9grec6v unique (class_id);
alter table authority add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);
alter table class_attendants add constraint UK_3rvr68kjhvwec9m2lwqsd4i5s unique (attendants_id);
alter table class_teachers add constraint UK_f0wgu57ke72f85a3q3wlekqa0 unique (teachers_id);
alter table organization add constraint UK_8j5y8ipk73yx2joy9yr653c9t unique (name);
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table tenant add constraint UK_dcxf3ksi0gyn1tieeq0id96lm unique (name);
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile);
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table alliance_dians add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian (id);
alter table alliance_dians add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance (id);
alter table appointment add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class (id);
alter table attendance add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class (id);
alter table class_attendants add constraint FKrdli3t5or5k5di3qgxevcx3m3 foreign key (attendants_id) references user (id);
alter table class_attendants add constraint FKbsnc7t6muwellwmo80sgskjr foreign key (class_id) references class (id);
alter table class_teachers add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user (id);
alter table class_teachers add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class (id);
alter table organization add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization (id);
alter table role_authority add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority (id);
alter table role_authority add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role (id);
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);
alter table alliance_dians drop foreign key FKatywp75m2f1lsrbahfhomurv9;
alter table alliance_dians drop foreign key FKgkfn0chcjdvacpf0l2ss1murc;
alter table appointment drop foreign key FK4r7cwqrwsavnyebiybpeyt350;
alter table attendance drop foreign key FKlsi77buto2iknunetxvp2vtw3;
alter table class_attendants drop foreign key FKrdli3t5or5k5di3qgxevcx3m3;
alter table class_attendants drop foreign key FKbsnc7t6muwellwmo80sgskjr;
alter table class_teachers drop foreign key FKceaoqs9sgq46ox0qlmpptgi6h;
alter table class_teachers drop foreign key FK7d3xlbrpue44wny4fghbxqmc;
alter table organization drop foreign key FKc30yedjwp9qw1f3nn2ytda7tj;
alter table role_authority drop foreign key FKqbri833f7xop13bvdje3xxtnw;
alter table role_authority drop foreign key FK2052966dco7y9f97s1a824bj1;
alter table user_role drop foreign key FKa68196081fvovjhkek5m97n3y;
alter table user_role drop foreign key FK859n2jvi8ivhui0rl0esws6o;
drop table if exists address;
drop table if exists address_seq;
drop table if exists alliance;
drop table if exists alliance_dians;
drop table if exists alliance_seq;
drop table if exists appointment;
drop table if exists appointment_seq;
drop table if exists attendance;
drop table if exists attendance_seq;
drop table if exists authority;
drop table if exists authority_seq;
drop table if exists campaign;
drop table if exists campaign_seq;
drop table if exists class;
drop table if exists class_attendants;
drop table if exists class_seq;
drop table if exists class_teachers;
drop table if exists contract;
drop table if exists contract_seq;
drop table if exists coupon;
drop table if exists coupon_seq;
drop table if exists course;
drop table if exists course_seq;
drop table if exists device;
drop table if exists device_seq;
drop table if exists dian;
drop table if exists dian_seq;
drop table if exists franchisee;
drop table if exists franchisee_seq;
drop table if exists invitation;
drop table if exists invitation_seq;
drop table if exists invoice;
drop table if exists invoice_seq;
drop table if exists lead;
drop table if exists lead_seq;
drop table if exists member_card_seq;
drop table if exists member_card;
drop table if exists oauth2authorization;
drop table if exists oauth2authorization_seq;
drop table if exists oauth2authorization_consent;
drop table if exists oauth2registered_client_seq;
drop table if exists oauth2registered_client;
drop table if exists order;
drop table if exists order_seq;
drop table if exists organization;
drop table if exists organization_seq;
drop table if exists payment;
drop table if exists payment_seq;
drop table if exists role;
drop table if exists role_authority;
drop table if exists role_seq;
drop table if exists tenant;
drop table if exists tenant_seq;
drop table if exists user;
drop table if exists user_role;
drop table if exists user_seq;
drop table if exists voucher;
drop table if exists voucher_seq;
create table address (latitude float(53), longitude float(53), id bigint not null, city varchar(255), district varchar(255), postal_code varchar(255), province varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table alliance (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table alliance_dians (alliance_id bigint not null, dians_id bigint not null) engine=InnoDB;
create table alliance_seq (next_val bigint) engine=InnoDB;
insert into alliance_seq values ( 1 );
create table appointment (class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table attendance (check_in_time datetime(6), class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table attendance_seq (next_val bigint) engine=InnoDB;
insert into attendance_seq values ( 1 );
create table authority (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table authority_seq (next_val bigint) engine=InnoDB;
insert into authority_seq values ( 1 );
create table campaign (id bigint not null, primary key (id)) engine=InnoDB;
create table campaign_seq (next_val bigint) engine=InnoDB;
insert into campaign_seq values ( 1 );
create table class (id bigint not null, primary key (id)) engine=InnoDB;
create table class_attendants (attendants_id bigint not null, class_id bigint not null, primary key (attendants_id, class_id)) engine=InnoDB;
create table class_seq (next_val bigint) engine=InnoDB;
insert into class_seq values ( 1 );
create table class_teachers (class_id bigint not null, teachers_id bigint not null, primary key (class_id, teachers_id)) engine=InnoDB;
create table contract (id bigint not null, primary key (id)) engine=InnoDB;
create table contract_seq (next_val bigint) engine=InnoDB;
insert into contract_seq values ( 1 );
create table coupon (id bigint not null, primary key (id)) engine=InnoDB;
create table coupon_seq (next_val bigint) engine=InnoDB;
insert into coupon_seq values ( 1 );
create table course (id bigint not null, tags varchar(255), primary key (id)) engine=InnoDB;
create table course_seq (next_val bigint) engine=InnoDB;
insert into course_seq values ( 1 );
create table device (id bigint not null, primary key (id)) engine=InnoDB;
create table device_seq (next_val bigint) engine=InnoDB;
insert into device_seq values ( 1 );
create table dian (business_hour_end time(6), business_hour_start time(6), deleted bit, shop_area float(23), status tinyint check (status between 0 and 3), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), equipment_info varchar(255), primary key (id)) engine=InnoDB;
create table dian_seq (next_val bigint) engine=InnoDB;
insert into dian_seq values ( 1 );
create table franchisee (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table franchisee_seq (next_val bigint) engine=InnoDB;
insert into franchisee_seq values ( 1 );
create table invitation (deleted bit, when time(6) not null, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table invitation_seq (next_val bigint) engine=InnoDB;
insert into invitation_seq values ( 1 );
create table invoice (paid_amount decimal(12,2) not null, id bigint not null, number varchar(16) not null, download_link varchar(255), primary key (id)) engine=InnoDB;
create table invoice_seq (next_val bigint) engine=InnoDB;
insert into invoice_seq values ( 1 );
create table lead (id bigint not null, primary key (id)) engine=InnoDB;
create table lead_seq (next_val bigint) engine=InnoDB;
insert into lead_seq values ( 1 );
create table member_card_seq (next_val bigint) engine=InnoDB;
insert into member_card_seq values ( 1 );
create table member_card (end_date date, paid_amount decimal(12,2), start_date date, id bigint not null, primary key (id)) engine=InnoDB;
create table oauth2authorization (access_token_expires_at datetime(6), access_token_issued_at datetime(6), authorization_code_expires_at datetime(6), authorization_code_issued_at datetime(6), device_code_expires_at datetime(6), device_code_issued_at datetime(6), oidc_id_token_expires_at datetime(6), oidc_id_token_issued_at datetime(6), refresh_token_expires_at datetime(6), refresh_token_issued_at datetime(6), user_code_expires_at datetime(6), user_code_issued_at datetime(6), access_token_scopes varchar(100), access_token_type varchar(100), authorization_grant_type varchar(100) not null, id varchar(100) not null, registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorized_scopes varchar(1000), access_token_value varbinary(255), refresh_token_value varbinary(255), access_token_metadata tinyblob, attributes blob, authorization_code_metadata tinyblob, authorization_code_value tinyblob, device_code_metadata tinyblob, device_code_value tinyblob, oidc_id_token_metadata tinyblob, oidc_id_token_value tinyblob, refresh_token_metadata tinyblob, state blob, user_code_metadata tinyblob, user_code_value tinyblob, primary key (id)) engine=InnoDB;
create table oauth2authorization_seq (next_val bigint) engine=InnoDB;
insert into oauth2authorization_seq values ( 1 );
create table oauth2authorization_consent (registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorities varchar(1000) not null, primary key (registered_client_id, principal_name)) engine=InnoDB;
create table oauth2registered_client_seq (next_val bigint) engine=InnoDB;
insert into oauth2registered_client_seq values ( 1 );
create table oauth2registered_client (client_id_issued_at datetime(6) not null, client_secret_expires_at datetime(6), client_id varchar(100), id varchar(100) not null, client_name varchar(200), client_secret varchar(200), authorization_grant_types varchar(1000), client_authentication_methods varchar(1000), post_logout_redirect_uris varchar(1000), redirect_uris varchar(1000), scopes varchar(1000), client_settings varchar(2000), token_settings varchar(2000), primary key (id)) engine=InnoDB;
create table order (id bigint not null, primary key (id)) engine=InnoDB;
create table order_seq (next_val bigint) engine=InnoDB;
insert into order_seq values ( 1 );
create table organization (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, parent_id bigint, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table organization_seq (next_val bigint) engine=InnoDB;
insert into organization_seq values ( 1 );
create table payment (id bigint not null, primary key (id)) engine=InnoDB;
create table payment_seq (next_val bigint) engine=InnoDB;
insert into payment_seq values ( 1 );
create table role (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table role_authority (authority_id bigint not null, role_id bigint not null, primary key (authority_id, role_id)) engine=InnoDB;
create table role_seq (next_val bigint) engine=InnoDB;
insert into role_seq values ( 1 );
create table tenant (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table tenant_seq (next_val bigint) engine=InnoDB;
insert into tenant_seq values ( 1 );
create table user (birthday date, deleted bit, gender tinyint check (gender between 0 and 1), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, email varchar(31), mobile varchar(31), type varchar(31) not null, nickname varchar(63), username varchar(63) not null, avatar_url varchar(255), description varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id)) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
create table voucher (id bigint not null, primary key (id)) engine=InnoDB;
create table voucher_seq (next_val bigint) engine=InnoDB;
insert into voucher_seq values ( 1 );
alter table alliance_dians add constraint UK_n1j77f5bspvh7p1326wlq0saq unique (dians_id);
alter table appointment add constraint UK_5wnjrqs6gkbnr8v7v5hd0dwjv unique (class_id);
alter table attendance add constraint UK_j82sopqp9enibyd77a9grec6v unique (class_id);
alter table authority add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);
alter table class_attendants add constraint UK_3rvr68kjhvwec9m2lwqsd4i5s unique (attendants_id);
alter table class_teachers add constraint UK_f0wgu57ke72f85a3q3wlekqa0 unique (teachers_id);
alter table organization add constraint UK_8j5y8ipk73yx2joy9yr653c9t unique (name);
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table tenant add constraint UK_dcxf3ksi0gyn1tieeq0id96lm unique (name);
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile);
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table alliance_dians add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian (id);
alter table alliance_dians add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance (id);
alter table appointment add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class (id);
alter table attendance add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class (id);
alter table class_attendants add constraint FKrdli3t5or5k5di3qgxevcx3m3 foreign key (attendants_id) references user (id);
alter table class_attendants add constraint FKbsnc7t6muwellwmo80sgskjr foreign key (class_id) references class (id);
alter table class_teachers add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user (id);
alter table class_teachers add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class (id);
alter table organization add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization (id);
alter table role_authority add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority (id);
alter table role_authority add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role (id);
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);
alter table alliance_dians drop foreign key FKatywp75m2f1lsrbahfhomurv9;
alter table alliance_dians drop foreign key FKgkfn0chcjdvacpf0l2ss1murc;
alter table appointment drop foreign key FK4r7cwqrwsavnyebiybpeyt350;
alter table attendance drop foreign key FKlsi77buto2iknunetxvp2vtw3;
alter table class_attendants drop foreign key FKrdli3t5or5k5di3qgxevcx3m3;
alter table class_attendants drop foreign key FKbsnc7t6muwellwmo80sgskjr;
alter table class_teachers drop foreign key FKceaoqs9sgq46ox0qlmpptgi6h;
alter table class_teachers drop foreign key FK7d3xlbrpue44wny4fghbxqmc;
alter table organization drop foreign key FKc30yedjwp9qw1f3nn2ytda7tj;
alter table role_authority drop foreign key FKqbri833f7xop13bvdje3xxtnw;
alter table role_authority drop foreign key FK2052966dco7y9f97s1a824bj1;
alter table user_role drop foreign key FKa68196081fvovjhkek5m97n3y;
alter table user_role drop foreign key FK859n2jvi8ivhui0rl0esws6o;
drop table if exists address;
drop table if exists address_seq;
drop table if exists alliance;
drop table if exists alliance_dians;
drop table if exists alliance_seq;
drop table if exists appointment;
drop table if exists appointment_seq;
drop table if exists attendance;
drop table if exists attendance_seq;
drop table if exists authority;
drop table if exists authority_seq;
drop table if exists campaign;
drop table if exists campaign_seq;
drop table if exists class;
drop table if exists class_attendants;
drop table if exists class_seq;
drop table if exists class_teachers;
drop table if exists contract;
drop table if exists contract_seq;
drop table if exists coupon;
drop table if exists coupon_seq;
drop table if exists course;
drop table if exists course_seq;
drop table if exists device;
drop table if exists device_seq;
drop table if exists dian;
drop table if exists dian_seq;
drop table if exists franchisee;
drop table if exists franchisee_seq;
drop table if exists invitation;
drop table if exists invitation_seq;
drop table if exists invoice;
drop table if exists invoice_seq;
drop table if exists lead;
drop table if exists lead_seq;
drop table if exists member_card_seq;
drop table if exists member_card;
drop table if exists oauth2authorization;
drop table if exists oauth2authorization_seq;
drop table if exists oauth2authorization_consent;
drop table if exists oauth2registered_client_seq;
drop table if exists oauth2registered_client;
drop table if exists order;
drop table if exists order_seq;
drop table if exists organization;
drop table if exists organization_seq;
drop table if exists payment;
drop table if exists payment_seq;
drop table if exists role;
drop table if exists role_authority;
drop table if exists role_seq;
drop table if exists tenant;
drop table if exists tenant_seq;
drop table if exists user;
drop table if exists user_role;
drop table if exists user_seq;
drop table if exists voucher;
drop table if exists voucher_seq;
create table address (latitude float(53), longitude float(53), id bigint not null, city varchar(255), district varchar(255), postal_code varchar(255), province varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table alliance (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table alliance_dians (alliance_id bigint not null, dians_id bigint not null) engine=InnoDB;
create table alliance_seq (next_val bigint) engine=InnoDB;
insert into alliance_seq values ( 1 );
create table appointment (class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table attendance (check_in_time datetime(6), class_id bigint, id bigint not null, primary key (id)) engine=InnoDB;
create table attendance_seq (next_val bigint) engine=InnoDB;
insert into attendance_seq values ( 1 );
create table authority (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table authority_seq (next_val bigint) engine=InnoDB;
insert into authority_seq values ( 1 );
create table campaign (id bigint not null, primary key (id)) engine=InnoDB;
create table campaign_seq (next_val bigint) engine=InnoDB;
insert into campaign_seq values ( 1 );
create table class (id bigint not null, primary key (id)) engine=InnoDB;
create table class_attendants (attendants_id bigint not null, class_id bigint not null, primary key (attendants_id, class_id)) engine=InnoDB;
create table class_seq (next_val bigint) engine=InnoDB;
insert into class_seq values ( 1 );
create table class_teachers (class_id bigint not null, teachers_id bigint not null, primary key (class_id, teachers_id)) engine=InnoDB;
create table contract (id bigint not null, primary key (id)) engine=InnoDB;
create table contract_seq (next_val bigint) engine=InnoDB;
insert into contract_seq values ( 1 );
create table coupon (id bigint not null, primary key (id)) engine=InnoDB;
create table coupon_seq (next_val bigint) engine=InnoDB;
insert into coupon_seq values ( 1 );
create table course (id bigint not null, tags varchar(255), primary key (id)) engine=InnoDB;
create table course_seq (next_val bigint) engine=InnoDB;
insert into course_seq values ( 1 );
create table device (id bigint not null, primary key (id)) engine=InnoDB;
create table device_seq (next_val bigint) engine=InnoDB;
insert into device_seq values ( 1 );
create table dian (business_hour_end time(6), business_hour_start time(6), deleted bit, shop_area float(23), status tinyint check (status between 0 and 3), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), equipment_info varchar(255), primary key (id)) engine=InnoDB;
create table dian_seq (next_val bigint) engine=InnoDB;
insert into dian_seq values ( 1 );
create table franchisee (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table franchisee_seq (next_val bigint) engine=InnoDB;
insert into franchisee_seq values ( 1 );
create table invitation (deleted bit, when time(6) not null, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, description varchar(255), primary key (id)) engine=InnoDB;
create table invitation_seq (next_val bigint) engine=InnoDB;
insert into invitation_seq values ( 1 );
create table invoice (paid_amount decimal(12,2) not null, id bigint not null, number varchar(16) not null, download_link varchar(255), primary key (id)) engine=InnoDB;
create table invoice_seq (next_val bigint) engine=InnoDB;
insert into invoice_seq values ( 1 );
create table lead (id bigint not null, primary key (id)) engine=InnoDB;
create table lead_seq (next_val bigint) engine=InnoDB;
insert into lead_seq values ( 1 );
create table member_card_seq (next_val bigint) engine=InnoDB;
insert into member_card_seq values ( 1 );
create table member_card (end_date date, paid_amount decimal(12,2), start_date date, id bigint not null, primary key (id)) engine=InnoDB;
create table oauth2authorization (access_token_expires_at datetime(6), access_token_issued_at datetime(6), authorization_code_expires_at datetime(6), authorization_code_issued_at datetime(6), device_code_expires_at datetime(6), device_code_issued_at datetime(6), oidc_id_token_expires_at datetime(6), oidc_id_token_issued_at datetime(6), refresh_token_expires_at datetime(6), refresh_token_issued_at datetime(6), user_code_expires_at datetime(6), user_code_issued_at datetime(6), access_token_scopes varchar(100), access_token_type varchar(100), authorization_grant_type varchar(100) not null, id varchar(100) not null, registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorized_scopes varchar(1000), access_token_value varbinary(255), refresh_token_value varbinary(255), access_token_metadata tinyblob, attributes blob, authorization_code_metadata tinyblob, authorization_code_value tinyblob, device_code_metadata tinyblob, device_code_value tinyblob, oidc_id_token_metadata tinyblob, oidc_id_token_value tinyblob, refresh_token_metadata tinyblob, state blob, user_code_metadata tinyblob, user_code_value tinyblob, primary key (id)) engine=InnoDB;
create table oauth2authorization_seq (next_val bigint) engine=InnoDB;
insert into oauth2authorization_seq values ( 1 );
create table oauth2authorization_consent (registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorities varchar(1000) not null, primary key (registered_client_id, principal_name)) engine=InnoDB;
create table oauth2registered_client_seq (next_val bigint) engine=InnoDB;
insert into oauth2registered_client_seq values ( 1 );
create table oauth2registered_client (client_id_issued_at datetime(6) not null, client_secret_expires_at datetime(6), client_id varchar(100), id varchar(100) not null, client_name varchar(200), client_secret varchar(200), authorization_grant_types varchar(1000), client_authentication_methods varchar(1000), post_logout_redirect_uris varchar(1000), redirect_uris varchar(1000), scopes varchar(1000), client_settings varchar(2000), token_settings varchar(2000), primary key (id)) engine=InnoDB;
create table order (id bigint not null, primary key (id)) engine=InnoDB;
create table order_seq (next_val bigint) engine=InnoDB;
insert into order_seq values ( 1 );
create table organization (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, parent_id bigint, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table organization_seq (next_val bigint) engine=InnoDB;
insert into organization_seq values ( 1 );
create table payment (id bigint not null, primary key (id)) engine=InnoDB;
create table payment_seq (next_val bigint) engine=InnoDB;
insert into payment_seq values ( 1 );
create table role (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table role_authority (authority_id bigint not null, role_id bigint not null, primary key (authority_id, role_id)) engine=InnoDB;
create table role_seq (next_val bigint) engine=InnoDB;
insert into role_seq values ( 1 );
create table tenant (deleted bit, created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), primary key (id)) engine=InnoDB;
create table tenant_seq (next_val bigint) engine=InnoDB;
insert into tenant_seq values ( 1 );
create table user (birthday date, deleted bit, gender tinyint check (gender between 0 and 1), created_at datetime(6) not null, created_by bigint not null, id bigint not null, updated_at datetime(6) not null, updated_by bigint not null, email varchar(31), mobile varchar(31), type varchar(31) not null, nickname varchar(63), username varchar(63) not null, avatar_url varchar(255), description varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id)) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
create table voucher (id bigint not null, primary key (id)) engine=InnoDB;
create table voucher_seq (next_val bigint) engine=InnoDB;
insert into voucher_seq values ( 1 );
alter table alliance_dians add constraint UK_n1j77f5bspvh7p1326wlq0saq unique (dians_id);
alter table appointment add constraint UK_5wnjrqs6gkbnr8v7v5hd0dwjv unique (class_id);
alter table attendance add constraint UK_j82sopqp9enibyd77a9grec6v unique (class_id);
alter table authority add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);
alter table class_attendants add constraint UK_3rvr68kjhvwec9m2lwqsd4i5s unique (attendants_id);
alter table class_teachers add constraint UK_f0wgu57ke72f85a3q3wlekqa0 unique (teachers_id);
alter table organization add constraint UK_8j5y8ipk73yx2joy9yr653c9t unique (name);
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table tenant add constraint UK_dcxf3ksi0gyn1tieeq0id96lm unique (name);
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile);
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table alliance_dians add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian (id);
alter table alliance_dians add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance (id);
alter table appointment add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class (id);
alter table attendance add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class (id);
alter table class_attendants add constraint FKrdli3t5or5k5di3qgxevcx3m3 foreign key (attendants_id) references user (id);
alter table class_attendants add constraint FKbsnc7t6muwellwmo80sgskjr foreign key (class_id) references class (id);
alter table class_teachers add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user (id);
alter table class_teachers add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class (id);
alter table organization add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization (id);
alter table role_authority add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority (id);
alter table role_authority add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role (id);
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);
drop table if exists address cascade ;
drop table if exists alliance cascade ;
drop table if exists alliance_dians cascade ;
drop table if exists appointment cascade ;
drop table if exists attendance cascade ;
drop table if exists authority cascade ;
drop table if exists campaign cascade ;
drop table if exists class cascade ;
drop table if exists class_attendants cascade ;
drop table if exists class_teachers cascade ;
drop table if exists contract cascade ;
drop table if exists coupon cascade ;
drop table if exists course cascade ;
drop table if exists device cascade ;
drop table if exists dian cascade ;
drop table if exists franchisee cascade ;
drop table if exists invitation cascade ;
drop table if exists invoice cascade ;
drop table if exists lead cascade ;
drop table if exists member_card cascade ;
drop table if exists oauth2authorization cascade ;
drop table if exists oauth2authorization_consent cascade ;
drop table if exists oauth2registered_client cascade ;
drop table if exists order cascade ;
drop table if exists organization cascade ;
drop table if exists payment cascade ;
drop table if exists role cascade ;
drop table if exists role_authority cascade ;
drop table if exists tenant cascade ;
drop table if exists user cascade ;
drop table if exists user_role cascade ;
drop table if exists voucher cascade ;
drop sequence if exists address_seq;
drop sequence if exists alliance_seq;
drop sequence if exists appointment_seq;
drop sequence if exists attendance_seq;
drop sequence if exists authority_seq;
drop sequence if exists campaign_seq;
drop sequence if exists class_seq;
drop sequence if exists contract_seq;
drop sequence if exists coupon_seq;
drop sequence if exists course_seq;
drop sequence if exists device_seq;
drop sequence if exists dian_seq;
drop sequence if exists franchisee_seq;
drop sequence if exists invitation_seq;
drop sequence if exists invoice_seq;
drop sequence if exists lead_seq;
drop sequence if exists member_card_seq;
drop sequence if exists oauth2authorization_seq;
drop sequence if exists oauth2registered_client_seq;
drop sequence if exists order_seq;
drop sequence if exists organization_seq;
drop sequence if exists payment_seq;
drop sequence if exists role_seq;
drop sequence if exists tenant_seq;
drop sequence if exists user_seq;
drop sequence if exists voucher_seq;
create sequence address_seq start with 1 increment by 50;
create sequence alliance_seq start with 1 increment by 50;
create sequence appointment_seq start with 1 increment by 50;
create sequence attendance_seq start with 1 increment by 50;
create sequence authority_seq start with 1 increment by 50;
create sequence campaign_seq start with 1 increment by 50;
create sequence class_seq start with 1 increment by 50;
create sequence contract_seq start with 1 increment by 50;
create sequence coupon_seq start with 1 increment by 50;
create sequence course_seq start with 1 increment by 50;
create sequence device_seq start with 1 increment by 50;
create sequence dian_seq start with 1 increment by 50;
create sequence franchisee_seq start with 1 increment by 50;
create sequence invitation_seq start with 1 increment by 50;
create sequence invoice_seq start with 1 increment by 50;
create sequence lead_seq start with 1 increment by 50;
create sequence member_card_seq start with 1 increment by 50;
create sequence oauth2authorization_seq start with 1 increment by 50;
create sequence oauth2registered_client_seq start with 1 increment by 50;
create sequence order_seq start with 1 increment by 50;
create sequence organization_seq start with 1 increment by 50;
create sequence payment_seq start with 1 increment by 50;
create sequence role_seq start with 1 increment by 50;
create sequence tenant_seq start with 1 increment by 50;
create sequence user_seq start with 1 increment by 50;
create sequence voucher_seq start with 1 increment by 50;
create table address (latitude float(53), longitude float(53), id bigint not null, city varchar(255), district varchar(255), postal_code varchar(255), province varchar(255), street varchar(255), primary key (id));
create table alliance (deleted boolean, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, description varchar(255), primary key (id));
create table alliance_dians (alliance_id bigint not null, dians_id bigint not null unique);
create table appointment (class_id bigint unique, id bigint not null, primary key (id));
create table attendance (check_in_time timestamp(6), class_id bigint unique, id bigint not null, primary key (id));
create table authority (deleted boolean, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, name varchar(63) not null unique, description varchar(255), primary key (id));
create table campaign (id bigint not null, primary key (id));
create table class (id bigint not null, primary key (id));
create table class_attendants (attendants_id bigint not null unique, class_id bigint not null, primary key (attendants_id, class_id));
create table class_teachers (class_id bigint not null, teachers_id bigint not null unique, primary key (class_id, teachers_id));
create table contract (id bigint not null, primary key (id));
create table coupon (id bigint not null, primary key (id));
create table course (id bigint not null, tags varchar(255), primary key (id));
create table device (id bigint not null, primary key (id));
create table dian (business_hour_end time(6), business_hour_start time(6), deleted boolean, shop_area float(24), status tinyint check (status between 0 and 3), created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, name varchar(63) not null, description varchar(255), equipment_info varchar(255), primary key (id));
create table franchisee (deleted boolean, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, description varchar(255), primary key (id));
create table invitation (deleted boolean, when time(6) not null, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, description varchar(255), primary key (id));
create table invoice (paid_amount numeric(12,2) not null, id bigint not null, number varchar(16) not null, download_link varchar(255), primary key (id));
create table lead (id bigint not null, primary key (id));
create table member_card (end_date date, paid_amount numeric(12,2), start_date date, id bigint not null, primary key (id));
create table oauth2authorization (access_token_expires_at timestamp(6), access_token_issued_at timestamp(6), authorization_code_expires_at timestamp(6), authorization_code_issued_at timestamp(6), device_code_expires_at timestamp(6), device_code_issued_at timestamp(6), oidc_id_token_expires_at timestamp(6), oidc_id_token_issued_at timestamp(6), refresh_token_expires_at timestamp(6), refresh_token_issued_at timestamp(6), user_code_expires_at timestamp(6), user_code_issued_at timestamp(6), access_token_scopes varchar(100), access_token_type varchar(100), authorization_grant_type varchar(100) not null, id varchar(100) not null, registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorized_scopes varchar(1000), access_token_value varbinary(255), refresh_token_value varbinary(255), access_token_metadata blob, attributes blob, authorization_code_metadata blob, authorization_code_value blob, device_code_metadata blob, device_code_value blob, oidc_id_token_metadata blob, oidc_id_token_value blob, refresh_token_metadata blob, state blob, user_code_metadata blob, user_code_value blob, primary key (id));
create table oauth2authorization_consent (registered_client_id varchar(100) not null, principal_name varchar(200) not null, authorities varchar(1000) not null, primary key (registered_client_id, principal_name));
create table oauth2registered_client (client_id_issued_at timestamp(6) not null, client_secret_expires_at timestamp(6), client_id varchar(100), id varchar(100) not null, client_name varchar(200), client_secret varchar(200), authorization_grant_types varchar(1000), client_authentication_methods varchar(1000), post_logout_redirect_uris varchar(1000), redirect_uris varchar(1000), scopes varchar(1000), client_settings varchar(2000), token_settings varchar(2000), primary key (id));
create table order (id bigint not null, primary key (id));
create table organization (deleted boolean, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, parent_id bigint, updated_at timestamp(6) not null, updated_by bigint not null, name varchar(63) not null unique, description varchar(255), primary key (id));
create table payment (id bigint not null, primary key (id));
create table role (deleted boolean, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, name varchar(63) not null unique, description varchar(255), primary key (id));
create table role_authority (authority_id bigint not null, role_id bigint not null, primary key (authority_id, role_id));
create table tenant (deleted boolean, created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, name varchar(63) not null unique, description varchar(255), primary key (id));
create table user (birthday date, deleted boolean, gender tinyint check (gender between 0 and 1), created_at timestamp(6) not null, created_by bigint not null, id bigint not null, updated_at timestamp(6) not null, updated_by bigint not null, email varchar(31) unique, mobile varchar(31) unique, type varchar(31) not null, nickname varchar(63), username varchar(63) not null unique, avatar_url varchar(255), description varchar(255), password varchar(255), primary key (id));
create table user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id));
create table voucher (id bigint not null, primary key (id));
create index IDXsb8bbouer5wak8vyiiy4pf2bx on user (username);
create index IDXcnjwxx5favk5ycqajjt17fwy1 on user (mobile);
create index IDXob8kqyqqgmefl0aco34akdtpe on user (email);
alter table if exists alliance_dians add constraint FKatywp75m2f1lsrbahfhomurv9 foreign key (dians_id) references dian;
alter table if exists alliance_dians add constraint FKgkfn0chcjdvacpf0l2ss1murc foreign key (alliance_id) references alliance;
alter table if exists appointment add constraint FK4r7cwqrwsavnyebiybpeyt350 foreign key (class_id) references class;
alter table if exists attendance add constraint FKlsi77buto2iknunetxvp2vtw3 foreign key (class_id) references class;
alter table if exists class_attendants add constraint FKrdli3t5or5k5di3qgxevcx3m3 foreign key (attendants_id) references user;
alter table if exists class_attendants add constraint FKbsnc7t6muwellwmo80sgskjr foreign key (class_id) references class;
alter table if exists class_teachers add constraint FKceaoqs9sgq46ox0qlmpptgi6h foreign key (teachers_id) references user;
alter table if exists class_teachers add constraint FK7d3xlbrpue44wny4fghbxqmc foreign key (class_id) references class;
alter table if exists organization add constraint FKc30yedjwp9qw1f3nn2ytda7tj foreign key (parent_id) references organization;
alter table if exists role_authority add constraint FKqbri833f7xop13bvdje3xxtnw foreign key (authority_id) references authority;
alter table if exists role_authority add constraint FK2052966dco7y9f97s1a824bj1 foreign key (role_id) references role;
alter table if exists user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role;
alter table if exists user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user;
