
    create table restaurants (
       id  serial not null,
        dish varchar(255) not null,
        price int4 not null,
        vote int4,
        user_id int4 not null,
        primary key (id)
    )

    create table user_roles (
       user_id int4 not null,
        role varchar(255)
    )

    create table users (
       id  serial not null,
        name varchar(255) not null,
        email varchar(255) not null,
        enabled bool default true not null,
        password varchar(255) not null,
        primary key (id)
    )

    alter table if exists users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)

    alter table if exists restaurants 
       add constraint FK18q23rj2s35r80ot3oag4ivo6 
       foreign key (user_id) 
       references users 
       on delete cascade

    alter table if exists user_roles 
       add constraint FKhfh9dx7w3ubf1co1vdev94g3f 
       foreign key (user_id) 
       references users
