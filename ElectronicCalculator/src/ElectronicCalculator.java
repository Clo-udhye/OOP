import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ElectronicCalculator extends JFrame {

	double pre = 0, curr = 0; // 첫번째 입력된 숫자와 두번째 입력된 숫자를 저장하는 변수
	double curr_buff = 0, pre_buff = 0; // 직전에 저장한 숫자를 저장하는 변수와
										// 현재까지 입력된 숫자들을 계산한 값을 가지는 변수
	String number_Text; // 현재 스크린에 떠있는 숫자들을 저장할 문자열 변수
	int operator = 0, operator_buff = 0; // 연산자를 저장하는 변수와 직전의 연산자를 저장하는 변수

	int dot_flag = 0; // 소수점버튼을 눌렀는지 확인하는 플래그 변수
	int equal_flag = 0;// 엔터버튼을 눌렀는지 확인하는 플래그 변수

	Label screen1 = new Label("0", Label.RIGHT);// 현재수와 계산된수를 보여줄 라벨
	Label screen2 = new Label("", Label.RIGHT); // 엔터버튼을 누르기 전까지의 숫자와 연산을 보여줄 라벨

	Color myred = new Color(255, 113, 113); // 버튼 색지정을 위한 Color 객체
	Color myyellow = new Color(255, 246, 18);
	Color mygreen = new Color(171, 242, 0);
	Font font = new Font("맑은고딕", Font.PLAIN, 40); // 버튼과 스크린의 폰트를 지정

	int X = 20, Y = 200; // 컴포넌트의 위치를 정할때 쓰이는 변수
	int width = 100, height = 100; // 기본 버튼의 크기

	ElectronicCalculator() {
		setTitle("자바계산기  - 박다혜");
		setSize(560, 780); // 프레임 사이즈 결정

		Container contentPane = getContentPane(); // 현재 컨텐츠팬을 get
		contentPane.setLayout(null); // 레이아웃 매니저를 null로 지정해 버튼의 위치를 개별로 설정

		screen1.setBounds(20, 50, 5 * (width + 5) - 5, height * 2 - 70); // 컴포넌트위치설정구문
		screen1.setBackground(Color.WHITE); // 컴포넌트 색 지정 구문
		contentPane.add(screen1); // 컨텐츠팬에 부착하는 구문
		screen1.setFont(font); // 폰트지정 구문

		screen2.setBounds(20, 20, 5 * (width + 5) - 5, 30);
		screen2.setBackground(Color.WHITE);
		contentPane.add(screen2);
		screen2.setFont(font);

		JButton c = new JButton("C"); // 현재까지의 연산을 모두 초기화
		c.setBounds(X, Y, width, height);
		c.setBackground(myred);
		contentPane.add(c);
		c.setFont(font);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pre = 0;
				curr = 0;
				curr_buff = 0;
				pre_buff = 0;
				operator = 0;
				operator_buff = 0;
				equal_flag = 0;
				dot_flag = 0;

				screen1.setText("0");
				screen2.setText("");
			}
		});

		JButton ce = new JButton("CE"); // 현재 입력하고 있는 수를 초기화
		ce.setBounds(X + width + 5, Y, width, height);
		ce.setBackground(myred);
		contentPane.add(ce);
		ce.setFont(font);
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curr = 0;
				curr_buff = 0;
				screen1.setText("0");
				if (operator == -1) { // 연산이 끝난 후에 누르면 c와 같은 기능을 한다.
					curr_buff = 0;
					pre_buff = 0;
					operator = 0;
					operator_buff = 0;
					equal_flag = 0;
					dot_flag = 0;
				}
			}
		});

		JButton delete = new JButton("<"); // 현재 입력하고 있는 수의 한글자 지우기
		delete.setBounds(X + 2 * (width + 5), Y, width, height);
		delete.setBackground(myred);
		contentPane.add(delete);
		delete.setFont(font);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number_Text = screen1.getText();
				curr = Double.parseDouble(number_Text);// 현재 스크린의 숫자를 curr에 받아옴

				if (curr == (int) curr) // 소수점자리가 없을 때
					screen1.setText(Integer.toString((int) curr / 10)); // 10으로
																		// 몫 나눗셈

				else {// 소수점자리가 있을 때
					int number_Text_length = screen1.getText().length();
					number_Text = number_Text.substring(0, number_Text_length - 1);// 스크린의문자열의가장마지막을지운다.
					curr = Double.parseDouble(number_Text);// 현재 수를 curr
					if (curr == (int) curr) // 소수점 자리가 없어지면 int형으로 출력
						screen1.setText(Integer.toString((int) curr));
					else
						screen1.setText(Double.toString(curr));
				}
			}
		});

		JButton mult = new JButton("×"); // 곱하기 버튼
		mult.setBounds(X + 3 * (width + 5), Y, width, height);
		mult.setBackground(myyellow);
		contentPane.add(mult);
		mult.setFont(font);
		mult.addActionListener(new OperationListener()); // 리스너로OperationListener()를등록

		JButton div = new JButton("÷"); // 나누기 버튼
		div.setBounds(X + 4 * (width + 5), Y, width, height);
		div.setBackground(myyellow);
		contentPane.add(div);
		div.setFont(font);
		div.addActionListener(new OperationListener());

		JButton minus = new JButton("－"); // 빼기 버튼
		minus.setBounds(X + 3 * (width + 5), height + Y + 5, 2 * width + 5, height);
		minus.setBackground(myyellow);
		contentPane.add(minus);
		minus.setFont(font);
		minus.addActionListener(new OperationListener());

		JButton plus = new JButton("＋"); // 더하기 버튼
		plus.setBounds(X + 3 * (width + 5), Y + 2 * (height + 5), 2 * width + 5, height);
		plus.setBackground(myyellow);
		contentPane.add(plus);
		plus.setFont(font);
		plus.addActionListener(new OperationListener());

		JButton equal = new JButton("＝"); // 엔터 버튼
		equal.setBounds(X + 3 * (width + 5), +Y + 3 * (height + 5), 2 * width + 5, 2 * height + 5);
		equal.setBackground(mygreen);
		contentPane.add(equal);
		equal.setFont(font);
		equal.addActionListener(new ActionListener() { // 액션 리스너를 익명클래스로 등록
			public void actionPerformed(ActionEvent e) {
				if (equal_flag == 0) { // 엔터 버튼을 한번 만 누를 때
					if (operator == 1)
						pre_buff *= curr;
					else if (operator == 2)
						pre_buff /= curr;
					else if (operator == 3)
						pre_buff -= curr;
					else if (operator == 4)
						pre_buff += curr;
					else // 연산자를 안눌렀을 때
						pre_buff = curr;

				} else { // 엔터버튼을 여러번 연속해서 누를 때
					if (operator_buff == 1)
						pre_buff *= curr_buff;
					else if (operator_buff == 2)
						pre_buff /= curr_buff;
					else if (operator_buff == 3)
						pre_buff -= curr_buff;
					else if (operator_buff == 4)
						pre_buff += curr_buff;
				}
				if (pre_buff == (int) pre_buff) // 계산된 값을 int형으로 출력
					screen1.setText(Integer.toString((int) pre_buff));
				else // double형으로 출력
					screen1.setText(Double.toString(pre_buff));
				screen2.setText(""); // screen2를 초기화
				operator = -1; // 연산자 초기화
				dot_flag = 0; // 소수점 플래그 초기화
				equal_flag = 1; // 엔터버튼을 누른것을 표시
				curr = 0; // 현재수를 0으로 초기화
			}
		});

		// 0제외한 숫자 버튼 NumberListener()를 리스너로 등록
		JButton seven = new JButton("7");
		seven.setBounds(X, Y + height + 5, width, height);
		seven.setBackground(Color.WHITE);
		contentPane.add(seven);
		seven.setFont(font);
		seven.addActionListener(new NumberListener());

		JButton eight = new JButton("8");
		eight.setBounds(X + width + 5, Y + height + 5, width, height);
		eight.setBackground(Color.WHITE);
		contentPane.add(eight);
		eight.setFont(font);
		eight.addActionListener(new NumberListener());

		JButton nine = new JButton("9");
		nine.setBounds(X + 2 * (width + 5), Y + height + 5, width, height);
		nine.setBackground(Color.WHITE);
		contentPane.add(nine);
		nine.setFont(font);
		nine.addActionListener(new NumberListener());

		JButton four = new JButton("4");
		four.setBounds(X, Y + 2 * (height + 5), width, height);
		four.setBackground(Color.WHITE);
		contentPane.add(four);
		four.setFont(font);
		four.addActionListener(new NumberListener());

		JButton five = new JButton("5");
		five.setBounds(X + width + 5, Y + 2 * (height + 5), width, height);
		five.setBackground(Color.WHITE);
		contentPane.add(five);
		five.setFont(font);
		five.addActionListener(new NumberListener());

		JButton six = new JButton("6");
		six.setBounds(X + 2 * (width + 5), Y + 2 * (height + 5), width, height);
		six.setBackground(Color.WHITE);
		contentPane.add(six);
		six.setFont(font);
		six.addActionListener(new NumberListener());

		JButton one = new JButton("1");
		one.setBounds(X, Y + 3 * (height + 5), width, height);
		one.setBackground(Color.WHITE);
		contentPane.add(one);
		one.setFont(font);
		one.addActionListener(new NumberListener());

		JButton two = new JButton("2");
		two.setBounds(X + width + 5, Y + 3 * (height + 5), width, height);
		two.setBackground(Color.WHITE);
		contentPane.add(two);
		two.setFont(font);
		two.addActionListener(new NumberListener());

		JButton three = new JButton("3");
		three.setBounds(X + 2 * (width + 5), Y + 3 * (height + 5), width, height);
		three.setBackground(Color.WHITE);
		contentPane.add(three);
		three.setFont(font);
		three.addActionListener(new NumberListener());

		JButton zero = new JButton("0"); // 0버튼
		zero.setBounds(X, Y + 4 * (height + 5), 2 * width + 5, height);
		zero.setBackground(Color.WHITE);
		contentPane.add(zero);
		zero.setFont(font);
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 익명클래스로 리스너를 등록
				if (operator == -1) { // 엔터 버튼 후, 다른 식을 연산 하기 위해 초기화
					pre = 0;
					curr = 0;
					screen1.setText("0");
					screen2.setText("");
					operator = 0;
				}
				number_Text = screen1.getText();
				if (dot_flag == 0) { // 소수점버튼을 누르지 않았을때
					curr = Integer.parseInt(number_Text) * 10;
					screen1.setText(Integer.toString((int) curr));
				} else {// 소수점버튼을 눌렀을 때
					number_Text += "0";
					screen1.setText(number_Text);
					curr = Double.parseDouble(number_Text);
				}
				curr_buff = curr;
			}
		});

		JButton dot = new JButton("."); // 소수점 버튼
		dot.setBounds(X + 2 * (width + 5), Y + 4 * (height + 5), width, height);
		dot.setBackground(Color.WHITE);
		contentPane.add(dot);
		dot.setFont(font);
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dot_flag == 0) {// 한번 눌리도록 한다
					number_Text = screen1.getText() + ".";
					screen1.setText(number_Text);
				}
				dot_flag = 1;
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class NumberListener implements ActionListener { // 0제외 숫자버튼의리스너
		public void actionPerformed(ActionEvent e) {
			JButton numberBtn = (JButton) e.getSource();
			String number = numberBtn.getText();

			if (operator == -1) {// 엔터 버튼 후, 다른 식을 연산 하기 위해 초기화
				pre = 0;
				curr = 0;
				screen1.setText("");
				screen2.setText("");
				operator = 0;
			}
			if (screen1.getText() == "0")// 현재 수가 0이면 스크린을 빈칸으로 초기화
				screen1.setText("");

			number_Text = screen1.getText() + number; // 문자열끼리의 덧셈으로 숫자입력
			curr = Double.parseDouble(number_Text);
			curr_buff = curr; // 입력받은수를 버퍼에 저장
			equal_flag = 0; // 엔터플래그를 초기화
			screen1.setText(number_Text);// 입력받은 수를 스크린에 띄운다.
		}
	}

	class OperationListener implements ActionListener { // 연산자 리스너
		public void actionPerformed(ActionEvent e) {
			JButton operationBtn = (JButton) e.getSource();
			if (operator == -1) // 이전 식의 결과 값을 이번 식에 바로 이용할 때
				curr = Double.parseDouble(screen1.getText());
			pre = curr; // 현재 수를 pre에 저장
			if (operator == 0 || operator == -1) { // 식의 처음일때
				if (operationBtn.getText() == "×") {
					operator = 1;
					pre_buff = pre;
				} else if (operationBtn.getText() == "÷") {
					operator = 2;
					pre_buff = pre;
				} else if (operationBtn.getText() == "－") {
					operator = 3;
					pre_buff = pre;
				} else if (operationBtn.getText() == "＋") {
					operator = 4;
					pre_buff = pre;
				}
			} else { // 식의 처음이 아닐때
				if (operationBtn.getText() == "×") {
					operator = 1;
					pre_buff *= curr;
				} else if (operationBtn.getText() == "÷") {
					operator = 2;
					pre_buff /= curr;
				} else if (operationBtn.getText() == "－") {
					operator = 3;
					pre_buff -= curr;
				} else if (operationBtn.getText() == "＋") {
					operator = 4;
					pre_buff += curr;
				}
			}
			// 스크린에 출력
			screen2.setText(screen2.getText() + " " + screen1.getText() + " " + operationBtn.getText() + " ");
			screen1.setText("0");
			equal_flag = 0;// 플래그 초기화
			dot_flag = 0;
			operator_buff = operator;// 연산자 저장
			curr = 0;
		}
	}
}