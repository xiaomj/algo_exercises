#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"

void reverse_list(list *li) {
	node *cur = li->head;
	node *pre = NULL;
	node *next = cur->next;
	
	while (cur) {
		if (pre != NULL) {
			cur->next = pre;
		}
		pre = cur;
		cur = next;
		if (next) {
			next = next->next;
		}
	}
	li->head = pre;
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
	//second->next = third;
	li->head = head;
	
	reverse_list(li);
	
	printf("%d\n", li->head->val);
}
