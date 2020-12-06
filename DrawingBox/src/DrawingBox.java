import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingBox extends JPanel {

	int startX, startY, endX, endY, w, h; //startPoint, endPoint, width, height 선언
	Color randColor; //random color를 저장할 변수 선언

	public static void main(String[] args) {
		JFrame f = new JFrame("DrawingBox"); //프레임 이름설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new DrawingBox());//컨텐츠팬설정
		f.setSize(500, 500);
		f.setVisible(true);
	}

	DrawingBox() {
		startX = startY = endX = endY = w = h = 0;
		MyMouseListener listener = new MyMouseListener();// Listener 등록
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public void setStartPoint(int x, int y) { //startPoint 설정
		startX = x;
		startY = y;
	}

	public void setEndPoint(int x, int y) { //endPoint, width, height 설정
		endX = x;
		endY = y;
		w = Math.abs(startX - endX);
		h = Math.abs(startY - endY);
	}

	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256); //0~256 사이의 정수를 랜덤으로 지정
			randColor = new Color(red, green, blue); //랜덤의 매개변수로 컬러 인스턴스 생성 
			setStartPoint(e.getX(), e.getY());//마우스가 눌린 좌표를 startPoint로 설정
		}

		public void mouseDragged(MouseEvent e) {
			setEndPoint(e.getX(), e.getY());//드래그 되는 좌표를 endPoint로 설정
			repaint(); // 패널 그리기 요청
		}

		public void mouseReleased(MouseEvent e) {
			setEndPoint(e.getX(), e.getY());//마우스 버튼이 떼어진 좌표를 endPoint로 설정
			repaint(); // 패널 그리기 요청
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(randColor); //랜덤의 색 지정 
		if (startX > endX && startY > endY) { //endPoint가 startPoint의 왼쪽위에 있을 때 
			g.fillRect(endX, endY, w, h);//색으로 채워진 사각형 그리기
		} else if (startY > endY) {//endPoint가 startPoint의 오른쪽위에 있을 때 
			g.fillRect(startX, endY, w, h);
		} else if (startX > endX) {//endPoint가 startPoint의 왼쪽아래에 있을 때 
			g.fillRect(endX, startY, w, h);
		} else {//endPoint가 startPoint의 오른쪽아래에 있을 때 
			g.fillRect(startX, startY, w, h); 
		}

		g.setColor(Color.RED); // 빨간색 선택
		if (startX > endX && startY > endY) {
			g.drawRect(endX, endY, w, h); //테두리 그리기 (속이 빈 사각형 그리기)
		} else if (startY > endY) {
			g.drawRect(startX, endY, w, h);
		} else if (startX > endX) {
			g.drawRect(endX, startY, w, h);
		} else {
			g.drawRect(startX, startY, w, h); 
		}
	}
}
