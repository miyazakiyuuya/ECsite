package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.dao.CartDAO;
import com.internousdev.ecsite3.util.BaseAction;

public class DeleteBuyHistoryAction extends BaseAction{

	private int id;

	public String execute() {

		CartDAO dao = new CartDAO();

		dao.deleteById(id);

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
