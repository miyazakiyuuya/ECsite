package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite3.dto.RegisterUserDTO;
import com.internousdev.ecsite3.util.DBConnector;

public class RegisterUserDAO {

	//int 何件作ったかを知れる executeUpdate
	//boolean 登録成功か失敗かがわかる execute
	public int insert(RegisterUserDTO dto) {

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "INSERT INTO login_user_transaction(user_name, user_address, user_tell, login_id, login_password) VALUES (?,?,?,?,?)";

		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getUserName());
			preparedStatement.setString(2, dto.getUserAddress());
			preparedStatement.setString(3, dto.getUserTell());
			preparedStatement.setString(4, dto.getLoginId());
			preparedStatement.setString(5, dto.getLoginPassword());

			result = preparedStatement.executeUpdate();

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