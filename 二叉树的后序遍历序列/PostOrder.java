class Node {
	public Node left;
	public Node right;
	public int val;
}

class Tree {
	public Node root;
}

class PostOrder {
	public Integer internalTraverse(Node root, int[] res, int i) {
		int cntLeft = 0;
		int cntRight = 0;
		if (root.left != null) {
			cntLeft = internalTraverse(root.left, res, i);
		}
		if (cntLeft == -1) {
			return -1;
		}
		if (root.right != null) {
			cntRight = internalTraverse(root.right, res, i + cntLeft);
		}
		if (cntRight == -1) {
			return -1;
		}
		if (i + cntLeft + cntRight >= res.length) {
			return -1;
		}
		if (root.val == res[i + cntLeft + cntRight]) {
			return cntLeft + cntRight + 1;
		} else {
			return -1;
		}
	}

	public void traverse(Tree tree, int[] res) {
		System.out.println(internalTraverse(tree.root, res, 0) == res.length);
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node();
		Node left = new Node();
		Node right = new Node();
		root.val = 1;
		left.val = 2;
		right.val = 3;
		root.left = left;
		root.right = right;
		tree.root = root;
		int[] res = {2, 3, 1, 0};
		new PostOrder().traverse(tree, res);
	}
}
