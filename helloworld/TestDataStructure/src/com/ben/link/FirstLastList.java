package com.ben.link;

public class FirstLastList {
	Link first;
	Link last;
	
	public FirstLastList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(int key) {
		Link newLink = new Link(key);
		
		if (isEmpyt()) {
			last = newLink;
		}
		
		newLink.next = first;
		first = newLink;
		

		
	}
	
	public void insertLast(int key) {
		Link newLink = new Link(key);
		
		if (isEmpyt()) {
			first = newLink;
		} else {
			last.next = newLink;
		}

		last = newLink;
	}
	
	public boolean isEmpyt() {
		return first == null;
	}
	
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		
		if (isEmpyt()) {
			last = null;
		}
		
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
		
		if (!isEmpyt() && current.data == key) {
			deleteFirst();
			return current;
		} 
		
		Link preLink = first;
		while (current != null) {
			if (current.data == key) {
				preLink.next = current.next;
				if (current.next == null) {
					last = preLink;
				}
				break;
			} else {
				preLink = current;
				current = current.next;
			}
		}

		return current;
	}
	
	public void displayFistLastList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
}
