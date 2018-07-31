package com.internousdev.ecsite3.action;

import java.util.ArrayList;

import com.internousdev.ecsite3.dao.CartDAO;
import com.internousdev.ecsite3.dto.CartDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class BuyHistoryAction extends BaseAction {

	//購入した履歴の機能
	//履歴と削除

	//購入のCompletelyしてきたデータをgetしてそれを表示させる

	private int userId;

	private String item_name;

	private int item_price;

	private int count;

	private int id;

	private int total_price;

	public String execute() {

		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
		CartDAO cartDAO = new CartDAO();


		cartList = cartDAO.selectById(userId);
		System.out.println(cartList.size());

		return SUCCESS;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
