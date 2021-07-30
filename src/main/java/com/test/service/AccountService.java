package com.test.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.entity.Account;
import com.test.entity.Department;
import com.test.entity.Position;
import com.test.form.AccountFormForCreating;
import com.test.form.AccountFormForUpdating;
import com.test.repository.IAccountRepository;
import com.test.repository.IDepartmentRepository;
import com.test.repository.IPossitionRepository;
@Service
public class AccountService implements IAccountService {
@Autowired
private IAccountRepository accountRepository;
@Autowired
private IDepartmentRepository departmentRepository;
@Autowired
private IPossitionRepository possitionRepository;
@Override
public List<Account> getAllAccount() {
// TODO Auto-generated method stub
return accountRepository.findAll();
}
@Override
public Account getAccountById(short id) {
// TODO Auto-generated method stub
return accountRepository.getById(id);
}
@Override
public void deleteAccount(short id) {
accountRepository.deleteById(id);
}
@Override
public void createAccount(AccountFormForCreating form) {
Account account = new Account();
Department department = departmentRepository.getById(form.getDepartmentId());
Position position = possitionRepository.getById(form.getPositionId());
account.setEmail(form.getEmail());
account.setUsername(form.getUsername());
account.setFullname(form.getFullname());
account.setDepartment(department);
account.setPosition(position);
accountRepository.save(account);
}
@Override
public void updateAccount(short id, AccountFormForUpdating form) {
Account account = accountRepository.getById(id);
Department department = departmentRepository.getById(form.getDepartmentId());
Position position = possitionRepository.getById(form.getPositionId());
account.setFullname(form.getFullname());
account.setDepartment(department);
account.setPosition(position);
accountRepository.save(account);
}

@Override 
 public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException{
	Account account = accountRepository.findByUsername(username);
	 if ( account == null ) {
		 throw new UsernameNotFoundException(username);
	 }
	 return new User ( account.getUsername(),account.getPassword() , AuthorityUtils.createAuthorityList(account.getRole().toString()));
	 
}
@Override 
	public Account getAccountByUsername(String username) { 
	return  accountRepository.findByUsername(username);
}
















































}