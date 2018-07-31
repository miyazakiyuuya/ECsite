package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite3.util.DBConnector;

public class ChangePasswordDAO {

	public int update(String loginId, String loginPassword, String newPassword) {

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "UPDATE login_user_transaction SET login_password =? WHERE login_id =? AND login_password = ?";

		int result = 0;

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, loginId);
			preparedStatement.setString(3, loginPassword);

			//System.out.println(preparedStatement.toString());

			result = preparedStatement.executeUpdate();

			//System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
