class Node {
	public int val;
	public Node left;
	public Node right;
}

class Tree {
	public Node root;
}

public class MirrorBinTree {
	public static void internalMirror(Node root) {
		if (root.left != null) {
			internalMirror(root.left);
		}
		if (root.right != null) {
			internalMirror(root.right);
		}
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void mirror(Tree tree) {
		Node root = tree.root;
		internalMirror(root);	
	}

	public static void main(String[] args) {
		Node root = new Node();
        root.val = 1;
        Node left = new Node();
        left.val = 2;
        Node right = new Node();
        right.val = 3;
        root.left = left;
        root.right = right;

		Tree tree1 = new Tree();

        tree1.root = root;
		mirror(tree1);
		System.out.println(root.left.val);		
		System.out.println(root.right.val);		
	}
}
