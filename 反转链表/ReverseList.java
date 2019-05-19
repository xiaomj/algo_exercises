class List {
	public Node head;
	
	private Node internalReverse(Node node) {
		Node cur = node;
		if (node == null) {
			return cur;
		}
		if (cur.next == null) {
			head = cur;
		} else {
			Node tail = internalReverse(cur.next);	
			tail.next = cur;
		}
		cur.next = null;
		return cur;
	}
	
	public void reverse() {
		internalReverse(head);	
	}

	public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }	
}

class Node {
	public int val;
	public Node next;
}

public class ReverseList {
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
        list.reverse();
        list.print();		
	}
}
