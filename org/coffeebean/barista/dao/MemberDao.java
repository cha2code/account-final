package org.coffeebean.barista.dao;

import java.util.List;

import org.coffeebean.barista.vo.Member;

public interface MemberDao {

	// 리스트에 저장
	void setList(Member member);
	
	// 아이디 중복 확인
	Member checkId(String userid);
	
	// 계좌 번호 생성
	String createAccount();
	
	// 계좌 정보
	List<Member> getAccountInfo(String userid);
	
	// 계좌 정보 변경
	boolean changeAccount(Member member);
	
	// 입금
	Member deposit(Member member, String money);
	
	// 출금
	Member withdrawal(Member member, String money);
	
	// 송금
	
	// 계좌 삭제
	boolean delete(Member member);

}
