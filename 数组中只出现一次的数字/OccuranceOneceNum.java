class OccuranceOneceNum {
	public void find(int[] arr) {
		int xorRes = 0;
		for (int i = 0; i < arr.length; i++) {
			xorRes ^= arr[i];
		}

		int notZero = 0;
		while (true) {
			if ((xorRes ^ (1 << notZero)) != 0) {
				break;
			}
			notZero++;
		}
		
		int xorResHalf1 = 0;
		int xorResHalf2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] ^ (1 << notZero)) == 0) {
				xorResHalf1 ^= arr[i];
			} else {
				xorResHalf2 ^= arr[i];
			}
		}
		System.out.println(xorResHalf1);	
		System.out.println(xorResHalf2);
	}

	public static void main(String[] args) {
		int[] arr = {1, 4};
		new OccuranceOneceNum().find(arr);
	}
} 
