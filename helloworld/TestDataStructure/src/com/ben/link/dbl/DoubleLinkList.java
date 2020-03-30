package com.ben.link.dbl;

public class DoubleLinkList {
	
	Link first;
	Link last;
	
	public DoubleLinkList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int key) {
		Link newLink = new Link(key);
		
		if (isEmpty()) {
			last = newLink;
		} else {
			first.pre = newLink;
		}
		
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(int key) {
		Link newLink = new Link(key);
		
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.pre = last;
		}
		
		last = newLink;
		
		
	}
	
	public Link deleteFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.pre = null;
		}
		
		first = first.next;
		return temp;
		
	}
	
	public Link deleteLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.pre.next = null;
			//last.pre = null;
		}
		
		last = last.pre;
		
		return temp;
	}
	
	public void insertAfter(int newKey, int oldKey) {
		Link newLink = new Link(newKey);
		
		Link current = first;
		while (current != null && current.data != oldKey) {
			current = current.next;
		}
		
		if (current == last) {
			//current.next = newLink;
			//newLink.pre = current;
			last = newLink;
		} else {
			newLink.next = current.next;
			current.next.pre = newLink;

		}
		
		current.next = newLink;
		newLink.pre = current;
	}
	
	public Link deletekey(int key) {
		
		Link current = first;
		
		while (current !=null && current.data != key) {
			current = current.next;
		}
		Link temp = current;
		
		if (current == first) {
			first = current.next;
			//current.next.pre = null;
			//return;
		} else {
			current.pre.next = current.next;
		}
		
		if (current == last) {
			//current.pre.next = null;
			last = current.pre;
			//return;
		} else {
			current.next.pre = current.pre;
		}
		
		//current.pre.next = current.next;
		//current.next.pre = current.pre;
		return temp;
	}
	
	public void displayForward() {
		
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
	public void dispalyBackward() {
		Link current = last;
		while (current != null) {
			current.displayLink();
			current = current.pre;
		}
	}
	
}
