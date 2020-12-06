package FigureEditor2020;

public class Rectangle extends Figure {
	public Rectangle(double width, double height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

	@Override
	double getGirth() {
		// TODO Auto-generated method stub
		return (this.width + this.height) * 2;
	}
}
