package in.skumar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.skumar.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	@Query("upadate UserEntity set accStatus=:status where userId=:userId")
	public Integer updateUserAccStatus(Integer userId, String status);

	public UserEntity findByEmail(String email);

	public UserEntity findByEmailAndPwd(String email,String pwd);
}


