package com.internousdev.ecsite3.action;

import java.util.ArrayList;

import com.internousdev.ecsite3.dao.LoginDAO;
import com.internousdev.ecsite3.dto.LoginDTO;
import com.internousdev.ecsite3.util.BaseAction;

public class MyPageAction extends BaseAction {

	private int id;

	private String loginId;

	private String loginPassword;

	private String userName;

	private String userAddress;

	private String userTell;


	//sessionを使ってリストに入れてJSPに反映させる
	public String execute() {

		//ログインしてればそのログイン状態を反映させる
		//ログインしてなければログインに飛ばす


		ArrayList<LoginDTO> myPageList = new ArrayList<LoginDTO>();

		LoginDAO dao = new LoginDAO();

		myPageList = dao.selectAll();

		session.put("myPageList", myPageList);

		System.out.println(myPageList.size());

		return SUCCESS;

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserTell() {
		return userTell;
	}


	public void setUserTell(String userTell) {
		this.userTell = userTell;
	}

}
