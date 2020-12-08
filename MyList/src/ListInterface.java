
public interface ListInterface <T> {
	void add(T obj) throws ListisFullError; // 리스트의 끝에 obj 추가
	void delete(int index) throws WrongIndexError, ListisEmptyError; // index번째 obj 삭제																													
	T getAt(int index); // index번째 obj 리턴
	int getSize(); // 리스트의 크기 리턴
}