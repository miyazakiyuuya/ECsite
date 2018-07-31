package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite3.dto.LoginDTO;
import com.internousdev.ecsite3.util.DBConnector;

public class LoginDAO {

	public LoginDTO select(String loginId, String loginPassword) {

		//フィールドで設定するよりも実行の中で設定した方が良い
		//もしselectを②個使う時にバグる可能性がある
		DBConnector dbConnector = new DBConnector();

		Connection connection = dbConnector.getConnection();

		//失敗した時にnullに返すように設定
		LoginDTO loginDTO = null;

		//SQLから一致させたいデータを表示
		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? AND login_password = ?";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				loginDTO = new LoginDTO();

				//(sql)resultSetから取得だからSQLのカラムに合わせないといけない。ie,("user_name")
				//loginDTOの設定に合わせる
				loginDTO.setId(resultSet.getInt("id"));
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_password"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setMaster(resultSet.getString("master"));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return loginDTO;
	}

	//myPageで使うために全部セレクトする
	public ArrayList<LoginDTO> selectAll() {

		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();

		//から箱を用意する(returnの値を入れるために)

		String sql ="SELECT * FROM login_user_transaction ";

		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				LoginDTO dto = new LoginDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_password"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserAddress(rs.getString("user_address"));
				dto.setUserTell(rs.getString("user_tell"));

				list.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
