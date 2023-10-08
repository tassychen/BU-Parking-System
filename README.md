# BUParking
The Boston University Parking Lots Management Application will improve the drivers’ parking experience at BU parking lots. For BU students, employees, and guests, the app reduces parking lot searching time and simplifies the parking permit application while BU has the limited availability of the parking space, and the time-consuming permit application process. 

## Project Objective
We are going to deliver a solution that provides the following features:

1.	Secured user account 
2.	Permit reservation with vehicle information by non-first-year BU students, BU faculty and staff, and guests
3.	Able to update existing vehicle information under an existing permit
4.	Display locations of all BU-owned lots and garages on a map
5.	Display pricing, availability, policies, and other information for each permit
6.	Display available lots based on the type of permit held by the user including availability on different days and times
7.	Secured credit card payment
8.	Display availability estimated for each lot/garage depending on the survey after user’s parking 

## Stakeholders
a.	Boston University Parking and Transportation Services:
-	Interests: high interest. The project lets the department collect all the information in one database for better management. It also can maximize the parking space utilization for better economic benefit.
-	Impact: biggest impact on the project since the department will provide the most essential information: location of the parking lots, the capacity of each parking lot, parking rates, information about all the permits, etc)
-	Potential influences: BU would benefit from the project and so do the overall industry of the parking lot management system. As one of the major academic institutions with an overall population of 44,000, BU is approximately a medium-sized city in the state. The successful parking management at BU exemplifies a potential prototype for other academic institutions(similar population) in the limited parking space. 

b.	Non-first-year BU student drivers: 
  -	Interests: high interest. Students can apply for new permits, check the parking availability, and rates, display their permits, and make payments on one platform. The app will provide more transparent information that lets students find the desired lot. 
  -	Impact: students can provide their essential needs on on-campus parking and give feedback on our project. 
  -	Potential influences: Students are the largest demographic requiring parking on the BU campus. Congestion around BU streets can be significantly reduced by reducing the amount of time each student spends searching for a parking spot. Significant reduction in time consumption may also make the process of traveling between classes smoother, allowing students to arrive at classes on time, and reducing disruption to lectures. 

c.	BU faculty and staff drivers:
-	Interests: high interest. Faculty and staff can apply for new permits, check the parking availability, and rates, display their permits and make payments on one platform. The app will provide more transparent information that lets employees find the desired lot.
-	Impact: employees can provide their essential needs on on-campus parking and give feedback on our project. 
-	Potential influences: Faculty and staff drivers park on campus almost every day, occupying parking spaces regularly. Congestion around BU streets can be significantly reduced by reducing the amount of time each faculty or staff member spends on parking spot searching. Significant reductions in time consumption may also allow faculty and staff to arrive at classes/shifts on time, reducing disruption to students’ education, and smoothening the shift turnover process. 

d.	Guest drivers 
-	Interests: BU guests can apply for new permits, check the parking availability, and rates, display their permits, and make payments on one platform. The app will provide more transparent information that lets employees find the desired lot.
-	Impact: employees can provide their essential needs on on-campus parking and give feedback on our project
-	Potential influences: BU guests can apply and reserve the guest pass efficiently. They will not waste time looking for parking and be late for the event. Great parking experience will leave guests, especially potential students and their parents, with a good impression of BU


## Acceptance criteria
-	Boston University Parking and Transportation Services: 
The app will have a clear categorization of different information(permits, vehicle information, accounts) and saved in a secured database for easy management 
-	Non-first-year BU students: 
The app will show collective and transparent information about all the available parking spaces within BU campus. Students are able to apply for a new permit, update vehicle information and make payments on the app.
-	BU faculty and staff: 
The app will show collective and transparent information about all the available parking spaces within the BU campus, and they are able to apply for a new permit, update vehicle information and make payments on the app.
-	Guest drivers: 
The app will show collective and transparent information about all the available parking spaces on the BU campus. They are able to apply for a new permit, update vehicle information and make payments on the app.

## Use Case Diagram
![image](https://github.com/lukkn/BUParking/assets/70594133/3d50eb91-7a74-46c3-897f-278c33134929)
**Diagram.1**
In the use case diagram there are three major actors and four major use cases. The actors are BU Employee and Staff, Guest, and Non-First-Year BU Student while the guests and students can be categorized into two more specific types of users. All the actors benefit from the four system functionalities: Privacy, Reserve New Permit, Update Vehicle Information and Find Desired Lot. For the use case order a new permit and update vehicle information, each has an included use case. 

## Use Case Descriptions

### Use Case 1 
| Use Case         | Privacy |
| ---------------- | ------- |
| Actors           | BU employee, staff, Guest, Non-first-year BU student, BU parking lot management |
| Description      | The BU employee, staff, guest, or non-first-year BU student first registers an account in the BU Parking Lot Management System. After the BU parking lot management adds the user’s username and password into the database, the user uses a secure login to enter the BU Parking Lot Management System, and they can view the account information or perform further tasks. |
| Stakeholders     |<ul><li>	BU employee, staff, Guest, Non-first-year BU student: to register and log in to the BU Parking Lot Management System </li><li>	BU parking lot management: add new accounts in the database and verify accounts logs in information(username and password) when user logs in.</li></ul> |
| Trigerring Event | The BU employee, staff, guest, or non-first-year BU student registers an account in the Web-based system. |
| Steps            | <ol><li> The BU employee and staff, guest, or non-first-year BU student registers an account in the BU Parking Lot Management System</li><li> The BU parking lot management adds the account’s username and password into the database</li><li> The BU employee and staff, guest, or non-first-year BU logs in to the system and view the account information or perform further tasks. </li> |
| Pre-conditions   | BU employee, staff, guest, or non-first-year BU student must exist |
| Post-conditions  | BU employee, staff, guest, or non-first-year BU student is registered |

![image](https://github.com/lukkn/BUParking/assets/70594133/0148a224-7666-4c38-bc82-50306c550941)
**Diagram.2**
This is the sequence diagram of our privacy use case, consisting of the objects of the user, client device, and server. Here, our user logs in or registers through their client device, which communicates with the server, which then returns the login/registration result to the client device. This result is then displayed to the user. 


### Use Case 2 
| Use Case         | Reserve New Permit |
| ---------------- | ------- |
| Actors           | BU employee, staff, Guest, Non-first-year BU student |
| Description      | The BU employee, staff, guest, or non-first-year BU student first logs into his/her account in the BU Parking Lot Management System. If they are a new user, they register a new account. Then the user chooses the permit type and then puts in the vehicle information. After the system presents the order summary, the user submits the payment.   |
| Stakeholders     |<ul><li>	BU parking lot management: add or verify the user’s account in the database when the user logs in/register </li><li>	-	Boston University Parking and Transportation Services: to provide primary information about permits(rates, permit types, availability of the permits, etc) </li></ul> |
| Related Use Case | <ul><li> *Privacy* </li> <li> includes: *Credit Card Payment* </li> |
| Trigerring Event | The BU employee, staff, guest, or non-first-year BU student registers an account in the Web-based system. |
| Steps            | <ol><li> The BU employee and staff, guest, or non-first-year BU student goes to the home page</li><li> If it is a new user, the user links to the registration page to register an account in the BU Parking Lot Management System (*Privacy* use case) </li><li> If an existing user, user logs in to their account (*Privacy* use case) </li> <li> The user chooses the permit type </li> <li> The user puts in the vehicle information</li> <li> The user submits payment (*Credit Card Payment* use case) </li> |
| Pre-conditions   | <ul><li> BU employee and staff, guest, or non-first-year BU student must exist </li> <li> Permit types must exist for required permits </li> |
| Post-conditions  | <ul><li> The permit application must be created </li> <li> The permit must be related to a user </li> <li> Permit transaction must be created for the permit payment </li> |


![image](https://github.com/lukkn/BUParking/assets/70594133/bc723049-5d62-4434-8d46-7af834be0dea)
**Diagram.3**
This is the sequence diagram of our reserve new permit case, consisting of the objects of the user, client device, and server. Here, our user requests a new permit through their client device, which communicates with the server, which then returns the result to the client device. This result is then displayed to the user. 

## System architecture
![image](https://github.com/lukkn/BUParking/assets/70594133/ffe8f6ca-6c06-41a8-b625-75ffc4bfef66)

**Diagram.4**
Our system architecture is based on the client/server architecture pattern. Any number of user clients connect directly to our firebase database through the internet, which stores all necessary user and parking data. In our architecture, we substitute the firebase database as the server, since a server is unnecessary to connect to the Firebase Database.

## Class Diagram
![image](https://github.com/lukkn/BUParking/assets/70594133/0e7a8b4f-bcfc-4946-a3db-4f62752b19ee)
**Diagram.5**
There are two major domain classes named User and Permit. Each user can apply and hold one and only one permit. The superclass User has three subclasses naming Non-first-year BU Student, Guest, and BU Employee and Staff. User class has three attributes, Username, Password, and Permit, while it has 5 methods for the attributes. For Permit class, it has 7 attributes as each permit has the detailed permit and vehicle information. The class has two methods: the permit attribute can do credit card payments and display the permit as a label.

## State Machine Diagram
![image](https://github.com/lukkn/BUParking/assets/70594133/0f3b119e-1276-421b-bcec-f59a5b8ca8e3)
**Diagram.6**
There are eight states named “login and register dialog,” “map window opened,” “vehicle information window opened,” “permit information window opened,” “update vehicle information page opened,” “parking confirmation page opened,” “input vehicle information page opened,” and “input payment information page opened.” The three states, “login and register dialog,” “map window opened,” and “vehicle information window opened,” are triggered by clicking on the three corresponding buttons in the menu bar. Also, the page for updating vehicle information and the pages for reserving permits (one page for inputting vehicle information and the other for inputting payment information) will be displayed respectively, if the user clicks on the “update” button in the vehicle information window and the “reserve permit” button in the permit information window.

## ER Diagram
![image](https://github.com/lukkn/BUParking/assets/70594133/0d4a74d1-9959-4c26-bf90-d3e5ce830690)
**Diagram.7**
For our system architecture, we used a database with tables for parking lots and users. The users table is used for login/registration, and the parking lots are used to check parking spots used. Each user has 0 or 1 parking spot, and each parking lot has many spots.

## Conclusion
Our project taught us the importance of gathering and prioritization of requirements, system planning through architecture patterns, and communication and version control to ensure a final product. Firstly, our requirements found use cases that required many distinct system parts, such as login, parking lot database, and a map display. We found that using an incremental model, with modular parts that could be completed at different points, worked the best. The prioritization of our requirements also allowed us to complete the essential parts to make our app functional before the project deadline. We also found that it would have helped to better define the modular parts (i.e. database calls) before starting to avoid boilerplate code, but since we used many new technologies, we were more agile with our process of linking the system together. Finally, version control helped us to avoid clashes with the code and ensure a stable system. 

## References
“Bu Facts & Stats.” BU Facts & Stats | Office of the President, https://www.bu.edu/president/boston-university-facts-stats/. 

“Gomasscommute.” GoMassCommute, https://gomasscommute.com/#/.

Parking & Transportation Services, Boston University. https://www.bu.edu/parking/.

Transportation Management Portal, https://bu.aimsparking.com/. 

