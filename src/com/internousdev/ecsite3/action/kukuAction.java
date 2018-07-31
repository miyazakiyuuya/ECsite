package com.internousdev.ecsite3.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite3.util.BaseAction;

public class kukuAction extends BaseAction {

	private List<Integer> k = new ArrayList<>();

	private int a;

	public String execute() {

		int answer;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				answer = (i + 1) * (j + 1);

				k.add(answer);
			}
		}
		System.out.println(k);
		session.put("k", a);

		return SUCCESS;
	}

}
