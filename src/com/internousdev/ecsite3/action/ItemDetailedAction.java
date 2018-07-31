package com.internousdev.ecsite3.action;

import java.util.List;

import com.internousdev.ecsite3.dao.ItemListDAO;
import com.internousdev.ecsite3.dto.ItemListDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class ItemDetailedAction extends BaseAction {

	private List<ItemListDTO> list;

	private int id;

	private String item_name;

	private String item_price;

	private ItemListDTO itemListDTO;

	public String execute() {

		ItemListDAO dao = new ItemListDAO();

		list = dao.selectItemAll();

		//キャスト笑
		//キャストしてlistの中にsession.getしてきたitemListに入れる
		list = (List<ItemListDTO>) session.get("itemList");

		//jspから入力されたidと一致したBuyItemDTOのデータ取得
		//list.sizeでlistの中に何個あるか調べれる
		//getしてきたidが同じなら入る
		for (int i = 0; i < list.size(); i++) {
			ItemListDTO dto = list.get(i);
			if (dto.getId() == id) {
				itemListDTO = dto;
				break;
			}
		}

		//System.out.print(buyItemDTO); データが入ってるのを確認済
		return SUCCESS;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//次のjspにセット
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_price() {
		return item_price;
	}

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	//帰ってきた値をdtoに返す
	public ItemListDTO getItemListDTO() {
		return itemListDTO;
	}

}
