package com.ben.queue;

public class TestPriorityQueue {
	
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(5);
		
		queue.insert(3);
		queue.insert(1);
		queue.insert(2);
		queue.insert(6);
		queue.insert(5);
		
		queue.display2();
		
	}
}
