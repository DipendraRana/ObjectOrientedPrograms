package com.bridgelabz.utility;

import java.util.LinkedList;

public class QueueLinkedList<T> {
	
	protected LinkedList<T> queue;
	
	protected int topOfElement;
	
	public QueueLinkedList() {
		queue=new LinkedList<T>();
		topOfElement=-1;
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public void enqueue(T element) {
			topOfElement++;
			queue.add(topOfElement, element);
	}
	
	public void dequeue() {
		if(queue.isEmpty())
			System.out.println("Queue Empty");
		else
			queue.removeFirst();
	}
	
	public int size() {
		return queue.size();
	}
	
	public void print() {
		System.out.println(queue);
	}
	
	public T get(int index){
		return queue.get(index);
	}
}
