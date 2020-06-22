package practice;

class BinaryNode{
	int data;
	BinaryNode left, right;
	public BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public int getHeight() {
		int leftHeight = 0, rightHeight = 0;
		if(this.left != null) {
			leftHeight = this.left.getHeight(); 
		}
		if(this.right != null) {
			rightHeight = this.right.getHeight();
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
public class BinaryTree {
	public int getHeight(BinaryNode root) {
		if(root != null) {
			return root.getHeight();
		} else 
			return 0;
	}
	public int maxHeight(BinaryNode binaryNode) {
		if(binaryNode == null) {
			return 0;
		}
		int leftDepth = maxHeight(binaryNode.left);
		int rightDepth = maxHeight(binaryNode.right);
		if(leftDepth > rightDepth) {
			return leftDepth+1;
		} else {
			return rightDepth+1;
		}
	}
	int traverseStep = 1;
	public int searchNode(BinaryNode binaryNode, int data) {
		while(binaryNode != null) {
			if(data == binaryNode.data) {
				return traverseStep;
			} else if(data < binaryNode.data) {
				traverseStep++;
				return searchNode(binaryNode.left, data);
			} else if(data > binaryNode.data) {
				traverseStep++;
				return searchNode(binaryNode.right, data);
			}
		}
		return 0;
	}

	public BinaryNode insertNode(BinaryNode binaryNode, int data) {
		if(binaryNode == null) {
			binaryNode = new BinaryNode(data);
		}
		if(data < binaryNode.data) {
			binaryNode.left = insertNode(binaryNode.left, data);
		} else if(data > binaryNode.data) {
			binaryNode.right = insertNode(binaryNode.right, data);
		}
		return binaryNode;
	}
	public static void main(String[] args) {
		BinaryNode root = null;
		BinaryTree binaryTree = new BinaryTree();
//		int[] arr = {8,3,6,10,4,7,1,14,13,12,15,18};
		int[] arr = {1,2,3,4,5};
		for(int data:arr) {
			root = binaryTree.insertNode(root, data);	
		}
		int traverseStep = binaryTree.searchNode(root, 7);
		System.out.println("traverseStep:"+traverseStep);
		System.out.println("max height:"+binaryTree.getHeight(root));
	}
}