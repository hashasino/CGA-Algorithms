import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class PolygonGenerator extends JFrame {
	private final int numberOfSides;
	private final double sideLength;

	public PolygonGenerator(int numberOfSides, double sideLength) {
		this.numberOfSides = numberOfSides;
		this.sideLength = sideLength;

		setTitle("Regular Polygon");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Calculate the center of the frame
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;

		// Calculate the radius of the circumscribed circle
		double radius = (sideLength / (2 * Math.sin(Math.PI / numberOfSides)));

		// Create a path for the polygon
		Path2D path = new Path2D.Double();

		for (int i = 0; i < numberOfSides; i++) {
			// Calculate the angle for each vertex
			double angle = 2 * Math.PI * i / numberOfSides;

			// Calculate vertex coordinates
			double x = centerX + radius * Math.cos(angle);
			double y = centerY + radius * Math.sin(angle);

			if (i == 0) {
				path.moveTo(x, y);
			} else {
				path.lineTo(x, y);
			}
		}

		path.closePath();

		// Draw the polygon
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(path);
	}

	public static void main(String[] args) {
		// Example usage with 6 sides and side length of 100
		SwingUtilities.invokeLater(() -> {
			PolygonGenerator polygon = new PolygonGenerator(6, 100);
			polygon.setVisible(true);
		});
	}
}