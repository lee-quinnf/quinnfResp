package com.ben.stack;

public class TestStack {
	
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.pop();
		stack.display();
		
	}
}
