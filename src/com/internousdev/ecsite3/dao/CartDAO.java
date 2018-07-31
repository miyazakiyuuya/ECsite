package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite3.dto.CartDTO;
import com.internousdev.ecsite3.util.DBConnector;

public class CartDAO {

	//UserIdの情報を手に入れるため
	public ArrayList<CartDTO> selectById(int userId) {

		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "SELECT c.id, c.user_id, c.product_id, c.count, iit.id, iit.item_name, iit.item_price, "
				+ "iit.item_stock, iit.image_file_path, iit.image_file_name "
				+ "FROM cart_info_transaction c "
				+ "LEFT JOIN item_info_transaction iit "
				+ "ON c.product_id = iit.id "
				+ "WHERE c.user_id = ? ";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CartDTO dto = new CartDTO();

				dto.setUserId(resultSet.getInt("user_id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setCount(resultSet.getInt("count"));
				dto.setId(resultSet.getInt("id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				dto.setImage_file_path(resultSet.getString("image_file_path"));
				dto.setImage_file_name(resultSet.getString("image_file_name"));

				cartList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		try {

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cartList;
	}

	public int deleteById(int id) {

		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();

		String sql = "DELETE FROM cart_info_transaction WHERE id=?";

		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
