package Lab_Practicals;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;

public class Q4 extends Frame {
	private int r1, r2, r3;

	public Q4() {
		setSize(800, 800);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		add(new Label("Input the radii for circles:"));

		add(new Label("Radius 1:"));
		TextField r1Field = new TextField(3);
		add(r1Field);

		add(new Label("Radius 2:"));
		TextField r2Field = new TextField(3);
		add(r2Field);

		add(new Label("Radius 3:"));
		TextField r3Field = new TextField(3);
		add(r3Field);

		Button submitButton = new Button("Draw");
		add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				r1 = Integer.parseInt(r1Field.getText());
				r2 = Integer.parseInt(r2Field.getText());
				r3 = Integer.parseInt(r3Field.getText());
				repaint();
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(getWidth() / 2, getHeight() / 2);
		g2d.scale(1, -1);
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));

		Arc2D circle1 = new Arc2D.Double(-r1, -r1, 2 * r1, 2 * r1, 0, 360, Arc2D.OPEN);
		g2d.draw(circle1);
		Arc2D circle2 = new Arc2D.Double(-r2, -r2, 2 * r2, 2 * r2, 0, 360, Arc2D.OPEN);
		g2d.draw(circle2);
		Arc2D circle3 = new Arc2D.Double(-r3, -r3, 2 * r3, 2 * r3, 0, 360, Arc2D.OPEN);
		g2d.draw(circle3);
	}

	public static void main(String[] args) {
		Q4 line = new Q4();
		line.setTitle("Q4. Display a series of concentric circles of varying radius");
		line.setVisible(true);
	}
}
