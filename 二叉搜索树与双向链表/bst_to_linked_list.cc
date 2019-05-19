#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tree.h"

void internal_convert(node *cur, node * &head, node * &tail) {
	
	node *_left_head = NULL;
	node *_left_tail = NULL;
	node *_right_head = NULL;
	node *_right_tail = NULL;

	if (cur->left) {
		internal_convert(cur->left, _left_head, _left_tail);
	}
	if (cur->right) {
		internal_convert(cur->right, _right_head, _right_tail);
	}
	
	cur->right = _right_head;
	if (_right_head) {
		_right_head->left = cur;
	}
	cur->left = _left_tail;
	if (_left_tail) {
		_left_tail->right = cur;
	}
	if (cur->left) {
		head = _left_head;
	} else {
		head = cur;
	}
	if (cur->right) {
		tail = _right_tail;
	} else {
		tail = cur;
	}
}

void bst_to_double_linked_list(tree *tr) {
	node *root = tr->root;
	node *head;
	node *tail;
	internal_convert(root, head, tail);
	while (head) {
		printf("%d\n", head->val);
		head = head->right;
	}
	while (tail) {
		printf("%d\n", tail->val);
		tail = tail->left;
	}
}

int main(int argc, char *argv[]) {
    node *root = (node *)malloc(sizeof(node));
    root->val = 2;
    node *left = (node *)malloc(sizeof(node));
    left->val = 1;
	node *left2 = (node *)malloc(sizeof(node));
	left2->val = -1;
	left->left = left2;
    node *right = (node *)malloc(sizeof(node));
    right->val = 3;
    root->left = left;
    root->right = right;
    tree *tr = (tree *)malloc(sizeof(tree));
    tr->root = root;
	bst_to_double_linked_list(tr);
}	
