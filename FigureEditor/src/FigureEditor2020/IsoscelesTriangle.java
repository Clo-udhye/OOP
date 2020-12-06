package FigureEditor2020;

public class IsoscelesTriangle extends Figure {
	public IsoscelesTriangle(double width, double height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height * 0.5;
	}

	@Override
	double getGirth() {
		// TODO Auto-generated method stub
		double side = Math.sqrt(Math.pow((this.width/2), 2) + Math.pow(this.height, 2));

		return 2* side + this.width;
	}
}
