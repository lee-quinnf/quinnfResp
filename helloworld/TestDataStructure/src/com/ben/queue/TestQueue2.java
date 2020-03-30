package com.ben.queue;

public class TestQueue2 {
	
	public static void main(String[] args) {
		MyQueue2 queue = new MyQueue2(5);
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		//queue.insert(6);
		
		queue.remove();
		queue.insert(7);
		
		queue.display();
	}
}
