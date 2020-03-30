package com.ben.stack;
/**
 * 
 * @author Quinnf
 *
 */
public class MyStack {
	int[] stack;
	int size;
	int index;
	
	public MyStack(int size) {
		this.stack = new int[size];
		this.size = size;
		index = -1;
	}
	
	public void push(int item) {
		stack[++index] = item;
	}
	
	public int pop() {
		return stack[index--];
	}
	
	public boolean isEmpty() {
		
		return index == -1;
	}
	
	public boolean isFull() {
		return index == size - 1;
	}
	
	public void display() {
		while (!isEmpty()) {
			System.out.println(pop());
		}
	}
}
