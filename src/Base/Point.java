package Base;

public class Point {
	public final double x;
	public final double y;
	public final double z;
	char displayCharacter;
	boolean flag = false;

	//Constructor for 2D point
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		flag = true;
		z = 1;
	}

	//Constructor for 3D point
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//To set & modify display character
	void setCharacter(char character) {
		displayCharacter = character;
	}

	//To get coordinate value as a string
	public String getCoordinates() {
		long x = Math.round(this.x);
		long y = Math.round(this.y);
		long z = Math.round(this.z);

		if (flag)
			return "(" + x + "," + y + ")";
		else
			return "(" + x + "," + y + "," + z + ")";
	}

	//For testing purposes
	public static void main(String[] args) {
		Point point = new Point(2.235, 3.1234567890123455, 1.03);
		System.out.println(point.getCoordinates());
	}
}