import java.util.*;

class Node {
	Node next;
	Node sibling;
	int val;
}

class List {
	Node head;
}

class CopyComplicatedList {
	public void copyList(List copyFrom, List copyTo) {
		Map<Node, Node> dict = new HashMap<>();
		Node srcNode = copyFrom.head;
	
		Node dstHead = null;
		Node dstPre = null;

		while (srcNode != null) {
			Node node = new Node();
			node.val = srcNode.val;
			dict.put(srcNode, node); 
			if (dstPre != null) {
				dstPre.next = node;
			}
			if (dstHead == null) {
				dstHead = node;
			}
			dstPre = node;
			srcNode = srcNode.next;
		}
		
		srcNode = copyFrom.head;
		while (srcNode != null) {
			Node dstNode = dict.get(srcNode);
			dstNode.sibling = dict.get(srcNode.sibling);
			srcNode = srcNode.next;
		}
		copyTo.head = dstHead;	
	}
		
	void print(List list) {
		Node node = list.head;
		System.out.println("list: ");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		node = list.head;
		System.out.println("sibling: ");
		while (node != null) {
			System.out.print(node.sibling.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List list = new List();
		Node head = new Node();
		head.val = 0;
		Node first = new Node();
		first.val = 1;
		Node second = new Node();
		second.val = 2;
		Node third = new Node();
		third.val = 3;
		Node forth = new Node();
		forth.val = 4;
		head.next = first;
		first.next = second;
		second.next = third;
		third.next = forth;
		head.sibling = second;
		first.sibling = third;
		second.sibling = first;
		third.sibling = forth;
		forth.sibling = head;
		list.head = head;
		
		CopyComplicatedList ccl = new CopyComplicatedList();
		ccl.print(list);
		
		List newList = new List();
		ccl.copyList(list, newList);
		ccl.print(newList);
	}
}
