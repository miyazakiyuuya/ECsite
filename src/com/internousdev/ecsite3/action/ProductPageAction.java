package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.util.BaseAction;

public class ProductPageAction extends BaseAction {

	//ログインしてなかったらloginでログインアクションに飛ばす
	//ログインしてたらsuccessでそのままitemListに飛ばす　変更前

	//ログイン後の動作は問題なし
	//BUT ログインしてない状態だとItemDetailedActionよりも先に行かない
	private int userId;

	public String execute() {
		System.out.println(session.containsKey("loginDTO") + " : " + session.get("loginDTO"));

		if (!session.containsKey("loginDTO")) {
			return "login";
		} else {

			return SUCCESS;
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//			if (user.getLoginId().equals("login_id") && user.getLoginPassword().equals("login_password")) {
	//				return SUCCESS;
	//
	//			} else {
	//
	//				if (!(user.getLoginId().equals("login_id") || (user.getLoginPassword().equals("login_password")))) {
	//
	//					return "login";
	//				}
	//			}
	//
	//		}
	//		return ERROR;
	//	}

	//	public String getLoginId() {
	//		return loginId;
	//	}
	//
	//	public void setLoginId(String loginId) {
	//		this.loginId = loginId;
	//	}
	//
	//	public String getLoginPassword() {
	//		return loginPassword;
	//	}
	//
	//	public void setLoginPassword(String loginPassword) {
	//		this.loginPassword = loginPassword;
	//	}

}