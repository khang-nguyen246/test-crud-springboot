package com.test.service;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.test.entity.Account;
import com.test.form.AccountFormForCreating;
import com.test.form.AccountFormForUpdating;
public interface IAccountService extends  UserDetailsService {
public List<Account> getAllAccount();
public Account getAccountById(short id);
//
// public Account getAccountByName(String name);
//
Account getAccountByUsername(String username);

public void createAccount(AccountFormForCreating form);
public void updateAccount(short id, AccountFormForUpdating form);
public void deleteAccount(short id);
//
// public boolean isAccountExistsByID(short id);
//
// public boolean isAccountExistsByName(String name);
}
