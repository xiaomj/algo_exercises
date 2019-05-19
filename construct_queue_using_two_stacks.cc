#include <stack>

template<typename T>
struct queue {
	std::stack<T> stack_for_push;
	std::stack<T> stack_for_pop;

public:
	void appendTail(T target) {
		stack_for_push.push(target);
	}
	
	void deleteHead() {
		if (!stack_for_pop.empty()) {
			stack_for_pop.pop();
		} else {
			while (!stack_for_push.empty()) {
				stack_for_pop.push(stack_for_push.top());
				stack_for_push.pop();
			}
			stack_for_pop.pop();
		}
	}
};

int main(int agrc, char *argv[]) {
	queue<int> qu;
	qu.appendTail(1);	
	qu.appendTail(1);	
	qu.appendTail(1);	
	qu.deleteHead();
	qu.deleteHead();
}
