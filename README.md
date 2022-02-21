# Car-simulator

## Introduction

The task was to create a simulator which can simulate cars in a room of a specific size. The cars should move there according to a sequence of action commands, and the result should be whether such a sequence of action commands would be successful or if the car would hit a wall.

The script should be runnable form the CLI. From there, the user may provide arguments for the script, which should be on the form of:

"roomWidth roomHeight carPosX carPosY carDirection actionCommands..."

* roomWidth: an integer on how wide the room should be.
* roomHeight: an integer on how high the room should be.
* carPosX: the x-coordinate where to create the car.
* carPosY: the y-coordinate where to create the car.
* carDirection: in what direction the car should be headed. Any one of [N, E, S, W].
* actionCommands: the sequence of commands that the car should perform. Specify as spaced/separated characters, e.g "F F R L B F". Can be any one of: [F: forward, B: backward, R: right, L: left].

## Work process

### 1. Requirement specification and data flow diagram

The work started by interpreting the requirements, to understand the different parts that would need to be implemented. Based upon the requirements, a data flow diagram was set up, in which one way of how the program could be implemented was demonstrated. By doing so, the needed parts of the script could be identified and the structure of the program could be planned. The data flow diagram is shown in figure 1.

![](imgs/Flow%20of%20script.drawio.png)

Figure 1. The data flow of the script.

### 2. Initial class diagram

Next up was to identify the entities within the program. That is, what different classes would be needed to tackle the task in an efficient way. It was also a goal to achieve low coupling and high flexilibity. The initial class diagram can be seen in figure 2.

![](imgs/Class%20diagram.drawio.png)

Figure 2. The class diagram for this script.

With this initial setup, the thought was that the classes should be inter-independent. I.e., one class could easily be removed and substituted by another implementation of the class, for the program as a whole to still work (at least as long as the core functions are implemented, such as the abstract methods of the Vehicle-class).

### 3. Implementation

Then the work to implement this program according to the data flow- and class diagrams started. Step by step, the whole program was implemented. I made sure to check the instructions repeatedly, as to not do unnecessary work. 

### 4. Testing

Before the whole script was totally complete, System tests and unit tests were set up, as to assist in the implementation. The work then turned into Test-Driven development, where the tests helped indicating where the code was non-functional. 

The system tests were set up after a thought process. That is, the room was drawn, after which some kind of boundary-value analysis was executed. The goal was to identify the different boundaries where the results differ, which according to the instructions were driving into the walls. Those test cases are 1 - 4 in figure 3. Then, additional scenarios were identified, such as the impossibility of creating a car outside the room, as shown in test cases 6-9 in figure 3. In the middle is test case 5, where a couple of scenarios are captured, such as driving forward, turning right, turning right >= 360 degrees, reversing and turning left. This is some kind of mix between system and unit tests, as it comes down to testing the specific functions of the car. But I found it more relevant to be a system test, as it was also interesting to capture how it works in the simulator environment, as it should not be cause for any errors.

![](imgs/Test%20scenarios.png)

Figure 4. The test scenario plan.

### 5. Finalization

Then, the goal was to complete the assignment. From the implementation phase, some adjustments and additions had to be made to the class diagram, and the results can be seen in figure 4. 

![](imgs/Class%20diagram%202.png)

Figure 4. The final class diagram.

The goal was to preserve the basic principles of low coupling, high flexibility of the code, and I believe it was preserved, at least to a pretty high extent. 

## How to run the script

The script can be run either through an IDE or through the CLI.

### IDE

1. Go to Config.java and set DEBUG = true.
2. Go to Simulator.java and to the function specifyArgsFromIde(). 
3. Change the different strings of args[] to what sequence of arguments you want to test. The different arguments are described in the introduction.
4. Run the script and the results will be presented.

### CLI
1. Make sure DEBUG is set to false in Config.java.
2. In the CLI, change directory into the highest level of this project. That is, ".../HiQ test" is where you should be.
3. Run the command: java -jar Simulator.jar [args]
Note: [args] is the arguments as are specified in the introduction.