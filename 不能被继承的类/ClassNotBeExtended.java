class ClassNotBeExtended {
	private ClassNotBeExtended() {
	}
}

class SubClass extends ClassNotBeExtended {
	public static void main(String[] args) {
		new SubClass();
	}
}
