package helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	 public static Rectangle playButton = new Rectangle(240, 100, 100, 37);
	 public static Rectangle helpButton = new Rectangle(240, 180, 100, 37);
	 public static Rectangle quitButton = new Rectangle(240, 260, 100, 37);
	 
	 public static void render(Graphics g){
		 Graphics2D g2 = (Graphics2D) g;
		 Font fnt0 = new Font("Serif", Font.BOLD, 45);
	     Font fnt1 = new Font("Serif", Font.BOLD, 30);
	     Font fnt2 = new Font("Serif", Font.BOLD, 20);
	     g.setFont(fnt0);
	     g.setColor(Color.cyan);
	     g.drawString("Alex's helicopter game", 110, 40);
	     g.setFont(fnt1);
	     g.drawString("Play", playButton.x + 19, playButton.y + 29);
	     g2.draw(playButton);
	     g.setFont(fnt2);
	     g.drawString("Instructions", helpButton.x , helpButton.y + 29);
	     g2.draw(helpButton);
	     g.setFont(fnt1);
	     g.drawString("Quit", quitButton.x + 19, quitButton.y + 29);
	     g2.draw(quitButton);
	     g.setFont(fnt2);
	     g.drawString("1.0",500,380);
	 }

}
