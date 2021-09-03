package com.practice.week2;

public class Driver {
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Integer[] arr = {1,2,3,4,5,6,7,8,9};
		
		for(Integer i : arr) {
			System.out.print(" " + i);
			bt.root = bt.insert(bt.root, i);
		}
		System.out.println();
		bt.printInOrder(bt.root);
	}
}
