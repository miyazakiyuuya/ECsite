package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite3.dto.ItemListDTO;
import com.internousdev.ecsite3.util.DBConnector;

public class ItemListDAO {

	public ArrayList<ItemListDTO> selectItemAll() {

		DBConnector dbconnector = new DBConnector();

		Connection connection = dbconnector.getConnection();

		ArrayList<ItemListDTO> list = new ArrayList<ItemListDTO>();

		String sql = "SELECT * FROM item_info_transaction";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ItemListDTO dto = new ItemListDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				dto.setImage_file_path(resultSet.getString("image_file_path"));
				dto.setImage_file_name(resultSet.getString("image_file_name"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
}
