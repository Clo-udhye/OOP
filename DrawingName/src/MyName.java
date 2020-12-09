import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class MyName extends JComponent {
	public void paintComponent(Graphics g) {
		try {
			//배경 설정
			Image img;
			img = ImageIO.read(new File("./background.jpeg"));
			g.drawImage(img, 0, 0, getParent().getWidth(), getParent().getHeight(), null);
			
			//이름쓰기 - 박
			Color brown = new Color(205,133,63);
			g.setColor(brown);
			g.fillArc(50, 50, 60, 91, 150,240);
			g.fillRoundRect(60, 137, 100,30,20,20);
			g.fillArc(145, 97, 50, 50, 60, 180);
			g.fillRect(135, 160, 25, 30);
			g.setColor(Color.WHITE);
			g.fillArc(46, 87, 70, 50, 240, 60);
			g.fillArc(135, 178, 25, 25, 0,180);
			g.setColor(Color.BLACK);
			g.fillOval(92, 110, 10, 10);
			g.fillOval(60, 110, 10, 10);
			g.fillArc(71, 120, 20, 20, 60, 60);
			
			//이름쓰기 - 다
			int xPnts[] = {250,300,300,280,280,300,300,250};
			int yPnts[] = {100,100,120,120,150,150,170,170};
			int nPnts = xPnts.length;
			g.setColor(Color.GRAY);
			g.fillPolygon(xPnts,yPnts,nPnts); 
			g.fillArc(222, 100, 40, 40, 60, 120);
			g.setColor(Color.RED);
			g.fillArc(290, 140, 20, 20, 60, 120);
			g.setColor(Color.white);
			g.fillRect(320, 100, 25, 70);
			g.fillOval(308, 85, 25, 25);
			g.fillOval(330, 85, 25, 25);
			g.fillOval(308, 155, 25, 25);
			g.fillOval(330, 155, 25, 25);
			g.fillOval(340, 120, 25, 25);
			g.setColor(Color.BLACK);
			g.fillOval(295, 100, 10, 10);
			g.drawArc(255, 105, 20, 10, 0, 180);
			
			//이름쓰기 - 혜
			g.setColor(Color.DARK_GRAY);
			g.fillOval(400, 100, 80, 80);
			g.fillRect(400, 100, 80, 20);
			g.setColor(Color.WHITE);
			g.drawArc(410, 120, 20, 20, 180, 180);
			g.drawArc(450, 120, 20, 20, 180, 180);
			g.fillOval(433,110,10,10);
			g.fillArc(390, 135, 40, 40, 180, 120);
			g.fillArc(450, 135, 40, 40, 240, 120);
			g.setColor(Color.RED);
			g.fillArc(425, 85, 30, 30, 0, 180);
			int xPnts_2[] = {520,540,540,520,520,500,520,500,520};
			int yPnts_2[] = {90,90,170,170,150,140,130,120,110};
			int nPnts_2 = xPnts_2.length;
			g.fillPolygon(xPnts_2,yPnts_2, nPnts_2);
			g.fillRect(550, 70, 20, 130);
		
		} catch (IOException e) { //배경이미지를 찾지못하면 다음문장을 띄운다.
			Font font = new Font("휴먼둥근헤드라인",Font.BOLD,25);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("Can't found the background image.", 20, 50);
		}
	}	
}
