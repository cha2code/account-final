package org.coffeebean.barista.command;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;
import org.coffeebean.common.Input;
import org.coffeebean.common.cli.command.Command;

public class AccountInfoCommand implements Command {
	
	MemberDao dao = MemberDaoImpl.getInstance();

	@Override
	public void execute() {
		
		String userid = Input.read("ID : ");
		Member member = dao.checkId(userid); //리스트 내 데이터 유무 확인
		
		// 입력한 ID가 리스트에 있는 경우
		if(member != null) {
			
			System.out.printf("ID : %s\n", member.getUserid());			
			System.out.printf("Name : %s\n", member.getName());
			System.out.printf("Account number : %s\n", member.getAccountNumber());
			System.out.printf("Balance : %s\n", member.getBalance());
								
		}
		else {
			System.out.println("No data.");
		}		
	}
}
