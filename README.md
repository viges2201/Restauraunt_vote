- Hibernate-ready,
- Spring-ready,
- SpringMVC-ready,
- Test-not ready (finished to 9.10.2018)
- If user votes again the same day:
      - If it is before 11:00 we asume that he changed his mind.
      - If it is after 11:00 then it is too late, vote can't be changed - not ready (finished to 9.10.2018)
- curl commands to get data for voting and vote: <pre>voteDump - /rest/admin/users/refresh <pre>vote - /rest/profile/{idUser}/restaurant/{idRestaurant}
## Admin commands 
- Get all users <pre>http://localhost:8080/rest/admin/users
- Get user by id <pre>http://localhost:8080/rest/admin/users/100000
- Get user by email <pre>http://localhost:8080/rest/admin/users/by?email=user@yandex.ru
- Delete user by id <pre>http://localhost:8080/rest/admin/users/100000

## User profile commands 
 - Get user profile <pre>http://localhost:8080/rest/profilehttp://localhost:8080/rest/profile
## Restaurant commands
- Get all restaurants <pre>http://localhost:8080/rest/profile/restaurant
- Get restaurant by id <pre>http://localhost:8080/rest/profile/restaurant/100005
- Delete restaurant by id <pre>http://localhost:8080/rest/profile/restaurant/100003