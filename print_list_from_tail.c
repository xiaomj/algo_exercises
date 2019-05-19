#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <stack>

#include "list.h"

void internal_print_node(node *node) {
	if (node->next) {
		internal_print_node(node->next);
	}
	printf("%d\n", node->val);
}

void internal_print_node_iteratively(node *head) {
	std::stack<int> st;
	while (head) {
		st.push(head->val);
		head = head->next;
	}
	while (!st.empty()) {
		printf("%d\n", st.top());
		st.pop();
	}
}

void reverse_print_list(list *li) {
	if (!li || !li->head) {
		return;
	}
	internal_print_node_iteratively(li->head);	
}

int main(int argc, char **argv) {
    list *li = (list *)malloc(sizeof(list));
    node *head = (node *)malloc(sizeof(node));
    head->val = 1;
    node *second = (node *)malloc(sizeof(node));
    second->val = 2;
    node *third = (node *)malloc(sizeof(node));
    third->val = 3;

    head->next = second;
    second->next = third;
    li->head = head;
	reverse_print_list(li);
}
