#include <cstdio>

class InitializerList {
public:
	 int a;
	 int b;
	
public:
	InitializerList(): b(1), a(b+1) {
	}	
};

int main(int argc, char **argv) {
	InitializerList *il = new InitializerList();
	printf("a=%d, b=%d\n", il->a, il->b);
	return 0;
}
