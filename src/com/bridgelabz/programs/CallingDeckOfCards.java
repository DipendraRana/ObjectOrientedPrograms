package com.bridgelabz.programs;

import com.bridgelabz.utility.DeckOfCards;
import com.bridgelabz.utility.Utility;

public class CallingDeckOfCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards object=new DeckOfCards();
		object.shuffle();
		object.assignCardsToPlayer();
		object.displayPlayersCards();
		//Utility.sortCardsAndStore();
	}

}
