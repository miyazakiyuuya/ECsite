package com.internousdev.ecsite3.action;

import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite3.dao.CartDAO;
import com.internousdev.ecsite3.dto.CartDTO;
import com.internousdev.ecsite3.dto.CartEXDTO;
import com.internousdev.ecsite3.dto.LoginDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class CartAction extends BaseAction {

	private int userId;

	private String item_name;

	private int item_price;

	private int count;

	private int id;

	private int total_price;

	private Map<String, Object> total_price_tax;

	public String execute() {

		//		double rateTax = 1.08;
		//		session.put("item_price", item_price);
		//		session.put("count", count);
		//
		//		//文字列を数字に変換する
		//		int intItem_price = Integer.parseInt(session.get("item_price").toString());
		//		int intCount = Integer.parseInt(session.get("count").toString());
		//
		//		//Math.roundを使うことで小数点が消える
		//		double a = intItem_price * intCount * rateTax;
		//		session.put("total_price", Math.round(a));

		//userID取得
		LoginDTO loginDTO = null;
		loginDTO = (LoginDTO) session.get("loginDTO");
		userId = loginDTO.getId();

		//sessionに入れたuserIDを元にuser情報を集める
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		CartDAO dao = new CartDAO();

		cartList = dao.selectById(userId);

		//個々の合計金額の計算
		ArrayList<CartEXDTO> cartExList = new ArrayList<CartEXDTO>();
		for (int i = 0; i < cartList.size(); i++) {
			cartExList.add(new CartEXDTO(cartList.get(i)));
		}

		//全体の合計金額
		for (int i = 0; i < cartExList.size(); i++) {
			total_price += cartExList.get(i).getTotal_price();
		}

		session.put("cartList", cartExList);
		System.out.println(cartExList.size());

		return SUCCESS;
	}

	//次のjspのpropertyに送りたい時
	public int getUserId() {
		return userId;
	}

	//jspのpropertyに受け取りたい時
	public void setUseId(int userId) {
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
