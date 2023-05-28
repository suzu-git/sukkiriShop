package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.RegisterDTO;

public class RegisterDAO {
	//接続のための３つのデータ
	private static final String DB_URL ="jdbc:postgresql://localhost:5432/sukkiriShop";
	private static final String DB_USER = "postgres";
	private static final String DB_PASS = "password";
	
	public int RegisterCustomer(RegisterDTO dto) {
		//自動コミット機能をOFF
		
		int result = 0;
		 //戻り値にint したのにReturnを書かないと赤波消えない
		 //DBと接続
		try(Connection conn = DriverManager.getConnection(DB_URL,DB_USER, DB_PASS);){
			//自動コミット機能をOFF
			conn.setAutoCommit(false);
			//SQL文を作成 データを渡す内容はデータストリーム　内容はDTO見て、一つずつgetして置く
			String sql = "INSERT INTO account VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getPass());
			ps.setString(3, dto.getMail());
			ps.setString(4, dto.getName());
			ps.setInt(5, dto.getAge());
			result = ps.executeUpdate();
			
			//INSERT できなかった場合　ロールバックをかけてあげよう
			if(result == 0) {
				conn.rollback();
				return result;
				
			}
			//INSERTできた場合
			conn.commit();
			return result;
			
		
		}catch(SQLException e) {
			e.printStackTrace();
			return result;
		}
		
	}

}
