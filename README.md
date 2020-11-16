# SafeAlwayz

README

Overall summary For SafeAlwayz and functions

Main Objective

•	A user will be able to create a unique account.
•	A user will be able to add any of the available appliances/IoTs and retrieve data related from those appliances/IoTs once added.
•	A user will be able to remove any appliance/IoT they have added.
•	A user will be able to modify data related to the appliances/IoTs they have added.

UI Design (Raziel)

The philosophy behind the UI design is simplicity, we wanted the user to be easily able to navigate through the app and its contents. As such we added design elements like tabs to the main hub of the app. Above is a visual flow of the app.

Register and Login (Keyona)

Solid login system that was handled between the following four classes: Database Helper, RegisterActivity, AccountModel and Login.
The Light IoT (Keyona Swanson)
It allows for a user account stored in a database to create and interact with a light object. The light object is stored in a database and can be viewed and updated in real time. 

Thermostat (Marronee)

The thermostat IoT allows users to add multiple thermostats which will add them to the database. Once added to the DB, the user can view the indoor/outdoor temperature, set their preferred temperature and set the timers for each thermostat.

Smart Fridge (Nicole)

This functionality allows users to keep track of product's expiration dates and be notified before the product expires.

CCTV IoT (Raziel)

The CCTV IoT is implemented to take a name for a camera from a user and then add the IoT to its appropriate database. It should then be accessed by the user under applications, where a user can see a live feed or a recorded video for that camera.

Alarm (Daniel)
