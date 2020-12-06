import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawingMyName {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600,400);
		frame.setTitle("DrawingName");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyName component = new MyName();
		frame.add(component);
		frame.setVisible(true);
		

	}

}