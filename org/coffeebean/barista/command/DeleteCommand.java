package org.coffeebean.barista.command;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;
import org.coffeebean.common.Input;
import org.coffeebean.common.cli.command.Command;

public class DeleteCommand implements Command {
	
	MemberDao dao = MemberDaoImpl.getInstance();

	@Override
	public void execute() {

		String userid = Input.read("ID를 입력하세요 > ");
		Member member = dao.checkId(userid);
		
		//해당 member가 리스트에 있을 때 실행
		if(member != null) {
			
			System.out.println("정말로 삭제하시겠습니까?");
			String yesNo = Input.confirm("(삭제 : y / 취소 : 아무 키나 입력하세요) > ");
			
			if(yesNo != null) {
	
				boolean tf = dao.delete(member);
				
				if(tf == true) {
					
					System.out.println("삭제되었습니다.");
				}
			}
			
			else {
				
				System.out.println("삭제가 취소되었습니다.");
			}
		
		}
		//리스트에 정보가 없을 때 실행
				else {
						System.out.println("일치하는 아이디가 없습니다.");
				}
	}
}
