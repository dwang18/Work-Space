
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private BallClass ball;
	private ArrayList<BallClass> BallArray;
	
	public WalkingFrame()
	{
		setBounds(100,100,600,400);
		setLayout(null);
		man = new Man(0,0);
		add(man);
		ball = new BallClass(0,0);
		Timer timer = new Timer(5, this);
		timer.start();
		BallArray = new ArrayList<>();
		addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode()== e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode()== e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode()== e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode()== e.VK_D)
						{
							man.setDX(2);
						}
						if(e.getKeyCode()== e.VK_SPACE)
						{
							BallClass balltemp = new BallClass(man.getX(),man.getY());
							BallArray.add(balltemp);
							add(balltemp);
						}

					}

					@Override
					public void keyReleased(KeyEvent e) 
					{
						if(e.getKeyCode()== e.VK_W)
						{
							man.setDY(0);
						}
						if(e.getKeyCode()== e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode()== e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode()== e.VK_D)
						{
							man.setDX(0);
						}
						
					}

					@Override
					public void keyTyped(KeyEvent e) 
					{
						
						
					}
					
				});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new WalkingFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		man.update();
		for(int j = 0; j<BallArray.size(); j++)
		{
			BallArray.get(j).update();
			if (BallArray.get(j).getX() > 600)
			{
				remove(BallArray.get(j));
				BallArray.remove(j);
				j--;
			}
		}
		repaint();
		
	}
}
