package com.internousdev.ecsite3.action;

import com.opensymphony.xwork2.ActionSupport;

public class primeAction extends ActionSupport{

	public String execute() {

		isPrime();

		return SUCCESS;
	}



	public static void isPrime() {

		for(int i = 2; i <= 100; i++) { //エラトステネスのふるいを使う


			if(i == 2) {	//2が一致してれば
				System.out.println(i);
			}

			if(i == 3) {
				System.out.println(i);
			}

			if(i == 5) {
				System.out.println(i);
			}

			if(i == 7) {
				System.out.println(i);
			}

		if(i % 2 == 0) {	//2の倍数

		}
		else if(i % 3 == 0) {

		}
		else if(i % 5 == 0) {

		}
		else if(i % 7 == 0) {

		} else {
			System.out.println(i); //それ以外の数字を表示
		}
		}
	}
}


