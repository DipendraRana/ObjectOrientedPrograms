/*************************************************************************************************
 * purpose : 1. Write a Program DeckOfCards.java, to initialize deck of cards having
 * 			 suit ("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7",
 * 			 "8", "9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random
 * 			 method and then distribute 9 Cards to 4 Players and Print the Cards the received by
 * 			 the 4 Players using 2D Array.
 * 			 2.Extend the above program to create a Player Object having Deck of Cards, and having
 * 			 ability to Sort by Rank and maintain the cards in a Queue implemented using
 * 			 Linked List. Do not use any Collection Library. Further the Player are also arranged
 * 			 in Queue. Finally Print the Player and the Cards received by each Player.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 15 September 2017          
 *************************************************************************************************/

package com.bridgelabz.utility;

public class DeckOfCards {
	
	protected String suits;
	
	protected String ranks;
	
	protected String[] arrayOfSuits= {"Club","Diamonds","Hearts","Spades"};
	
	protected String[] arrayOfRanks= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	protected DeckOfCards[][] playersCard;
	
	protected DeckOfCards[] deckOfCards;
	
	protected QueueLinkedList<QueueLinkedList<DeckOfCards>> players=new QueueLinkedList<QueueLinkedList<DeckOfCards>>();
	 
	public DeckOfCards(String suits,String ranks) {
		this.suits=suits;
		this.ranks=ranks;
	}

	public DeckOfCards() {
		playersCard=new DeckOfCards[4][9];
		deckOfCards=new DeckOfCards[52];
		suits=null;
		ranks=null;
	}

	public void shuffle() {
		int noOfShuffle=(int)(Math.random()*52);
		for(int i=0;i<noOfShuffle;i++) {
			int choosenCard=(int)(Math.random()*52);
			DeckOfCards temp=deckOfCards[choosenCard];
			deckOfCards[choosenCard]=deckOfCards[52-1];
			deckOfCards[52-1]=temp;
		}
	} 
	
	public DeckOfCards[] cards() {
		for(int countingObject=0,countingRanks=0;countingObject<52;countingObject++) {
			if(countingRanks==13)
				countingRanks=0;
			if(countingObject<13&&countingRanks<13) {
				deckOfCards[countingObject]=new DeckOfCards(arrayOfSuits[0],arrayOfRanks[countingRanks]);
				countingRanks++;
			}
			else if(countingObject<26&&countingRanks<13) {
				deckOfCards[countingObject]=new DeckOfCards(arrayOfSuits[1],arrayOfRanks[countingRanks]);
				countingRanks++;
			}
			else if(countingObject<39&&countingRanks<13) {
				deckOfCards[countingObject]=new DeckOfCards(arrayOfSuits[2],arrayOfRanks[countingRanks]);
				countingRanks++;
			}
			else {
				deckOfCards[countingObject]=new DeckOfCards(arrayOfSuits[3],arrayOfRanks[countingRanks]);
				countingRanks++;
			}		
		}
		return deckOfCards;
	}	
	
	public void assignCardsToPlayer() {
		for(int player=0,cardFromDeck=0;player<4;player++) {
			for(int eachPlayerCard=0;eachPlayerCard<9;eachPlayerCard++) {
				playersCard[player][eachPlayerCard]=deckOfCards[cardFromDeck];
				cardFromDeck++;
			}	
		}
	}
	
	public void displayPlayersCards() {
		for(int player=0;player<4;player++) {
			System.out.print("Player "+(player+1+": "));
			for(int eachPlayerCard=0;eachPlayerCard<9;eachPlayerCard++) 
				System.out.print(playersCard[player][eachPlayerCard].suits+" "+playersCard[player][eachPlayerCard].ranks+"   ");
			System.out.println();
		}	
	}

	public void SortEachPlayerCardByRank() {
		for(int i=0;i<4;i++)
			players.enqueue(new QueueLinkedList<DeckOfCards>());
		for(int player=0;player<4;player++)
			Utility.deckOfCardSort(playersCard[player],players,arrayOfRanks,player);
	}
	
	public void displaySortedPlayerCardsFromQueue() {
		for(int playerNo=0;playerNo<players.size();playerNo++) {
			System.out.print("Player "+(playerNo+1)+": ");
			for(int playerCard=0;playerCard<players.get(playerNo).size();playerCard++)
				System.out.print(players.get(playerNo).get(playerCard).suits+" "+players.get(playerNo).get(playerCard).ranks+"  ");
			System.out.println();
		}
	}
}
