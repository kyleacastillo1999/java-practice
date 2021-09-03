package com.practice.week2;


public class Node implements Comparable<Node>{
	
	public int data, height;
	public Node left, right, parent;
	
	public Node(int data) {
		this.data = data;
		height = 1;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.data - n.data;
	}
}
	
	
