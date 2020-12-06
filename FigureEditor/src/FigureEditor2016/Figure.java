package FigureEditor2016;

public abstract class Figure {
	double width, height; // 가로, 세로
	int flag = 0;

	abstract double getArea(); // 넓이 구하기

	abstract double getGirth(); // 둘레 구하기

	void print() {
		System.out.printf("( 너비 = " + "%.1f" + ", 높이 = " + "%.1f" + " , 넓이 = " + "%.1f" + " , 둘레 = " + "%.1f" + " ) ",
				width, height, getArea(), getGirth());
		System.out.println(" "); // 너비, 높이, 넓이, 둘레를 형식에 맞춰 출력
	}
}
