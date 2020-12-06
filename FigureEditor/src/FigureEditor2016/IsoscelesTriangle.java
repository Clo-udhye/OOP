package FigureEditor2016;

public class IsoscelesTriangle extends Figure {
	double hypotenuse; // 삼각형의 빗변의 길이

	IsoscelesTriangle() {
		flag = 1;
	}

	IsoscelesTriangle(double width, double height) {
		this.width = width;
		this.height = height;
		hypotenuse = Math.sqrt(Math.pow((width) * 0.5, 2) + Math.pow(height, 2));
	}

	double getArea() {
		return 0.5 * (width * height);
	}

	double getGirth() {
		return (2 * hypotenuse) + width;
	}

	void print() {
		if (flag == 0)
			System.out.print("이등변삼각형  ");
		super.print();
	}
}