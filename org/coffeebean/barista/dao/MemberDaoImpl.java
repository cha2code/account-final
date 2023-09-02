package org.coffeebean.barista.dao;

import java.util.ArrayList;
import java.util.List;

import org.coffeebean.barista.cli.RandomNumber;
import org.coffeebean.barista.vo.Member;

public class MemberDaoImpl implements MemberDao {
	
	// Singleton pattern
	// 객체를 하나만 생성 가능. 생성 된 객체를 어디서든 참조 가능하도록 함
	private static MemberDaoImpl dao = new MemberDaoImpl();
	// 한 번만 호출 가능해야 함 - 생성자를 외부에서 호출할 수 없게 private으로 설정
	private MemberDaoImpl() { 
	}
	// 자기 자신에 대한 인스턴스를 만들어 외부에 제공
	public static MemberDao getInstance() {
		return dao;
	}
	
	// 고객 정보 저장 리스트
	private List<Member> memberList = new ArrayList<>();


	@Override
	public void setList(Member member) {
		
		memberList.add(member);
	}

	
	@Override
	public Member checkId(String userid) {
		
		int check = checkList();
		
		if(check != 0) {
			for(int i = 0; i < memberList.size(); i++ ) {
				
				// 입력 받은 아이디와 리스트에 저장 된 아이디가 같을 때
				if(memberList.get(i).getUserid().equals(userid) == true) {
					
					Member member = memberList.get(i);
					
					return member;
				}
			}
		}
		
		return null;
	}

	@Override
	public String createAccount() {
		
		while(true) {

			RandomNumber rn = new RandomNumber();
			String account = rn.randomNumber();
				
			// 계좌 번호 중복 확인
			int index = checkAccount(account);
				
			if(index == 1) {
				return account;
			}
		}
	}
	
	
	@Override
	public boolean changeAccount(Member member) {
		
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i) == member) {
				
				memberList.set(i, member);
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public List<Member> getAccountInfo(String userid) {
		
		Member member = new Member();
		
		for(int i = 0; i < memberList.size(); i++) {	
			member = memberList.get(i);
			
			if(member.getUserid().equals(userid) == true) {
				return memberList;
			}
		}
		
		System.out.println("Without your account.");
		
		return null;
	}

	
	@Override
	public Member deposit(Member member, String money) {
		
		while(true) {
			
			//입력 받은 값이 숫자인 지 판단 후 계산
			try {
				Integer.parseInt(money);
				
				int result = Integer.parseInt(member.getBalance()); //member에 저장 된 잔액을 int형으로 변환
				int deposit = Integer.parseInt(money); //money에 저장 된 입금액을 int형으로 변환
				
				result += deposit;
				
				money = Integer.toString(result); //잔액+입금액한 결과를 String으로 변환
				
				
				// 리스트에 저장
				member.setBalance(money);
				memberList.add(member);
				
				return member;

			} catch (NumberFormatException e) {
				System.out.println("Please enter the number.");
			}
			
		}
	}

	@Override
	public Member withdrawal(Member member, String money) {
		
		while(true) {
			
			//String money = Input.read("How much? : ");
			
			//입력 받은 값이 숫자인 지 판단 후 계산
			try {
				Integer.parseInt(money);
				
				int result = Integer.parseInt(member.getBalance()); //member에 저장 된 잔액을 int형으로 변환
				int withdrawal = Integer.parseInt(money); //money에 저장 된 출금액을 int형으로 변환
				
				if(result < withdrawal) { //잔액 < 출금액
					return null;
				}
				
				result -= withdrawal;
				
				money = Integer.toString(result); //잔액+입금액한 결과를 String으로 변환
				
				member.setBalance(money); //리스트에 잔액 저장
				memberList.add(member);
				
				return member;

			} catch (NumberFormatException e) {
				System.out.println("Please enter the number.");
			}
			
		}
	}
		
	@Override
	public boolean delete(Member member) {
		
		for(int i = 0; i < memberList.size(); i++) {
			
			if(member.getUserid().equals(memberList.get(i).getUserid()) == true) {
				
				memberList.remove(member);
				
				return true;
			}
		}
		return false;
	}
	
	
	
	// 리스트에 정보가 있는 지 체크
	public int checkList() {
		
		if(memberList == null) {
			return 0;
		}
			
		return 1;			
	}	
	
	// 계좌 번호 중복 확인
	public int checkAccount(String account) {
			
		if(memberList != null) {
			for(int i = 0; i < memberList.size(); i++) {
				Member member = memberList.get(i);
				if(member.getAccountNumber().equals(account)) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	// Password 맞는 지 확인
	public boolean matchPassword(String pwd, Member m) {
		
		if(pwd.equals(m.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}
	
	
	
	
	
	
	
	

