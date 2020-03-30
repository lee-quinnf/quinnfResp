package com.ben.queue;

public class PriorityQueue {
	
	int[] queue;
	int size;
	int items;
	
	public PriorityQueue(int size) {
		queue = new int[size];
		this.size = size;
		items = 0;
	}
	
	public void insert(int item) {
		if (items == 0) {
			queue[items++] = item;
		} else {
			int i = items - 1;
			for (; i >= 0; i--) {
				if (item < queue[i]) {
					queue[i + 1] = queue[i];
				} else {
					break;
				}
			}
			queue[i + 1] = item;
			items++;
		}
	}
	
	public int remove() {
		return queue[--items];
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
	
	public void display2() {
		for (int i : queue) {
			System.out.print(i + " ");
		}
	}
}
