package com.ben.link;

public class TestLinkList {
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		
		list.insertFirst(5);
		list.deleteFirst();
		
		Link link = list.find(9);
		if (link != null) {
			link.displayLink();
		} else {
			System.out.println("no found key");
		}
		Link delLink = list.delete(3);
		if (delLink != null) {
			delLink.displayLink();
			System.out.println("-------------");
		} else {
			System.out.println("no found link, cannot del");
		}
		list.displayLinkList();
	}
}
