package com.bridgelabz.utility;

import java.util.Collections;
import java.util.Scanner;

public class Utility {
	
	public static void regularExpression(String template) {
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		String fullname=input.nextLine();
		String phonenumber=input.next();
		String date=input.next();
		
		template=template.replaceAll("<<name>>", name);
		template=template.replaceAll("<<full\\sname>>", fullname);
		template=template.replaceAll("[x]+", phonenumber);
		template=template.replaceAll("01/01/2016", date);
		
		System.out.println(template);
	}

	public static void sortCardsAndStore() {
		DeckOfCards player=new DeckOfCards();
		QueueLinkedList<String> queue=new QueueLinkedList<String>(); 
		for(int i=0;i<player.size();i++) {
			queue.enqueue(player.deckOfCards[i]);
		}
		Collections.sort(queue.queue);
		queue.print();
		
	}
}
