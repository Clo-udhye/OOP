package FigureEditor2016;

public class Rectangle extends Figure {
	Rectangle() { // 기본생성자가 불리면 flag를 1로 초기화
		flag = 1;
	};

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	double getArea() {
		return (width * height);
	}

	double getGirth() {
		return 2 * (width + height);
	}

	void print() {
		if (flag == 0) // 기본생성자로 생성된 객체가 아니면 다음 문장을 출력
			System.out.print("직사각형  ");
		super.print();// Figure의 print()메소드 호출
	}
}
