package in.ashokit.service;

import java.util.List;

import in.ashokit.model.UserAccount;

public interface UserAccountService {

	public String saveOrUpdateUserAcc(UserAccount userAccount);

	public UserAccount showOneUser(Integer userId);

	public List<UserAccount> getAllUsers();
	
	public boolean deleteUserAcc(Integer userId);
	
	public boolean updateUserAccstatus(Integer userId,String status); 

}
