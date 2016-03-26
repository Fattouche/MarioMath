package helicopter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import helicopter.Board.STATE;

//responsible for the player mechanics/physics
public class player {
	/*
	 * x is the players x location
	 * y is the players y location
	 * dx is the players change in x location
	 * dy is the players change in y location
	 * nx,nx2,nx3 are for updating the background
	 */
	static int x,y,dx,dy,nx,nx2,nx3;
	
	Image player;
	static boolean dead=false;
	ImageIcon playerFalling = new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\falling.png");
	ImageIcon playerFlying = new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\jumping.jpg");
	int distance;
	static int buttonPressed=0;
	static int operation;
	public void player(){
		//starts with the image of the player falling
		player = playerFalling.getImage();
		x=5;
		y=150;
		nx=0;
		nx2=-575;
		nx3=0;
		distance=0;
	}
	
	//the main method for character physics
	public void move(){
		dx=3;
		y=y+dy;
		//gives the user time to think before the character starts falling
		if(distance<50){
			dy=1;
		}
		//if the spikes or ground gets hit the player will die
		if(y<75||y>285){
			dead=true;
		}
		//the next 3 methods update the background when in game
		if(x>0 && x<300){
			x=x+dx;
			nx=nx+dx;
			nx2=nx2+dx;
			nx3=nx3+dx;
		}
		if(x<=0){
			x=1;
			nx=nx+(dx*(int)0.5);
			nx3=nx3+dx;
			nx2=nx2+(dx*(int)0.5);
		}
		if(x>=300){
			x=300;
			nx=nx+(dx*(int)0.5);
			nx3=nx3+dx;
		    nx2 = nx2+(dx*(int)0.5); 
		}
		if(dx>0){
			distance++;
		}
		if(dx<0){
			distance--;
		}
		if(distance>104){
			x=299;
		}
	}
	public static int getX(){
		return x;
	}
	public static int getY(){
		return y;
	}
	public Image getImage() {
		return player; 
	} 
	
	//if the keys are released the player will start falling
	public void keyReleased(KeyEvent e) {                                                    
        int key = e.getKeyCode(); 
        player = playerFalling.getImage();
        if(key==KeyEvent.VK_1||key==KeyEvent.VK_2||key==KeyEvent.VK_3||key==KeyEvent.VK_4||key==KeyEvent.VK_5||key==KeyEvent.VK_6||key==KeyEvent.VK_7||key==KeyEvent.VK_8||key==KeyEvent.VK_9||key==KeyEvent.VK_0)
        	dy=2;
	}
	public static int getCalculation(){
		return operation;
	}
	
	//responsible for generating random math calculations
	public String calculation(){
		Random rand = new Random();
		int num1 = rand.nextInt(10)+1;
		int num2 = rand.nextInt(10)+1;
		String calculation="null";
		if(num1%2==0&&num2%2==0){
			operation = num1+num2;
			calculation=Integer.toString(num1)+"+"+Integer.toString(num2);
		}
		if(num1%2==0&&num2%2!=0){
			if(num1>num2){
				operation = num1-num2;
				calculation=Integer.toString(num1)+"-"+Integer.toString(num2);
			}
			if(num2>num1){
				operation = num2-num1;
				calculation=Integer.toString(num2)+"-"+Integer.toString(num1);
			}
		}
		if(num1%2!=0&&num2%2==0){
			if(num1>num2){
				operation = num1/num2;
				calculation=Integer.toString(num1)+"/"+Integer.toString(num2);
			}
			if(num2>num1){
				operation = num2/num1;
				calculation=Integer.toString(num2)+"/"+Integer.toString(num1);
			}
		}
		if(num1%2!=0&&num2%2!=0){
			operation = num1*num2;
			calculation=Integer.toString(num1)+"*"+Integer.toString(num2);
		}
		return calculation;
	}
	
	//if the correct number has been pressed the character will fly upwards
	public void keyPressed(KeyEvent e) {    
		buttonPressed = e.getKeyCode()-48;
		//the game uses modulo 10 to get the last digit of the solution to the math problem
		if(buttonPressed==getCalculation()%10){
			player = playerFlying.getImage();
			dy=-2;
		}
		
		//if escape is pressed then pause the game
		  if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
	        	Board.State = STATE.PAUSE;
	        	dy=0;
	       }
	}
}
