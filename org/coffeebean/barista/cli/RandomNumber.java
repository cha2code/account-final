package org.coffeebean.barista.cli;

import java.util.Random;

public class RandomNumber {
	
	//14자리 계좌 번호 랜덤 생성
		public String randomNumber() {

			int createNumber;
			String accountNumber = "";
			String randNumber="";
			
			Random rand = new Random();
			
			//14자리 랜덤 생성 된 숫자를 문자열로 변환
			for(int i = 0; i < 14; i++) {
				
				createNumber =  rand.nextInt(9);//0~9 사이의 정수를 랜덤으로 저장
				randNumber = Integer.toString(createNumber); //생성된 숫자를 문자열로 변환
				accountNumber += randNumber; //숫자 한 자리씩 추가
			}
			
			accountNumber = insertString(accountNumber);
			
			return accountNumber;
		}
		
		//계좌 번호 사이에 "-" 삽입
		public String insertString(String accountNumber) {
			
			StringBuffer sb = new StringBuffer(accountNumber); //문자열을 StringBuffer로 변경
			
			for(int i = 0; i < 14; i++) {
				if(i == 6 || i == 9) {
					sb.insert(i,"-");
				}
			}
			
			accountNumber = sb.toString(); //StringBuffer를 문자열로 변경
			
			return accountNumber;
		}

}
