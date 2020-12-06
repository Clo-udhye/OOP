package pack1;

public class ArithmeticExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 CalcXYZ 클래스에 산술식 x, y, z를 계산하는 메소드 calcX(), calcY(), calcZ()를 구현 
		 dataSet (a b c) = (3 4 5), (1 3 2), (2 4 1), (0 8 9), (2 7 2)
		*/
		System.out.printf("(a, b, c)%12s %10s %15s\n\n","calcX", "calcY", "calcZ");
		System.out.printf("(3, 4, 5)%10.3f%15.3f%30.3f\n", CalcXYZ.calcX(3, 4, 5), CalcXYZ.calcY(3, 4, 5), CalcXYZ.calcZ(3, 4, 5));
		System.out.printf("(1, 3, 2)%10.3f%15.3f%15.3f\n", CalcXYZ.calcX(1, 3, 2), CalcXYZ.calcY(1, 3, 2), CalcXYZ.calcZ(1, 3, 2));
		System.out.printf("(2, 4, 1)%10.3f%15.3f%15.3f\n", CalcXYZ.calcX(2, 4, 1), CalcXYZ.calcY(2, 4, 1), CalcXYZ.calcZ(2, 4, 1));
		System.out.printf("(0, 8, 9)%10.3f%15.3f%15.3f\n", CalcXYZ.calcX(0, 8, 9), CalcXYZ.calcY(0, 8, 9), CalcXYZ.calcZ(0, 8, 9));
		System.out.printf("(2, 7, 2)%10.3f%15.3f%15.3f\n", CalcXYZ.calcX(2, 7, 2), CalcXYZ.calcY(2, 7, 2), CalcXYZ.calcZ(2, 7, 2));
		
		//System.out.println(5.0/0); 		//Infinity
		//System.out.println(0.0/0);		//NaN
		//System.out.println(Math.sqrt(-1));//NaN
	}	

}
