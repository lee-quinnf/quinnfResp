package com.ben.recursion;

import org.junit.Test;

/**
 * 
 * @author Quinnf
 *
 */
public class TestRecursion {
	
	/*
	 * 三角数字
	 * 1, 3, 6, 10, 15, 21
	 * fn = fn-1 + n
	 */
	@Test
	public void triAngle() {
		
		int n = 5;
		int r = getTriAngle(n);
		System.out.println(r);
	}
	
	public int getTriAngle(int n) {
		if (n == 1) {
			return 1;
		}
		
		return n + getTriAngle(n - 1);
	}
	
	/*
	 * 阶乘
	 * n! = n * n -1 * n - 2 * ... 1.
	 */
	@Test
	public void factorial() {
		int n = 4;
		int r = getFactorial(n);
		System.out.println(r);
	}
	
	public int getFactorial(int n) {
		if (n == 1) {
			return 1;
		}
		
		return n * getFactorial(n - 1);
	}
	
	/*
	 * 阶乘
	 * n! = n * n -1 * n - 2 * ... 1.
	 * 阶乘和
	 * s! = n! + n-1! + ... + 1!.
	 * 
	 */
	@Test
	public void sumFactorial() {
		int n = 3;
		int r = getSumFactorial(n);
		System.out.println(r);
	}
	
	public int getSumFactorial(int n) {
		if (n == 1) {
			return 1;
		}
		
		return getSumFactorial(n - 1) + getFactorial(n);
	}
	
	/*
	 * 变为数
	 * s = abc
	 * abc acb bac bca cba cab
	 */
	@Test
	public void anagram() {
		int[] arr = {1, 2 ,3, 4};
		doAnagram(arr, arr.length);
	}
	
	public void doAnagram(int[] arr, int size) {
		if (size == 1) {
			return;
		}
		
		for (int i = 0; i < size; i++) {
			doAnagram(arr, size - 1);
			if (size == 2) {
				display(arr);
			}
			rotate(arr, size);
		}
		
	}
	
	/*
	 * p = arr.length - size
	 */
	public void rotate(int[] arr, int size) {
		int p = arr.length - size;
		int t = arr[p];
		
		for (int i = p; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length -1] = t;
		
	}
	
	/*
	 * 二分查找
	 * 
	 */
	
	@Test
	public void halfSearch() {
		int key = 7;
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		getHalfSearch(arr, key, 0, arr.length - 1);
	}
	
	public void getHalfSearch(int[] arr, int key, int low, int upper) {
		int mid = (low + upper) / 2;
		
		if (arr[mid] == key) {
			System.out.println("find " + arr[mid]);
			return;
		}
		if (arr[mid] > key) {
			getHalfSearch(arr, key, low, mid - 1);
		} else {
			getHalfSearch(arr, key, mid + 1, upper);
		}
		
	}
	
	/*
	 * 汉诺塔
	 */
	@Test
	public void hanoi() {
		String[] srr = {"A", "B", "C"};
		int n = 3;
		String from = srr[0];
		String inner = srr[1];
		String to = srr[2];
		doHanoi(n, from, inner, to);
	}
	
	public void doHanoi(int n, String from, String inner, String to) {
		
		if (n == 1) {
			System.out.println("Disk 1" + " from " + from + " to " + to);
			return;
		}
		doHanoi(n - 1, from, to , inner);
		System.out.println("Disk " + n + " from " + from + " to " + to);
		doHanoi(n - 1, inner, from , to);
		
	}
	
	/*
	 * 归并排序
	 */
	int[] arrA = {23, 47, 81, 95};
	int[] arrB = {7, 14, 39, 55, 62, 74};
	int[] arrC = new int[arrA.length + arrB.length];
	@Test
	public void sortAB2C() {
		
		int a= 0, b = 0, c = 0;
		while (a < arrA.length && b < arrB.length) {
			if (arrA[a] < arrB[b]) {
				arrC[c++] = arrA[a++];
			} else {
				arrC[c++] = arrB[b++];
			}
		}
		
		while (a < arrA.length) {
			arrC[c++] = arrA[a++];
		}
		
		while (b < arrB.length) {
			arrC[c++] = arrB[b++];
		}
		
		display(arrC);
				
	}
	
	/*
	 * 归并排序一个乱序数组
	 */
	int[] arr = {64, 21, 33, 70, 12, 85, 44, 3, 99, 0, 108, 36};
	int[] temp = new int[arr.length];
	@Test
	public void sortC2AB2C() {
		
		
		sortAB2C(0, arr.length - 1);
		
		display(arr);
	}
	
	public void sortAB2C(int low, int upper) {
		if (low == upper) {
			return;
		}
		int mid = (low + upper) / 2;
		
		sortAB2C(low, mid);
		sortAB2C( mid + 1, upper);
		mergeAB2C(low, mid, upper);
	}
	
	public void mergeAB2C(int low, int mid, int upper) {
		
		int a = low, b = mid + 1, c = 0;
		int size = upper - low + 1;
		while(a <= mid && b <= upper) {
			if (arr[a] < arr[b]) {
				temp[c++] = arr[a++];
			} else {
				temp[c++] = arr[b++];
			}
			
		}
		
		while (a <= mid) {
			temp[c++] = arr[a++];
		}
		
		while(b <= upper) {
			temp[c++] = arr[b++];
		}
		
		for (int i = 0; i < size; i++) {
			arr[i + low] = temp[i];
		}
		
	}
	
	
	
	
	
	public void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	
}
