class Node {
	public Node next;
	public int val;
}

class List {
	public Node head;
	
	public void deleteNode(Node node) {
		if (head == node) {
			head = null;
			return;
		}
		Node cur = node;
		Node next = cur.next;
		if (next != null) {
			cur.val = next.val;
			cur.next = next.next;
		} else {
			cur = head;
			while (head.next != node) {
				head = head.next;
			}
			head.next = null;
		}
	}
	
	public void print() {
		Node cur = head;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}	
}

public class Test {
	public static void main(String[] args) {
		Node head = new Node();
		Node first = new Node();
		Node second = new Node();
		head.val = 1;
		first.val = 2;
		second.val = 3;
		head.next = first;
		first.next = second;
		List list = new List();
		list.head = head;
		list.deleteNode(first);
		list.print();
	}
}
