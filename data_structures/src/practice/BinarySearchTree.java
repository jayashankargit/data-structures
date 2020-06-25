package practice;

import java.util.ArrayDeque;
import java.util.Queue;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinarySearchTree{
	public static int getHeight(Node root){
		int heightLeft = 0;
	    int heightRight = 0;

	    if (root.left != null) {
	        heightLeft = getHeight(root.left) + 1;
	    }
	    if (root.right != null) {
	        heightRight = getHeight(root.right) + 1;
	    }

	  return (heightLeft > heightRight ? heightLeft : heightRight);
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    static Queue<Integer> queue = new ArrayDeque<Integer>();
    public static void levelOrder(Node tree) {
    	int height = getHeight(tree);
    	for(int counter = 1; counter <= height + 1 ; counter++) {
    		printGivenLevel(tree, counter);
    	}
    	StringBuilder stringBuilder = new StringBuilder();
    	for(Integer data:queue) {
    		stringBuilder.append(data).append(" ");
    	}
    	stringBuilder.deleteCharAt(stringBuilder.length()-1);
    	System.out.println(stringBuilder.toString());
    }
	 private static void printGivenLevel(Node tree, int level) {
		 if(tree == null) {
			 return;
		 }
		 if(level == 1) {
			 queue.add(tree.data);
		 } else if(level > 1) {
			 printGivenLevel(tree.left, level - 1);
			 printGivenLevel(tree.right, level - 1);
		 }
	}

	public static void main(String args[]){
		BinarySearchTree tree = new BinarySearchTree();
        Node root=null;
        int[] arr = {3,2,1,5,4,7};
        for(int data:arr) {
        	root = insert(root,data);
        }
        int height=getHeight(root);
        tree.levelOrder(root);
        System.out.println(height);
    }
}