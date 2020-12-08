import java.util.InputMismatchException;
import java.util.Scanner;

public class MyListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in); // 스캐너 인스턴스 생성
		MyList<Integer> list = new MyList(); // <Integer>형으로 객체 생성
		int menulist;
		while (true) {
			try {
				System.out.print("메뉴 선택 (1=추가 , 2=제거, 3=출력, 0=종료)? ");
				menulist = read.nextInt(); // 메뉴입력
				if (menulist == 1) {
					System.out.print("숫자? ");
					list.add(read.nextInt());
					list.print();
				} else if (menulist == 2) {
					System.out.print("인덱스? ");
					list.delete(read.nextInt());
				} else if (menulist == 3) {
					list.printAll();
				} else if (menulist == 0) {
					break;
				} else // 메뉴에서 벗어난 입력시 예외처리
					throw new WrongMenuError();
			} catch (InputMismatchException e) { // 스캐너에서 정수가 아닌 입력에 대한 예외 처리
				read = new Scanner(System.in);// Scanner 오류를 잡기 위한 인스턴스 초기화
				System.out.println("잘못된 입력 오류! 정수를 입력해주세요.");
			} catch (WrongIndexError e) {
				System.out.println("잘못된 인덱스 오류!");
			} catch (WrongMenuError e) {
				System.out.println("잘못된 메뉴입력 오류!");
			} catch (ListisFullError e) {
				System.out.println("리스트가 가득찼습니다!");
			} catch (ListisEmptyError e) {
				System.out.println("리스트가 비어있습니다!");
			} finally {// try-catch문을 나가기전에 항상 수행
				System.out.println(" ");
			}

		}
		System.out.println("MyList 프로그램을 종료합니다.");
	}

}
