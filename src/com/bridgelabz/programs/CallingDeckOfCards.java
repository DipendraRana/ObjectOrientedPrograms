/*********************************************************************
 * purpose : Calling DeckOfCards class and extending it to store
 * 			 player cards in queue
 *           
 * @author Dipendra Rana
 * @version 2.0
 * @since 14 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import com.bridgelabz.utility.DeckOfCards;

public class CallingDeckOfCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards object=new DeckOfCards();
		object.cards();
		object.shuffle();
		object.assignCardsToPlayer();
		System.out.println("Players Card Unsorted");
		object.displayPlayersCards();
		System.out.println();
		System.out.println("Players Card Sorted");
		object.SortEachPlayerCardByRank();
		object.displaySortedPlayerCardsFromQueue();
	}
}
