package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.dao.ChangePasswordDAO;
import com.internousdev.ecsite3.util.BaseAction;

public class ChangePasswordAction extends BaseAction {

	private String loginId;

	private String loginPassword;

	private String newPassword;

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String execute() {

		ChangePasswordDAO dao = new ChangePasswordDAO();

		int result = dao.update(loginId, loginPassword, newPassword);

		if (result > 0) {
			return SUCCESS;

		} else {
			return ERROR;
		}

	}

}
