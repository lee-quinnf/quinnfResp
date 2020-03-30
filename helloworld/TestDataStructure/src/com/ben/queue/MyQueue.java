package com.ben.queue;

public class MyQueue {
	int[] queue;
	int size;
	int front;
	int rear;
	int items;
	
	public MyQueue(int size) {
		queue = new int[size];
		this.front = 0;
		this.rear = -1;
		this.items = 0;
		this.size = size;
	}
	
	public void insert(int item) {
		if (rear == size - 1) {
			rear = -1;
		}
		queue[++rear] = item;
		items++;
	}
	
	public int remove() {
		if (front == size - 1) {
			front = 0;
		}
		items--;
		return queue[front++];
	}
	
	public boolean isEmpty() {
		return items == 0;
	}
	
	public boolean isFull() {
		return items == size;
	}
	
	public void display() {
		while (!isEmpty()) {
			System.out.println(remove());
		}
	}
}
