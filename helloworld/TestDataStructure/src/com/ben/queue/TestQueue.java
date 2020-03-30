package com.ben.queue;

public class TestQueue {
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(10);
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		
		queue.remove();
		
		queue.display();
	}
}
