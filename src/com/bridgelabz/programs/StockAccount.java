/***************************************************************************************************
 * purpose : 1.StockAccount.java implements a data type that might be used by a financial institution
 * 			 to keep track of customer information. The StockAccount class implements following
 * 			 methods.
 *			 The StockAccount class also maintains a list of CompanyShares object which has Stock
 *			 Symbol and Number of Shares as well as DateTime of the transaction. When buy or sell is
 *			 initiated StockAccount checks if CompanyShares are available and accordingly update or
 *			 create an Object.
 *			 2.Maintain the List of CompanyShares in a Linked List So new CompanyShares can be added
 *			 or removed easily. Do not use any Collection Library to implement Linked List.
 *			 3.Further maintain the Stock Symbol Purchased or Sold in a Stack implemented using
 *			 Linked List to indicate transactions done.
 *			 4.Further maintain DateTime of the transaction in a Queue implemented using Linked List
 *			 to indicate when the transactions were done.
 *           
 * @author Dipendra Rana
 * @version 6.0
 * @since 16 September 2017          
 ***************************************************************************************************/

package com.bridgelabz.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgelabz.utility.CompanyShares;
import com.bridgelabz.utility.QueueLinkedList;
import com.bridgelabz.utility.StackLinkedList;

public class StockAccount {
	
	public static Scanner scanner=new Scanner(System.in);
	
	protected String path="E:\\myWorkSpace\\<<accountName>>";
	
	protected String accountName;
	
    protected String stockName;
	
	protected int noOfShares;
	
	protected ArrayList<Integer> priceOfEachShares;
	
	protected String stockSymbol;
	
	protected static LinkedList<CompanyShares> listOfStocks=new LinkedList<CompanyShares>();
	
	protected StackLinkedList<String> stack;
	
	protected QueueLinkedList<Date> queue;  
	
	protected Date stockSellDate,stockBuyDate;
	
 	public StockAccount() throws IOException {
		accountName=null;
		stockName=null;
		noOfShares=0;
		priceOfEachShares=null;
		stack=null;
		queue=null;
	}
	
	public StockAccount(String fileName) throws FileNotFoundException {
		//listOfStocks=new LinkedList<CompanyShares>();
		stack=new StackLinkedList<String>();
		queue=new QueueLinkedList<Date>();
		priceOfEachShares=new ArrayList<Integer>();
		path=path.replaceAll("<<accountName>>", fileName);
		Scanner read=new Scanner(new File(path));
		int incriment=0;
		String[] details = new String[2];
		while(read.hasNext()){
			String element=read.next();
			try{
				priceOfEachShares.add(Integer.parseInt(element));
			}catch(NumberFormatException e){
				details[incriment]=element;
				incriment++;
			}
		}
		stockName=details[0];
		stockSymbol=details[1];
		read.close();
	}
	
	public int valueOf(){
		int sum=0;
		for(int iteration=0;iteration<priceOfEachShares.size();iteration++) {
			sum=sum+priceOfEachShares.get(iteration);
		}
		return sum;
	} 
	
	public void buy(int amount,String symbol,String fileName) throws IOException{
		int count = 0;
		for(int i=0;i<listOfStocks.size();i++) {
			if(listOfStocks.get(i).getStockSymbol().equals(symbol)) {
				if(!listOfStocks.get(i).checkForShares()) {
					stockBuyDate=new Date();
					queue.enqueue(stockBuyDate);
					stack.push(symbol);
					if(listOfStocks.get(i).removeShares(amount, symbol)) {
						priceOfEachShares.add(Integer.valueOf(amount));
						save(fileName);
					}
				}	
				else
					System.out.println("This company right now have no share");
				count=1;;
			}
		}
		if(count==0)
			System.out.println("No Stock with this symbol is present ");
	}
	
	public void sell(int amount,String symbol,String fileName) throws IOException {
		int lookforCompany=0;
		for(int i=0;i<listOfStocks.size();i++) {
			if(listOfStocks.get(i).getStockSymbol().equals(symbol)) {
				int count=0;
				for(int iteration=0;iteration<priceOfEachShares.size();iteration++) {
					if(priceOfEachShares.get(iteration)==amount) {
						System.out.println("Do you want To sell the share "+(iteration+1)+" (yes/no):");
						String choose=scanner.next();
						if(choose.equals("yes")) {
							listOfStocks.get(i).addShares(amount, symbol);
							stockSellDate=new Date();
							queue.enqueue(stockSellDate);
							stack.push(symbol);
							priceOfEachShares.remove(iteration);
							save(fileName);
						}
						count=1;
					}
				}
				if(count==0)
					System.out.println("No such Stock is Present at the momment");
				lookforCompany=1;
			}
		}
		if(lookforCompany==0)
			System.out.println("No such Company with this Symbol");	
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
			
	public void save(String fileName) throws IOException {
		path=path.replaceAll("<<accountName>>", accountName);
		FileWriter write=new FileWriter(fileName);
		write.write(stockName);
		write.write("\n"+stockSymbol);
		for(int i=0;i<priceOfEachShares.size();i++)
			write.write("\n"+priceOfEachShares.get(i));
		write.write("\n"+valueOf());
		write.close();
	}
	
	public void printReport() {
		System.out.println("Report");
		System.out.println("Company Name: "+stockName);
		System.out.println("Stock Symbol: "+stockSymbol);
		for(int count=0;count<priceOfEachShares.size();count++)
			System.out.println("Share "+(count+1)+" : "+priceOfEachShares.get(count));
		System.out.println("The Total Value of Stock: "+valueOf());
		if(!stack.isEmpty()&&!queue.isEmpty()) {
			System.out.println("The Date and time Of transaction of Shares with Company Symbol are:");
			for(int i=0;i<stack.size();i++) 
				System.out.println(stack.getElement(i)+"   "+queue.get(i));
		}
	}
		
	public void companyShares(String companyName,int noOfShares,String stockSymbol) throws IOException {
		CompanyShares companyShares=new CompanyShares(companyName,noOfShares,stockSymbol);
		companyShares.enterDetails();
		System.out.println("Enter the Name for file to Saved");
		String fileName=scanner.next();
		companyShares.writeToFile(fileName);
		listOfStocks.add(companyShares);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int amount;
		String symbol;
		String choose;
		StockAccount stock=new StockAccount();
		do {
			System.out.println("Choose");
			System.out.println("1.Enter new Comapny Shares");
			System.out.println("2.Read accounts and performs changes");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1: System.out.println("How Many company Shares you want to Enter:");
					int numOfCompanies=scanner.nextInt();
					scanner.nextLine();
					for(int i=0;i<numOfCompanies;i++) {
						System.out.println("Company "+(i+1));
						System.out.println("Enter the Company Name:");
						String companyName=scanner.nextLine();
						System.out.println("Enter the Stock Symbol:");
						String stockSymbol=scanner.nextLine();
						System.out.println("Enter the No of shares:");
						int noOfShares=scanner.nextInt();
						stock.companyShares(companyName, noOfShares, stockSymbol);
						System.out.println();
						scanner.nextLine();
					}	
					break;
			case 2: scanner.nextLine();
					String answer;
					System.out.println("Enter the File Name:");
					String fileName=scanner.nextLine();
				try {
					stock=new StockAccount(fileName);
					do {
						System.out.println("What Operation you Want to do:");
						System.out.println("1.Buy stock");
						System.out.println("2.Sell stock");
						System.out.println("3.Have a look in to Others Company's stock");
						System.out.println("4.Print Detail Report of Your's Stock");
						int option=scanner.nextInt();
						switch(option){
						case 1:	System.out.println("Enter the Stock Symbol From which you want to buy:");
								symbol=scanner.next();
								System.out.println("Enter the Share Amount you want to buy:");
								amount=scanner.nextInt();
								stock.buy(amount, symbol,fileName);
								break;
						case 2: System.out.println("Enter the Share Amount you want to sell:");
								amount=scanner.nextInt();
								System.out.println("Enter the Stock Symbol to which you want to sell:");
								symbol=scanner.next();
								stock.sell(amount, symbol,fileName);
								break;
						case 3: scanner.nextLine();
								System.out.println("Enter the Company's name:");
								String companyName=scanner.nextLine();
								int count=0;
								for(int i=0;i<listOfStocks.size();i++) {
									if(listOfStocks.get(i).getCompanyName().equals(companyName)) {
										listOfStocks.get(i).printShares();
										count=1;
									}
								}
								if(count==0)
									System.out.println("There is such company Present");
								break;
						case 4: stock.printReport();
								break;
						default:System.out.println("Wrong Option");
						}
						System.out.println("Do you want to do Another Transaction(yes/no)");
						answer=scanner.next();
					}while(answer.equals("yes"));	
				} catch (FileNotFoundException e) {
					System.out.println("There is No such File");
				}
				break;
			default:System.out.println("Wrong Option");
			}
			System.out.println("Do you want to continue(yes/no):");
			choose=scanner.next();
			choose=choose.toLowerCase();
		}while(choose.equals("yes"));
		

	}
}
