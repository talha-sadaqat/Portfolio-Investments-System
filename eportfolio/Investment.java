package eportfolio;
import java.io.*;
import java.util.*;
import java.io.PrintWriter;


/**
* A class to represent a super class called Investment
* @author MUHAMMAD TALHA SADAQAT
*/

public class Investment         
{
    /** Using protected class so that these instances can be accessed by class , package and subclass , however it cant be accessed by the world */
    /** the symbol of the investments */
    protected String symbol; 
    /** the name of the investments */
    protected String name; 
    /** quanity which tells  how many shares are owned */
    protected int quantity;
    /** the price of the of investment */
    protected double price;
    /**  the bookvalue of the investments */
    protected double bookValue;
    /** investment type tells if it is stock or mutualfund */
    protected String investmentType;
   
    /**
    * Ccontructor for Investment used to intialize all the variables in the investment class
    * a constructor has no return value
    * the symbol of the investments
    * the name of the investments
    * quanity which tells  how many shares are owned
    * the price of the of investment
    *  the bookvalue of the investments
    * investment type tells if it is stock or mutualfund
    */
    public Investment()
    {
        this.symbol = "";
        this.name = "";
        this.quantity = 0;
        this.price = 0.0;
        this.bookValue = 0.0;
        this.investmentType = "";
    }
    
   
   // Below are all the mutators that are used to control chnages to a variable 

    /**
    * sets the investment type , wether it is a stock or mutual fund 
    * @param type if it is a stock or mutualfund 
    */
    public void setInvestmentType(String type)
    {
        this.investmentType = type;
    }

    /**
    * sets new quantoty 
    * @param quantity sets the new quantity
    */
    public void setQuantity(int quantity)
    {
       this.quantity = quantity;
    }

    /**
    * sets new bookvalue
    * @param bookValue sets the new bookvalue
    */
    public void setbookValue(double bookValue)
    {
       this.bookValue = bookValue;

    }

    /**
    * sets the new price 
    * @param price sets the new price
    */
    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public void setName (String name)
    {
        this.name = name;
    }



    //  below are some helper method to calulte different stuff  ----------------------------------------------------
    /**
    * @param quantitySold is the quantity sold and will be subtracted from the exisitng quantity 
    */
    public void sellQuantity(int quantitySold)
    {
        quantity = quantity - quantitySold;
    }

    /**
    * @param quantityBought is the quantity bought and will be added to the exisitng quantity 
    */
    public void addToExistingQuantity(int quantityBought)
    {
        quantity = quantity + quantityBought;
    }

    /*
    * This will bo overridden in the subclasses as the subclaases have calcutebookvalue 
    */
    public void calculateBookValue(double price ,int quantity)
    {

    }

    /**
    * this calcutes the book value when the user sells and investment 
    * @param quantity 
    */
    public void calculateSellBookValue(int quantity)
    {
      double tempQuantity = quantity;
      bookValue = bookValue * ( (this.quantity - tempQuantity) / this.quantity );
    }
    // ---------------------------------------------------------------------------------------------------------



  /**  below are all the accesors that are used to returb the vlaue of priavte variables */

    /**
    * return the quantity
    * @return quantity 
    */
    public int getQuantity()
    {
        return this.quantity;
    }
      
    /**
    * return the quantity
    * @return quantity 
    */
    public String getSymbol()
    {
        return symbol;
    }

    /**
    * returns the investmentType
    * @return investmentType
    */
    public String getInvestmentType()
    {
       return investmentType;
    }

    /**
    * Returns the price 
    * @return the price 
    */
    public double getPrice()
    {
       return price;
    }

    /**
    * Returns the bookvalue
    * @return the bookvalue
    */
    public double getbookValue()
    {
      return bookValue;
    }

    /**
    * returns the name
    * @return name 
    */
    public String getName()
    {
       return name;
    }

    /** To string method to print all the infomration of the current invetsment to the file with a specifi format  */
    public String toStringFile()   
    {
        return "type = " +"\"" + investmentType + "\"\n" +"symbol = " +  "\"" + symbol + "\"\n" + "name = " + "\""  + name + "\"\n" + "quantity = " +  "\"" + quantity + "\"\n" +  "price = " + "\""  + price + "\"\n" + "bookValue = " + "\"" + bookValue+ "\"\n";
    }
    
    /**To string method to print all the information for the current invetsment  */
    public String toString()   
    {
        return "\n" + "type = " +investmentType+ "\n" +"symbol = " + symbol + "\n" + "name = " + name + "\n" + "quantity = " + quantity + "\n" +  "price = $"  + price + "\n" + "bookValue = " + bookValue + "\n";
    }

    




}