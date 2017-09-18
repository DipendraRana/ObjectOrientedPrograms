/*********************************************************************
 * purpose : Write a program to read in Stock Names, Number of Share,
 * 			 Share Price. Print a Stock Report with total value of
 * 			 each Stock and the total value of Stock.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 16 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

public class StockReport {
	
	public static Scanner scanner=new Scanner(System.in);
	
	protected String stockName;
	
	protected int noOfShares;
	
	protected int[] priceOfEachShares;
	
	public StockReport() {
		stockName=null;
		noOfShares=0;
		priceOfEachShares=null;
	}
	
	public StockReport(String stockName,int noOfShares) {
		this.stockName=stockName;
		this.noOfShares=noOfShares;
		this.priceOfEachShares=new int[noOfShares];
	}
	
	public void insertValueOfEachShares(int index,int price) {
		priceOfEachShares[index]=price;
	}
	
	public int valueOfStock() {
		int sum=0;
		for(int iteration=0;iteration<priceOfEachShares.length;iteration++) {
			sum=sum+priceOfEachShares[iteration];
		}
		//System.out.println("The Total Value Of Your's "+stockName+" Stock is "+sum);
		return sum;
	}
	
	public void printReport() {
		System.out.println("Stock Name: "+stockName);
		for(int iteration=0;iteration<priceOfEachShares.length;iteration++) {
			System.out.println("share "+(iteration+1)+" Price:"+priceOfEachShares[iteration]);
		}
		System.out.println("The Total Value Of Your's "+stockName+" Stock is "+valueOfStock());
	}
	
	public StockReport enterDetailsOfStock(StockReport stock) {
		System.out.print("Enter the stock Name:");
		String stockName=scanner.next();
		System.out.print("Enter the Number of Shares:");
		int noOfShares=scanner.nextInt();
		stock=new StockReport(stockName,noOfShares);	//re-initialized the passed object reference 
		for(int iteration=0;iteration<stock.priceOfEachShares.length;iteration++) {
			System.out.print("Enter the Price Of Share "+(iteration+1)+": ");
			int price=scanner.nextInt();
			stock.insertValueOfEachShares(iteration,price);
		}
		return stock;
	}
	
	public String getStockName() {
		return stockName;
	}
	
	public int getnumberOfShares() {
		return noOfShares;
	}
	
	public int[] getPricessOfShares() {
		return priceOfEachShares;
	}
	
<<<<<<< HEAD
=======
	public int getNoOfShares(){
		return noOfShares;
	}
	
	public void writeToFile(String fileName) throws IOException {
		FileWriter write=new FileWriter(fileName);
		write.write(stockName);
		for(int i=0;i<priceOfEachShares.length;i++)
			write.write("\n"+priceOfEachShares[i]);
		write.write("\n"+valueOfStock());
		write.close();
	}
	
>>>>>>> 80813ef3db81e8debcc55be5b968f5d6e9e682b3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice;
		do {
			StockReport stock=new StockReport();
			stock=stock.enterDetailsOfStock(stock); //due to re-initialization by parameterized constructor, we need to pass new stock reference to this one again 
			stock.printReport();					//to make it reference to same object
			System.out.print("Do you want to Know Value Of Another Stock(yes/no)?");
			choice=scanner.next();
		}while(choice.equals("yes"));
	}

}
