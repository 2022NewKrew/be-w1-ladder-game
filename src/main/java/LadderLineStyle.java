public enum LadderLineStyle {
	HORIZONTAL_LINE("-----"),
	HORIZONTAL_EMPTY("     "),
	VERTICAL_LINE("|"),
	EMPTY("");

	private String shape;

	LadderLineStyle(String shape) {
		this.shape = shape;
	}

	public String getShape() {
		return shape;
	}
}
