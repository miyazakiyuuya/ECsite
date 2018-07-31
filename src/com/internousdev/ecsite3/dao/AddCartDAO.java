package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite3.dto.CartDTO;
import com.internousdev.ecsite3.util.DBConnector;

public class AddCartDAO {

	private DBConnector dbconnector = new DBConnector();
	private Connection connection = dbconnector.getConnection();

	public int insert(CartDTO dto) throws SQLException {

		String sql = "INSERT INTO cart_info_transaction(user_id, product_id, count) VALUE(?,?,?)";

		int result = 0;

		try {

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, dto.getUserId());
			ps.setInt(2, dto.getProductId());
			ps.setInt(3, dto.getCount());

			result = ps.executeUpdate();
			//int result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//System.out.println(dto);データが格納されてるのを確認済
		return result;
	}
}
