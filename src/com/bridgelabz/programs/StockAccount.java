/***************************************************************************************************
 * purpose : StockAccount.java implements a data type that might be used by a financial institution
 * 			 to keep track of customer information. The StockAccount class implements following
 * 			 methods.
 *			 The StockAccount class also maintains a list of CompanyShares object which has Stock
 *			 Symbol and Number of Shares as well as DateTime of the transaction. When buy or sell is
 *			 initiated StockAccount checks if CompanyShares are available and accordingly update or
 *			 create an Object.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 16 September 2017          
 ***************************************************************************************************/

package com.bridgelabz.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockAccount {
	
	public static Scanner scanner=new Scanner(System.in);
	
	protected String path="C:\\Users\\DIPENDRA\\Documents\\<<accountName>>.txt";
	
	protected String accountName;
	
    protected String stockName;
	
	protected int noOfShares;
	
	protected ArrayList<Integer> priceOfEachShares;
		
	protected String stockSymbol;
	
	public StockAccount() throws IOException {
		accountName=null;
		stockName=null;
		noOfShares=0;
		priceOfEachShares=null;
	}
	
	public StockAccount(String fileName) throws FileNotFoundException {
		path=path.replaceAll("<<accountName>>", fileName);
		Scanner read=new Scanner(new File(path));
		while(read.hasNext()){
			String element=read.next();
			try{
				priceOfEachShares.add(Integer.parseInt(element));
			}catch(NumberFormatException e){
				stockName=element;
			}
		}
		read.close();
	}
	
	public int valueOf(){
		int sum=0;
		for(int iteration=0;iteration<priceOfEachShares.size();iteration++) {
			sum=sum+priceOfEachShares.get(iteration);
		}
		return sum;
	} 
	
	public void buy(int amount,String symbol){
		
	}
	
	public int getNoOfShares(String path) throws FileNotFoundException{
		Scanner newReader=new Scanner(new File(path));
		int noOfWords=0;
		while(newReader.hasNextLine()){
			noOfWords++;
			newReader.nextLine();
		}
		newReader.close();
		return noOfWords-1;
	}
	
	public void createAccount() throws IOException {
		System.out.print("Enter the Account Name:");
		accountName=scanner.nextLine();
		path=path.replaceAll("<<accountName>>", accountName);
		StockReport stock=new StockReport();
		stock=stock.enterDetailsOfStock(stock);
		stock.writeToFile(path);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName=scanner.nextLine();
		StockAccount stock=new StockAccount(fileName);
		stock.valueOf();
		//stock.createAccount();
		
	}

}
