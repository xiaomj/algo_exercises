class BeerBottleExchangeBeer {
	public Integer drink(Integer money, int k) {
		if (money == 0) {
			return 0;
		}
		return money + drink(money / k, k);
	}

	public Integer money(Integer N, int k) {
		int x = 1;
		int y = N;
		while (x < y) {
			int mid = (x + y) / 2;
			if (drink(mid, k) < N) {
				x = mid + 1;
			} else if (drink(mid, k) > N) {
				y = mid - 1;
			} else {
				return mid;
			}	
		}
		return x;
	}
	
	public static void main(String[] args) {
		BeerBottleExchangeBeer bbeb = new BeerBottleExchangeBeer();
		System.out.println(bbeb.drink(bbeb.money(100, 9), 9));
	}
}
