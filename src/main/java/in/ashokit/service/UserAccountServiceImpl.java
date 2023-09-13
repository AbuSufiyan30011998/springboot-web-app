package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.model.UserAccount;
import in.ashokit.repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAccount) {

		Integer userId = userAccount.getUserId();
		
		
		if(userId==null) {
			userAccount.setActiveSw("Y");
		}
		userAccountRepository.save(userAccount);
		if (userId == null) {
			
			return "user-record saved";
		} else {
			return "user record update";
		}
	}

	@Override
	public UserAccount showOneUser(Integer userId) {
		Optional<UserAccount> findById = userAccountRepository.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<UserAccount> getAllUsers() {
		return userAccountRepository.findAll();
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {

		boolean existsById = userAccountRepository.existsById(userId);
		if (existsById) {
			userAccountRepository.deleteById(userId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateUserAccstatus(Integer userId, String status) {

		try {
			userAccountRepository.updateUserAccstatus(userId, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
