
public class PerfectNumber02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		1~10000사이의 완전수(Perfect number)를 구하는 자바프로그램
		완전수(Perfect number) : 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수
		출력 형식 : Perfect number 6 = 1 + 2 + 3
		*/
		
		int sum = 1;
		String beginStr="1 + ";
		String endStr = "";
		
		for(int number=2; number<=10000; number++) {
			for(int div=2; div<=Math.sqrt(number); div++) {
				if(number % div == 0) {
					if(div != (number/div)) {
						sum += div + (number/div);
						beginStr += div + " + ";
						
						if(!endStr.equals("")) {
							endStr = (number/div) + " + "+ endStr;
						}else {
							endStr += number/div;
						}
					} else {
						sum += div;
						beginStr += div + " + ";
					}
				}
			}
			
			if(sum == number) {
				System.out.println("Perfect Number " + number + " = " + beginStr + endStr);
			}
			
			sum = 1;
			beginStr="1 + ";
			endStr = "";
		}		
	}
}
