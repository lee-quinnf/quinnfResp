package com.ben.link.dbl;

public class Link {
	
	int data;
	Link next;
	Link pre;
	
	public Link(int key) {
		this.data = key;
	}
	
	public void displayLink() {
		System.out.println(this.data);
	}
}
