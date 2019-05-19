#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

void internal_left_traverse(node *node) {
	printf("%d\n", node->val);
	if (node->left) {
		internal_left_traverse(node->left);
	}
	if (node->right) {
		internal_left_traverse(node->right);
	}
}

void left_traverse(tree * t) {
	internal_left_traverse(t->root);	
}

int main(int argc, char *argv[]) {
	node *root = (node *)malloc(sizeof(node));
	root->val = 1;
	node *left = (node *)malloc(sizeof(node));
	left->val = 2;
	//node *right = (node *)malloc(sizeof(node));
	//right->val = 3;
	root->left = left;
	//root->right = right;
	tree *tr = (tree *)malloc(sizeof(tree));
	tr->root = root;
	left_traverse(tr);
	return 0;
}
