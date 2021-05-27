## Assessment back-end application

This is the answer for the assessment that is given by 99x Technologies, This assessment is develop price calculator for below given scenarios

- The rare product "Penguin-ears" is 20 units per carton. A carton is 175,-
- The product "Horseshoe" is 5 units per carton, a carton is 825,-
- If you purchase single units, the price is acquired using the carton price multiplied by an increase of
30% (1.3). (to compensate for manual labor)
- If you purchase 3 cartons or more, you will receive a 10% discount off the carton price

##1
- You are to create a price engine and a small calculation feature
- The calculation will determine the price of two products for a store
- The price engine is to optimize the price, meaning if you order 25 units and you have 20 units per
carton, the price will be set at 1 carton and 5 single units
- One GUI is to list the prices in a table, listing the actual prices for a product from 1-50 units
- Another GUI is to present a simple calculator which lets the user choose product and quantity of
either single units or cartons (Like a shopping cart in a web store)
- The price is to be calculated server side (not in Javascript)
- The service is to be created using test-driven-development (JUnit or Spock)
- Use a database (e.g. PostgreSQL) to store the initial prices and products, (in the event of time
shortage, this can be omitted in favor of hard coding/simple file)
- The calculation logic is to be developed in Java
-----------------------------
## back end technologies and requirements
1. JAVA 8.
2. PostgreSQL
3. spring boot
4. IDE (Eg. eclipse or InteliJ)
5. create database as  **assessment** and crete schema as **assessment**
6. I'm used for database config
     * database: assessment
     * username: postgres
     * password: 12345
     
     you can change above properties using **application.yml** this file is available under **\src\main\resources\application.yml**
     
7. Run project and then run data.sql(**\src\main\resources**) query script for initial run, because user role management.
     
