package practice;

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
        if(root == null) {
            return 0;
        }
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        if(leftDepth > rightDepth) {
            return leftDepth+1;
        } else{
            return rightDepth+1;
        }
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
	 public static void main(String args[]){
        Node root=null;
        int[] arr = {1,2,3,4,5};
        for(int data:arr) {
        	root = insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}