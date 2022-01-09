package service;

import dao.AccountDao;
import model.Account;

import java.util.List;

public class AccountService {

    AccountDao accountDao = new AccountDao();
    public  void add (Account account) {
        accountDao.createAccountDao(account);
        accountDao.showListAccount();
    }

    public void delete (int id) {
        accountDao.deleteAccount(id);
        accountDao.showListAccount();
    }

    public Account checkLoginAccount(String username, String passwords){
        List<Account> accountList = accountDao.showListAccount();
        for (Account a: accountList) {
            if(a.getUsername().equals(username) && a.getPasswords().equals(passwords)){
                return  a;
            }
        }
        return null;
    }
}
