package com.vivek.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	private Node root;
	private HashMap<Integer, Node> hm;
	public BinaryTree(Node root){
		this.root = root;
		hm = new HashMap<Integer, Node>();
	}
	
	public void inorderTraverse(Node root){
		if(root==null)
			return;
		
		inorderTraverse(root.getLeft());
		System.out.println(root.getData());
		inorderTraverse(root.getRight());
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void getTopView(Node base, int dist){
		
		if(!hm.containsKey(dist)){
			hm.put(dist, base);
			System.out.println(base.getData());
		}
		
		if(base.getLeft()==null && base.getRight()==null)
			return;
		
		if(base.getLeft()!=null){
			getTopView(base.getLeft(),dist-1);
		}
		if(base.getRight()!=null){
			getTopView(base.getRight(), dist+1);
		}
		
	}
	
	public void getLevelOrder(Node base){
		
		Queue<Node> que = new LinkedList<Node>();
		que.add(base);
		
		while(!que.isEmpty()){
			
			Node curr = que.poll();
			System.out.println(curr.getData());
			if(curr.getLeft()!=null)
				que.add(curr.getLeft());
			if(curr.getRight()!=null)
				que.add(curr.getRight());
			
		}
		
	}
	
	public void getLeftView(Node base, int level){
		if(!hm.containsKey(level)){
			hm.put(level, base);
			System.out.println(base.getData());
		}
		
		if(base.getLeft()==null && base.getRight()==null)
			return;
		
		if(base.getLeft()!=null){
			getLeftView(base.getLeft(),level+1);
		}
		if(base.getRight()!=null){
			getLeftView(base.getRight(), level+1);
		}
	}
	
	
	public void getRightView(Node base, int level){
		if(!hm.containsKey(level)){
			hm.put(level, base);
			System.out.println(base.getData());
		}
		
		if(base.getLeft()==null && base.getRight()==null)
			return;
		
		if(base.getRight()!=null){
			getRightView(base.getRight(), level+1);
		}
		
		if(base.getLeft()!=null){
			getRightView(base.getLeft(),level+1);
		}
		
	}


}
