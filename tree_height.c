#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

int max(int a, int b) {
	return a > b ? a : b;
}

int internal_traverse_height(node *tr) {
	int left_sub_tree_height = 0;
	int right_sub_tree_height = 0;

	if (tr->left) {
		left_sub_tree_height = internal_traverse_height(tr->left);
	}
	if (tr->right) {
		right_sub_tree_height = internal_traverse_height(tr->right);
	}
	return max(left_sub_tree_height + 1, right_sub_tree_height + 1);
}

int traverse_height(tree *tr) {
	return internal_traverse_height(tr->root);
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
    printf("%d\n", traverse_height(tr));
}	

