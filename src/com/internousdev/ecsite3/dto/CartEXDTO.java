package com.internousdev.ecsite3.dto;

public class CartEXDTO extends CartDTO {

	//コンストラクターをして計算処理

	private int total_price;

	private long total_price_tax;

	//Cart.jspのtotalPriceの計算
	public CartEXDTO(CartDTO dto) {

		this.setUserId(dto.getUserId());
		this.setId(dto.getId());
		this.setCount(dto.getCount());
		this.setItem_price(dto.getItem_price());
		this.setItem_stock(dto.getItem_stock());
		this.setProductId(dto.getProductId());
		this.setItem_name(dto.getItem_name());

		total_price = dto.getItem_price() * dto.getCount();

		total_price_tax = Math.round(total_price * 1.08);

	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public long getTotal_price_tax() {
		return total_price_tax;
	}

	public void setTotal_price_tax(long total_price_tax) {
		this.total_price_tax = total_price_tax;
	}

}
