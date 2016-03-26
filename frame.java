package helicopter;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

//This class is run first, it creates a board object which runs the game

public class frame {
	public static void main(String args[]){
	JFrame frame = new JFrame("Helicopter");
	ImageIcon img = new ImageIcon("C:\\Users\\Alex\\Pictures\\helicopter\\face.jpg");
	frame.setIconImage(img.getImage());
	frame.getContentPane().add(new Board());
	frame.setSize(600,413);
	frame.setLocationRelativeTo(null); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setVisible(true);
	}
}
