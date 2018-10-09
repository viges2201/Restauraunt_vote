DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

create table users (
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     varchar(255)        not null,
  email    varchar(255)        not null,
  enabled  bool default false   not null,
  password varchar(255)        not null
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER             NOT NULL,
  name     varchar(255)        not null,
  dish        varchar(255),
  price       INT,
  vote       INT,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX restaurants_unique_user_datetime_idx
  ON restaurants (user_id, name);