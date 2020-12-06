package FigureEditor2016;

public class Ellipse extends Figure {

	double alpa, beta; // alpa, beta는 타원의 장축*0.5과 단축*0.5

	Ellipse() {
		flag = 1;
	}

	Ellipse(double width, double height) {
		this.width = width;
		this.height = height;
		this.alpa = 0.5 * width;
		this.beta = 0.5 * height;
	}

	double getArea() {
		return (Math.PI * alpa * beta);
	}

	double getGirth() {
		return 2 * Math.PI * Math.sqrt((Math.pow(alpa, 2) + Math.pow(beta, 2)) * 0.5);
	}

	void print() {
		if (flag == 0)
			System.out.print("타원  ");
		super.print();
	}
}
