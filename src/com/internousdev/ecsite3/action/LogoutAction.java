package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.util.BaseAction;

public class LogoutAction extends BaseAction {

	public String execute() {
		session.clear();

		return SUCCESS;
	}

}
