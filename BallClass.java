import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BallClass extends JComponent
{
	private int dy = 0;
	private int dx = 4;
	public BallClass(int x, int y)
	{
		setLocation(x,y);
		setSize(8,8);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(0, 0, 8, 8);
		g2.fill(ball);
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}
