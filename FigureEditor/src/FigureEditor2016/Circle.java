package FigureEditor2016;

public class Circle extends Ellipse {
	Circle(double width) {
		this.width = this.height = width;
		alpa = beta = 0.5 * width;
	}

	void print() {
		System.out.print("원  ");
		super.print();
	}
}

