package FigureEditor2016;

import java.util.Scanner;

public class FigureEditor {
		static void arrayPrint(Figure[] A, int L) {
			// 지금까지 배열에 저장된 객체마다 print()함수를 부름, A는 객체가 저장된 배열, L은 만들어진 객체의 갯수
			for (int i = 0; i <= L; i++) {
				System.out.print(i + " : ");
				A[i].print();
			}
		}

		public static void main(String[] args) {
			Scanner read = new Scanner(System.in); // Scanner를 이용한 입력
			int FigureList = 0; // 저장할 배열의 인덱스
			int max = 100; // 도형의 최대 갯수
			Figure[] FigureArray = new Figure[max]; // 객체를 저장할 배열

			while (FigureList < max) {
				System.out.println("Clo-udhye의 도형편집기  □○△ 메뉴");
				System.out.println(" [1] = 직사각형 추가, [2] = 타원 추가, [3] = 이등변삼각형 추가");
				System.out.println(" [4] = 정사각형 추가, [5] = 원 추가, [6] = 정삼각형 추가, [0] = 종료");
				System.out.print("메뉴선택 : ");
				int menulist = read.nextInt(); // 키보드로 입력된 정수값을 read해서 메뉴선택

				if (menulist == 1) {
					System.out.print("직사각형의 가로, 세로? ");
					FigureArray[FigureList] = new Rectangle(read.nextDouble(), read.nextDouble());// 객체생성
					arrayPrint(FigureArray, FigureList);
					FigureList++;
				} else if (menulist == 2) {
					System.out.print("타원의 가로지름, 세로지름? ");
					FigureArray[FigureList] = new Ellipse(read.nextDouble(), read.nextDouble());
					arrayPrint(FigureArray, FigureList);
					FigureList++;
				} else if (menulist == 3) {
					System.out.print("이등변삼각형의 밑변, 높이? ");
					FigureArray[FigureList] = new IsoscelesTriangle(read.nextDouble(), read.nextDouble());
					arrayPrint(FigureArray, FigureList);
					FigureList++;
				} else if (menulist == 4) {
					System.out.print("정사각형의 크기? ");
					FigureArray[FigureList] = new Square(read.nextDouble());
					arrayPrint(FigureArray, FigureList);
					FigureList++;
				} else if (menulist == 5) {
					System.out.print("원의 지름? ");
					FigureArray[FigureList] = new Circle(read.nextDouble());
					arrayPrint(FigureArray, FigureList);
					FigureList++;
				} else if (menulist == 6) {
					System.out.print("정삼각형의 변? ");
					FigureArray[FigureList] = new RegularTriangle(read.nextDouble());
					arrayPrint(FigureArray, FigureList);
					FigureList++;
				} else if (menulist == 0) { // 반복문을 빠져나간다.
					System.out.println("안녕!");
					break;
				} else { // 0~6이외의 숫자 입력시 다음 문장을 출력
					System.out.println("메뉴를 다시 선택해 주세요.");
				}
				System.out.println(" ");
			}
			if (FigureList == max)
				System.out.println("도형의 갯수가 최대입니다! 도형편집기를 종료합니다.");
		}
	}
