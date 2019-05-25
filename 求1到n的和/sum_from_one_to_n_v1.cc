#include <stdio.h>

class SumFromOneToNV1 {
public:
	static int sum;

	SumFromOneToNV1()	{
		sum++;
	}
};

int SumFromOneToNV1::sum = 0;

int main(int argc, char **argv) {
	SumFromOneToNV1 *p = new SumFromOneToNV1[10];
	printf("%d\n", SumFromOneToNV1::sum);
}
