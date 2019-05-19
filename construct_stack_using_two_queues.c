#include <stdlib.h>
#include <stdio.h>
#include <queue>

typedef struct stack {
	std::queue<int> *queue_ref;
	std::queue<int> *queue_backup;

	stack() {
		queue_ref = new std::queue<int>();
		queue_backup = new std::queue<int>();
	}	

	void push(int target) {
		queue_ref->push(target);
	}
	

	int pop() {
		if (queue_ref->empty()) {
			return -1;
		}
		while (queue_ref->size() > 1) {
			queue_backup->push(queue_ref->front());
			queue_ref->pop();
		}
		int t = queue_ref->front();
		queue_ref->pop();

		std::queue<int> *q = queue_ref;
		queue_ref = queue_backup;
		queue_backup = q;
		
		return t;
	}
} stack;

int main(int argc, char *argv[]) {
	stack st;
	st.push(1);
	st.push(2);
	printf("%d\n", st.pop());
	st.push(3);
	printf("%d\n", st.pop());
	st.push(4);
	printf("%d\n", st.pop());
	printf("%d\n", st.pop());
}
