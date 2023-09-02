package org.coffeebean.barista.command;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;
import org.coffeebean.common.Input;
import org.coffeebean.common.cli.command.Command;

public class WithdrawalCommand implements Command {
	
	MemberDao dao = MemberDaoImpl.getInstance();
	
	@Override
	public void execute() {
		
		String userid = Input.read("ID : ");
		
		Member member = dao.checkId(userid);
		
		if(member != null) {
			if(member.getBalance() != "0") {
				
				String money = Input.read("출금 금액 > ");
				member = dao.withdrawal(member, money);
				System.out.printf("Total balance : %s\n", member.getBalance());
			}
				
			else {
				System.out.println("Your balance is 0.");
			}
		}
		
	}
}
