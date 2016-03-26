package helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Instructions {
	public static Rectangle normal = new Rectangle(240, 100, 100, 37);
	public static Rectangle back = new Rectangle(240, 260, 100, 37);
	
	 public static void render(Graphics g){
		 String Title = "Welcome to Alex's game of math";
		 String instructions1 = "instructions: hold the last digit of";
		 String instructions2 = "the solution to the math problem to fly";
		 String instructions3 = "Becareful not to hit the ground";
		 String instructions4 = "or the spikes. 	Have fun!";
		 Graphics2D g2 = (Graphics2D) g;
		 g.setColor(Color.cyan);
		 Font fnt0 = new Font("Serif", Font.BOLD, 35);
		 g.setFont(fnt0);
		 g.drawString(Title, 60, 37);
	     Font fnt1 = new Font("Serif", Font.BOLD, 30);
		 g.setFont(fnt1);
		 g.drawString(instructions1, 70, 100);
		 g.drawString(instructions2, 70, 140);
		 g.drawString(instructions3, 70, 180);
		 g.drawString(instructions4, 70, 220);
	     g.drawString("Back", back.x +19, back.y + 29);
	     g2.draw(back);
	 }
}
