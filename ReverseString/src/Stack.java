
public class Stack {
	int max;
	char[] stack; // 데이터가 저장되는 배열
	int top = -1; // 마지막 저장된 데이터 index

	public Stack(int m){ //생성자, 입력받을 문자열의 크기만큼 stack을 할당해준다.
		max = m;
		stack = new char[max];
	}
	boolean isEmpty(){// 스택이 비었는가?
		if(top==-1)
			return true;
		else
			return false;
	}
	boolean isFull(){// 스택이 가득 찼는가?
		if(top==max)
			return true;
		else
			return false;
	}
	void push(char ch){
		if(!isFull()){ 
			this.stack[++top] = ch;
		}
		else 
			System.out.println("Stack overflow error");
	} //ch를 스택에 push 한다. 이때, Stack overflow error를 확인한다.

	char pop(){
		if(!isEmpty())
			return this.stack[top--];
		else{
			System.out.println("Stack empty error!");
			return 0;
		}
	}// 스택에서 pop 한다. 이때, Stack empty error를 확인한다
}