package com.internousdev.ecsite3.action;

import java.util.ArrayList;

import com.internousdev.ecsite3.dao.ItemListDAO;
import com.internousdev.ecsite3.dto.ItemListDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class ItemListAction extends BaseAction {

	private ArrayList<ItemListDTO> list;

	public String execute() {

		//BuyItemDAOをnewする
		ItemListDAO dao = new ItemListDAO();

		list = dao.selectItemAll();

		session.put("itemList", list);


		return SUCCESS;

	}


}
