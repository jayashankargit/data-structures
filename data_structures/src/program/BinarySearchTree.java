package program;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
	}
}
class BinarySearchOperation{
	//return root with linking of child nodes
	public Node insert(Node node, int data) {
		if(node == null) {
			return new Node(data);
		}
		if(data < node.data) {
			node.left = insert(node.left, data);
		} else if(data > node.data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
}
public class BinarySearchTree{
	
	private static Node insertNode(BinarySearchOperation binaryOp) {
		Node root = null;
		int[] input = {8,3,10, 1, 6, 14, 4, 7, 13};
		for(int data : input) {
			root = binaryOp.insert(root, data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchOperation binaryOp = new BinarySearchOperation();
		Node root = insertNode(binaryOp);
		
		
	}
}