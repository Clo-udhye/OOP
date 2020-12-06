package FigureEditor2016;

public class Square extends Rectangle {
	Square(double width) { // 서브클래스의 객체 생성시 슈퍼클래스의 기본생성자가 불린다.
		this.width = this.height = width;
	}

	void print() {
		System.out.print("정사각형  ");
		super.print();
	}
}