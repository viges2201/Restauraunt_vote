
    alter table if exists restaurants 
       drop constraint if exists FK18q23rj2s35r80ot3oag4ivo6

    alter table if exists user_roles 
       drop constraint if exists FKhfh9dx7w3ubf1co1vdev94g3f

    drop table if exists restaurants cascade

    drop table if exists user_roles cascade

    drop table if exists users cascade
