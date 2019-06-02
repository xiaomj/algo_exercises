class Node {
	Node left;
	Node right;
	Integer val;
}

class Tree {
	Node root;
}

class CommonParentForTwoTreeNodesV1 {
	Boolean exist(Node root, Node a) {
		if (root == a) {
			return true;
		}
		if (root == null) {
			return false;
		}
		return exist(root.left, a) || exist(root.right, a);
	}

	Node internalFind(Node root, Node a, Node b) {
		if (root == null) {
			return null;
		}
		if (root == a || root == b) {
			return root;
		}
		
		Boolean aLeft = exist(root.left, a);
		Boolean bRight = exist(root.right, b);		
		if (aLeft && bRight) {
			return root;
		}
		if (!aLeft && !bRight) {
			return root;
		}
		if (aLeft) {
			return internalFind(root.left, a, b);
		} else {
			return internalFind(root.right, a, b);
		}
	}

	public Node find(Tree tree, Node a, Node b) {
		Node root = tree.root;
		return internalFind(root, a, b);		
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.val = 1;
		Node left = new Node();
		left.val = 2;
		Node right = new Node();
		right.val = 3;
		Node left2 = new Node();
		left2.val = 4;
		root.left = left;
		left.left = left2;
		root.right = right;
		Tree tree = new Tree();
		tree.root = root;
		System.out.println(new CommonParentForTwoTreeNodesV1().find(tree, left2, left).val);
	}
}
