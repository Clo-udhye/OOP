
public class MyList<T> implements ListInterface<T> {
	
	int max = 5;// 리스트의 최대갯수
	int index = -1;
	private T[] list;

	MyList() {
		list = (T[]) new Object[max]; // 리스트생성
	}

	public void add(T obj) throws ListisFullError {
		if (!isListFull()) // 리스트가 가득차지 않았으면 add
			list[++index] = obj;
		else
			throw new ListisFullError(); // 가득차면 예외처리

	}

	public void delete(int index) throws WrongIndexError, ListisEmptyError {
		if (isListEmpty()) // 리스트가 비어있으면 예외처리
			throw new ListisEmptyError();
		if (index > this.index || index < 0) // 잘못된 index입력을 받았을때 예외처리
			throw new WrongIndexError();
		for (int i = index; i < this.index; i++)// 입력받은 index부터 한칸씩 앞으로 옮겨온다.
			list[i] = list[i + 1];
		list[(this.index)--] = null; // 마지막 중복되는 수를 null로 치환

	}

	public T getAt(int index) {
		return list[index]; // index에 있는 값을 리턴
	}

	public int getSize() { // List에 저장된 숫자의 갯수
		return index + 1;

	}

	public void print() { // 리스트의 마지막에 저장된 인덱스와 값을 출력
		System.out.println("[" + index + "] " + list[index] + " ");
	}

	public void printAll() throws ListisEmptyError { // 리스트 전체의 인덱스와 값을 출력
		if (!isListEmpty()) {
			for (int i = 0; i <= index; i++)
				System.out.print("[" + i + "] " + list[i] + " ");
		} else // 비어있는 리스트 예외처리
			throw new ListisEmptyError();
		System.out.println(" ");
	}

	public Boolean isListEmpty() {
		return getSize() == 0 ? true : false;
	}

	public Boolean isListFull() {
		return getSize() == max ? true : false;
	}
}

