package com.vivek.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.vivek.datastructures.BinaryTree;
import com.vivek.datastructures.Node;

public class CommonCode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line1 = br.readLine(); 
		Node root = new Node(6);
		Node l1 = new Node(5);
		Node l2 = new Node(-1);
		Node l3 = new Node(9);
		Node l4 = new Node(4);
		Node r1 = new Node(3);
		Node r2 = new Node(1);
		Node r3 = new Node(2);
		Node r4 = new Node(7);
		Node r5 = new Node(8);
		Node r6 = new Node(11);
		l1.setLeft(l2);
		l2.setRight(l3);
		l1.setRight(l4);
		r1.setRight(r2);
		r1.setLeft(r3);
		r2.setLeft(r4);
		r4.setRight(r5);
		r5.setRight(r6);
		root.setLeft(l1);
		root.setRight(r1);
		BinaryTree obj = new BinaryTree(root);
		obj.getLevelOrder(root);
	}

}
