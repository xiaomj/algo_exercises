#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "list.h"

void append_list(list *li, int target) {
	if (!li) {
		return;
	}

	node *head = li->head;
	if (!head) {
		head = (node *)malloc(sizeof(node));
		head->val = target;
		li->head = head;
	}
	node *cur = head;
	node *next = cur->next;
	while (next) {
		cur = next;
		next = next->next;
	}
	next = (node *)malloc(sizeof(node));
	next->val = target;
	cur->next = next;	
}

int main(int argc, char *argv[]) {
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
	append_list(li, 1);
	while (head) {
		printf("%d\n", head->val);
		head = head->next;
	}
}
