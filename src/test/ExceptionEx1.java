package test;

import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class ExceptionEx1 {
	public void main() {
		A a = new B();
		//SQLException보다 하위 클래스의 익셉션을 발생시키면 ㅈ처리 할 수 있지만 상위 클래스의 익셉션을 발생시키면 처리할 수 없다.
		
		try {
			a.method();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class B implements A {

	@Override
	//상위 클래스의 익센션을 발생시킬 수 없으므로 
	public void method() throws SQLTimeoutException{
	}
}

//추상메소드에 exception이 있는 경우 누군가 A 타입으로 B의 메소드를 실행하면 a의 시선으로 보니까 예외처리를 해야한다.

interface A {
	void method() throws SQLException;
}


