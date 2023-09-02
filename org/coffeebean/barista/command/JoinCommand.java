package org.coffeebean.barista.command;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;
import org.coffeebean.common.Input;
import org.coffeebean.common.cli.command.Command;

public class JoinCommand implements Command {
	
	MemberDao dao = MemberDaoImpl.getInstance();

	@Override
	public void execute() {
		
		//가입 시 정보 입력 받은 후 리스트 생성
		while(true) {

			String userid = Input.read("ID : ");
			Member result = dao.checkId(userid);
			
			if(result == null) { // ID가 중복이 아닐 때 실행
				String password = Input.read("Password : ");
				String name = Input.read("Name : ");
				String accountNumber = dao.createAccount();
				String balance = "0";
					
				Member member = new Member(userid, password, name, accountNumber, balance);
					
				// 리스트에 저장
				dao.setList(member);
				
				System.out.printf("Welcome %s!\n", userid);
				break;
			}
			
			else {
				System.out.println("Duplicate ID.");
			}
		}
	}
}
