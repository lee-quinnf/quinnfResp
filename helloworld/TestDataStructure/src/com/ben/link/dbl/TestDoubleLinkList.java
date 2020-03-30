package com.ben.link.dbl;

public class TestDoubleLinkList {
	
	public static void main(String[] args) {
		DoubleLinkList list = new DoubleLinkList();
		
//		list.insertFirst(1);
//		list.insertFirst(2);
//		list.insertFirst(3);
		
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		
//		list.insertAfter(5, 1);
//		list.insertAfter(5, 2);
//		list.insertAfter(5, 3);
		
//		list.deleteFirst();
//		list.deleteLast();
		
//		list.deletekey(1);
//		list.deletekey(3);
//		list.deletekey(4);
		
		list.displayForward();
		System.out.println("--------------");
		list.dispalyBackward();
	}
}
