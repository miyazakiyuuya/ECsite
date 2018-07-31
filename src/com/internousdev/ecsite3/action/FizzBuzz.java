package com.internousdev.ecsite3.action;

import java.util.ArrayList;

import com.internousdev.ecsite3.util.BaseAction;

public class FizzBuzz extends BaseAction {

	public String execute() {

		run();

		return SUCCESS;
	}

	public void run() {

		ArrayList<String> FizzBuzzList = new ArrayList<String>();

		final String FIZZ="FIZZ";
		final String BUZZ="BUZZ";
//		int j=10;
//		System.out.println(j<=10?"OK":"NG");

		for (int i = 1; i <= 100; i++) {
			String str = (i%15==0 ? FIZZ+BUZZ :((i%3==0)?FIZZ:((i%5==0)?BUZZ:String.valueOf(i))));
			System.out.println(str);
//
//			String a = "i";
//
//
//
//			if (i % 15 == 0) {
//				a = "FizzBuzz";
//
//			} else if (i % 3 == 0) {
//				a = "Fizz";
//
//
//			} else if (i % 5 == 0) {
//				a = "Buzz";
//
//
//			} else {
//
//				a = String.valueOf(i);
//
//				System.out.println(i + "");
//
//			}

			if (i % 10 == 0) {

				System.out.println();
			}
			System.out.println("FizzBuzz");
			System.out.println("Fizz");
			System.out.println("Buzz");


			FizzBuzzList.add(str);

		}

		session.put("FizzBuzzList", FizzBuzzList);
	}
}
