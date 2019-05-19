typedef struct node {
	struct node *next;
	int val;
} node;

typedef struct list {
	struct node *head;
} list;
