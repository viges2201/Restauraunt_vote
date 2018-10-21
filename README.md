## Выпускной проект
Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it.

-----------------------------
P.S.: Make sure everything works with latest version that is on github :)

P.P.S.: Asume that your API will be used by a frontend developer to build frontend on top of that.

-----------------------------

## The postman collection is available in root Restaurant.postman_collection.json

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
{
    "name": "newAdmin",
    "email": "newAdminr@gmail.com",
    "password": "newAdminr",
    "enabled": true,
    "roles": [
        "ROLE_ADMIN",
        "ROLE_USER"
    ],
    "restaurants": null
}
- Update user (put) <pre>http://localhost:8080/rest/admin/users/100009 
{
    "id": 100009,
        "name": "newFakeName",
        "email": "newUser@gmail.com",
        "password": "newUser",
        "enabled": false,
        "roles": [
        	"ROLE_ADMIN",
            "ROLE_USER"
        ],
        "restaurants": null
}
## User profile commands 
 - Get user profile (get) <pre>http://localhost:8080/rest/profilehttp://localhost:8080/rest/profile
 - Voting (get) <pre>http://localhost:8080/rest/profile/100000/restaurant/100005
 - Update profile (put) <pre>http://localhost:8080/rest/profile
 {
     "id": 100008,
         "name": "newUserProfile",
         "email": "newUserProfile@gmail.com",
         "password": "newUser",
         "enabled": false,
         "roles": [
         	"ROLE_ADMIN",
             "ROLE_USER"
         ],
         "restaurants": null
 }
## Restaurant commands
- Get all restaurants (get) <pre>http://localhost:8080/rest/profile/restaurant
- Get restaurant by id (get) <pre>http://localhost:8080/rest/profile/restaurant/100005
- Delete restaurant by id (delete) <pre>http://localhost:8080/rest/profile/restaurant/100003
- Create new restaurant (post) <pre>http://localhost:8080/rest/profile/restaurant
{
    "name": "new Restaurant",
    "dish": "pizza",
    "price": 5686,
    "vote": 10,
    "user": null
}
- Update restaurant (put) <pre>http://localhost:8080/rest/profile/restaurant/100005 
{
 "id": 100005,
    "name": "RefreshRest",
    "dish": "Fish",
    "price": 126,
    "vote": 4,
    "user": null
}
