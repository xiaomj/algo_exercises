import java.util.*;

class Node {
	Node left;
	Node right;
	Integer val;
}

class Tree {
	Node root;
}

class CommonParentForTwoTreeNodesV2 {

	Boolean internalFindPath(Node root, Node a, List<Node> path) {
		if (null == root) {
			return false;
		}
		path.add(root);
		if (a == root) {
			return true;
		}
		if (internalFindPath(root.left, a, path)) {
			return true;
		}
		
		if (internalFindPath(root.right, a, path)) {
			return true;
		}
		path.remove(root);
		return false;
	}	

	Node internalFind(Node root, Node a, Node b) {
		if (root == null) {
			return null;
		}
		if (root == a || root == b) {
			return root;
		}
		List<Node> pathForA = new ArrayList<>();
		List<Node> pathForB = new ArrayList<>();
		if (!internalFindPath(root, a, pathForA)) {
			return null;
		}
		if (!internalFindPath(root, b, pathForB)) {
			return null;
		}
		int i = 0;
		while (i < pathForA.size() && i < pathForB.size()) {
			if (pathForA.get(i) != pathForB.get(i)) {
				break;
			} 
			i++;
		}
		return pathForA.get(i-1);
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
		System.out.println(new CommonParentForTwoTreeNodesV2().find(tree, right, left2).val);
	}
}
