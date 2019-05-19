class Node {
	public int val;
	public Node left;
	public Node right;
}

class Tree {
	public Node root;
}

public class IsSubTree {
	public static Boolean internalIsSub(Node root, Node subRoot) {
		if (subRoot == null) {
			return true;
		} else if (root == null) {
			return false;
		} else if (root.val != subRoot.val) {
			return false;
		}

		Boolean match = internalIsSub(root.left, subRoot.left) && internalIsSub(root.right, subRoot.right);
		if (!match) {
			match = internalIsSub(root.left, subRoot);
		}	
		if (!match) {
			match = internalIsSub(root.right, subRoot);
		}
		return match;
	}

	public static Boolean isSub(Tree parent, Tree child) {
		return internalIsSub(parent.root, child.root);		
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

		Node root2 = new Node();
		root2.val = 1;
		root2.left = left;
		//root2.right = right;

		Tree tree1 = new Tree();
		Tree tree2 = new Tree();
		
		tree1.root = root;
		tree2.root = root2;
		
		System.out.println(isSub(tree1, tree2));
	}
}
