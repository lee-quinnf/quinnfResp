package com.ben.queue;

public class MyQueue2 {
	
	int[] queue;
	int front;
	int rear;
	int size;
	
	public MyQueue2(int size) {
		this.size = size + 1;
		this.queue = new int[this.size];
		this.rear = -1;
		this.front = 0;
	}
	
	public void insert(int item) {
		if (rear == size - 1) {
			rear = -1;
		}
		queue[++rear] = item;
	}
	
	public int remove() {
		int t = queue[front++];
		if (front == size) {
			front = 0;
		}	
		return t;
	}
	
	public boolean isEmpty() {
		return rear == front - 1 || rear == front + size - 1;
	}
	
	public boolean isFull() {
		return rear == front - 2 || rear == size + front - 2;
	}
	
	public int size() {
		if (rear > front) {
			return rear - front + 1;
		} else {
			return (size - front) + (rear + 1);
		}
	}
	
	public void display() {
		while (!isEmpty()) {
			System.out.println(remove());
		}
	}
	
	
	
}
