package in.ashokit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

	@Transactional
	@Modifying
	@Query("update UserAccount set activeSw=:status where userId=:userId")
	void updateUserAccstatus(Integer userId, String status);
	
	

}
