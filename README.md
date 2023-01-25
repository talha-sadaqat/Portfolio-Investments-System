# Portfolio-Investments-System

NAME: MUHAMMAD TALHA SADAQAT   

HOW TO RUN AND COMPILE THE PROGRAM?

They are many ways to run my java program
one of these are :

(Method 1)

javac *.java                    (Run this command inside the eportfolio direcotry)
cd ..                               (Move back one directory)
java eportfolio.Gui   

Please compile each file seprately if the above instruction doesnt work
Please note I have done error checking so that my code runs properly and efficiently



I have a folder called msadaqat_a3
inside that there are two folders one is called eportfolio which has all my java classes , the Gui class and code and te other is my javadoc , inside my msadaqat_a3 you will also find readme file which has test plans and alot of other information about my portfolio program 


SECTION EXPLAINING MY COMPLETED COMPONENTS

Gui.java
*This is my GUI interface that also implements exception handling so that the system will be more robust and user-friendly.
*I have also made sure to definy copy constructor so that we can create a duplicate object and assign it to another reference in order to avoid privacy leaks.
*Gui class is where the user menu is , this made my code more readable and help me use abstract coding , my Gui class implements all the user display and controls the user display as well , Taking in different values from the user from th Gui input fields and error checking it to make it more user friendly 
*I even declare an object of portfolio class so that I can access all the fucntions and instances in my portfolio class , which does all the backend program work for me and make the code more efficient and reduced redundecy .
*I have also used truly overiding methods for inhertiance
* I have also made use of abstract classes for both mutual fund and stock and then added it into an investment array list
* I have done all the exceptions handling in order to make the porgram more user friendly for the user


Portfolio.java
The Portfolio class maintains one single ArrayLists , hence implemtning polymorphesim for both stocks and mutualfunds for buying, selling, updating, and computing the total gain for the related investments,
In a portfolio, one may own multiple stocks and/or mutual fund.
Portofiol class is being used by my main Gui class that uses portfolio is my backend code to run all the program and out results into the gui display

Investment.java
Investment class(super class) has attributes, including symbol, name, quantity, price, and bookValue, and I have implemented methods to compute the bookValue, payment received, and gain of an investment ,toString and many other methods , to be used by both the stocks and the mutual fund subclass , investment.c helped me reduce code redundacy as I has all the fcuntions impmlemented in one class which can be acceseed by the subclass stock and mutualFund 

Stock.java
The stock class extends the Investment class , as my stock class is the subclass of the investment , it has very few lines of code as I have reduced code redundacy buy using the super class investment , my stock class only has an overidden method to calculate book value as the bookvalue is calculated differently for both the mutualfunds and stocks, it also has a static final double which stores the commision value for stocks (9.99)

MutualFund.java
The MutualFund class extends the Investment class , as my MutualFund class is the subclass of the investment , it has very few lines of code as I have reduced code redundacy buy using the super class investment , my MutualFund class only has an overidden method to calculate book value as the bookvalue is calculated differently for both the mutualfunds and stocks, it also has a static final double which stores the commision value for MutualFund (45.0)



ANY KNOWN LIMITATION OF MY PROGRAM
I have made sure to check most of the edge cases , I have made sure that if the user enters negative values or wrong input , the processor would ask the user to enter the values again , I havent implemented file input and output in this assignment , as it wasnt mentioned in the assignment description



FUTURE IMPROVEMENTS
I did file reading and file output for my assignemnt 2 but did not implement in this assignment as it wasnt mentioned in A3 instructions , but its really easy to implement file input and output to gui and I would love to implement it and would have done so , if it was mentioned in the assignment description
Further testing my code to extreme edge cases
Ddding more detailed comment which could help me better understand the concept 
Making the user display more attractive , simple by adding more colors and making it stand out 
Most Importanly using separte fucntions and calling them to do the task behind the scene so that my Portfolio file wasnt long and tedious 


                                                                     
TEST PLAN:

*Make sure that the code runs when entered in the command line
*Make sure that commands menu has six choices: buy, sell, update, getGain, search, and quit.  
*Make sure that Choosing quit will simply terminate the program, but choosing other commands will 
change the interface to the ones specified in the following requirements.  and choosing the X button on the window frame 
*Make sure that scroll Panelgives the  correct error message when  the user enters wrong input and asks the user to enter  input again.
*Test is one arraylist is able to store both the mutual funds and stocks accurately  without mixing  up the investment type hence using dynmic binding and implementing polymorphesim
*Check to see if ComboBox for the investment type is with the options of stock and mutualfund
*Make sure that there are Common TextFields: Symbol, Name, Quantity, and Price 
* Make sure that Buy and Reset Buttons works
* Make sure that TextArea implents horizontal and vertical scrollbars for the messages when the output gets long 
* Buy and Reset Button for adding investments and resetting the TextFields should work. 
*Make sure that sell interferance gets displayed and works 
*Make sure that label and text box for Symbol, Quantity, and Price shows up
* Sell and Reset Buttons should work for sell as well 
* TextArea with horizontal and vertical scrollbars for messages should show up and show error messages and profit gained  
* sell and reset button should work  for validity check and resetting the TextFields, respectively. 
* make sure Symbol, Name, and price shows up for update interface
* test to see if save next and previus button works for update and disable accordingly to the postion in the investment array
* Save Button for updating the price values for the related investments
* Make sure that getGain has Read-only TextFieldTextArea with horizontal and vertical scrollbars for messages that displays seperate individual gains for each investment
* Make sure that all the Common TextFields for search menu option shows Symbol, Name keywords, Low price, and High price. 
* test to see that Search and Reset Buttons for search option 
* Make sure that scroll panel displays error messages .
*Test if the search fucntion works when no input is eneteres
*Test to check if the price ranges and the symbol name works for search
*Make sure to check if the key is able to search up symbol names in the hashtable 
*Test for multiple words for the symbol name 
*Test of the Search works if the given element is not on the list
* Test to see if search works if only low number is enetred 
*test to see if serach worsk if only high number is entered 
*Test to see if search works and displayes error message if not investment is not found 
*Test to see that all validity checks are done and there are no privacy leaks
*Make sure that overiding is done correctly inside my code with correct use of abstract classes
*Make sure use effective binding properly for implementing correct poylmorphesim and hence making it easier to get items from our investment array
*One of the most importsant think to test is that all the constructor , mutator and input excpetion are handled properly wihc makes the program more user friendly and efficient


BELOW ARE SOME OF MY RUNNED TEST PLAN RESULT


(IF USER SELECTS OPTION BUY AND ENTERS A NEGATIVE QUANTITY)

The GUI interface (scroll panel) displays this error message to the user and doesnt add the investment
---------------------------------------------
ERROR 
Please enter a quantity larger then 0: 
--------------------------------------


(IF USER SELECTS OPTION BUY AND ENTERS A NEGATIVE PRICE)

The GUI interface (scroll panel) displays this error message to the user and doesnt add the investment
---------------------------------------------
ERROR 
Please enter a price larger then 0 as price cannot be negative: 
--------------------------------------


(IF USER SELECTS OPTION BUY AND ENTERS ALL VALUES CORRECLTY )

The GUI Buy interface (scroll panel) displays the new investment that was added 
---------------------------------------------
The investments you add will be showed below

type = Stock
symbol = bitcoin
name = shibu
quantity = 200
price = $10.0
bookValue = 2009.99
--------------------------------------



(IF USER SELECTS OPTION SELL AND ENTERS AN INVESTMENT THAT DOESNT EXIST)

The GUI interface (scroll panel) displays this error message to the user 
---------------------------------------------
This symbol does not exist in the investment , please enter an investment that you own
--------------------------------------


(IF USER SELECTS OPTION SELL AND ENTERS A NEGATIVE QUANTITY TO SELL)

The GUI interface (scroll panel) displays this error message to the user and doesnt sell the investment
---------------------------------------------
ERROR 
Please enter a quantity larger then 0: 
--------------------------------------


(IF USER SELECTS OPTION SELL AND ENTERS A NEGATIVE PRICE)

The GUI interface (scroll panel) displays this error message to the user and doesnt sell the invetsment
---------------------------------------------
ERROR 
Please enter a price larger then 0 as price cannot be negative: 
--------------------------------------


(IF THE USER SELECTS GETGAIN MENU OPTION)
The Gui interface (scroll panel ) displays seperate individual gains for each investment and outputs the total gain in a non editabel text box 
Below is a result from my program
---------------------------------------------
Individuals Gain

Gain for investment apple is 370.03

Gain for investment APPL is -19.98
--------------------------------------


(IF THE USER SELECTS UPDATE MENU OPTION)

--------------------------------------
I have checked that all the buttons work properly and enable and disbale accordingly 
The update dispalys all the error messages correctly as well
The update moves around the invesmnets correctly 
it also displayes the saved price 
----------------------------------


(IF USER SELECTS OPTION SEARCH USING DIFFERENT PRICE RANGES)

(IF THE USER ENTERS ONLY SYMBOL)

The Gui interface (scroll panel ) displays the matches found for symbol APPL
------------------------------------------------------
Match was Found

type = Stock
symbol = APPL
name = iphone
quantity = 10
price = $50.0
bookValue = 509.99
------------------------------------------------------


(IF THE USER ENTERS ONLY NAME)

The Gui interface (scroll panel ) displays the matches found for name iphone
------------------------------------------------------
Match was Found

type = Stock
symbol = APPL
name = iphone
quantity = 10
price = $50.0
bookValue = 509.99
------------------------------------------------------


(IF THE USER ENTERS 5 IN LOW PROCE)

The Gui interface (scroll panel ) displays the matches found for the low price 5
-----------------------------------------------------
Match was Found

type = Stock
symbol = apple
name = iphone
quantity = 20
price = $50.0
bookValue = 619.98

Match was Found

type = Stock
symbol = APPL
name = iphone
quantity = 10
price = $50.0
bookValue = 509.99
------------------------------------------------------


















