#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int read_int(FILE * fp, int offset) {
	fseek(fp, offset * sizeof(int), SEEK_SET);
	int data = 0;
	fread(&data, sizeof(int), 1, fp);
	return data;
}

void write_int(FILE *fp, int offset, int data) {
	fseek(fp, offset * sizeof(int), SEEK_SET);
	fwrite(&data, sizeof(int), 1, fp);
}

FILE *temp_fd;

void copy(FILE *src_fd, int start, FILE *dst_fd, int start2, int size) {
	for (int i = 0; i < size; i++) {
		write_int(dst_fd, start2 + i, read_int(src_fd, start + i));
	}	
}

void merge(FILE *fd, int start, int end, int start2, int end2) {
	int a; 
	int b; 
	int z = 0;
	int i = start;
	int j = start2;
	while (i <= end && j <= end2) {
		a = read_int(fd, i);
		b = read_int(fd, j);

		if (a < b) {
			write_int(temp_fd, z++, a);
			i++;
		} else {
			write_int(temp_fd, z++, b);
			j++;
		}
	}
	while (i <= end) {
		a = read_int(fd, i++);
		write_int(temp_fd, z++, a);
	}
	while (j <= end2) {
		b = read_int(fd, j++);
		write_int(temp_fd, z++, b);
	}
	copy(temp_fd, 0, fd, start, z);	
}

void merge_sort(FILE *fd, int start, int end) {
	if (start >= end) {
		return;
	}
	int mid = (start + end) / 2;
	merge_sort(fd, start, mid);
	merge_sort(fd, mid + 1, end);
	merge(fd, start, mid, mid + 1, end);
}

int main(int argc, char *argv[]) {
	temp_fd = fopen(".tmp", "wb+");
	FILE *fp = fopen(".data.bin", "wb+");

	srand(time(NULL));
	for (int i = 0; i <= 1000; i++) {	
		write_int(fp, i, rand() % 10000);
	}
	merge_sort(fp, 0, 1000);		
	for (int i = 0; i <= 1000; i++) {	
		printf("%d\n", read_int(fp, i));
	}
}
