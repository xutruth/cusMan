package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
		try {
		Connection conn =	JdbcUtils.getConnection();
		String sql = "insert into ghb values(18)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
