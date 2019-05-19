#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <vector>
#include <algorithm>
#include <pthread.h>

#define MAX_SIZE 100

template<typename T>
class hash_table {
private:	
	std::vector<T> li[MAX_SIZE];
	pthread_mutex_t lock;

public:
	hash_table() {
		pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
	}

	void insert(T t) {
		pthread_mutex_lock(&lock);
		if (query(t) == 1) {
			pthread_mutex_unlock(&lock);
			return;
		}
		int idx = t % MAX_SIZE;
		li[idx].push_back(t);
		pthread_mutex_unlock(&lock);
	}

	int query(T t) {
		pthread_mutex_lock(&lock);
		int idx = t % MAX_SIZE;
		if (std::find(li[idx].begin(), li[idx].end(), t) == li[idx].end()) {
			pthread_mutex_unlock(&lock);
			return 0;
		}
		pthread_mutex_unlock(&lock);
		return 1;
	}
};

int main(int argc, char *argv[]) {
	hash_table<int> ht;
	ht.insert(1);
	ht.insert(2);
	ht.insert(3);
	ht.insert(4);
	printf("%d\n", ht.query(5));
	printf("%d\n", ht.query(4));
	printf("%d\n", ht.query(1));
}
