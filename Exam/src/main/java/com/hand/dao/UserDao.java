package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.util.ConnectionFactory;

public class UserDao {
	public ResultSet get(Connection conn, String first_name) throws SQLException {// 查询customer表
		PreparedStatement ps = conn.prepareStatement("select * from customer where first_name=?");
		ps.setString(1, first_name);
		return ps.executeQuery();
	}

	public boolean check(String first_name) {// 检查用户名
		Connection conn = null;
		conn = ConnectionFactory.getInstance().makeConnection();
		try {
			conn.setAutoCommit(false);
			ResultSet resultset = get(conn, first_name);
			while (resultset.next()) {
				return true;
			}
			resultset.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public ResultSet getAllFilm() {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().makeConnection();
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"select f.film_id,f.title,f.description,l.name language from language l,film f where l.language_id=f.language_id  ");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

}
