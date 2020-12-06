
public class GregorianDate {
	private int year;
	private int month;
	private int date;
	
	public GregorianDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	static boolean checkDate(int year, int month, int date) {
		if(year<1900) {
			return false;
		}
		if(month == 4 || month == 6 || month == 9 || month ==11) {
			if(date>30) {
				return false;
			}
		} else if(month == 2){
			if(isLeapyear(year)) {
				if(date>29) {
					return false;
				}
			} else {
				if(date>28) {
					return false;
				}
			}
		}else {
			if(date>31) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isLeapyear(int year) {
		/*
		 * 4로 나누어 떨어지는 해는 윤년으로 한다.
 		그 중에 100으로 나누어 떨어지는 해는 평년으로 한다.
 		그 중에 400으로 나누어 떨어지는 해는 다시 윤년으로 한다
		 * */
		if((year%4==0 && year%100!=0)||year%400==0 ) {
			return true;
		}
		return false;
	}
	
	String getWeekday() {
		String[] weekday = {"일", "월", "화", "수", "목", "금", "토"};
		return weekday[(getDays()%7)];
	}
	
	int getDays() {
		int days = (this.year-1900)*365;
		
		//지금까지의 윤년횟수 계산 
		int leapYearCount = 0;
		
		for(int y=1900; y<this.year; y++) {
			if((y%4==0 && y%100!=0)||y%400==0 ) {
				leapYearCount++;
			}
		}
		
		days += leapYearCount;
		
		for(int m=1; m<this.month; m++) {
			if(m == 4 || m == 6 || m == 9 || m ==11) {
				days += 30;
			} else if(m == 2) {
				if(GregorianDate.isLeapyear(this.year)) {
					days += 29;
				} else {
					days += 28;
				}
			} else {
				days += 31;
			}
		}
		
		days += this.date;
		return days;
	}
	
}
