/**
Edgar Giang
213438528

compiled using :
javac StockMarketMain.java StockMarket.java
java StockMarketMain


The following program gets user to input the number of stocks and the individual stock value. It will then test
for input validation and then outptu the calculated future cost of each individual stock.
If the stock symbols are lowercase it will be converted to upper case.
Example output is:

Please input the number of Stocks:5
Symbol for Stock #1:AMZN
Symbol for Stock #2:AAPL
Symbol for Stock #3:NVDA
Symbol for Stock #4:AMD
Symbol for Stock #5:INTC
Stock Symbols    current value   future Value    (Percentage Change)
AMZN             $81.56          $88.33          8.3%
AAPL             $81.98          $79.27          -3.31%
NVDA             $58.07          $56.7           -2.36%
AMD              $1.02           $1.07           5.19%
INTC             $65.7           $63.47          -3.4%


**/

/**
Java import setup
**/
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
public class StockMarketMain
{



public static void main(String args[])
{
/*set up for scanner input*/
Scanner scanner = new Scanner(System.in);

double userInputBalance = 0.0;

String stockString = " ";
int inputNum = 0;
int tempInputNum = 0;
int numStocks = 0;

boolean isValid = true;
boolean endProgram = false;

StockMarket stockMarket;

ArrayList<String> userInputStocks = new ArrayList<String>();
String stockSymbol = " ";

/**special char checking**/
Pattern pattern = Pattern.compile("[^A-Za-z0-9]");

/**Intro prommpt **/
System.out.println("Welcome to the stock market Program.You will input the  number of stocks, ");
System.out.println("and the symbol of each stocks. The program will then determine the future value");
System.out.println("of the stock and also present the percentage change of that future value.");

do
{

/**Ask user to enter number of stocks(integer)**/

	System.out.print("Please input the number of Stocks:");
	/**while integer is not detected it would promp the user to enter again**/
		
	while(!scanner.hasNextInt()){
		System.out.println("Please enter a valid Number!");
		scanner.next();	
	}
	/**user input will be assigned to numStocks**/
	
		inputNum = scanner.nextInt();
       	numStocks = inputNum;

	
	/**while inputNum is not a negative number and the program didn't end yet we get a temp variable
	called tempInputNum to tell the user which number of stock they should give a symbole for. numStocks
	is used for logical programming and should not be shown to the user as the number starts at zero.**/
		while(inputNum >= 0 && !endProgram )
		{
			tempInputNum++;
			System.out.print("Symbol for Stock #" + tempInputNum + ":");
				
			stockSymbol = scanner.next();
						
			/**Since stock symbols can't contain special characters and the symbol is less than 5 characters long
			there is input validation for it.**/
			Matcher matcher = pattern.matcher(stockSymbol);
			boolean specialCharTrue = matcher.find();
						
			if(stockSymbol.length() < 6 && !specialCharTrue)
			{
							
					/**Once validation is successful stockSybol which is user input is added to userInputStocks Arraylist**/
					userInputStocks.add(stockSymbol);
					
					/**stockMarket Object can now be called with it's provided parameter values which was recieved
					from user valid input**/
					stockMarket = new StockMarket(numStocks, userInputStocks);
					/**generate random numbers for stock value and percent**/
					stockMarket.generateValue();
					stockMarket.generatePercentChange();
								
				/**Once the number of stock symbols is given and matches the user number of stocks entered it will output the results**/
				if(numStocks == tempInputNum)
				{
					System.out.println("Stock Symbols \t current value \t future Value \t (Percentage Change)");
					for(int i = 0 ; i < numStocks; i++)
					{

					System.out.print(stockMarket.getUserStocks().get(i).toUpperCase());
	
					System.out.print( "\t\t $" + stockMarket.getStockValue().get(i) + "\t\t");
		
					System.out.print(" $" + stockMarket.futureCost(stockMarket.getStockValue().get(i),stockMarket.getPercentChange().get(i)));
		
					System.out.print("\t\t " + stockMarket.getPercentChange().get(i) + "%" + "\n");
					
					}
					/**end program is set to true to end the program**/
					endProgram = true;
					/**toString method is called to provide information about the variables used**/
					System.out.println("\n" + stockMarket.toString());
				}
								
			}
			else
			{
				System.out.print("Please Enter a valid Stock. Stock symbols length must be less than 6 and no special characters! ");
				tempInputNum--;
								
			}
			
		}
/**as long as endProgram and inputNum is less than or equal zero then what's in the loop will be executed**/
}while(inputNum <= 0 && !endProgram);

}





}