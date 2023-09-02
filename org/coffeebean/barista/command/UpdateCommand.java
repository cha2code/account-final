package org.coffeebean.barista.command;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;
import org.coffeebean.common.Input;
import org.coffeebean.common.cli.command.Command;

public class UpdateCommand implements Command {
	
	MemberDao dao = MemberDaoImpl.getInstance();

	@Override
	public void execute() {
		
		while(true) {

			boolean tf = false;

			String userid = Input.read("ID를 입력하세요 > "); //바꾸려는 계정 리스트에서 찾기
			Member member = dao.checkId(userid);
				
			// 이름 변경 part
			if(member != null) {
					
				System.out.println("(변경하지 않으시려면 Enter를 눌러주세요.)");
				String answer = Input.confirm("변경할 이름을 입력하세요 > ");
					
				if(answer != null) {
						
					member.setName(answer);
					tf = dao.changeAccount(member);
				}
					
				System.out.println("(변경하지 않으시려면 Enter를 눌러주세요.)");
				answer = Input.confirm("현재 비밀번호를 입력하세요 > ");
				
				if(answer != null ) {
					
					member.setPassword(answer);
					tf = dao.changeAccount(member);
				}
			}
				
			else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
			
			if(tf == true) {
				
				System.out.println("정보가 수정되었습니다.");
				break;
			}
		}
				
	}

}
