package eportfolio;

import java.io.*;
import java.util.*;
import java.io.PrintWriter;


/**
* A class to represent mutualFund , it has a super class which has most of its methods and instances 
* this class has an overide method to calcute the book value 
* @author MUHAMMAD TALHA SADAQAT
*/

public class MutualFund extends Investment   /**Extending this subclass to the super class investment */
{
  public static final double commision = 45.0;     /** final static commison for mutualfund and it cannot be changed  */


  /** 
  *@param price , this is the price the user will input and will be used to calculte the book value
  *@param quantity , this is the quantity that the user will input and will be used to clcute the bookvalue
  */
  @Override  /**This method overirdes the method from the investment class */
  public void calculateBookValue(double price ,int quantity)
  {
    bookValue = bookValue + ( price *quantity );
  }
    
}    