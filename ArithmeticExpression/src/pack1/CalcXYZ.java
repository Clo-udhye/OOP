package pack1;

public class CalcXYZ {
	static double calcX(int a, int b, int c) {
		double result = (b*(-1) + Math.sqrt(Math.pow(b, 2) - (4*a*c))) / (2 * a); 	
		return result;
	}
	static double calcY(int a, int b, int c) {
		double result = Math.pow(3, a) + Math.pow(4, b) - (5*c);
		return result;
	}
	static double calcZ(int a, int b, int c) {
		double result = Math.abs(Math.pow(a, 2) - Math.pow(b, Math.pow(2, c)));
		return result;
	}
}