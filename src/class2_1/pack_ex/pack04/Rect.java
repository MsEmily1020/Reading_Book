package class2_1.pack_ex.pack04;

class Rect {
	private int width;
	private int height;

	public Rect(int w, int h) {
		this.width = w;
		this.height = h;
	}

	public boolean equals(Object obj) {
		Rect p = (Rect)obj;

		if(width * height == p.width * p.height)
			return true;
		else return false;
	}
}
