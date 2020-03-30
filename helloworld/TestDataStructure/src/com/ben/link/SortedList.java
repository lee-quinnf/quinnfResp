package com.ben.link;

public class SortedList {
	Link first;
	
	public SortedList() {
		first = null;
	}
	
	public void insert(int key) {
		Link newLink = new Link(key);
		
		if (first == null) {
			first = newLink;
		} else {
			Link current = first;
			Link preLink = null;
			while (current != null && key > current.data) {
				preLink = current;
				current = current.next;
			}
			
			if (preLink == null) {
				first = newLink;
			} else {
				preLink.next = newLink;
			}
			
			newLink.next = current;
		}
	}
	
	public void displaySortedList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
}
