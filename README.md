- Hibernate-ready,
- Spring-ready,
- SpringMVC-ready,
- Test-not ready (finished to 9.10.2018)
- curl commands to get data for voting and vote: <pre>voteDump - /rest/admin/users/refresh <pre>vote - /rest/profile/{idUser}/restaurant/{idRestaurant}
- If user votes again the same day:
      - If it is before 11:00 we asume that he changed his mind.
      - If it is after 11:00 then it is too late, vote can't be changed - not ready (finished to 9.10.2018)
