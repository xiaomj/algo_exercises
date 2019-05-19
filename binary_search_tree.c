#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tree.h"

int bst_search(tree *tr, int target) {
	node *nd = tr->root;
	while (nd) {
		if (nd->val == target) {
			return 1;
		} else if (nd->val < target) {
			nd = nd->right;
		} else {
			nd = nd->left;
		}
	}
	return 0;
}

tree *create_bst() {
	node *root = (node *)malloc(sizeof(node));
	root->val = 1;

	node *cur = root;
	node *pre = NULL;

	for (int i = 2; i < 10; i++) {
		while (cur) {
			if (i < cur->val) {
				pre = cur;
				cur = cur->left;
				if (cur == NULL) {
					node *left = (node *)malloc(sizeof(node));
					left->val = i;
					pre->left = left;
					break;
				}
			} else {
				pre = cur;
				cur = cur->right;
				if (cur == NULL) {
					node *right = (node *)malloc(sizeof(node));
					right->val = i;
					pre->right = right;
					break;
				}
			}
		}
	}
	tree *tr = (tree *)malloc(sizeof(tree));
	tr->root = root;
	return tr;
}

int main(int argc, char *argv[]) {
	tree *tr = create_bst();
	printf("%d\n", bst_search(tr, 2));
}
