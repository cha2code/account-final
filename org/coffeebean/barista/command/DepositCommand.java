package org.coffeebean.barista.command;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;
import org.coffeebean.common.Input;
import org.coffeebean.common.cli.command.Command;

public class DepositCommand implements Command {
	
	MemberDao dao = MemberDaoImpl.getInstance();
	
	@Override
	public void execute() {
		
		String userid = Input.read("ID : ");
		
		Member member = dao.checkId(userid);
		
		if(member != null) {			

			String money = Input.read("입금 금액 > ");
			member = dao.deposit(member, money);
			System.out.printf("Total blance : %s\n", member.getBalance());
		}
		
	}

}
