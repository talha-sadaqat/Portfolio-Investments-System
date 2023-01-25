package eportfolio;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/** 
*
*@author MUHAMMAD TALHA SADAQAT
*/

/**
*main Gui class where the user menu is , this made my code more readable and help me use abstract coding , 
*my Gui class implements all the user display and controls the user display as well , it also handled exception handling and prints error messages for the user 
*Taking in different values from the user in the main class and error checking it to make it more user friendly 
* I even declare an object of portfolio class so that I can access all the fucntion in my portfolio class , which does all the backend program work for me 
*I even declared an object of portfolio class so that I can access all the fucntions and instances in my portfolio class , which does all the backend program work for me and make the code more efficient and reduced redundecy .
*I have also used truly overiding methods for inhertiance
*This Gui class also makes sure to definy copy constructor so that we can create a duplicate object and assign it to another reference in order to avoid privacy leaks.
*/
public class Gui extends JFrame implements ActionListener
{

  Portfolio portfolio = new Portfolio();
  public static final int WIDTH = 700;
  public static final int HEIGHT = 600;
  public static final int LINES = 20;
  public static final int CHAR_PER_LINE = 30;

  JMenuBar bar;
  JMenu selectCommand;
  JMenuItem op1;
  JMenuItem op2;
  JMenuItem op3;
  JMenuItem op4;
  JMenuItem op5;
  JMenuItem op6;

  JPanel firstPage;
  JPanel panel1;
  JPanel op1PanelTop;


  JTextArea welcomeMessage;
  JTextArea memoDisplay;

  JTextField TypeFieldTextBox;
  JTextField SymbolFieldBox;
  JTextField NameFieldBox;
  JTextField QuantityFieldBox;
  JTextField priceFieldBox;
  JTextField totalGainBox;
  JTextField SymbolFieldBoxSearch;
  JTextField NameFieldBoxSearch;
  JTextField lowPriceFieldBox;
  JTextField highpriceFieldBox;
  JTextField updateSymbolTextBox;
  JTextField updateNameTextBox;
  JTextField updatePriceTextBox;

  JButton AddInvestment;
  JButton ResetBuy;
  JButton sellButton;
  JButton resetSell;
  JButton resetSearch;
  JButton buttonSearch;
  JButton updatePreviousButton;
  JButton updateNextButton;
  JButton updateSaveButton;

  String TypeinString;

  JComboBox <String> listOfTypes;
  String[] types = {"stock" , "mutualFund"};
  String currentType;


  int counter = -1;
  int updateCounter = 0;

  /**
  I am calling Gui in this class in order to have no privacy leak , hence have portection , therefore also 
  making use of proper abstract classes 
  */
  

  public static void main(String[] args)
  {
   // Portfolio portfolio = new Portfolio();     /*declaring an object for portfolio*/
  
    
    Gui Gui = new Gui();
    Gui.setVisible(true);
  }

  public Gui()
  {
    setTitle("ePortfolio");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    setLayout( new BorderLayout() ); 

    introduction();
    menuItems();

  }

  /**
  * This public sets up the menu option with all the different menu items that have action listeners and hence work accordingly
  */

  public void menuItems()
  {
    bar = new JMenuBar();
    setJMenuBar(bar);

    selectCommand = new JMenu("Commands");
    selectCommand.setFont(new Font("dialog", Font.BOLD,20));
    bar.add(selectCommand);

    op1 = new JMenuItem("Buy");
    selectCommand.add(op1);
    op1.addActionListener(this);

    op2 = new JMenuItem("Sell");
    selectCommand.add(op2);
    op2.addActionListener(this);

    op3 = new JMenuItem("Update");
    selectCommand.add(op3);
    op3.addActionListener(this);

    op4 = new JMenuItem("getGain");
    selectCommand.add(op4);
    op4.addActionListener(this);

    op5 = new JMenuItem("Search");
    selectCommand.add(op5);
    op5.addActionListener(this);

    op6 = new JMenuItem("Quit");
    selectCommand.add(op6);
    op6.addActionListener(this);

  }

  /**
  * sets and displays the main page with a welcome message displayed in a user friendly way
  */

  public void introduction()
  {

    firstPage = new JPanel();
    firstPage.setLayout(new BorderLayout() );
    firstPage.setBorder(new EmptyBorder(5,5,5,5));

    welcomeMessage = new JTextArea(5,5);
    welcomeMessage.setBackground(Color.WHITE);
    welcomeMessage.setEditable(false);
    welcomeMessage.setBorder(new EmptyBorder(10,10,10,10));
    welcomeMessage.setFont(new Font("monospaced", Font.BOLD,20));
    welcomeMessage.setText("\n\n\nWelcome to ePortfolio. \n\n\n\n\n\n\n\n Choose a command from the “Commands” menu to buy or   sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program. ");
    welcomeMessage.setLineWrap(true);
    firstPage.add(welcomeMessage);
    firstPage.setVisible(true);
    add(firstPage,BorderLayout.CENTER);


  }

  /**
  * This is the page layout that opens up when the user selects the buy page it has buttons with action listners that perform save and reset fucntons
  * it also has a scroll panel to display all the error messages and to see what investment was bought by the user
  *this public void mehtod also calls the fucntion backEndup with performs all the program required to add investments and carry out error checkings 
  */
  public void buyLayout()
  {
    
    firstPage.removeAll();
    firstPage.revalidate();
    firstPage.repaint();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1,2));

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
    
    panel1 = new JPanel();
    panel1.setLayout(new FlowLayout());

    JPanel Labels = new JPanel();
    Labels.setLayout(new GridLayout(0,1,15,15));

    JPanel Controls  = new JPanel();
    Controls.setLayout(new GridLayout(0,1,10,10));

    
    
    listOfTypes = new JComboBox <>(types);
    listOfTypes.setSelectedIndex(0);
    currentType = types[0];
    listOfTypes.addActionListener(this);
    
    Labels.add(new JLabel("  "));
    Controls.add(new JLabel("Buying an Investment") );
    
    TypeFieldTextBox = new JTextField(10);              /************ */

  

    //TypeFieldTextBox = new JTextField(10);  
    Labels.add(new JLabel("Type"));
    Controls.add(listOfTypes);

    SymbolFieldBox = new JTextField(10);
    Labels.add(new JLabel("Symbol "));
    Controls.add(SymbolFieldBox);

    NameFieldBox = new JTextField(10);
    Labels.add(new JLabel("Name "));
    Controls.add(NameFieldBox);

    QuantityFieldBox = new JTextField(10);
    Labels.add(new JLabel("Quantity "));
    Controls.add(QuantityFieldBox);

    priceFieldBox = new JTextField(10);
    Labels.add(new JLabel("Price "));
    Controls.add(priceFieldBox);


    // BUTTON **************************************
    JPanel AorRbutton = new JPanel();
    AorRbutton.setLayout(new FlowLayout());

    JPanel buttonsPosition = new JPanel();
    buttonsPosition.setLayout(new GridLayout(0,1,10,10));

    AddInvestment = new JButton("Buy");
    buttonsPosition.add(AddInvestment);
    AddInvestment.addActionListener(this);

    ResetBuy = new JButton("Reset");
    buttonsPosition.add(ResetBuy);
    ResetBuy.addActionListener(this);

    AorRbutton.add(buttonsPosition);

  
    memoDisplay = new JTextArea(LINES, CHAR_PER_LINE);
    memoDisplay.setBackground(Color.WHITE);

    JScrollPane scrolledText = new JScrollPane(memoDisplay);
    scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    memoDisplay.append("Messages\n\n");
    memoDisplay.append("The investments you add will be showed below\n");

    
    panel1.add( Labels);
    panel1.add( Controls);

    topPanel.add(panel1);
    topPanel.add(AorRbutton);

    bottomPanel.add(scrolledText);

    firstPage.add(topPanel,BorderLayout.WEST);
    firstPage.add(bottomPanel,BorderLayout.SOUTH);
    firstPage.setVisible(true);

  }


  /**
  * This is the page layout that opens up when the user selects the sell page it has buttons with action listners that perform sell and reset fucntons
  * it also has a scroll panel to display all the error messages and to see what investment was sold and what was the profit recieved 
  *this public void mehtod also calls the fucntion backsell with performs all the program required to sell investments and carry out error checkings 
  */

  public void sellLayout()
  {

    firstPage.removeAll();
    firstPage.revalidate();
    firstPage.repaint();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1,2));

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
    
    panel1 = new JPanel();
    panel1.setLayout(new FlowLayout());

    JPanel Labels = new JPanel();
    Labels.setLayout(new GridLayout(0,1,15,15));

    JPanel Controls  = new JPanel();
    Controls.setLayout(new GridLayout(0,1,10,10));

    
    Labels.add(new JLabel("  "));
    Controls.add(new JLabel("Selling an Investment") );
    

    SymbolFieldBox = new JTextField(10);
    Labels.add(new JLabel("Symbol "));
    Controls.add(SymbolFieldBox);

    QuantityFieldBox = new JTextField(10);
    Labels.add(new JLabel("Quantity "));
    Controls.add(QuantityFieldBox);

    priceFieldBox = new JTextField(10);
    Labels.add(new JLabel("Price "));
    Controls.add(priceFieldBox);


    // BUTTON **************************************
    JPanel AorRbutton = new JPanel();
    AorRbutton.setLayout(new FlowLayout());

    JPanel buttonsPosition = new JPanel();
    buttonsPosition.setLayout(new GridLayout(0,1,10,10));

    sellButton = new JButton("Sell");
    buttonsPosition.add(sellButton);
    sellButton.addActionListener(this);

    resetSell = new JButton("Reset");
    buttonsPosition.add(resetSell);
    resetSell.addActionListener(this);

    AorRbutton.add(buttonsPosition);

  
    memoDisplay = new JTextArea(LINES, CHAR_PER_LINE);
    memoDisplay.setBackground(Color.WHITE);

    JScrollPane scrolledText = new JScrollPane(memoDisplay);
    scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    memoDisplay.append("Messages\n\n");
    memoDisplay.append("The investments you sell will be showed below\n");

    
    panel1.add( Labels);
    panel1.add( Controls);

    topPanel.add(panel1);
    topPanel.add(AorRbutton);

    bottomPanel.add(scrolledText);

    firstPage.add(topPanel,BorderLayout.WEST);
    firstPage.add(bottomPanel,BorderLayout.SOUTH);
    
    firstPage.setVisible(true);
  }


 /**
  * This is the page layout that opens up when the user selects the update page it has buttons with action listners that perform next previous and save fucntions
  * it also has a scroll panel to display all the error messages and to see what investment was bupdated
  *this public void mehtod also calls the fucntion backEndUpdate with performs all the program required to update investments and carry out error checkings 
  */
  public void updateLayout()
  {
    firstPage.removeAll();
    firstPage.revalidate();
    firstPage.repaint();

    updateCounter =0;

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1,2));

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
    
    panel1 = new JPanel();
    panel1.setLayout(new FlowLayout());

    JPanel Labels = new JPanel();
    Labels.setLayout(new GridLayout(0,1,15,15));

    JPanel Controls  = new JPanel();
    Controls.setLayout(new GridLayout(0,1,10,10));

    
    Labels.add(new JLabel("  "));
    Controls.add(new JLabel("Updating Investments") );

    System.out.println(portfolio.investmentsArray.size());


    updateSymbolTextBox = new JTextField(10);
    Labels.add(new JLabel("Symbol "));
    Controls.add(updateSymbolTextBox);
    updateSymbolTextBox.setEditable(false);

    updateNameTextBox = new JTextField(10);
    Labels.add(new JLabel("Name "));
    Controls.add(updateNameTextBox);
    updateNameTextBox.setEditable(false);

    updatePriceTextBox = new JTextField(10);
    Labels.add(new JLabel("Price "));
    Controls.add(updatePriceTextBox);
   
   if(updateCounter == 0 && portfolio.investmentsArray.size()!=0 )
    {
      updateSymbolTextBox.setText(portfolio.investmentsArray.get(0).getSymbol());
      updateNameTextBox.setText(portfolio.investmentsArray.get(0).getName());
    }

    

   


    // BUTTON **************************************
    JPanel AorRbutton = new JPanel();
    AorRbutton.setLayout(new FlowLayout());

    JPanel buttonsPosition = new JPanel();
    buttonsPosition.setLayout(new GridLayout(0,1,10,10));

    updatePreviousButton = new JButton("Previous");
    buttonsPosition.add(updatePreviousButton);
    updatePreviousButton.addActionListener(this);
    if(updateCounter == 0 )
    {
      updatePreviousButton.setEnabled(false);    
    }

   System.out.println(portfolio.investmentsArray.size());
    System.out.println(updateCounter);


    updateNextButton = new JButton("Next");
    buttonsPosition.add(updateNextButton);
    updateNextButton.addActionListener(this);

    if(portfolio.investmentsArray.size() == 0)
    {
      updateNextButton.setEnabled(false); 
    }
    if(updateCounter == 0 && portfolio.investmentsArray.size()==1 )
    {
      updateNextButton.setEnabled(false);    
    }
    

    updateSaveButton = new JButton("Save");
    buttonsPosition.add(updateSaveButton);
    updateSaveButton.addActionListener(this);

    AorRbutton.add(buttonsPosition);

  
    memoDisplay = new JTextArea(LINES, CHAR_PER_LINE);
    memoDisplay.setBackground(Color.WHITE);

    JScrollPane scrolledText = new JScrollPane(memoDisplay);
    scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    memoDisplay.append("Messages\n\n");
    memoDisplay.append("The investments you update will be showed below\n");

    
    panel1.add( Labels);
    panel1.add( Controls);

    topPanel.add(panel1);
    topPanel.add(AorRbutton);

    bottomPanel.add(scrolledText);

    firstPage.add(topPanel,BorderLayout.WEST);
    firstPage.add(bottomPanel,BorderLayout.SOUTH);
    
    firstPage.setVisible(true);


  }


 /**
  * This is the page layout that opens up when the user selects the getGain page . this page displays the total get gain , and the textfield is uneditable 
  * it also has a scroll panel to display all the individual gains separately
  *this public void mehtod cll portfolio class to use the getgain code and hence calcualte it 
  */
  public void getGainLayout()
  {
    firstPage.removeAll();
    firstPage.revalidate();
    firstPage.repaint();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1,2));

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
    
    panel1 = new JPanel();
    panel1.setLayout(new FlowLayout());

    JPanel Labels = new JPanel();
    Labels.setLayout(new GridLayout(0,1,15,15));

    JPanel Controls  = new JPanel();
    Controls.setLayout(new GridLayout(0,1,10,10));

    
    Labels.add(new JLabel("  "));
    Controls.add(new JLabel("Getting Total gain") );
    
    totalGainBox = new JTextField(10);
    totalGainBox.setEditable(false);
    Labels.add(new JLabel("Total gain "));
    Controls.add(totalGainBox);

    String gettingTotalGain = portfolio.getGain();

    totalGainBox.setText(gettingTotalGain);

  
    memoDisplay = new JTextArea(LINES, CHAR_PER_LINE);
    memoDisplay.setBackground(Color.WHITE);

    JScrollPane scrolledText = new JScrollPane(memoDisplay);
    scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    memoDisplay.append("Individuals Gain\n\n");

    String gettingIndividualGain = portfolio.getGainInvestmentNames();
    memoDisplay.append(gettingIndividualGain);

    panel1.add( Labels);
    panel1.add( Controls);

    topPanel.add(panel1);


    bottomPanel.add(scrolledText);

    firstPage.add(topPanel,BorderLayout.WEST);
    firstPage.add(bottomPanel,BorderLayout.SOUTH);
    
    firstPage.setVisible(true);

  }



 /**
  * This is the page layout that opens up when the user selects the Search page . 
  * it also has a scroll panel to display all the investment that was found during search
  *this public void mehtod call portfolio class to use the getgain code and hence calcualte it 
  */
  public void searchLayout()
  {
    firstPage.removeAll();
    firstPage.revalidate();
    firstPage.repaint();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1,2));

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
    
    panel1 = new JPanel();
    panel1.setLayout(new FlowLayout());

    JPanel Labels = new JPanel();
    Labels.setLayout(new GridLayout(0,1,15,15));

    JPanel Controls  = new JPanel();
    Controls.setLayout(new GridLayout(0,1,10,10));
    
    
    Labels.add(new JLabel("  "));
    Controls.add(new JLabel("Searching Investments") );
    
    SymbolFieldBoxSearch = new JTextField(10);     
    Labels.add(new JLabel("Symbol"));
    Controls.add(SymbolFieldBoxSearch);

    NameFieldBoxSearch = new JTextField(10);
    Labels.add(new JLabel("Name keywords "));
    Controls.add(NameFieldBoxSearch);

    lowPriceFieldBox = new JTextField(10);
    Labels.add(new JLabel("Low Price "));
    Controls.add(lowPriceFieldBox);

    highpriceFieldBox = new JTextField(10);
    Labels.add(new JLabel("High Price "));
    Controls.add(highpriceFieldBox);


    // BUTTON **************************************
    JPanel AorRbutton = new JPanel();
    AorRbutton.setLayout(new FlowLayout());

    JPanel buttonsPosition = new JPanel();
    buttonsPosition.setLayout(new GridLayout(0,1,10,10));

    resetSearch = new JButton("Reset");
    buttonsPosition.add(resetSearch);
    resetSearch.addActionListener(this);

    buttonSearch = new JButton("Search");
    buttonsPosition.add(buttonSearch);
    buttonSearch.addActionListener(this);

    AorRbutton.add(buttonsPosition);

  
    memoDisplay = new JTextArea(LINES, CHAR_PER_LINE);
    memoDisplay.setBackground(Color.WHITE);

    JScrollPane scrolledText = new JScrollPane(memoDisplay);
    scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    memoDisplay.append("Search results\n\n");
    memoDisplay.append("The investments you search will be showed below\n\n");

    
    panel1.add( Labels);
    panel1.add( Controls);

    topPanel.add(panel1);
    topPanel.add(AorRbutton);

    bottomPanel.add(scrolledText);

    firstPage.add(topPanel,BorderLayout.WEST);
    firstPage.add(bottomPanel,BorderLayout.SOUTH);
    firstPage.setVisible(true);

  }


 /**
  * This is the backend code that does all the work to buy a new or exisitng investment. 
  * it also has a scroll panel to display all the investment that were bought
  *this public void mehtod call portfolio class to inherit and use its code to buy a new investent
 */
  public void backEndBuy() 
  {
    String investmentType;  
    String symbol;  
    String name;
    int stockOrMutualFund =0;  
    int symbolIndex =0;   
    String quantity;  
    String price; 
    String investmentSymbolName; 

    int quantityParse =0;
    double priceParse =0;
 

    symbol = SymbolFieldBox.getText();
    if(symbol.isEmpty())
    {
      System.out.println("Please Enter the symbol name that you want to buy or add too , and symbol cannot be an integer");
    }
    
    symbolIndex = portfolio.symbolIndexCheck( symbol);

    if(symbolIndex >=0)  /** the investment already exists in the investment array */
    {
      System.out.println("Please Enter the quantity you would like to buy for your investment:");   

      quantity = QuantityFieldBox.getText();
      quantityParse = Integer.parseInt(quantity);

      if(quantityParse <=0) /**checking to see if the user enetered a quantoty larger then 0 */
      {
        memoDisplay.append("\nERROR \nPlease enter a quantity larger then 0 and its shoud not be a string \n");
      }

      System.out.println("Please Enter the price for the investment you would like to buy: ");  

      price = priceFieldBox.getText();   
      priceParse = Double.parseDouble(price);

      if(priceParse <=0.0 )   /**checking to seee if the user didnt eneter a negative price  */
      {
        memoDisplay.append("\nERROR \nPlease enter a price larger then 0 as price cannot be negative: and it should not be a string \n");
      }

      if( priceParse >= 0.0 && quantityParse >=0  )
      {

        String gettingString = portfolio.updateExistingInvestment(quantityParse , priceParse, symbolIndex);
        System.out.println(gettingString);

        memoDisplay.append(gettingString);
      }
    }
    
    else if (symbolIndex == -1)  /**if its a brand new investment and it doesnt exists in invesntsmenr array */
    {

      System.out.println("Please Enter the Type of investment (either stock or mutual Fund) that you would like to buy: ");  
      
      investmentType = currentType;


      if( investmentType.equalsIgnoreCase("stock") || investmentType.equalsIgnoreCase("s") || investmentType.equalsIgnoreCase("stocks")  )       /** if user selected stock */
      {
        stockOrMutualFund = 0;  /** assining it to 0 to represent a stock has been called */
      }

      if( investmentType.equalsIgnoreCase("mutual fund") ||  investmentType.equalsIgnoreCase("M")  || investmentType.equalsIgnoreCase("mutualFunds") || investmentType.equalsIgnoreCase("mutualFund") || investmentType.equalsIgnoreCase("mutual Funds") )
      {
        stockOrMutualFund = 1;  /** assining it to 1 to represent a stock has been called */
      }

      System.out.println("Please Enter the name for the investment symbol you would like to buy: ");  /** askign to enter name for the investment */
      name = NameFieldBox.getText();
    
      System.out.println("Please Enter the quantity for the investment you would like to buy: ");    
      quantity = QuantityFieldBox.getText();
      quantityParse = Integer.parseInt(quantity);   


      if(quantityParse <=0) 
      {

       memoDisplay.append("\nERROR \nPlease enter a quantity larger then 0 and it should not be a SString \n");

      }

      System.out.println("Please Enter the price for the investment that you would like to buy: ");  

      price = priceFieldBox.getText();   
      priceParse = Double.parseDouble(price);

      if(priceParse <=0.0 )   /**checking to seee if the user didnt eneter a negative price  */
      {
        memoDisplay.append("\nERROR \nPlease enter a price larger then 0 as price cannot be negative and it should not be a String \n");
      }

      if( priceParse >= 0.0 && quantityParse >=0  )
      {

        if(stockOrMutualFund == 0 )  /**If the user sleecetd a stock */
        {
          String gettingString = portfolio.addStockToArrayList(symbol,name,quantityParse,priceParse);
          System.out.println(gettingString);

          memoDisplay.append(gettingString);

          
        }
        else if (stockOrMutualFund == 1)  /**If the user sleecetd a mutualFund */
        {
          String gettingString =portfolio.addMutualFundsToArrayList(symbol,name,quantityParse,priceParse);
          System.out.println(gettingString);

          memoDisplay.append(gettingString);
        }

      }

    }

  }

 /**
  * This is the backend for sell code that does all the work to sell an  investment. 
  * it also has a scroll panel to display all the investments that were sold and display error messages for wrong input 
  *this public void mehtod call portfolio class to inherit and use its code to sell an investent
 */
  public void backEndSell()
  {
    
    String investmentType;  
    String symbol;  
    int stockOrMutualFund =0;  
    int symbolIndex =0;   
    String quantity;  
    String price; 
    String investmentSymbolName; 

    int quantityParse =0;
    double priceParse =0;

    
    symbol = SymbolFieldBox.getText();

    if (symbol.isEmpty())
    {
      memoDisplay.append("\nERROR \nPlease enter a symbol and dont enter and integer \n");
    }
    
    if ( (!symbol.isEmpty()) )
    {
     symbolIndex = portfolio.symbolIndexCheck( symbol);
    }

    if(symbolIndex != -1)   /** checkign to see if the symbol index exixts in our arraylist */
    {
      System.out.println("Please enter the number of shares you want to sell of your investment:");
      
      quantity = QuantityFieldBox.getText();
      quantityParse = Integer.parseInt(quantity);   


      if(quantityParse <0) 
      {

       memoDisplay.append("\nERROR \nPlease enter a quantity larger then 0: and dont enter a String \n");

      }

      price = priceFieldBox.getText();   
      priceParse = Double.parseDouble(price);

      if(priceParse <=0.0 )   /**checking to seee if the user didnt eneter a negative price  */
      {
        memoDisplay.append("\nERROR \nPlease enter a price larger then 0 as price cannot be negative and price cannot be a String \n");
      }

      if(priceParse >= 0.0 && quantityParse >=0 )   /**checking to seee if the user didnt eneter a negative price  */
      {
        String gettingString = portfolio.sell(quantityParse , priceParse, symbolIndex);
        memoDisplay.append(gettingString);
      }

    } 
    else  /**Error message of the symbol doesnt exist in the investment array */
    {
      memoDisplay.append("\nThis symbol does not exist in the investment , please enter an investment that you own\n");
    }

  }

  /**
  * This is the backend for search code that does all the work to search an  investment. 
  * it also has a scroll panel to display all the investments that were found and display anh error messages for wrong input 
  *this public void mehtod call portfolio class to inherit and use its code to search an investent
 */
  public void backEndSearch()
  {
    String gettingSymbol;
    String gettingName;
    String gettingLowPrice;
    String gettingHighPrice;

    gettingSymbol = SymbolFieldBoxSearch.getText();
    gettingName = NameFieldBoxSearch.getText();
    gettingLowPrice = lowPriceFieldBox.getText();
    gettingHighPrice = highpriceFieldBox.getText();

    System.out.println(gettingSymbol + gettingName + gettingLowPrice + gettingHighPrice );


    String gettingString = portfolio.search(gettingSymbol,gettingName,gettingLowPrice,gettingHighPrice);
     memoDisplay.append(gettingString);
  }

  /**
  * This is the backend code for updating it implements all the code that does enables and disbales buttons according to the position of the loop and moves around the array
  * it also has a scroll panel to display all the investments whoe pirces were updayes display anh error messages for wrong input 
  *this public void mehtod call portfolio class to inherit and use its code update the price of an investment 
 */
  public void updateNext()
  {
    updateCounter = updateCounter + 1;
    updateSymbolTextBox.setText(portfolio.investmentsArray.get(updateCounter).getSymbol());
    updateNameTextBox.setText(portfolio.investmentsArray.get(updateCounter).getName());
    if(updateCounter == ( portfolio.investmentsArray.size() -1 ) )
    {
      updateNextButton.setEnabled(false);    
    }
    if(updateCounter > ( portfolio.investmentsArray.size() -1 ) )
    {
      updateNextButton.setEnabled(false);    
    }
    if(updateCounter != 0 )
    {
      updatePreviousButton.setEnabled(true);    
    }
  }


  /**
  * This is the backend code for saving the updated investment when the save button is pressed 
  * it also has a scroll panel to display all the investments whoe pirces were updated and dispaly error messages for wrong input  , such as negative price 
  *this public void mehtod call portfolio class to inherit and use its code update the price of an investment 
 */
  public void updateSave()
  {
    String gettingUpdatePrice = updatePriceTextBox.getText();
    double priceInDouble = Double.parseDouble(gettingUpdatePrice);
    if(priceInDouble <0)
    {
      memoDisplay.append("\nERROR\n please enter a postive value price\n");
    }
    else
    {
      portfolio.investmentsArray.get(updateCounter).setPrice(priceInDouble);
      memoDisplay.append(portfolio.investmentsArray.get(updateCounter).toString());
    }
  }


 /**
  * This is the backend code for updating it implements all the code that does enables and disbales buttons according to the position of the loop and moves around the array
  * it also has a scroll panel to display all the investments whoe pirces were updated and display any error messages for wrong input 
  *this public void mehtod call portfolio class to inherit and use its code update the price of an investment 
 */
  public void updatePrevious()
  {
    updateCounter = updateCounter - 1;
    updateSymbolTextBox.setText(portfolio.investmentsArray.get(updateCounter).getSymbol());
    updateNameTextBox.setText(portfolio.investmentsArray.get(updateCounter).getName());
    if(updateCounter == ( portfolio.investmentsArray.size() -1 ) )
    {
      updateNextButton.setEnabled(false);    
    }
    if(updateCounter != 0 )
    {
      updatePreviousButton.setEnabled(true);    
    }
    if(updateCounter == 0 )
    {
      updatePreviousButton.setEnabled(false);    
    }
    if(updateCounter == 0 && portfolio.investmentsArray.size()!=0 )
    {
      updateNextButton.setEnabled(true);    
    }

  }

 
/** Below are all the action listenrs that call different methods according to which action needs to take place
* It also check which button was pressed and what action needs to take place 
* it alsso implements all reset options 
 */
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == op1)
    {
      buyLayout();

    }
    else if(e.getSource() == AddInvestment)
    {
      backEndBuy();
    }
    else if (e.getSource() == listOfTypes)
    {
      currentType = (String)listOfTypes.getSelectedItem();
      System.out.println(currentType);

    }
    else if (e.getSource() == ResetBuy)
    {
      priceFieldBox.setText("");
      listOfTypes.setSelectedIndex(0);
      SymbolFieldBox.setText("");
      NameFieldBox.setText("");
      QuantityFieldBox.setText("");
    }

    else if(e.getSource() == op2)
    {
      sellLayout();
      
    }

    else if(e.getSource() == sellButton)
    {
      backEndSell();
    }

    else if(e.getSource() == resetSell)
    {
      priceFieldBox.setText("");
      SymbolFieldBox.setText("");
      QuantityFieldBox.setText("");
    }

    else if(e.getSource() == op4)
    {
      getGainLayout();

    }

    else if(e.getSource() == op6)
    {
      System.exit(0);
    }

    else if(e.getSource() == op5)
    {
      searchLayout();
    }

    else if(e.getSource() == resetSearch)
    {
      SymbolFieldBoxSearch.setText("");
      NameFieldBoxSearch.setText("");
      lowPriceFieldBox.setText("");
      highpriceFieldBox.setText("");
    }

    else if(e.getSource() == buttonSearch)
    {
      backEndSearch();

    }

    else if (e.getSource() == op3)
    {
      updateLayout();
    }

    else if (e.getSource() == updateNextButton)
    {
      updateNext();
    }

    else if (e.getSource() == updateSaveButton)
    {
      updateSave();
    }

    else if (e.getSource() == updatePreviousButton)
    {
      updatePrevious();
    }


  }


  

}
