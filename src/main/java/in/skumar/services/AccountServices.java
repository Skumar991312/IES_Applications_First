package in.skumar.services;

import java.util.List;

import in.skumar.bindings.UnlockAccForm;
import in.skumar.bindings.UserAccForm;

public interface AccountServices {

	//Check Status & create Account
	public boolean createUserAccount(UserAccForm accForm);

    //Views Account
	public List<UserAccForm> fetchUserAccount();

	// Retries Data & Edit Data
	public UserAccForm getUserAccById(Integer accId);

	//Change Account Data & Check Status
	public String changeAccStatus(Integer userId, String status);

	public String unlockUserAcc(UnlockAccForm unlockAccForm);


}
