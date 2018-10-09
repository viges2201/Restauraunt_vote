DELETE FROM user_roles;
DELETE
FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants (name, dish, price, vote,user_id) VALUES
  ('firsRest','borsh',1234,4,100000),
  ('secondRest','pureshka',897,7,100000),
  ('thirdRest','pureshka',2434,5,100000),
  ('fourRest','pureshka',34356,2,100000),
  ('fiveRest','AdminKotletka',34311,3,100001),
  ('sixRest','AdminGrecha',34476,9,100001);


