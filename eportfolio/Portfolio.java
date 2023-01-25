package eportfolio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.HashMap;



/**
*The Portfolio class maintains one ArrayLists for both stocks and mutualfunds for buying, selling, updating, and computing the total gain for 
*the related investments, portfolio searches the lists using a hashtable for the matched investments, 
*and displays the result on the screen In a portfolio, one may own multiple stocks and/or mutual fund.
*Profoilio class also has two functions which when called by main reads investments from a file and stores it in the arrayList , it also uplaods all the investment to the filename 
*that wa sinput when compiling the program
* @author MUHAMMAD TALHA SADAQAT
*/
public class Portfolio 
{

  Investment investment  =new Investment();   /** creating a new object of class investment */
  MutualFund mutualFund =  new MutualFund();  /**Creating a new object of class mutual fund */
  Stock stock =  new Stock();                 /**Creating a new object of class stock */

  ArrayList <Investment> investmentsArray =new ArrayList<Investment>();  /**Declaring an arrayList for invetsments  */

  HashMap<String, ArrayList<Integer>> Index = new HashMap<String, ArrayList<Integer>>();
  Scanner scanning = new Scanner(System.in);


  /**
  * takes the the filename and uploads all the invetsments to the filname enetered
  * @param fileName
  */
  public void outputToFile(String fileName)
  {
    try
    {
      PrintWriter outputFile= new PrintWriter(fileName,"UTF-8");
      for (int i =0; i<investmentsArray.size() ; i++)
      {
        outputFile.println(investmentsArray.get(i).toStringFile() );
      }
      outputFile.close();
    }
    catch (Exception e)
    {
      System.out.println("Error opening the " +fileName+ " stuff.txt.");
      System.exit(0);
    }
    

  }

 /**
  * takes the the filename and read all the invetsments from the filename into the current investment array
  *Carries out file exception
  * @param fileName
  */  
  public void inputFileContents(String fileName)
  {

    Scanner inputStream =null;
   
   try 
   {
      inputStream = new Scanner ( new FileInputStream(fileName) );
   }
   catch (FileNotFoundException e)      /**File exception handlind  */
   {
      System.out.println("File couldn not be opened");
      System.exit(0);
   }

   while(inputStream.hasNextLine() )
   {
     String readingFile;
     readingFile = inputStream.nextLine(); /**Reading in the nextline */


     if(!readingFile.equals("") )   /**Error checking to see if the line is empt then skip it  */
     {
       String LineOne = readingFile.substring(readingFile.indexOf("\"") +1, readingFile.lastIndexOf("\"") );  /**Spilt method to substring between quotation marks  */

        if( LineOne.equalsIgnoreCase("stock") )
       {
          String investmentPrice;
          String investmentSymbol;          /**Different varaubkes declared that would be used by the code below to read file input  */
          String investmentBookValue;
          String investmentName;
          String investmentQuantity;

         Stock temporaryFileStock = new Stock();  /**Deaclring a new stock object  */
        

         temporaryFileStock.setInvestmentType("Stock");  /** Setting the stock type  */

        
         investmentSymbol =inputStream.nextLine();
         String LineTwo = investmentSymbol.substring(investmentSymbol.indexOf("\"") +1, investmentSymbol.lastIndexOf("\"") );  /**Reading line two which should haave the symbol */
         temporaryFileStock.setSymbol(LineTwo);

        
         investmentName = inputStream.nextLine();
         String lineThree = investmentName.substring(investmentName.indexOf("\"") +1, investmentName.lastIndexOf("\"") ); /**Reading line 3 whihc should have the invetsment name  */
         temporaryFileStock.setName(lineThree);

         
         investmentQuantity = inputStream.nextLine();
         String lineFour = investmentQuantity.substring(investmentQuantity.indexOf("\"") +1, investmentQuantity.lastIndexOf("\"") ); /**reading line four which should have the quantot y */
         temporaryFileStock.setQuantity( Integer.parseInt(lineFour) );

         
         investmentPrice = inputStream.nextLine();
         String lineFive = investmentPrice.substring(investmentPrice.indexOf("\"") +1, investmentPrice.lastIndexOf("\"") );  /**Redading line five whihc should have the price  */
         temporaryFileStock.setPrice(Double.parseDouble(lineFive ));

         
         investmentBookValue = inputStream.nextLine();
         String lineSix = investmentBookValue.substring(investmentBookValue.indexOf("\"") +1, investmentBookValue.lastIndexOf("\"") );  /**Redaing line 6 which should have the bookvalue  */
         temporaryFileStock.setbookValue(Double.parseDouble(lineSix ));

         investmentsArray.add(temporaryFileStock);
        }

        else if(LineOne.equalsIgnoreCase("mutualfund") )
       {
          String investmentPrice;
          String investmentSymbol;
          String investmentBookValue;   /**Different varaubkes declared that would be used by the code below to read file input  */
          String investmentName;
          String investmentQuantity;

          MutualFund temporaryFileStock = new MutualFund();
          temporaryFileStock.setInvestmentType("MutualFund");

          
          investmentSymbol =inputStream.nextLine();
          String LineTwo = investmentSymbol.substring(investmentSymbol.indexOf("\"") +1, investmentSymbol.lastIndexOf("\"") );  /**Reading line two which should haave the symbol */
          temporaryFileStock.setSymbol(LineTwo);

          
          investmentName = inputStream.nextLine();
          String lineThree = investmentName.substring(investmentName.indexOf("\"") +1, investmentName.lastIndexOf("\"") );  /**Reading line 3 whihc should have the invetsment name  */
          temporaryFileStock.setName(lineThree);

         
          investmentQuantity = inputStream.nextLine();
          String lineFour = investmentQuantity.substring(investmentQuantity.indexOf("\"") +1, investmentQuantity.lastIndexOf("\"") );
          temporaryFileStock.setQuantity(Integer.parseInt(lineFour) );  /**reading line four which should have the quantot y */

          
          investmentPrice = inputStream.nextLine();
          String lineFive = investmentPrice.substring(investmentPrice.indexOf("\"") +1, investmentPrice.lastIndexOf("\"") );
          temporaryFileStock.setPrice(Double.parseDouble(lineFive ));  /**Redading line five whihc should have the price  */

          
          investmentBookValue = inputStream.nextLine();
          String lineSix = investmentBookValue.substring(investmentBookValue.indexOf("\"") +1, investmentBookValue.lastIndexOf("\"") );
          temporaryFileStock.setbookValue(Double.parseDouble(lineSix ));  /**Reading line 6 which should have the bookvalue  */

          investmentsArray.add(temporaryFileStock);   /**Finnaly adding it to the array */
        }
      }
    }
    

  }

  /**
  * Checks to see if the symbol exists in the investment array or not , if it does then it return the index where it is stored in array ,
  otherwise it returns -1
  * @param symbol
  * @return symbolIndex
  */
  public int symbolIndexCheck (String symbol)
  {
    for(int symbolIndex =0; symbolIndex<investmentsArray.size(); symbolIndex++)   /** for loop to go through all the investmentsArray  array */
    {
      if( symbol.equals( investmentsArray.get(symbolIndex).getSymbol() ) )
      {
        return symbolIndex;          /** returning the symbol index in the array list */
      }
    }

    return -1;            /** returning -1 if it doesnt esxit */

  }
  

  /**
  * This Public method takes on all the parmeter a mutual fund requires and adds it to the one array list of invesments
  * @param symbol 
  * @param name
  * @param quantity
  * @param price
  */
  public String addMutualFundsToArrayList(String symbol , String name ,int quantity , double price )
  {
    mutualFund.setSymbol(symbol);  /** Using setters to set values of mutual funds */
    mutualFund.setName(name);
    mutualFund.setQuantity(quantity);
    mutualFund.setPrice(price);
    mutualFund.calculateBookValue(price,quantity);
    mutualFund.setInvestmentType("MutualFund");

    investmentsArray.add(mutualFund);

    String returningString = mutualFund.toString();

    System.out.println(mutualFund.toString() );

    mutualFund = new MutualFund();
    return returningString;
  }
  
  /**
  * This public method takes on all the parmeter a stock requires and adds it to the one array list of invesments
  * @param symbol 
  * @param name
  * @param quantity
  * @param price
  */
  public String addStockToArrayList(String symbol , String name ,int quantity , double price )
  {
    stock.setSymbol(symbol);   /** Using setters to set values of stocks */
    stock.setName(name);
    stock.setQuantity(quantity);
    stock.setPrice(price);
    stock.calculateBookValue(price,quantity);
    stock.setInvestmentType("Stock");

    investmentsArray.add(stock); /**Adding the stock to the invetsments Array */

    System.out.println(stock.toString() );  /**Printing th stock that was added  */

    String returningString = stock.toString();

    stock = new Stock();  /**Declaring a new stock objectthat will be used by the next stock */

    return returningString;
  }

  
  /**
  * This public method takes on all the parameter of an investment and sells it , by reducing the quantity calcuting new book value and updating the price 
  * @param price
  * @param quantity
  * @param symbolIndex
  */
  public String sell(int quantity, double price, int symbolIndex)
  {
    String returningString =null;

    if(quantity > investmentsArray.get(symbolIndex).getQuantity() )  /** Error message to cehck if the user didnt enter quanototy less then the exisitng quantity  */
    {
      System.out.println("Please enter the quantity number again as only " + investmentsArray.get(symbolIndex).getQuantity() + " exists in your portfolio");
   
      returningString = "\n"+"Please enter the quantity number again as only " + investmentsArray.get(symbolIndex).getQuantity() + " exists in your portfolio\n";
      System.out.println(returningString);
      return returningString;
    }

    investmentsArray.get(symbolIndex).calculateSellBookValue(quantity);  /**Calcuting the book value when selling */
    investmentsArray.get(symbolIndex).sellQuantity(quantity);  /**Updating the quantity after selling  */
    investmentsArray.get(symbolIndex).setPrice(quantity);  /**Setting the price  */
    

   if(investmentsArray.get(symbolIndex).getInvestmentType().equals("MutualFund"))
   {
      double profit =0;
      profit = (price * quantity) - MutualFund.commision;

      float convertedToFloat =  (float)profit;
      System.out.println("You received $" + convertedToFloat + " and have " + investmentsArray.get(symbolIndex).getQuantity() + " shares left");
      returningString = "\n"+"You received $" + convertedToFloat + " and have " + investmentsArray.get(symbolIndex).getQuantity() + " shares left of investment " +  investmentsArray.get(symbolIndex).getSymbol() + "\n"  ;
      System.out.println(returningString);
   }

   if(investmentsArray.get(symbolIndex).getInvestmentType().equals("Stock"))
   {
     double profit =0;
     profit = (price * quantity) - Stock.commision;   /**printing statments to show how much profit you recieved while selling */
        

     float convertedToFloat =  (float)profit;
      System.out.println("You received $" + convertedToFloat + " and have " + investmentsArray.get(symbolIndex).getQuantity() + " shares left");
      returningString = "\n"+"You received $" + convertedToFloat + " and have " + investmentsArray.get(symbolIndex).getQuantity() + " shares left of investment " +  investmentsArray.get(symbolIndex).getSymbol() + "\n"  ;
      System.out.println(returningString);
   }

    if(investmentsArray.get(symbolIndex).getQuantity() ==0 )
    {
      investmentsArray.remove(symbolIndex);   /**printing statments to show how much profit you recieved while selling */
      System.out.println("The quantity has been removed and no more quantity of the current Investment exists");
      returningString = "The quantity has been removed and no more quantity of the current Investment exists";
      System.out.println(returningString);
    }

    return returningString;
  }


  /**
  * This public method takes on all the parameter of an investment and adds it to the investment array of an existing investment 
  * @param price
  * @param quantity
  * @param symbolIndex
  */
  public String updateExistingInvestment(int quantity , double price, int symbolIndex)
  {
    investmentsArray.get(symbolIndex).addToExistingQuantity(quantity);
    investmentsArray.get(symbolIndex).setPrice(price);
    investmentsArray.get(symbolIndex).calculateBookValue(price,quantity);
     
    String returningString;

    System.out.println(investmentsArray.get(symbolIndex).toString() );

    returningString = investmentsArray.get(symbolIndex).toString();

    return returningString;
  }
   

  /**
  * This public method takes new price of every indivdual investment and updates it in the arraylist 
  */
  public void update()
  {
    
    double price;
    Scanner priceInput = new Scanner (System.in);   // scanner to scan in the price 
  
    for (int i=0 ; i<investmentsArray.size() ; i++ ) /**for loop to traverse through the investment array  */   
    {
      
      System.out.println("Enter the price to update for the following investment: " + investmentsArray.get(i).getSymbol() + ": " );   // asking user to enetr price to update the current stock 
      price = priceInput.nextDouble();
      investmentsArray.get(i).setPrice(price);                   // setting the new price
      System.out.println("Your current holding of investments are ");
      System.out.println( investmentsArray.get(i).toString() );  /** Print statement to show the current holdings */
    }
      
  }

  /**
  * This public method when called calculates the total Net getgain and tells the user the total Gain they have for all of there investments  
  */
  public String getGain ()
  {
    double totalGain = 0.0;
    double MutualFundGain= 0.0;
    double stockGain= 0.0;

    for (int i=0 ; i<investmentsArray.size() ; i++ )   // traversing through the stock size
    {

      if(investmentsArray.get(i).getInvestmentType().equals("MutualFund") )  /**Calcuting book value for mutual funds */
     {
        MutualFundGain = MutualFundGain + (  (investmentsArray.get(i).getQuantity() *investmentsArray.get(i).getPrice() - MutualFund.commision)  -  investmentsArray.get(i).getbookValue() ) ;
     }
      else if(investmentsArray.get(i).getInvestmentType().equals("Stock"))  /**Calcuting book value for stocks */
     {
       stockGain = stockGain + (  (investmentsArray.get(i).getQuantity() *investmentsArray.get(i).getPrice() - Stock.commision)  -  investmentsArray.get(i).getbookValue()   );  
     }
     
    }

    String returningTotalGain; 
    totalGain = MutualFundGain + stockGain;   /** calcuting total gain */
    System.out.println("Your Total Gain for all the investments is:" + (double)totalGain);   // print statment to check for total gain

    float convertedToDouble =  (float)totalGain;

    returningTotalGain = String.valueOf(convertedToDouble);
    return returningTotalGain;
  }

  public String getGainInvestmentNames()
  {
    double totalGain = 0.0;
    double MutualFundGain= 0.0;
    double stockGain= 0.0;
    
    double currentGain = 0.0;
    float currentGainInFloat;

    StringBuffer allInvestments = new StringBuffer();
    String separate;
    String bufferToString = "";

    for (int i=0 ; i<investmentsArray.size() ; i++ )   // traversing through the stock size
    {

      if(investmentsArray.get(i).getInvestmentType().equals("MutualFund") )  /**Calcuting book value for mutual funds */
     {
        MutualFundGain = MutualFundGain + (  (investmentsArray.get(i).getQuantity() *investmentsArray.get(i).getPrice() - MutualFund.commision)  -  investmentsArray.get(i).getbookValue() ) ;
        currentGain =(  (investmentsArray.get(i).getQuantity() *investmentsArray.get(i).getPrice() - MutualFund.commision)  -  investmentsArray.get(i).getbookValue() ) ;
        
        currentGainInFloat = (float)currentGain;
        separate ="\n"+ "Gain for investment " + investmentsArray.get(i).getSymbol() + " is " + currentGainInFloat +"\n" ;

        allInvestments.append(separate);
     }
      else if(investmentsArray.get(i).getInvestmentType().equals("Stock"))  /**Calcuting book value for stocks */
     {
       stockGain = stockGain + (  (investmentsArray.get(i).getQuantity() *investmentsArray.get(i).getPrice() - Stock.commision)  -  investmentsArray.get(i).getbookValue()   );  
        
        currentGain = (  (investmentsArray.get(i).getQuantity() *investmentsArray.get(i).getPrice() - Stock.commision)  -  investmentsArray.get(i).getbookValue()   ); 
        
       currentGainInFloat = (float)currentGain;

       separate ="\n"+ "Gain for investment " + investmentsArray.get(i).getSymbol() + " is " + currentGainInFloat +"\n" ;

        allInvestments.append(separate);
     }

     bufferToString = allInvestments.toString();
     
    }

    return bufferToString;

  }

  /**
  * This public method when called can serach for s specfic invetsment name or synbol , it can even search for a specifc price range 
  * It uses hashmap to make the search alogorithm faster 
  */
  public String search (String gettingSymbol ,String gettingName ,String gettingLowPrice ,String gettingHighPrice)
  {
    
    StringBuffer allInvestments = new StringBuffer();
     String separate;
    String bufferToString = "";


    String rangeInput = "";
    String symbolInput;                           /** string to take in a symbol */
    System.out.println("Entering symbol");   /**asking users to enter input */

    String concatenatingRange = gettingLowPrice + gettingHighPrice;
    System.out.println(concatenatingRange);
  

    boolean symbolPresent = true;        /** boolean to cheack if symbol is present or not */               
    symbolInput = gettingSymbol;

    if ( symbolInput.isEmpty() )         /** checiking to see if the symbol is enetred or not */
    {
       System.out.println("Symbol has been found empty ");
      symbolPresent = false;             /** if the user leaves it empty set symbol to false */
          
    }

    String wordInput;                    /** string to take in word */
    boolean wordPresent = true;          /** boolean to cheack if the word is present or not */
    System.out.println("Entering words ");  /** asking users to enter words they want to search */
    wordInput = gettingName;  /** scanning in the values */
               
    if (wordInput.isEmpty() )       /** if no word is entered test */
    {
      System.out.println("Name has been found empty ");
      wordPresent = false;         /** if useres leaves word empty sent it to false */
                    
    }

   /*************************************************************************************************************** */

   if( !gettingLowPrice.isEmpty() && gettingHighPrice.isEmpty() )
   {
     gettingLowPrice = gettingLowPrice + "-";
     rangeInput =gettingLowPrice;
     System.out.println(rangeInput);
   }

   if( gettingLowPrice.isEmpty() && !gettingHighPrice.isEmpty() )
   {
     gettingHighPrice = "-"+ gettingHighPrice;
     rangeInput = gettingHighPrice;
     System.out.println(rangeInput);
   }

   if( !gettingLowPrice.isEmpty() && !gettingHighPrice.isEmpty() )
   {
     rangeInput = gettingLowPrice +"-"+ gettingHighPrice;
     System.out.println(rangeInput);
   }


    
    boolean rangePresent = true;   /** boolean to check for range */
    

    if ( rangeInput.isEmpty() )    /** if the range is empty */
    { 
      System.out.println("Range has been found empty  ");
      rangePresent = false;        /** is user leaves range empty set it as false */
 
    }


    float upperRange = 0;           /** setting two doubel vlaues for upper range and bottom range */
    boolean dashNotPresent = true;  /** boolean to check if dash is present or not */
    float bottomRange = 0;          /**Setting up thr bottom range */
          
    if (rangePresent == true)   /** if the user entered the range below are different way to test what the user enteres */
    {
      for (int i = 0; i < rangeInput.length(); i++)   /** traversing through the range */
      {
        if ( rangeInput.charAt(i) == '-' )             /** if there is a - symbol then set exact to false */
        {
          dashNotPresent = false;                    /** tells us dash is present */
        }
      }
            
      if (dashNotPresent)                           /** if the user only entere a price */
      {
        upperRange = Float.parseFloat(rangeInput);  /** upper range is the same as input and we conevrt it to double */
        bottomRange = upperRange;                   /** bottom range is same as upper range as its only one price */
      } 
            
      else if ( rangeInput.charAt( rangeInput.length() - 1 ) == '-') /** if the range enetred has dash at the end */
      {
        String tempBottomRange;
        tempBottomRange = rangeInput.substring(0, rangeInput.length() - 1);  /** rmeoving the dash at the end using substring method */
        bottomRange = Float.parseFloat(tempBottomRange);                            /** converting to string the bottomrange */
        upperRange = Float.POSITIVE_INFINITY;                                       /** setting upper range to infinite , used interent to search for postive_infite */
      }

      else if ( rangeInput.charAt(0)== '-' )  /** if the dash is at the beginning */
      {
        String tempUpperRange = rangeInput.substring(1);  /** onyl using the number and removing the dash at the beggining as - is t 0 index */
        upperRange = Float.parseFloat(tempUpperRange);  /** updating upper range using */
      }

      else    /** to check if the dash is somewhere in between */
      {
        String rangeInputArray[] = rangeInput.split("-");  /** using split methid to split numbers on either side of dash*/
        bottomRange = Float.parseFloat(rangeInputArray[0]);  /** then th ebottom range would be at index */
        upperRange = Float.parseFloat(rangeInputArray[1]);   /** the upper range would be at index 1 */
      }
    }
          
          
    for (int i = 0; i < investmentsArray.size(); i++)   
    {
      boolean symbolPresentArray = false;    /** booleans to check is symbol range and word are present in arrays*/
          
      if (symbolPresent)  /** if symbol is present and the user enetered */
      {
        if (symbolInput.equals(investmentsArray.get(i).getSymbol() ) == true) /** if the symbol is isnde  */
        {
          symbolPresentArray = true;  /** set that symbolPresent in th earray is true */
        }
      }
            

      boolean rangePresentArray = false;
      if (rangePresent)    /** if the range is present and enetred by user */
      {
        double tempPrice = investmentsArray.get(i).getPrice();  /** getting the price and storing it in tempprice */
        if (tempPrice >= bottomRange && tempPrice <= upperRange)   /** comapring to see if the tempPirce in in the range enetred*/
        {
          rangePresentArray = true;   /** tells us that the number is present in the array and set it to true */

        }
                   
      }
          
      boolean keyWordPresentArray = false;
      if (wordPresent)  /** if word is present and entered by the user */
      {
        String wordSearchArray[] = investmentsArray.get(i).getName().split("[/ .,;:]+");  /** cehcking to see if word is inside array */
        boolean wordFound = true;
        String wordSplited[] = wordInput.split("[/ .,;:]+");  /** spilting the words entered  */
        boolean wordMatchFound = false;  /** the word match found inside array */

        for (int f = 0; f < wordSplited.length; f++) 
        {
          wordMatchFound = false;  /**  setting boolean to word not found */

          for (int g = 0; g < wordSearchArray.length; g++) 
          {
            if (wordSplited[f].equalsIgnoreCase( wordSearchArray[g] ) ) 
            {
              wordMatchFound = true;  /** if the word is found in the array and matches the word enetred */
            }
          }
        }
                  
        if (wordFound) /** if the word was found inside the array*/
        {
          keyWordPresentArray = true;  /** then set the word present in array to true*/
        }

        if (!wordMatchFound)   /** if no match was found then set wordfound to false*/
        {
          wordFound = false;
        }
      }

      if (rangePresent == rangePresentArray && symbolPresent == symbolPresentArray  &&  wordPresent == keyWordPresentArray)  /** checking to see if range symbol and word are both present in array and entered by user*/
      {
        System.out.println("Match was Found");
        System.out.println( investmentsArray.get(i).toString() ); 

        separate = ( "\nMatch was Found\n" + investmentsArray.get(i).toString() );

        System.out.println(separate);

        allInvestments.append(separate);

      }
    }

    bufferToString = allInvestments.toString();

   return bufferToString;
  }
  
 

  

          
}