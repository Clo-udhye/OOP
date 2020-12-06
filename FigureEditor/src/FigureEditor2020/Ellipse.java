package FigureEditor2020;

public class Ellipse extends Figure {
	
	public Ellipse(double width, double height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		double alpa = this.width/2;
		double beta = this.height/2;
		return Math.PI*(alpa)*(beta);
	}

	@Override
	double getGirth() {
		// TODO Auto-generated method stub
		double alpa = this.width/2;
		double beta = this.height/2;
		return Math.sqrt((Math.pow(alpa,2) + Math.pow(beta, 2)) / 2) * 2 * Math.PI;
	}
}
