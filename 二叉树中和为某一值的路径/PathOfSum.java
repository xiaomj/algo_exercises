import java.util.*;

class Node {
	Node left;
	Node right;
	int val;
}

class Tree {
	Node root;
}

class PathOfSum {
	public void internalCalcPath(List<Node> nodes, Node root, int sum) {
		if (root == null) {
			return;
		}
		if (root.val < sum) {
			nodes.add(root);
			internalCalcPath(nodes, root.left, sum - root.val);	
			internalCalcPath(nodes, root.right, sum - root.val);
			nodes.remove(root);
		} else if (root.val == sum) {
			for (int i = 0; i < nodes.size(); i++) {
				System.out.print(nodes.get(i).val + " ");
			}
			System.out.println(root.val + " ");
		}
	}

	public void calcPath(Tree tree, int sum) {
		List<Node> nodes = new ArrayList<>();
		internalCalcPath(nodes, tree.root, sum);		
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node();
		Node left = new Node();
		Node right = new Node();
		root.val = 1;
		left.val = 2;
		Node leftleft = new Node();
		leftleft.val = 1;
		left.left = leftleft;
		right.val = 3;
		root.left = left;
		root.right = right;
		tree.root = root;	
		new PathOfSum().calcPath(tree, 4);
	}
}
