#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "list.h"

void remove_element(list *li, int target) {
	if (!li) {
		return;
	}
	node *head = li->head;
	if (!head) {
		return;
	}
	node *pre = NULL;
	node *cur = head;
	node *next = head->next;
	while (cur) {
		if (cur->val == target) {
			if (!pre) {
				li->head = next;
			} else {
				pre->next = next;
			}
			return;
		}
		pre = cur;
		cur = next;
		if (next) {
			next = next->next;
		}
	} 
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
    remove_element(li, 3);
	head = li->head;
	while (head) {
		printf("%d\n", head->val);
		head = head->next;
	}
}
