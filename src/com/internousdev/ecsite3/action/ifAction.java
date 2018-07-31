package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.util.BaseAction;

public class ifAction extends BaseAction {

	private int a;

	private String result;

	public String execute() {

		result = SUCCESS;
		if (a < 20) {

			result = ERROR;
		}

		return result;

	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}
