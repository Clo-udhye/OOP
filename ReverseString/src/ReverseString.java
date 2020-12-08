
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = { "apple", "banana", "동해물과 백두산이","watermelon", "grapefruit" };
		for (int i = 0; i < str.length; i++) {
			Stack s = new Stack(str[i].length());
			// Original 문자열 str[i] 출력
			// str[i]의 Reverse 문자열 출력
			System.out.println("Original = \"" + str[i] +"\"");
			for(int j=0; j<str[i].length();j++){
				char ch = str[i].charAt(j); //문자열의 [j]번째 문자를 리턴해주는 함수
				s.push(ch);
			}
			System.out.print("Reverse = \"");
			for(int j=0; j<str[i].length();j++){
				System.out.print(s.pop());
			}
			System.out.println("\"");
		}
	}

}
