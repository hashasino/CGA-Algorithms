package Lab_Practicals;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Q1 extends Frame {
	private int x1, y1, x2, y2;

	public Q1() {
		setSize(800, 800);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		add(new Label("Input start & end coordinates:"));

		add(new Label("x1"));
		TextField x1Field = new TextField(3);
		add(x1Field);

		add(new Label("y1"));
		TextField y1Field = new TextField(3);
		add(y1Field);

		add(new Label("x2"));
		TextField x2Field = new TextField(3);
		add(x2Field);

		add(new Label("y2"));
		TextField y2Field = new TextField(3);
		add(y2Field);

		Button submitButton = new Button("Draw");
		add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x1 = Integer.parseInt(x1Field.getText());
				y1 = Integer.parseInt(y1Field.getText());
				x2 = Integer.parseInt(x2Field.getText());
				y2 = Integer.parseInt(y2Field.getText());
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

		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(line);
	}

	public static void main(String[] args) {
		Q1 line = new Q1();
		line.setTitle("Q1. 2D Line Drawing as Raster Graphics Display");
		line.setVisible(true);
	}
}
