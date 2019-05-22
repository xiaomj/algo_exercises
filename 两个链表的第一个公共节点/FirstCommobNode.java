class Node {
	int val;
	Node next;
}

class List {
	Node head;
}

class FirstCommobNode {
	public void find(List list1, List list2) {
		if (list1 == null || list1.head == null) {
			return;
		}
		
		if (list2 == null || list2.head == null) {
			return;
		}
		
		Node node1 = list1.head;
		int count1 = 0;
		while (node1 != null) {
			node1 = node1.next;	
			count1++;
		}
		
		Node node2 = list2.head;
		int count2 = 0;
		while (node2 != null) {
			node2 = node2.next;
			count2++;
		}
		
		node1 = list1.head;
		node2 = list2.head;
		while (count2 > count1) {
			node2 = node2.next;
			count2--;
		}
		while (count1 > count2) {
			node1 = node1.next;
			count1--;
		}
		while (count1 > 0 && count2 > 0) {
			node1 = node1.next;
			node2 = node2.next;
			if (node1 == node2) {
				System.out.println(node1.val);
				return;
			}
			count1--;
			count2--;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node();
		node1.val = 1;
		Node node2 = new Node();
		node2.val = 2;
		Node node3 = new Node();
		node3.val = 3;
		node1.next = node2;
		node2.next = node3;
		
		Node node11 = new Node();
		node11.val = 11;
		Node node12 = new Node();
		node12.val = 12;
		Node node13 = new Node();
		node13.val = 13;
		node11.next = node12;
		node12.next = node3;
		//node13.next = node3;
		
		List list1 = new List();
		list1.head = node1;
		
		List list2 = new List();
		list2.head = node11;
		new FirstCommobNode().find(list1, list2);
	}
}
