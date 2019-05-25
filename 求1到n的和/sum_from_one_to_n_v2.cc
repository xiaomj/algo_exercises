#include <stdio.h>

template<int n>
class SumFromOneToNV2 {
public:
	enum { sum = SumFromOneToNV2<n-1>::sum + 1};
};

template<>
class SumFromOneToNV2<0> {
public:
	enum { sum = 0 };
};

int main(int argc, char **argv) {
	printf("%d\n", SumFromOneToNV2<100>::sum);
}
