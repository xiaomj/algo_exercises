#include <stdio.h>
#include <stdlib.h>
#include <string.h>


class parent {
public:
	int a;

public:
	parent() {
		a = 2;
	}
	virtual int getA() {
		return a;
	}	
};

class child: public parent {
public:
	int a;

public:
	child(): parent() {
		a = 1;
	}
	virtual int getA() {
		return a;
	}
};

int main(int argc, char **argv) {
	child *ch = new child;
	parent *p = (parent *) ch;
	printf("%d\n", ch->a);
	printf("%d\n", p->a);
	printf("%d\n", ch->getA());
	printf("%d\n", p->getA());

	child c;
	parent p2 = (parent) c;
	
	printf("%d\n", &c);
	printf("%d\n", &p2);
	printf("%d\n", c.getA());
	printf("%d\n", p2.getA());
	return 0;
}	
