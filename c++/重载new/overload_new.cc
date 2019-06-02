#include <stdlib.h>
#include <stdio.h>

void operator delete(void *p) {
	printf("address to free: %d\n", p);
	free(p);
}

void operator delete[] (void *p) {
	printf("array address to free: %d\n", p);
	free(p);
}

int main(int argc, char **argv) {
	char *p = new char[10];
	delete []p;
	return 0;
}
