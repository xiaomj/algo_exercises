#include <stdio.h>
#include <stdlib.h>
#include "list.h"

void find_kth_list(list *li, int k) {
	if (!li) {
		return;
	}
	node *cur = li->head;
	node *cur_ahead = li->head;
	int i = k - 1;
	while (i-- && cur_ahead) {
		cur_ahead = cur_ahead->next;
	}
	if (!cur_ahead) {
		return;
	}
	
	while (cur_ahead->next) {
		cur_ahead = cur_ahead->next;
		cur = cur->next;
	}
	printf("%d\n", cur->val);
}

int main(int argc, char *argv[]) {
	node *head = (node *)malloc(sizeof(node));
	node *second = (node *)malloc(sizeof(node));
	node *third = (node *)malloc(sizeof(node));
	list *li = (list *)malloc(sizeof(list));
	head->val = 1;
	second->val = 2;
	third->val = 3;
	//head->next = second;
	second->next = third;
	li->head = head;
	find_kth_list(li, 111);
}
