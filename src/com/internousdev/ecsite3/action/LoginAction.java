package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.dao.LoginDAO;
import com.internousdev.ecsite3.dto.LoginDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class LoginAction extends BaseAction {

	//取得したいデータを定義
	private String loginId;
	private String loginPassword;

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();

	public String execute() {

		//loginIdとloginPasswordが一致した値を取得する
		loginDTO = loginDAO.select(loginId, loginPassword);

		if (loginDTO != null) { //取得に成功した場合

			session.put("loginDTO", loginDTO); //sessionに取得してきたユーザー情報を設定

			//userと管理者を分ける

			if (loginDTO.getMaster() != null) {

				if (loginDTO.getMaster().equals("master")) {
					return "master";

				} else {
					return SUCCESS;
				}

			} else {
				return SUCCESS; //loginSuccessに飛ぶ
			}

		} else {
			return ERROR; //loginErrorに飛ぶ
		}
	}

	//sessionに取得してきたデータを設定
	//getはjspでのvaluse= ""で表示できる
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}