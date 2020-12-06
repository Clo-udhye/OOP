
public class PerfectNumber01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * 1~10000사이의 완전수(Perfect number)를 구하는 자바프로그램
		완전수(Perfect number) : 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수
		출력 형식 : Perfect number 6 = 1 + 2 + 3
		 */

		int perfectNum, sum=0, divCount=0;//sum은 약수의 합, divCount은 약수의 개수를 저장하는 변수
		for (perfectNum=2; perfectNum <= 10000; perfectNum++){
			for (int i=2; i<=Math.sqrt(perfectNum); i++){ 
				//perfectNum의 루트 만큼 반복하여 자기자신과 sum이 같은 수 perfectNum을 찾는다. 
				if (perfectNum%i==0){
					sum = sum+i+(perfectNum/i);
					divCount+=2;
				}
			}
			
			// 1은 모든 수의 약수
			sum++;
			divCount++;
			
			if (sum==perfectNum){ //완전수를 찾으면 약수의 개수 크기의 배열을 생성한다. 
				int div[] = new int[divCount];
				div[0] = 1; //1은 모든 수의 약수
				int d =2, index=1;
				for(int i=1;i<=Math.sqrt(perfectNum); i++){//약수를 찾아  배열에 저장
					if(perfectNum%d==0){
						div[index] = d;
						div[divCount-index] = perfectNum/d;
						index++;
					}
					d++;
				}
				//출력
				System.out.print("Perfect number " + perfectNum + " = ");
				for (int i=0; i<divCount; i++){
					if(i!=divCount-1)
						System.out.print(div[i] + " + " );
					else
						System.out.println(div[i]);
				}
			}
			sum=0; //초기화
			divCount=0;
		}

	}

}
