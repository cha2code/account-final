package org.coffeebean.barista;

import org.coffeebean.barista.command.AccountInfoCommand;
import org.coffeebean.barista.command.DeleteCommand;
import org.coffeebean.barista.command.DepositCommand;
import org.coffeebean.barista.command.JoinCommand;
import org.coffeebean.barista.command.UpdateCommand;
import org.coffeebean.barista.command.WithdrawalCommand;
import org.coffeebean.common.ui.Application;
import org.coffeebean.common.ui.Menu;
import org.coffeebean.common.ui.MenuItem;

public class AccountApp extends Application {
	
	// 메뉴 생성
	@Override
	public void createMenu(Menu menu) {
		
		super.createMenu(menu);
		
		menu.add(new MenuItem("계좌 생성", new JoinCommand()));
		menu.add(new MenuItem("계좌 확인", new AccountInfoCommand()));
		menu.add(new MenuItem("입금", new DepositCommand()));
		menu.add(new MenuItem("출금", new WithdrawalCommand()));
		menu.add(new MenuItem("송금", null));
		menu.add(new MenuItem("정보 변경", new UpdateCommand()));
		menu.add(new MenuItem("계좌 삭제", new DeleteCommand()));
	}
	
	@Override
	public void cleanUp() {
		super.cleanUp();

	}
	
	public static void main(String[] args) {
		
		Application app = new AccountApp();
		app.run();
	}

}
