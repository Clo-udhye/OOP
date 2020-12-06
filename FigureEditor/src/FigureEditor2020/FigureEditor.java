package FigureEditor2020;
import java.util.Scanner;

public class FigureEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 추상클래스 Figure 생성
		// double width, height; 		// 가로, 세로
		// abstract double getArea(); 	// 넓이 구하기
		// abstract double getGirth(); 	// 둘레 구하기
		// Figure를 상속하는 6개의 클래스 : 직사각형, 정사각형, 타원, 원, 이등변삼각형, 정삼각형

		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int menu;
		final int MAX_FIGURE = 7;
		int figureCount = 0;
		Figure[] figures = new Figure[MAX_FIGURE];
		double width, height;

		while(run) {
			System.out.println("Clo-udhye의 도형 편집기 □○△ 메뉴");
			System.out.println(" [1] = 직사각형 추가, [2] = 타원 추가, [3] = 이등변삼각형 추가,");
			System.out.println(" [4] = 정사각형 추가, [5] = 원 추가, [6] = 정삼각형 추가, [0] = 종료");

			System.out.print("메뉴 선택? ");
			menu = scanner.nextInt();

			if(menu == 1){
				System.out.print("직사각형의 가로, 세로? ");
				figures[figureCount++] = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
			} else if(menu == 2) {
				System.out.print("타원의 가로지름, 세로지름? ");
				figures[figureCount++] = new Ellipse(scanner.nextDouble(), scanner.nextDouble());
			} else if(menu == 3) {
				System.out.print("이등변삼각형의 밑변, 높이? ");
				figures[figureCount++] = new IsoscelesTriangle(scanner.nextDouble(), scanner.nextDouble());
			} else if(menu == 4) {
				System.out.print("정사각형의 크기? ");
				figures[figureCount++] = new Square(scanner.nextDouble());
			} else if(menu == 5) {
				System.out.print("원의 지름? ");
				figures[figureCount++] = new Circle(scanner.nextDouble());
			} else if(menu == 6) {
				System.out.print("정삼각형의 변? ");
				figures[figureCount++] = new RegularTriangle(scanner.nextDouble());
			} else if(menu == 0) {
				System.out.println("도형 편집기 프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력\n");
				continue;
			}
			for(int i=0; i<figureCount; i++) {
				System.out.print(i+" : ");
				
				if(figures[i] instanceof Square) {
					System.out.print("정사각형 ");
				} else if(figures[i] instanceof Circle) {
					System.out.print("원 ");
				} else if(figures[i] instanceof RegularTriangle) {
					System.out.print("정삼각형 ");
				}else if(figures[i] instanceof Rectangle) {
					System.out.print("직사각형 ");
				} else if(figures[i] instanceof Ellipse) {
					System.out.print("타원 ");
				} else if(figures[i] instanceof IsoscelesTriangle) {
					System.out.print("이등변삼각형 ");
				} 

				System.out.println(figures[i].print());
			}
			System.out.println();

			if(figureCount>=MAX_FIGURE) {
				System.out.println("도형 갯수가 최대입니다. 도형 편집기 프로그램 종료");
				break;
			}
		}
	}
}

