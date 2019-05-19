import java.util.*;

class Node {
	public Node left;
	public Node right;
	public int val;
}

class Tree {
	public Node root;
}

class LevelTraverseTree {
	public void traverse(Tree tree) {
		Queue<Node> queue = new LinkedList<>();
		Node root = tree.root;
		if (tree == null || tree.root == null) {
			return;
		}
		queue.add(root);
		while (queue.size() > 0) {
			Node node = queue.poll();
			System.out.println(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}		
		}	
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node();
		root.val = 1;
		Node left = new Node();
		left.val = 2;
		Node right = new Node();
		right.val = 3;
		root.left = left;
		root.right = right;
		tree.root = root;
		new LevelTraverseTree().traverse(tree);
	}
}
