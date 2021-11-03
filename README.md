# recipeapi
This project can be used to maintain favorite recipes online

Implementation
Recipe CRUD API implemented using Spring Boot, Java and H2 DB.

Technologies&Tools:

1)Spring Boot Version : 2.5.6   
2)Java Version : 8 
3)H2 DB 
4)Postman
5)Swagger

Swagger URL: http://localhost:8080/swagger-ui.html

Swagger API_Doc URL: http://localhost:8080/v2/api-docs

H2 Console: http://localhost:8080/h2-console/

JDBC URL: jdbc:h2:mem:cookbookdb

Step 1:Create token to pass in recipe endpoints
Authentication :
http://localhost:8080/authenticate
Method:POST
User :
"username": "hemanth", "password": "pass123"
2)
Insert recipe
http://localhost:8080/cookbook/
Method:POST
Request:
{ "name": "Rayalaseema chicken gravy", "numberOfPeople":10, "rating":3, "isVegetarian": false,
 "ingredientsList": [ { "name": "Chicken" }, { "name": "onion" }, { "name": "Chilli" }, { "name": "Ginger garlic" }, { "name": "salt" } ],
 "cookingInstructions": "Fry onion then add chilli,ginger garlic and add marinate chicken", "mastercheftips":"Cook on low flame" }
3)
i)Get all recipes
http://localhost:8080/cookbook/
Method:GET
ii)
Get Recipe by id
http://localhost:8080/cookbook/id=1
Method:GET
iii)
Get Recipe by rating
http://localhost:8080/cookbook/rating=3
Method:GET
iv)
Get recipe based on how many people it is sufficient for
http://localhost:8080/cookbook/numberofpeople=10
Method:GET
4)Update a Recipe
http://localhost:8080/cookbook/1
Method:PUT
Request:
{ "name": "Rayalaseema chicken gravy", "numberOfPeople":10, "rating":3, "isVegetarian": false,
 "ingredientsList": [ { "name": "Chicken" }, { "name": "onion" }, { "name": "Chilli" }, { "name": "Ginger garlic" }, { "name": "salt" } ],
 "cookingInstructions": "Fry onion then add chilli,ginger garlic and add marinate chicken", "mastercheftips":"Cook on low flame,add good amount of salt" }
5)Delete a Recipe
http://localhost:8080/cookbook/1
Method:DELETE