#ifndef _NODE
#define _NODE

typedef struct node {
    struct node *left;
    struct node *right;
    int val;
} node;

typedef struct tree {
    struct node *root;
} tree;

#endif
