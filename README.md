# CarProblem
Milestone test for OOP week 3

Your company decides that it is time to have a team building weekend Yaay! []~(￣▽￣)~*  
You have to take cars to the location and some people even offered their cars and would drive some other employees if need be.

The office team created a collection of all the employees, and a collection of all the cars based on an excel sheet that the employees filled out. 
Humans can make mistakes, so maybe there are some problems with this data.  
<br />
**Your task is to write a program which can calculate the following information:**
1. How many unhappy cars do we have?
2. (OPTIONAL) Is there enough cars and drivers so that everyone can go? (canStartTheTrip)
    - Every car has to be drivable
    - Every employee in the employees collection can be found in a Car

What we know: 
 - There will only be drivers who have cars
 - Drivers know which car is their own
 - Passengers might have some people whom they are not friends with, and if they sit in the same car, the car will be unhappy
 - Drivers can be passengers if their car is not needed
 - Every car knows how many passengers it can accommodate (driver included!)

## **Car**
 - Has a licence plate
 - Has number of available seats (with driver!)
 - Knows the people currently assigned to the car
 - Can tell if it is drivable (has a driver and no more people than the max number of seats)
 - Can tell if it’s a happy car or an unhappy car (car is unhappy if there are people in it, who don’t want to be in the car together)
## **Driver**
 - Is an employee of the company
 - Has a name
 - Has a car
 - Might have people they don’t want to be in the same car with
## **Passenger**
 - Is an employee of the company
 - Has a name
 - Might have people they don’t want to be in the same car with
 - Can change the radio channel (Should print to the console: "Radio changed by: /name of the passenger/”)
## **CarManager**
 - Gets a collection of Cars and collection of Employees
 - Has a “countUnhappyCars” method that counts how many cars are unhappy 
 - Has a “canStartTheTrip” method. IMPLEMENTATION IS OPTIONAL: checks if every car is drivable and checks if all employees from the employee set are present in one of the cars
