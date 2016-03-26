package helicopter;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import helicopter.Board.STATE;

//this class changes the game state depending on what area of the screen has been clicked
public class mouseInput implements MouseListener
{
	public void mousePressed(MouseEvent e)
	{
        int mx = e.getX();
        int my = e.getY();

        //if at the start menu
        if(mx>=240 && mx<=340&& Board.state==1)
        {
        	//starts the game
            if(my>=100 && my<=137)
            {
                Board.State = Board.STATE.GAME;
            }
            
            //goes to the instructions
            if(my>=180 && my<=207)
            {
                Board.State=Board.STATE.INSTRUCTIONS;
            }
            
            //quits the game
            if(my>=260 && my<=297)
            {
                System.exit(1);
            }
        }
        //if at the instructions menu
        if(mx>=240 && mx<=340&& Board.state==3)
        {
        	//goes back to the start menu
            if(my>=260 && my<=297) 
            {
            	Board.State = STATE.MENU;
            }
        }
        
        //if paused
        if(mx>=240 && mx<=340&& Board.state==4)
        {
        	//resumes game
            if(my>=100 && my<=137)
            {
                Board.State = STATE.GAME;
                player.dy=1;
            }
            //goes to instructions
            if(my>=180 && my<=207)
            {
                Board.State=Board.STATE.INSTRUCTIONS;
            }
            //quits the game to main menu
            if(my>=260 && my<=297)
            {
            	Board.State = STATE.MENU;
            }
        }
        //if dead
        if(mx>=240 && mx<=340&& Board.state==5)
        {
        	//restarts the game (Doesn't work very well)
            if(my>=180 && my<=207) 
            {
            	Board.score=0;
            	player.dead=false;
            	player.y=150;
            	player.x=5;
                Board.State=Board.STATE.GAME;
            }
            
            //quits the game
            if(my>=260 && my<=297)
            {
                System.exit(1);
            }
        }
        
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
	
}
