package com.internousdev.ecsite3.action;

import java.sql.SQLException;

import com.internousdev.ecsite3.dao.AddCartDAO;
import com.internousdev.ecsite3.dto.CartDTO;
import com.internousdev.ecsite3.dto.LoginDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class AddCartAction extends BaseAction {

	//BuyItemDTOに格納したIDをゲットしていない
	private int userId;

	private int productId;

	private int count;

	private String item_name;

	private int item_price;

	private int id;

	public String execute() throws SQLException {

		//loginDTOにあるID(userIdのために)を取得するためにまずはloginDTOを取得する
		LoginDTO loginDTO = null;
		loginDTO = (LoginDTO) session.get("loginDTO");

		//loginDTOにあるIDを取得してさらにuserIdに入れる
		userId = loginDTO.getId();

		CartDTO dto = new CartDTO();

		dto.setUserId(userId);
		dto.setProductId(productId);
		dto.setCount(count);
		dto.setId(id);

		AddCartDAO dao = new AddCartDAO();
		int result = dao.insert(dto);

		return SUCCESS;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
