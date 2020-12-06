package FigureEditor2020;

public abstract class Figure {
	double width, height; 			// 가로, 세로
	abstract double getArea(); 		// 넓이 구하기
	abstract double getGirth(); 	// 둘레 구하기
	String print() {
		// TODO Auto-generated method stub
		String info = String.format("(너비 = %.1f, 높이 = %.1f, 넓이 = %.1f, 둘레 = %.1f)"
				, this.width, this.height, this.getArea(), this.getGirth());

		return info;
	}
}
