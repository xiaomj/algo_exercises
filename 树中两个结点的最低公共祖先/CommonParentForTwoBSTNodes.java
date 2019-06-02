class Node {
	Node left;
	Node right;
	Integer val;
}

class Tree {
	Node root;
}

class CommonParentForTwoBSTNodes {
	Node internalFind(Node root, Integer a, Integer b) {
		if (root == null) {
			return null;
		}
		if ((root.val - a) * (root.val - b) <= 0) {
			return root;
		} else if ((root.val - a) > 0) {
			return internalFind(root.left, a, b);
		} else {
			return internalFind(root.right, a, b);
		}
	}

	public Node find(Tree tree, Integer a, Integer b) {
		Node root = tree.root;
		return internalFind(root, a, b);		
	}
}
