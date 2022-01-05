/**
Edgar Giang
213438528

Stock market class

**/
import java.util.ArrayList;
import java.util.Random;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class StockMarket{

/*userStocks is the symbol that represents the stock*/
ArrayList<String> userStocks = new ArrayList<String>();
/*stockValue is the cost of each individual stocks*/
ArrayList<Double> stockValue = new ArrayList<Double>();

/*the percentage change value of each stocks*/
ArrayList<Double> percentChange = new ArrayList<Double>();

String stockString = "";

/*below values are set up to help generate a random value in doubles
to represent value and percent*/
Random randomStockValue = new Random();
Random randomPercentValue = new Random();

double randValue = 0.0;
double randPercent = 0.0;

int numStocks = 0;

/*The constructor which has parameter value numStock, and ArrayList<String> userStocks
.The two mentioned values will be assigned to the class variables numStocks(this.numStocks)
and userStocks(this.userStocks)
*/

public StockMarket(int numStocks, ArrayList<String> userStocks)
{

this.numStocks = numStocks;
this.userStocks = userStocks;

}


/*setters and getters for number of stocks*/
public int getNumSocks()
{
	return numStocks;
	
}

public void setNumStocks(int numStocks)
{
	
	this.numStocks = numStocks;
}
/**
Setters and getters for userStocks
**/
public ArrayList<String>  getUserStocks()
{
	return (userStocks);
}

public void setUserStocks(ArrayList<String> userStocks)
{
	this.userStocks = userStocks;
	
}
/**
Setters and getters for stock Value
**/
public ArrayList<Double>  getStockValue()
{
		
	return (stockValue);
}

public void setStockValue(ArrayList<Double> stockValue)
{
	this.stockValue = stockValue;
	
}

/**
Setters and getters for percentage change of each stock
**/
public ArrayList<Double>  getPercentChange()
{
	
	
	return (percentChange);
}

public void setPercentChange(ArrayList<Double> userInputPercentChange)
{
	this.stockValue = userInputPercentChange;
	
}



/**
Prints data of object in an appropriate formatted string
Will print ArrayList<String> stockSymbol,
 ArrayList<double> stockValue,
  ArrayList<String> percentageChange,
   and numstocks
**/

public String toString()
{
	
	
	return "Number of input values for stocks is an Integer: " + getNumSocks() + "\n"
	+ "Percentage change of each stock value is ArrayList<Double> : " + getPercentChange() + "\n" + 
	" Stock Value is ArrayList<Double>: " + getStockValue() + "\n"
	+ "user stocks which is the symbol of each stock  is ArrayList<String>: " + getUserStocks() + "\n";
		
	
}

/**
generateValue() when called generates a random value(double) between the range
of 1.00 and 100.00 n(numStocks) times. It will then be 
rounded to two decimal places and then added to stockValue. 
returns stockValue ArrayList<Double>
**/
public ArrayList<Double> generateValue()
{
	
	for(int i = 0 ; i < numStocks;i++)
	{
	randValue = 1.00 + (100.0 - 1.00) * randomStockValue.nextDouble() ;
	randValue = randValue * 100;
	randValue = Math.round(randValue);
	randValue = randValue/100;
	stockValue.add(randValue);

	}
	
return (stockValue);
}

/**
generatePercentChange() when called generates a random value(double) between the range
of -10.0 and 10.0 n(numStocks) times. It will then be 
rounded to two decimal places and then added to randPercent.
This method is used to simulate the percentage change of the value of a particular growth.
Method returns percentChange ArrayList<Double>.
 
**/
public ArrayList<Double> generatePercentChange()
{
	
	for(int i = 0 ; i < numStocks;i++)
	{
	randPercent = -10.0 + (10.0 + 10.0) * randomPercentValue.nextDouble() ;
	randPercent = randPercent * 100;
	randPercent = Math.round(randPercent);
	randPercent = randPercent/100;
	percentChange.add(randPercent);

	}
	
return (percentChange);
}

/**
futureCost takes two parameter values. indexStockValue(double) and indexPercentChange(double).

The indexStockValue and percentChange is used to calculate the future cost of an stock value
based on which index it's in. It will then be rounded to two decimal places and will return a double.

**/
public double futureCost(double indexStockValue,double indexPercentChange)
{
	double calculatedValue = 0.0;

	calculatedValue = indexStockValue + (indexStockValue * (indexPercentChange  / 100));

	calculatedValue = calculatedValue * 100;
	calculatedValue = Math.round(calculatedValue);
	calculatedValue = calculatedValue/100;
	
	return calculatedValue;
}





}