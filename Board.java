package helicopter;

import java.awt.*;                                                                           
import java.awt.event.*;                                                                     
import java.util.ArrayList;
import java.util.Random;
import helicopter.Board.STATE;
import javax.swing.*;

//This is the main class that runs the game
 
public class Board extends JPanel implements ActionListener
{
	static int state=1;
	Random rand =  new Random();
	private Menu Menu;
	private frame Frame;
	player p=new player();
	ImageIcon i = new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\mario_jump.jpg");
	Image heli=i.getImage();
	public static enum STATE{MENU,GAME,PAUSE,INSTRUCTIONS,DEAD};
	public static STATE State = STATE.MENU;
	Image background;
	Image menubg;
	Image roof;
	Timer time;
	static int timey = 0;
	static int score=0;
	static int counter=0;
	String math = p.calculation();
	boolean drawing=false;
	public Board(){
		this.addMouseListener(new mouseInput());
		Menu = new Menu();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\menu.jpg");
		menubg=i.getImage();
		i = new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\background.png");
		background = i.getImage();
		i= new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\roof.png");
		roof=i.getImage();
		time = new Timer(20,this);
		time.start();
		p.player();
	}
	
	//Updates the game
	public void actionPerformed(ActionEvent e)
	{
		p.move();
		repaint();
	}
	
	//Responsible for graphics throughout the game
	public void paint( Graphics g )
	{
		//draw the menu graphics
		if(State == STATE.MENU)
		{
			state=1;
			g.drawImage(menubg,0,0,null);
			Menu.render(g);
		}
		
		//draw the pause graphics
		if(State == STATE.PAUSE)
		{
			state=4;
			g.drawImage(menubg,0,0,null);
			Pause.render(g);
		}
		
		//draw the instructions graphics
		if(State == STATE.INSTRUCTIONS)
		{
			state=3;
			g.drawImage(menubg,0,0,null);
			Instructions.render(g);
		}
		
		//draw the dead graphics
		if(State == STATE.DEAD)
		{
			state=5;
			g.drawImage(menubg,0,0,null);
			Dead.render(g);
		}
		
		//start the game
		if(State == STATE.GAME)
		{
			player.x = p.getX();
			player.y = p.getY();
			if(timey%50 == 1)
			{
				score++;
			}
			
			if(timey%100 == 1)
			{
				math=p.calculation();
			}
			RemindTask task = new RemindTask();
			task.start();
			if(p.dead==true)
			{
				State=STATE.DEAD;
			}
			
			//this section draws the graphics and updates the math question
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.drawImage(background, -p.nx, 0, null);                                   
            g2.drawImage(background, -p.nx2, 0, null);
            g2.drawImage(roof, 0, 0, null);
            Font fnt1 = new Font("Serif", Font.BOLD, 30);
			g.setFont(fnt1);
			g.setColor(Color.black);
			g2.setColor(Color.GREEN);
			g.drawString("Score:"+score, 240, 100);
			g2.setColor(Color.black);
			g.drawString("question:"+ math, 240, 200);
			if(-p.nx<-575)
			{
            	p.nx=-575;
            }
			
            if(-p.nx>575)
            {
            	p.nx=575;
            }
            
            if(-p.nx2<-575)
            {
            	p.nx2=-575;
            }
            
            if(-p.nx2>575)
            {
            	p.nx2=575;
            }
            
            if(p.nx3>600)
            {
            	p.nx3=0;
            }
            //this is drawing the character as it updates
            g2.drawImage(p.getImage(), p.getX(), p.getY(), null);
		}
	}
	
	//gives the score to other classes
	public static int getscore()
	{
		return score;
	}
	
	//Responsible for recording the player input
	private class AL extends KeyAdapter
	{                                                    
	    public void keyPressed(KeyEvent e)
	    {                                                 
	    	p.keyPressed(e);                                                                 
	    }
	    public void keyReleased(KeyEvent e)
	    {                                                
	        p.keyReleased(e);                                                                
	    }
	}
}
