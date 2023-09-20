
    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by bigint not null,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by bigint not null,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by bigint not null,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by bigint not null,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists code_verification cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tag cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists code_verification_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tag_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence code_verification_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tag_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table code_verification (
        created_at timestamp(6),
        expired_at timestamp(6),
        id bigint not null,
        code varchar(255),
        email varchar(255) not null,
        mobile varchar(255) not null,
        status varchar(255) check (status in ('Verifying','Verified','Canceled')),
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        expired_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tag (
        id bigint not null,
        primary key (id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists code_verification cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tag cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists code_verification_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tag_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence code_verification_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tag_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table code_verification (
        created_at timestamp(6),
        expired_at timestamp(6),
        id bigint not null,
        code varchar(255),
        email varchar(255) not null,
        mobile varchar(255) not null,
        status varchar(255) check (status in ('Verifying','Verified','Canceled')),
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        expired_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tag (
        id bigint not null,
        primary key (id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists code_verification cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tag cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists code_verification_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tag_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence code_verification_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tag_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table code_verification (
        created_at timestamp(6),
        expired_at timestamp(6),
        id bigint not null,
        code varchar(255),
        email varchar(255) not null,
        mobile varchar(255) not null,
        status varchar(255) check (status in ('Verifying','Verified','Canceled')),
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        expired_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tag (
        id bigint not null,
        primary key (id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists code_verification cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tag cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists code_verification_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tag_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence code_verification_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tag_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table code_verification (
        created_at timestamp(6),
        expired_at timestamp(6),
        id bigint not null,
        code varchar(255),
        email varchar(255) not null,
        mobile varchar(255) not null,
        status varchar(255) check (status in ('Verifying','Verified','Canceled')),
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        expired_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tag (
        id bigint not null,
        primary key (id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists code_verification cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tag cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists code_verification_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tag_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence code_verification_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tag_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table code_verification (
        created_at timestamp(6),
        expired_at timestamp(6),
        id bigint not null,
        code varchar(255),
        email varchar(255) not null,
        mobile varchar(255) not null,
        status varchar(255) check (status in ('Verifying','Verified','Canceled')),
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        expired_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tag (
        id bigint not null,
        primary key (id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;

    drop table if exists address cascade ;

    drop table if exists alliance cascade ;

    drop table if exists appointment cascade ;

    drop table if exists attendance cascade ;

    drop table if exists authority cascade ;

    drop table if exists campaign cascade ;

    drop table if exists code_verification cascade ;

    drop table if exists comment cascade ;

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

    drop table if exists organization_dians cascade ;

    drop table if exists payment cascade ;

    drop table if exists post cascade ;

    drop table if exists role cascade ;

    drop table if exists role_authority cascade ;

    drop table if exists tag cascade ;

    drop table if exists tutorial cascade ;

    drop table if exists user cascade ;

    drop table if exists user_organizations cascade ;

    drop table if exists user_role cascade ;

    drop table if exists voucher cascade ;

    drop sequence if exists address_seq;

    drop sequence if exists alliance_seq;

    drop sequence if exists appointment_seq;

    drop sequence if exists attendance_seq;

    drop sequence if exists authority_seq;

    drop sequence if exists campaign_seq;

    drop sequence if exists code_verification_seq;

    drop sequence if exists comment_seq;

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

    drop sequence if exists post_seq;

    drop sequence if exists role_seq;

    drop sequence if exists tag_seq;

    drop sequence if exists tutorial_seq;

    drop sequence if exists user_seq;

    drop sequence if exists voucher_seq;

    create sequence address_seq start with 1 increment by 50;

    create sequence alliance_seq start with 1 increment by 50;

    create sequence appointment_seq start with 1 increment by 50;

    create sequence attendance_seq start with 1 increment by 50;

    create sequence authority_seq start with 1 increment by 50;

    create sequence campaign_seq start with 1 increment by 50;

    create sequence code_verification_seq start with 1 increment by 50;

    create sequence comment_seq start with 1 increment by 50;

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

    create sequence post_seq start with 1 increment by 50;

    create sequence role_seq start with 1 increment by 50;

    create sequence tag_seq start with 1 increment by 50;

    create sequence tutorial_seq start with 1 increment by 50;

    create sequence user_seq start with 1 increment by 50;

    create sequence voucher_seq start with 1 increment by 50;

    create table address (
        latitude float(53),
        longitude float(53),
        id bigint not null,
        city varchar(255),
        district varchar(255),
        postal_code varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table alliance (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table appointment (
        id bigint not null,
        primary key (id)
    );

    create table attendance (
        check_in_time timestamp(6),
        id bigint not null,
        primary key (id)
    );

    create table authority (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table campaign (
        id bigint not null,
        primary key (id)
    );

    create table code_verification (
        created_at timestamp(6),
        expired_at timestamp(6),
        id bigint not null,
        code varchar(255),
        email varchar(255) not null,
        mobile varchar(255) not null,
        status varchar(255) check (status in ('Verifying','Verified','Canceled')),
        primary key (id)
    );

    create table comment (
        id bigint not null,
        pid bigint,
        post_id bigint,
        content varchar(512) not null,
        primary key (id)
    );

    create table contract (
        id bigint not null,
        primary key (id)
    );

    create table coupon (
        id bigint not null,
        primary key (id)
    );

    create table course (
        id bigint not null,
        tags varchar(255),
        primary key (id)
    );

    create table device (
        id bigint not null,
        primary key (id)
    );

    create table dian (
        business_hour_end time(6),
        business_hour_start time(6),
        deleted boolean,
        shop_area float(24),
        status tinyint check (status between 0 and 3),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owned_by_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null,
        description varchar(255),
        equipment_info varchar(255),
        primary key (id)
    );

    create table franchisee (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invitation (
        deleted boolean,
        when time(6) not null,
        created_at timestamp(6),
        created_by bigint,
        expired_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        description varchar(255),
        primary key (id)
    );

    create table invoice (
        paid_amount numeric(12,2) not null,
        id bigint not null,
        number varchar(16) not null,
        download_link varchar(255),
        primary key (id)
    );

    create table lead (
        id bigint not null,
        primary key (id)
    );

    create table member_card (
        end_date date,
        paid_amount numeric(12,2),
        start_date date,
        id bigint not null,
        primary key (id)
    );

    create table oauth2authorization (
        access_token_expires_at timestamp(6),
        access_token_issued_at timestamp(6),
        authorization_code_expires_at timestamp(6),
        authorization_code_issued_at timestamp(6),
        device_code_expires_at timestamp(6),
        device_code_issued_at timestamp(6),
        oidc_id_token_expires_at timestamp(6),
        oidc_id_token_issued_at timestamp(6),
        refresh_token_expires_at timestamp(6),
        refresh_token_issued_at timestamp(6),
        user_code_expires_at timestamp(6),
        user_code_issued_at timestamp(6),
        access_token_scopes varchar(100),
        access_token_type varchar(100),
        authorization_grant_type varchar(100) not null,
        id varchar(100) not null,
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorized_scopes varchar(1000),
        access_token_value varbinary(255),
        refresh_token_value varbinary(255),
        access_token_metadata blob,
        attributes blob,
        authorization_code_metadata blob,
        authorization_code_value blob,
        device_code_metadata blob,
        device_code_value blob,
        oidc_id_token_metadata blob,
        oidc_id_token_value blob,
        refresh_token_metadata blob,
        state blob,
        user_code_metadata blob,
        user_code_value blob,
        primary key (id)
    );

    create table oauth2authorization_consent (
        registered_client_id varchar(100) not null,
        principal_name varchar(200) not null,
        authorities varchar(1000) not null,
        primary key (registered_client_id, principal_name)
    );

    create table oauth2registered_client (
        client_id_issued_at timestamp(6) not null,
        client_secret_expires_at timestamp(6),
        client_id varchar(100),
        id varchar(100) not null,
        client_name varchar(200),
        client_secret varchar(200),
        authorization_grant_types varchar(1000),
        client_authentication_methods varchar(1000),
        post_logout_redirect_uris varchar(1000),
        redirect_uris varchar(1000),
        scopes varchar(1000),
        client_settings varchar(2000),
        token_settings varchar(2000),
        primary key (id)
    );

    create table order (
        id bigint not null,
        primary key (id)
    );

    create table organization (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        owner_id bigint,
        parent_id bigint,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table organization_dians (
        dians_id bigint not null unique,
        organization_id bigint not null,
        primary key (dians_id, organization_id)
    );

    create table payment (
        id bigint not null,
        primary key (id)
    );

    create table post (
        comment_size integer,
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        image_urls varchar(10240),
        description varchar(255),
        title varchar(255) not null,
        content clob not null,
        primary key (id)
    );

    create table role (
        deleted boolean,
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        name varchar(63) not null unique,
        description varchar(255),
        primary key (id)
    );

    create table role_authority (
        authority_id bigint not null,
        role_id bigint not null,
        primary key (authority_id, role_id)
    );

    create table tag (
        id bigint not null,
        primary key (id)
    );

    create table tutorial (
        id bigint not null,
        primary key (id)
    );

    create table user (
        birthday date,
        deleted boolean,
        gender tinyint check (gender between 0 and 1),
        created_at timestamp(6),
        created_by bigint,
        id bigint not null,
        updated_at timestamp(6),
        updated_by bigint,
        email varchar(31) unique,
        mobile varchar(31) unique,
        type varchar(31) not null,
        nickname varchar(63),
        username varchar(63) not null unique,
        avatar_url varchar(255),
        coach_id varchar(255),
        description varchar(255),
        image_urls varchar(255),
        member_id varchar(255),
        password varchar(255),
        store_id varchar(255),
        primary key (id)
    );

    create table user_organizations (
        organizations_id bigint not null unique,
        store_id bigint not null,
        primary key (organizations_id, store_id)
    );

    create table user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table voucher (
        id bigint not null,
        primary key (id)
    );

    create index IDXsb8bbouer5wak8vyiiy4pf2bx 
       on user (username);

    create index IDXcnjwxx5favk5ycqajjt17fwy1 
       on user (mobile);

    create index IDXob8kqyqqgmefl0aco34akdtpe 
       on user (email);

    alter table if exists comment 
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 
       foreign key (post_id) 
       references post;

    alter table if exists comment 
       add constraint FKp4qv1kq7ab549ljq0w8lny89d 
       foreign key (pid) 
       references comment;

    alter table if exists dian 
       add constraint FK7v2kce7wil6tccxuqs7956l4r 
       foreign key (owned_by_id) 
       references organization;

    alter table if exists organization 
       add constraint FKg8f2umaoour9eym5s64axwbdr 
       foreign key (owner_id) 
       references user;

    alter table if exists organization 
       add constraint FKc30yedjwp9qw1f3nn2ytda7tj 
       foreign key (parent_id) 
       references organization;

    alter table if exists organization_dians 
       add constraint FKqo6hp5a5885gjip0ej88hbu6g 
       foreign key (dians_id) 
       references dian;

    alter table if exists organization_dians 
       add constraint FKnyifrusqc5uen4oa9v55xnipn 
       foreign key (organization_id) 
       references organization;

    alter table if exists role_authority 
       add constraint FKqbri833f7xop13bvdje3xxtnw 
       foreign key (authority_id) 
       references authority;

    alter table if exists role_authority 
       add constraint FK2052966dco7y9f97s1a824bj1 
       foreign key (role_id) 
       references role;

    alter table if exists user_organizations 
       add constraint FKsr8ljbfseaeqdprspopy34jwt 
       foreign key (organizations_id) 
       references organization;

    alter table if exists user_organizations 
       add constraint FKd8xl3vdbtneoefnxcrrq5qn7q 
       foreign key (store_id) 
       references user;

    alter table if exists user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role;

    alter table if exists user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user;
