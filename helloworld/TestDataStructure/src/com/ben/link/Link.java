package com.ben.link;

public class Link {
	int data;
	Link next;
	
	public Link(int data) {
		this.data = data;
	}
	
	public void displayLink() {
		System.out.println(this.data);
	}
}
