package com.ben.link;

public class LinkList {
	Link first;
	
	public LinkList() {
		first = null;
	}
	
	public void insertFirst(int key) {
		Link newLink = new Link(key);
	
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public Link find(int key) {
		Link current = first;
		while (current != null) {
			if (current.data == key) {
				break;
			} else {
				current = current.next;
			}
		}
		
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link preLink = first;
		
		if (first.data == key) {
			first = first.next;
			return current;
		}
		while (current != null) {
			if (current.data == key) {
				preLink.next = current.next;
				break;
			} else {
				preLink = current;
				current = current.next;
			}
		}
		
		return current;
		
	}
	
	
	public void displayLinkList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
}
