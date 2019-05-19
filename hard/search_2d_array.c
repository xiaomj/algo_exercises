#include <stdio.h>
#include <stdlib.h>

int search_2d(int arr[][], int sx, int sy, int ex, int ey, int target) {
	if (sx < ex || sy < ey) {
		return 0;
	}

	int midx = (sx + ex) / 2;
	int midy = (sy + ey) / 2;

	int left_down = arr[sx][midy];
	int right_up = arr[midx][sy];
	int right_down = arr[midx][midy];
	
	if (target == right_down || target == left_up || target == left_down) {
		return 1;
	}	
	
	if (target > right_down) {
		return search_2d(arr, midx, ex, midy, ey, target);
	}
	if (target < left_up && target < left_down) {
		return search_2d(arr, sx, sy, midx, midy, target);
	}
	return search_2d(arr, sx, sy, midx, midy, target) || search_2d(arr, midx, sy, sx, midy, target) || 
		search_2d(arr, sx, midy, midx, midy, target); 
}

int main(int argc, char **argv) {
}
