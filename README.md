##The postman collection is available in root Restaurant.postman_collection.json

- Hibernate-ready,
- Spring-ready,
- SpringMVC-ready,
## Admin commands 
- Start voting (get) <pre>http://localhost:8080/rest/admin/users/start
- Dump results of vote (get) <pre>http://localhost:8080/rest/admin/users/refresh
- Get all users (get) <pre>http://localhost:8080/rest/admin/users
- Get user by id (get) <pre>http://localhost:8080/rest/admin/users/100000
- Get user by email (get) <pre>http://localhost:8080/rest/admin/users/by?email=user@yandex.ru
- Delete user by id (delete) <pre>http://localhost:8080/rest/admin/users/100000
- Create new user (post) <pre>http://localhost:8080/rest/admin/users
- Update user (put) <pre>http://localhost:8080/rest/admin/users/100009
## User profile commands 
 - Get user profile (get) <pre>http://localhost:8080/rest/profilehttp://localhost:8080/rest/profile
 - Voting (get) <pre>http://localhost:8080/rest/profile/100000/restaurant/100005
 - Update profile (put) <pre>http://localhost:8080/rest/profile
## Restaurant commands
- Get all restaurants (get) <pre>http://localhost:8080/rest/profile/restaurant
- Get restaurant by id (get) <pre>http://localhost:8080/rest/profile/restaurant/100005
- Delete restaurant by id (delete) <pre>http://localhost:8080/rest/profile/restaurant/100003
- Create new restaurant (post) <pre>http://localhost:8080/rest/profile/restaurant
- Update restaurant (put) <pre>http://localhost:8080/rest/profile/restaurant/100005