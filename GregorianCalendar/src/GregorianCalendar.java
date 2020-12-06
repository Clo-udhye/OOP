import java.util.Scanner;

public class GregorianCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력 : 	1900년 이후의 날짜 (year-month-day): YYYY-MM-DD 
		//출력 : 	1900-01-01부터 날짜수는 X
		//		YYYY-MM-DD의 요일은 X요일
		
		/*
		  Hint
		1900년 1월 1일 부터 날짜수를 세어 요일을 계산한다.
 		입력하는 날짜는 1900년 1월 1일 이후로 한다.
 		1900년 1월 1일은 월요일이다
		  
		4로 나누어 떨어지는 해는 윤년으로 한다.
 		그 중에 100으로 나누어 떨어지는 해는 평년으로 한다.
 		그 중에 400으로 나누어 떨어지는 해는 다시 윤년으로 한다
		*/
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1900년 이후의 날짜 (year-month-day): ");
		String[] inputStr = scanner.nextLine().split("-");
		
		int year = Integer.parseInt(inputStr[0]);
		int month = Integer.parseInt(inputStr[1]);
		int date = Integer.parseInt(inputStr[2]);
		
		if(!GregorianDate.checkDate(year, month, date)) {
			System.out.println("잘못된 날짜 입니다.");
			return;
		}
		GregorianDate gd = new GregorianDate(year, month, date);
		
		System.out.println("1900-01-01부터 날짜수는 " + gd.getDays());
		System.out.printf("%s-%s-%s의 요일은 %s요일\n", inputStr[0], inputStr[1], inputStr[2], gd.getWeekday());
		
	}

}
