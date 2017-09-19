/*********************************************************************
 * purpose : Object Oriented programs Logic
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 14 September 2017          
 *********************************************************************/

package com.bridgelabz.utility;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Utility {
	
	public static Scanner scanner=new Scanner(System.in);
	
	public static void regularExpression(String template) {
		System.out.println("Enter Receivers Name:");
		String name=scanner.nextLine();
		System.out.println("Enter the Full name Of Receiver");
		String fullname=scanner.nextLine();
		System.out.println("Enter the Phone number(don't write +91):");
		String phonenumber=scanner.next();
		System.out.println("Enter the Todays date(dd/mm/yy)");
		String date=scanner.next();
		
		template=template.replaceAll("<<name>>", name);
		template=template.replaceAll("<<full\\sname>>", fullname);
		template=template.replaceAll("[x]+", phonenumber);
		template=template.replaceAll("01/01/2016", date);
		
		System.out.println(template);
	}

	public static void deckOfCardSort(DeckOfCards[] playerCards,QueueLinkedList<QueueLinkedList<DeckOfCards>> player,String[] arrayOfRanks,int playerNo) {
		int untilThis=playerCards.length;
		int decreaseTheArraySize=0;
		for(int lookAtRank=0;lookAtRank<arrayOfRanks.length;lookAtRank++) {	//we enter in queue all those cards which matches each rank accordingly 
			for(int checkPlayerCard=0;checkPlayerCard<untilThis-decreaseTheArraySize;checkPlayerCard++) {
				if(playerCards[checkPlayerCard].ranks.equals(arrayOfRanks[lookAtRank])) {//player.get(playerNo).enqueue(copyOfPlayerCards[checkPlayerCard]);
					swap(playerCards,checkPlayerCard,decreaseTheArraySize);	//this swapping is done to decrease the number of checking 
					decreaseTheArraySize++;											//in that array for next element ,if element is found
				}
			}
		}
		for(int thisElement=playerCards.length-1;thisElement>=0;thisElement--) { //sorted array inserted to queue
			player.get(playerNo).enqueue(playerCards[thisElement]);;
		}
	}
	
	public static void swap(DeckOfCards[] playerCards,int index,int decreaseTheArraySize) {	//swapping any element with last element
		int whereToSeeInArray=(playerCards.length-decreaseTheArraySize)-1;
		if(playerCards[index].ranks.equals(playerCards[whereToSeeInArray].ranks)&&index!=whereToSeeInArray) {	//if swapping last index is same as this swapping element than 
			whereToSeeInArray=lookForNextNonSimilarRank(playerCards,index,whereToSeeInArray);
			DeckOfCards temporary=playerCards[index];													//swap with second last element
			playerCards[index]=playerCards[whereToSeeInArray];
			playerCards[whereToSeeInArray]=temporary;
		}
		else {
			DeckOfCards temporary=playerCards[index];
			playerCards[index]=playerCards[whereToSeeInArray];
			playerCards[whereToSeeInArray]=temporary;
		}	
	}
	
	public static int lookForNextNonSimilarRank(DeckOfCards[] playerCards,int index,int whereToSeeInArray) {
		int checkingFrom;
		for(checkingFrom=index+1;checkingFrom<whereToSeeInArray;checkingFrom++) {
			if(!playerCards[index].ranks.equals(playerCards[checkingFrom].ranks)&&playerCards[checkingFrom+1].ranks.equals(playerCards[index].ranks))
				return checkingFrom;
		}
		return checkingFrom;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject jasonInventory() {
		JSONObject inventory=new JSONObject();
		String chooseToContinue;
		do {
			System.out.println("What Do you want To Enter:"
					+"\n1.Rice"
					+"\n2.Pulses"
					+"\n3.Wheat");
			int choiceOfEntry=scanner.nextInt();
			switch(choiceOfEntry) {
			case 1: System.out.println("How many Types of Rice you have??");
					int typeOfRice=scanner.nextInt();
					JSONArray rice=new JSONArray();
					for(int riceCount=0;riceCount<typeOfRice;riceCount++) {
						System.out.println("Entry "+(riceCount+1)+"\n");
						JSONObject typesOfRice=new JSONObject();
						System.out.println("Enter the Name of Rice:");
						String name=scanner.next();
						typesOfRice.put("Name", name);
						System.out.println("Enter the Quantity of "+name+" Rice:");
						int quantity=scanner.nextInt();
						typesOfRice.put("Weight", quantity);
						System.out.println("Enter the Price(PerKG) of "+name+" Rice:");
						int price=scanner.nextInt();
						typesOfRice.put("Price", price);
						rice.add(typesOfRice);
					}
					inventory.put("Rice", rice);
					System.out.println("SuccesFully Entered");
					break;
			case 2: System.out.println("How many Types of Pulses you have??");
					int typeOfPulses=scanner.nextInt();
					JSONArray pulses=new JSONArray();
					for(int pulseCount=0;pulseCount<typeOfPulses;pulseCount++) {
						System.out.println("Entry "+(pulseCount+1)+"\n");
						JSONObject typesOfPulses=new JSONObject();
						scanner.nextLine();
						System.out.println("Enter the Name of Pulses:");
						String name=scanner.nextLine();
						typesOfPulses.put("Name", name);
						System.out.println("Enter the Quantity of "+name+" :");
						int quantity=scanner.nextInt();
						typesOfPulses.put("Weight", quantity);
						System.out.println("Enter the Price(PerKG) of "+name+" :");
						int price=scanner.nextInt();
						typesOfPulses.put("Price", price);
						pulses.add(typesOfPulses);
					}
					inventory.put("Pulses", pulses);
					System.out.println("SuccesFully Entered");
					break;
			case 3: System.out.println("How many Types of Pulses you have??");
					int typeOfWheat=scanner.nextInt();
					JSONArray wheat=new JSONArray();
					for(int wheatCount=0;wheatCount<typeOfWheat;wheatCount++) {
						System.out.println("Entry "+(wheatCount+1)+"\n");
						JSONObject typesOfWheat=new JSONObject();
						scanner.nextLine();
						System.out.println("Enter the Name of Wheat:");
						String name=scanner.nextLine();
						typesOfWheat.put("Name", name);
						System.out.println("Enter the Quantity of "+name+" Wheat:");
						int quantity=scanner.nextInt();
						typesOfWheat.put("Weight", quantity);
						System.out.println("Enter the Price(PerKG) of "+name+" Wheat:");
						int price=scanner.nextInt();
						typesOfWheat.put("Price", price);
						wheat.add(typesOfWheat);
					}
					inventory.put("Wheat", wheat);
					System.out.println("SuccesFully Entered");
					break;
			default: System.out.println("Wrong Choice");
			}
			System.out.println("Do you want to enter any other Data(yes/no)");
			chooseToContinue=scanner.next();
			chooseToContinue=chooseToContinue.toLowerCase();
		}while(chooseToContinue.equals("yes"));
		return inventory;
	}

	public static double inventoryItemValueCalculation(JSONObject inventory) {
		long valueOfItem = 0;
		System.out.println("Enter the Type Of Item:");
		String itemType=scanner.nextLine();
		System.out.println("Which item's Name You want");
		String itemName=scanner.nextLine();
		try {
			JSONArray item=(JSONArray)inventory.get(itemType);
			for(int getTheItem=0;getTheItem<item.size();getTheItem++) {
				JSONObject gotItem=(JSONObject)item.get(getTheItem);
				if(String.valueOf(gotItem.get("Name")).equals(itemName)) {
					Long weight=(Long) gotItem.get("Weight");
					Long price=(Long) gotItem.get("Price");
					valueOfItem=weight*price;
					System.out.println("The Total Value Of "+itemName+" :"+valueOfItem);
				}
			}
		}catch(Exception e) {
			System.out.println("No such Item is present"+e);
			return -1;
		}
		return valueOfItem;
	}
}
