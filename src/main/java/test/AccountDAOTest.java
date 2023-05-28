package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
	public static void main(String[] args) {
		testFindByLogin1(); //ユーザが見つかる場合のテスト
		testFindByLogin2(); //ユーザが見つあらない場合のテスト
	}
	public static void testFindByLogin1() {
		Login login = new Login("minato","1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result != null) //&&
//			result.getUserId().equals("minato    "))//&&
		{
			System.out.println("userFindByLogin1:成功しました");
		} else {
			System.out.println("userFindByLogin1:失敗しました");
		}
		}
    
	public static void testFindByLogin2() {
		Login login = new Login("minato","12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		}else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
