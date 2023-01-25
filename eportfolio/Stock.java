package eportfolio;
import java.io.*;
import java.util.*;
import java.io.PrintWriter;

/**
* A class to represent a stock purchase 
* it has a super class which has most of its methods and instances 
* this class has an overide method to calcute the book value
* @author MUHAMMAD TALHA SADAQAT
*/

public class Stock extends Investment
{

  public static final double commision =9.99; /**Extending this subclass to the super class investment */

  /** 
  *@param price , this is the price the user will input and will be used to calculte the book value
  *@param quantity , this is the quantity that the user will input and will be used to clcute the bookvalue
  */
  @Override
  public void calculateBookValue(double price ,int quantity)
  {
    bookValue = bookValue + ( price *quantity ) + commision;
  }
     
}