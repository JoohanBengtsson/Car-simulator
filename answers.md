# General

First and foremost, thanks for letting me do the test. I feel honored to have been chosen to do the test!

Then, I would like to apologize for only doing the backend-task. From school, we have mostly worked with backend, where I have most knowledge within Java and Python, and just one not very good course in Web programming. Therefore, I felt like I have more to come with in the backend. However, as I am very interested in improving my toolbox, I am currently taking a course in full-stack development with React at the same time as I am doing my master's thesis. Thus I aim to become better acquainted within full-stack very soon.

# Answers to the questions of HiQ

1. How long time did you end up spending on this coding test?

It resulted in around 10 hours, as I wanted to be thorough with many of the details.

2. Explain why you chose the code structure(s) you used in your solution.

The work process is described more in the README.md. But my thought process went like:

Initially I set up a data flow diagram in order to understand how the data should flow in the script from the beginning until the end. By doing so, it became clearer what entities that should be defined in the script. As such, I tried to find entities that should be of low coupling and to ensure a high flexibility and scalability. I.e. I created the abstract class for Vehicle as to enable future development of different kinds of vehicles. Secondly, I setup the Simulator to potentially be able to run several rooms, as the rooms are independent of each other and may run their own simulations. As such, with some modifications, it would be possible to run several parallel simulations at the same time. Thirdly, in the Room-class I stored the cars in an ArrayList. This makes it easier to add several cars to the simulation, with only some slight changes here and there. In order to support that, I also added regNr as an attribute to the Vehicle-class, as to be able to separate vehicles from one another. And regarding the low coupling, I strived towards setting up Vehicle and Car independently of Room, so that you easily could set up a new Car class and to integrate it with the Room-class, should it be necessary. Or the other way around as well.

3. What would you add to your solution if you had more time? This question is especially important if you did not spend much time on the coding test - use this as an opportunity to explain what your solution is missing.

When starting this task, I wanted to implement a Simulator which could house any number of cars during the same simulation, an idea which I later on discarded, but left some functionalities for. Thus, I believe I would have liked to start by implementing these features, so that car collisions would be basis for failures as well.

Additionally, it would be interesting to add different types of vehicles, with different measures. E.g. trucks which might be larger and to integrate that into the script.

Lastly, I would have liked to set up some more tests, as to have a profound test suite used for working in a test-driven development-way which would be increasingly important when the complexity of the simulator would increase.

4. What did you think of this recruitment test?

It was very fun! It feels exciting to receive an arbitrary task and then try to solve it to the best of my abilities. As I found it very thrilling and fun, I did put some additional hours beyond what was recommended into it, but it was fun!