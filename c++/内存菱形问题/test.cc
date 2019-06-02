class Base {
	virtual f() {
		printf("base.f()\n");
	}
}

class Mid1: public Base {
}

class Mid2: public Base {
}

class Child: public Mid1, Mid2 {
}	
