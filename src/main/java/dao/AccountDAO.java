package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	private static final String DB_URL ="jdbc:postgresql://localhost:5432/sukkiriShop";
	private static final String DB_USER = "postgres";
	private static final String DB_PASS = "password";
	
	public Account findByLogin(Login login) {
		Account account = null;
		
	//データベースへ接続
	try (Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS)){
		
		//SELECT文を準備
	String sql = "SELECT USER_ID,PASS,MAIL,NAME,AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setString(1,login.getUserId());
	pStmt.setString(2,login.getPass());
	
	//SELECT文を実行し結果票を取得
	ResultSet rs = pStmt.executeQuery();
	//一致したユーザが存在した場合、そのユーザを表すAccountインスタンスを生成
	if(rs.next()) {
		//結果表からデータを取得
		String userId = rs.getString("USER_ID");
		String pass = rs.getString("PASS");
		String mail = rs.getString("MAIL");
		String name = rs.getString("NAME");
		int age = rs.getInt("AGE");
		account = new Account(userId, pass, mail, name, age);
	
	}
	
	}catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	//見つかったユーザまたはnullを返す
	return account;
	}
}
