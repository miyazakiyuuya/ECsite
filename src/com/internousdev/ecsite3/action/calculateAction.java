package com.internousdev.ecsite3.action;

import com.internousdev.ecsite3.util.BaseAction;

public class calculateAction extends BaseAction {

	private String aaa;

	private String bbb;

	private String select;

	private int answer;

	public String execute() {

		System.out.println(aaa);
		int num1 = Integer.parseInt(aaa);
		int num2 = Integer.parseInt(bbb);

		System.out.println(num1);

		System.out.println(select);

		if (select.equals("sum")) {
			answer = num1 + num2;
		}
		if (select.equals("dif")) {
			answer = num1 - num2;
		}
		if (select.equals("mul")) {
			answer = num1 * num2;
		}
		if (select.equals("div")) {
			answer = num1 / num2;
		}

		System.out.println(answer);
		return SUCCESS;
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getBbb() {
		return bbb;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getAnswer() {
		return answer;
	}

}
