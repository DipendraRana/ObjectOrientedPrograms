package com.bridgelabz.utility;

public class DeckOfCards {
	
	public String[] deckOfCards;
	
	public String[][] playersCard;
	
	public int size;
	
	public enum suits{Clubs,Diamonds,Hearts,Spades}
	
	public enum rank{}
	
	public DeckOfCards() {
		deckOfCards=new String[]{"C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK","CA",
				   "D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK","DA",
				   "H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK","HA",
				   "S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK","SA"};
		playersCard=new String[4][9];
	}
	
	public int size() {
		return deckOfCards.length;
	}
	
	public void shuffle() {
		
		int noOfShuffles=1+(int)(Math.random()*26);
		for(int i=0;i<noOfShuffles;i++) {
			int chooseCard=1+(int)(Math.random()*52);
			String temporary=deckOfCards[chooseCard-1];
			deckOfCards[chooseCard-1]=deckOfCards[52-1];
			deckOfCards[52-1]=temporary;
		}
	}
	
	public void assignCardsToPlayer() {
		int cards=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<9;j++) {
				playersCard[i][j]=deckOfCards[cards];
				cards++;
			}
		}
	}
	
	public void displayPlayersCards() {
		for(int i=0;i<4;i++) {
			System.out.print("Player"+(i+1)+": ");
			for(int j=0;j<9;j++) {
				System.out.print(playersCard[i][j]+" ");
			}	
			System.out.println();
		}
	}
}
