package com.ben.base;

import org.junit.Test;
/***
 * 
 * @author Quinnf
 *
 */

public class TestUnitSort {
	/*
	 * 冒泡排序 O(N^2)
	 */
	@Test
	public void maopaoSort() {
		
		int[] arr = {77, 99, 44, 55, 22 , 88, 11, 00, 66, 33};
		
		for (int k = 0; k < arr.length; k++) {
			for (int i = 0; i < arr.length - 1; i++) {
				
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			display(arr);
		
		}
		
	}
	
	/*
	 * 选择排序  
	 * 交换O(N)， 选择O(N^2)
	 */
	@Test
	public void selectSort() {
		int[] arr = {77, 99, 44, 55, 22 , 88, 11, 00, 66, 33};
		
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int j = i + 1;
			int index = i;
			for (; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
			display(arr);
		}
	
	}
	
	/*
	 * 插入排序 O(N^2)
	 */
	@Test
	public void insertSort() {
		int[] arr = {77, 99, 44, 55, 22 , 88, 11, 00, 66, 33};
		
		for (int i = 1; i < arr.length; i++) {
			
			int flag = arr[i];
			int j = i -1;
			for (; j >= 0; j--) {
				if (flag < arr[j]) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			
			arr[j + 1] = flag;
			display(arr);
		}
		
		
	}
	
	/*
	 * 希尔排序
	 */
	@Test
	public void shellSort() {
		int[] arr = {77, 99, 44, 55, 22 , 88, 11, 00, 66, 33};
		int h = 1;
		while (h < (arr.length - 1) / 3) {
			h = 3 * h + 1;
		}
		//System.out.println(h);
		while (h > 0) {
			for (int i = h; i < arr.length; i++) {
				
				int flag = arr[i];
				int j = i -h;
				for (; j >= 0;) {
					if (flag < arr[j]) {
						arr[j + h] = arr[j];
					} else {
						break;
					}
					j -= h;
				}
				
				arr[j + h] = flag;
				display(arr);
				
			}
			//System.out.println("h = " + h);
			h = (h -1) / 3;
		
		}
		
		
	}
	
	/*
	 * 快速排序 O(N)
	 */
	@Test
	public void quickSort() {
		int[] arr = {77, 99, 44, 55, 22 , 88, 11, 00, 66, 33};
		int start = 0;
		int end = arr.length - 1;
		
		reQuickSort(arr, start, end);
		display(arr);
		
	}
	
	public void reQuickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int p = partion(arr, start, end);
		reQuickSort(arr, start, p - 1);
		reQuickSort(arr, p + 1, end);
		
	}
	
	public int partion(int[] arr, int start, int end) {
		
		int i = start - 1;
		int j = end;
		
		while (true) {
			while (arr[++i] < arr[end]) {
			}
			
			while (j > 0 && arr[--j] > arr[end]) {
			}
	
			if (i >= j) {
				swap(arr, end, i);
				break;
			} else {
				swap(arr, i, j);
			}
		}
		
		display(arr);
		return i;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	@Test
	public void quickSort2() {
		int[] arr = {77, 99, 44, 55, 22 , 88, 11, 00, 66, 33};
		int start = 0;
		int end = arr.length - 1;
		
		
		doQuickSort(arr, start, end);
		
		
	}
	
	public int partion2(int[] arr, int start, int end) {

		int i = start, j = end;
		int x = arr[i];
		while (true) {

			for (; j > i; j--) {
				if (arr[j] < x) {
					arr[i] = arr[j];
					i++;
					break;
				}
			}

			for (; i < j; i++) {
				if (arr[i] > x) {
					arr[j] = arr[i];
					//arr[i] = flag;
					j--;
					break;
				}
			}

			if (i == j) {
				arr[i] = x;
				break;
			}

		}
		display(arr);
		return i;
	}	
	
	public void doQuickSort(int[] arr, int start, int end) {
		
		if (start >= end) {
			 return;
		}
		int p = partion2(arr, start, end);
		doQuickSort(arr, start, p - 1);
		doQuickSort(arr, p + 1, end);
	}
	
	
	
	
	
	
	
	
	public void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
