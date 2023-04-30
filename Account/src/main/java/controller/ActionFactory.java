package controller;

import controller.action.*;

public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("indexBeforeLogin")) {
			action = new CustomerIndexBeforeLogin();
		} else if (command.equals("loginAction")) {
			action = new CustoemrLoginAction();
		} else if (command.equals("indexAfterLogin")) {
			action = new CustomerIndexAfterLogin();
		} else if (command.equals("joinFormAction")) {
			action = new CustoemrJoinFormAction();
		} else if (command.equals("joinAction")) {
			action = new CustoemrJoinAction();
		} else if (command.equals("logoutAction")) {
			action = new CustoemrLogoutAction();
		} else if (command.equals("createAccountAction")) {
			action = new CustomerCreateAccountAction();
		} else if (command.equals("createAccountFormAction")) {
			action = new CustomerCreateAccountFormAction();
		} else if (command.equals("exchangeAction")) {
			action = new CustomerExchangeAction();
		} else if (command.equals("customerBoardFormAction")) {
			action = new CustomerBoardForm();
		} else if (command.equals("transactionAction")) {
			action = new CustoemrTransactionAction();
		} else if (command.equals("transaction_write_form")) {
			action = new CustoemrTransactionWriteFormAction();
		}  else if (command.equals("transaction_write")) {
			action = new CustoemrTransactionWriteAction();
		} else if (command.equals("CustomerMyPageAction")) {
			action = new CustomerMyPageAction();
		} else if (command.equals("myPageAction")) {
			action = new CustomerMyPageAction();
		}  else if (command.equals("customerBoardForm")) {
			action = new CustomerBoardForm();
		}
		
		return action;
	}
}