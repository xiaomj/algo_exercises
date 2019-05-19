public class PrintMatrix {
	public static void internalPrintMatrix(int[][] arr, int startX, int startY, int sizeX, int sizeY) {
		if (sizeX <= 0 || sizeY <= 0) {
			return;
		}
		for (int j = startY; j < startY + sizeY; j++) {
			System.out.println(arr[startX][j]);
		}
		for (int j = startX + 1; j < startX + sizeX; j++) {
			System.out.println(arr[j][startY + sizeY - 1]);
		}
		for (int j = startY + sizeY - 2; j >= startY; j--) {
			System.out.println(arr[startX + sizeX - 1][j]);
		}
		for (int j = startX + sizeX - 2; j >= startX + 1; j--) {
			System.out.println(arr[j][startY]);
		}
		internalPrintMatrix(arr, startX + 1, startY + 1, sizeX - 2, sizeY - 2);
	}

	public static void printMatrix(int[][] arr, int sizeX, int sizeY) {
		internalPrintMatrix(arr, 0, 0, sizeX, sizeY);
	}

	public static void main(String[] args) {
		int[][] arr = {
		{1,2,3},
		{5,6,7},
		{5,6,7},
		{5,6,7},
		};
		printMatrix(arr, 4, 3);
	}
}
