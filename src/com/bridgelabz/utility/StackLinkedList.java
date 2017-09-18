/*********************************************************************
 * purpose : Making Stack Class Using Inbuilt Linked List Class 
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 13 September 2017          
 *********************************************************************/

package com.bridgelabz.utility;

import java.util.LinkedList;

public class StackLinkedList<T> {
	
	public LinkedList<T> stack;
	
	public int topOfArray;
	
	public StackLinkedList() {
		stack=new LinkedList<T>();
		topOfArray=-1;
	}
	
	public void push(T element) {
		topOfArray++;
		stack.add(topOfArray, element);
	}
	
	public void pop() {
		if(topOfArray==-1)
			System.out.println("Stack is empty");
		else {
			stack.removeLast();
			topOfArray--;
		}	
	}
	
	public boolean isEmpty() {
		return (topOfArray==-1);
	}
	
	public int size() {
		return stack.size();
	}
	
	public T getElement(int index) {
		return stack.get(index);
	}

}
