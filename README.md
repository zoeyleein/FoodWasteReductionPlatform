<h1> Food Waste Reduction Platform </h1>

<h2>Functional requirements</h2>

A user can register at the home page by providing their details along with their subscription preferences. 
Every retailer has an inventory which contains details about products, product price, batch number, quantity, expiry date, and excess demand. A retailer can cycle through surplus items and decide whether to offer them for donations or at a discount. 
A charity can claim surplus food items that have been put up for donation and add them to their inventory. 
Consumers can purchase items from retailers in both scenarios, at a discount and at normal prices. They can browse through items across different retailers and can also view inventory across different retailers. Users who have subscribed to alerts shall receive messages on their phone and/or email based on their location. 

<h2>Application Architecture</h2>

<h3>Front-end (Presentation Layer)</h3>
The front-end of the FWRP comprises JSP (JavaServer Pages) for dynamic web page generation and user interaction.
JSP pages provide the user interface for registration, login/logout, browsing surplus food items, and managing user subscriptions.
Servlets act as our controller, it is responsible for being the mediary between our Model and View.

<h3>Back-end (Business Logic Layer)</h3>
Back end is composed of java code that will act as the model in the MVC pattern. 
Model will interact with the Servlet to talk with the front end JSP’s.
The Java code will be dealing with all our logic, for example providing the sale price of items that have a discount on them or providing prepared statements to store data in the DB.
We plan to implement different design patterns during our implementation like abstract factory for generating users, builder pattern for initializing users, singleton class for validation, and DAO for CRUD operations for our database.

<h3>Database (Data Layer)</h3>
The FWRP relies on a relational database management system (RDBMS), named FWRP, for data storage and management.
MySQL can be utilized as the underlying RDBMS to store information related to users, retailers, food items, subscriptions, and transactions.
The database schema includes entities (tables) such as ‘users’, ‘transaction’, ‘charity_inventory’, ‘user_inventory’, ‘item’, and ‘user_account’ structured to support the platform's functionalities.

<h3>Integration</h3>
Integration between the front-end and back-end is achieved through HTTP requests and responses.
JSP pages communicate with Servlets using HTTP protocols, exchanging data and triggering server-side actions.
Servlets interact with the database using JDBC (Java Database Connectivity), executing SQL queries to retrieve, update, and manipulate data.

<h2>Business Architecture</h2>
Registration:
<ol>Retailers: Retailers play a crucial role in our platform by managing surplus food items. They have the ability to add new items, update quantities, set expiration dates, and specify whether the items are available for donation or sale at a reduced price. Additionally, retailers can easily flag surplus food items that are nearing expiration or are in excess of demand. Once flagged, these surplus items can be promptly listed on the platform for donation or sale. </ol>
<ol>Charitable Organization: Charitable organizations are empowered to seamlessly claim surplus food items listed by retailers and promptly update their inventory accordingly. By simply selecting the desired items, charitable organizations can efficiently claim the available surplus food, ensuring that it reaches those in need.</ol>
<ol>Consumers: Consumers have the opportunity to purchase surplus food items at discounted prices through this system. By browsing the available listings, consumers can easily identify and select items they wish to purchase at reduced rates.</ol>

<h3>Database Structure</h3>
Our database shall have 5 tables.
<ul>Users: This table has general user details like name, email, phone, location, and password along with the user type (charity, consumer, retailer), and user preferences for subscription. </ul>
<ul>Item: This table has details about food items and their category (poultry, dairy, etc.).</ul>
<ul>User_inventory: This table contains the details about retailer’s inventory. It has details regarding batch number, batch expiry date, quantity, unit price, and final price.</ul>
<ul>Transaction: This table shall concern the transactions that take place once a consumer buys from a retailer. The quantity purchased shall be decreased from the retailer’s inventory.</ul>
<ul>Charity inventory: This table shall contain details of the stock held by charities to be given as donation. </ul>
<ul>userAccount: This table contains details about the account balance of customers.</ul>

<h2>Security Architecture </h2>
Users will have an account with a balance, we will perform validity checks on their stored, store credit to make sure that purchases are valid.
The passwords are stored in a plain text format in the database. Ideally, they should be encoded to safeguard user information. However, outsiders can’t access our database without credentials. 
SQL statements are prepared using preparedStatement() so that users cannot SQL inject to pry at, or manipulate our database
Users will only interact with the GUI and won’t have any interaction with the JAVA code. 

<h2>Created By</h2> 
<ul>Mayank Arora</ul>
<ul>Andres Porras</ul>
<ul>JingYi Li</ul>
<ul>Aaron Thompson</ul>

High Level Design : 
https://docs.google.com/document/d/1SkjawkOkLsN35J8bnhqSzhr_HtTyTBvO67HUS49Nnhg/edit?usp=sharing


