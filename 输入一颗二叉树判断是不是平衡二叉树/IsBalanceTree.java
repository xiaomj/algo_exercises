class Node {
	Node left;
	Node right;
	int val;
}

class Tree {
	Node root;
}

class IsBalanceTree {
	public Integer internalVerify(Node node) {
		if (node == null) {
			return 0;
		}

		Integer leftTreeHeight = 0;
		if (node.left != null) {
			leftTreeHeight = internalVerify(node.left);
		}
		Integer rightTreeHeight = 0;
		if (node.right != null) {
			rightTreeHeight = internalVerify(node.right);
		}
		if (leftTreeHeight == -1 || rightTreeHeight == -1) {
			return -1;
		}
		if (leftTreeHeight - rightTreeHeight > 1 || leftTreeHeight - rightTreeHeight < -1) {
			return -1;
		}
		return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1 : rightTreeHeight + 1;
	}

	public void verify(Tree tree) {
		if (tree == null) {
			return;
		}
		Integer heightAndResult = internalVerify(tree.root);	
		if (heightAndResult == -1) {
			System.out.println("非平衡树");
		} else {
			System.out.println("平衡树");
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node();
		Node left = new Node();
		Node left1 = new Node();
		Node left2 = new Node();
		Node right = new Node();
		root.val = 1;
		left.val = 2;
		left1.val = 2;
		left2.val = 2;
		left.left = left1;
		left1.left = left2;
		right.val = 3;
		root.left = left;
		root.right = right;
		tree.root = root;		
		new IsBalanceTree().verify(tree);
	}
}
