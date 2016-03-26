package helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pause {
	 public static Rectangle playButton = new Rectangle(240, 100, 100, 37);
	 public static Rectangle quitButton = new Rectangle(240, 260, 100, 37);
	 
	 public static void render(Graphics g){
		 Graphics2D g2 = (Graphics2D) g;
		 g.setColor(Color.cyan);
		 Font fnt1 = new Font("Serif", Font.BOLD, 30);
		 g.setFont(fnt1);
		 g.drawString("Resume", playButton.x , playButton.y + 29);
	     g2.draw(playButton);
	     g.drawString("Quit", quitButton.x + 19, quitButton.y + 29);
	     g2.draw(quitButton);
	}
}
