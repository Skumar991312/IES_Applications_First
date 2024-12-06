package in.skumar.services;

import in.skumar.bindings.DashbordCard;
import in.skumar.bindings.LoginForm;
import in.skumar.bindings.UserAccForm;

public interface UserServices {

   //Login User Data Form
  public String login(LoginForm loginForm);

  //User Data Forget & Recover by Email
  public boolean recoverPWD(String email);

  public  DashbordCard fetchDashbordInfo();

  public UserAccForm getUserByEmail(String email);


}
