package org.coffeebean.barista.common;

import java.util.List;

import org.coffeebean.barista.dao.MemberDao;
import org.coffeebean.barista.dao.MemberDaoImpl;
import org.coffeebean.barista.vo.Member;

public class AccountUtils {
	
	MemberDao dao = MemberDaoImpl.getInstance();
	
	List<Member> list = dao.getAccountInfo(null);

}
