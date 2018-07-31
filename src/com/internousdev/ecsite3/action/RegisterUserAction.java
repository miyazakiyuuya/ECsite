package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.dao.RegisterUserDAO;
import com.internousdev.ecsite3.dto.RegisterUserDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class RegisterUserAction extends BaseAction {

	//jspから受けるための箱を準備
	private String userName;

	private String userAddress;

	private String userTell;

	private String loginId;

	private String loginPassword;

	//jspから受け取るためのメソッド
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setUserTell(String userTell) {
		this.userTell = userTell;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String execute() {

		if (userName.equals("") || userAddress.equals("") || userTell.equals("") || loginId.equals("") ||
				loginPassword.equals("")) {
			return ERROR;
		}

		//jspからゲット値をdtoにsetting
		//insertするためにdtoの形にsetting(DAOでDTOを引数にしてるため)
		RegisterUserDTO dto = new RegisterUserDTO();

		dto.setUserName(userName);
		dto.setUserAddress(userAddress);
		dto.setUserTell(userTell);
		dto.setLoginId(loginId);
		dto.setLoginPassword(loginPassword);

		RegisterUserDAO dao = new RegisterUserDAO();
		//dao.insert(dto);

		//（dao）戻り値の受け取り
		//新規ユーザーデータの追加　　戻り値が件数でresultに戻り値を入れる
		int result = dao.insert(dto);

		//件数が１以上でサクセス
		if (result > 0) {
			return SUCCESS;

		} else {
			return ERROR;
		}

	}

}
