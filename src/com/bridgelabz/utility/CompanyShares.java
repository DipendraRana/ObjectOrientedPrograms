/***************************************************************************************************
 * purpose : To create new company shares
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 19 September 2017          
 ***************************************************************************************************/

package com.bridgelabz.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompanyShares {
	
	private String companyName;
	
	private int noOfShares;
	
	private ArrayList<Integer> priceOfEachShares;
	
	private String stockSymbol;
	
	public static Scanner scanner=new Scanner(System.in);
	
	protected String path="E:\\myWorkSpace\\<<CompanyName>>";
	
	public CompanyShares(String companyName,int noOfShares,String stockSymbol) {
		this.companyName=companyName;
		this.noOfShares=noOfShares;
		this.priceOfEachShares=new ArrayList<Integer>(noOfShares);
		this.stockSymbol=stockSymbol;
	}
	
	public void enterDetails() {
		for(int counter=0;counter<noOfShares;counter++) {
			System.out.print("Enter the price of Share "+(counter+1)+" : ");
			int value=scanner.nextInt();
			priceOfEachShares.add(value);
		}
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	
	public int getNoOfShares() {
		return noOfShares;
	}
	
	public ArrayList<Integer> getPricesOfShares(){
		return priceOfEachShares;
	}
	
	public boolean removeShares(int amount,String symbol) {
		int count=0;
		if(stockSymbol.equals(symbol)) {
			for(int i=0;i<priceOfEachShares.size();i++) {
				if(priceOfEachShares.get(i)==amount) {
					System.out.println("Did you wanted to buy share "+(i+1)+" ?");
					String choose=scanner.next();
					if(choose.equals("yes"))
						priceOfEachShares.remove(i);
					count=1;
				}
			}
			if(count==0) {
				System.out.println("Wrong Amount");
				return false;
			}
			else
				return true;
		}
		else
			return false;
	}
	
	public boolean addShares(int amount,String symbol) {
		if(stockSymbol.equals(symbol)) {
			priceOfEachShares.add(amount);
			return true;
		}
		else 
			return false;
	}
	
	public void printShares() {
		System.out.println();
		System.out.println("The Company Name: "+companyName);
		System.out.println("Stock Symbol: "+stockSymbol);
		for(int count=0;count<priceOfEachShares.size();count++)
			System.out.println("Share "+(count+1)+" : "+priceOfEachShares.get(count));
	}
	
	public void writeToFile(String fileName) throws IOException {
		path=path.replaceAll("<<CompanyName>>", fileName);
		FileWriter write=new FileWriter(path);
		write.write(companyName);
		write.write("\n"+stockSymbol);
		for(int i=0;i<priceOfEachShares.size();i++)
			write.write("\n"+priceOfEachShares.get(i));
		System.out.println("SucessFully Created");
		write.close();
	}

	public boolean checkForShares() {
		return priceOfEachShares.isEmpty();
	}
}
