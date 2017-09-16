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
		JSONObject basmati=new JSONObject();	//basmati rice object
		basmati.put("Name","Basmati");
		basmati.put("Weight", new Double(300));
		basmati.put("Price", new Double(120));
		JSONObject mysoori=new JSONObject();
		mysoori.put("Name", "Mysoori");	//myssori rice object
		mysoori.put("Weight", new Double(450));
		mysoori.put("Price", new Double(65));
		JSONArray rice=new JSONArray();	//basmati and myssori object is taken under JsonArray 
		rice.add(basmati);
		rice.add(mysoori);
		inventory.put("Rice", rice); //rice array is added as value with key as rice to inventory
		JSONObject kidneyBeans=new JSONObject();
		kidneyBeans.put("Name", "Kidney Beans");
		kidneyBeans.put("Weight", new Double(160));
		kidneyBeans.put("Price", new Double(75));
		JSONObject chickPeas=new JSONObject();
		chickPeas.put("Name", "Chick Peas");
		chickPeas.put("Weight", new Double(250));
		chickPeas.put("Price", new Double(85));
		JSONArray pulse=new JSONArray();
		pulse.add(kidneyBeans);
		pulse.add(chickPeas);
		inventory.put("Pulse", pulse);
		JSONObject wholeGrain=new JSONObject();
		wholeGrain.put("Name", "Whole Grain");
		wholeGrain.put("Weight", new Double(400));
		wholeGrain.put("Price", new Double(66));
		JSONObject plain=new JSONObject();
		plain.put("Name", "Plain");
		plain.put("Weight", new Double(600));
		plain.put("Price", new Double(35));
		JSONArray wheat=new JSONArray();
		wheat.add(wholeGrain);
		wheat.add(plain);
		inventory.put("Wheat", wheat);
		return inventory;
	}

	public static void inventoryItemValueCalculation(JSONObject inventory) {
		JSONArray rice=(JSONArray)inventory.get("Rice");
		JSONObject basmati=(JSONObject)rice.get(0);
		Double weight=(Double) basmati.get("Weight");
		Double price=(Double) basmati.get("Price");
		double valueOfBasmatiRice=weight.doubleValue()*price.doubleValue();
		System.out.println("The total value of basmati rice present is(Rs) "+valueOfBasmatiRice);
		JSONObject mysoori=(JSONObject)rice.get(1);
		weight=(Double) mysoori.get("Weight");
		price=(Double) mysoori.get("Price");
		double valueOfMysooriRice=weight.doubleValue()*price.doubleValue();
		System.out.println("The total value of basmati rice present is(Rs) "+valueOfMysooriRice);
		/***********************************************/
		JSONArray pulse=(JSONArray) inventory.get("Pulse");
		JSONObject kidneyBeans=(JSONObject)pulse.get(0);
		weight=(Double) kidneyBeans.get("Weight");
		price=(Double) kidneyBeans.get("Price");
		double valueOfKidneyBeans=weight.doubleValue()*price.doubleValue();
		System.out.println("The total value of Kidney Beans present is(Rs) "+valueOfKidneyBeans);
		JSONObject chickPeas=(JSONObject)rice.get(1);
		weight=(Double) chickPeas.get("Weight");
		price=(Double) chickPeas.get("Price");
		double valueOfChickPeas=weight.doubleValue()*price.doubleValue();
		System.out.println("The total value of Chik peas present is(Rs) "+valueOfChickPeas);
		/************************************************/
		JSONArray wheat=(JSONArray) inventory.get("Wheat");
		JSONObject wholeGrain=(JSONObject)wheat.get(0);
		weight=(Double) wholeGrain.get("Weight");
		price=(Double) wholeGrain.get("Price");
		double valueOfWholeGrain=weight.doubleValue()*price.doubleValue();
		System.out.println("The total value of Whole grain wheat present is(Rs) "+valueOfWholeGrain);
		JSONObject plain=(JSONObject)rice.get(1);
		weight=(Double) plain.get("Weight");
		price=(Double) plain.get("Price");
		double valueOfPlainWheat=weight.doubleValue()*price.doubleValue();
		System.out.println("The total value of Plain Wheat present is(Rs) "+valueOfPlainWheat);
	}
}
