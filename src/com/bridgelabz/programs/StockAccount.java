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
import java.util.Arrays;
import java.util.Scanner;

public class StockAccount {
	
	public static Scanner scanner=new Scanner(System.in);
	
	protected String path="/home/bridgeit/Documents/<<accountName>>";
	
	protected String accountName;
	
    protected String stockName;
	
	protected int noOfShares;
	
	protected int[] priceOfEachShares;
	
	public StockAccount() throws IOException {
		accountName=null;
		stockName=null;
		noOfShares=0;
		priceOfEachShares=null;
	}
	
	public StockAccount(String fileName) throws FileNotFoundException {
		StockReport stock=new StockReport();
		path=path.replaceAll("<<accountName>>", fileName);
		@SuppressWarnings("resource")
		Scanner read=new Scanner(new File(path));
		int incriment=0;
		while(read.hasNext()) {
			if(read.hasNext(stock.getStockName()))
				stockName=read.nextLine();
			else {
			priceOfEachShares[incriment]=read.nextInt();
			incriment++;
			}
		}
		System.out.println(Arrays.toString(priceOfEachShares));
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
		//stock.createAccount();
		
	}

}
