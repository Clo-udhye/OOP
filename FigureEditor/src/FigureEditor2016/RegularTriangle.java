package FigureEditor2016;

public class RegularTriangle extends IsoscelesTriangle {
	RegularTriangle(double width) {
		this.width = hypotenuse = width;
		this.height = Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(width * 0.5, 2));
	}

	void print() {
		System.out.print("정삼각형  ");
		super.print();
	}
}