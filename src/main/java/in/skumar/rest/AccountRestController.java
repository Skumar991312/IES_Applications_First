package in.skumar.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.skumar.bindings.UserAccForm;
import in.skumar.services.AccountServices;
import jakarta.websocket.server.PathParam;

@RestController
public class AccountRestController {

   private Logger logger=LoggerFactory.getLogger(AccountRestController.class);

	@Autowired
	private AccountServices accService;

	@PostMapping("/user")
	public ResponseEntity<String>  createAccount(@RequestBody UserAccForm userAccForm){

		 logger.debug("Account Creation Process Started...");
		 boolean status=accService.createUserAccount(userAccForm);
		 logger.debug("Account Creation Process Completed...");
		if(status) {
	      logger.info("Account Creations Successfully..");
		 return new ResponseEntity<>("Account Created",HttpStatus.CREATED);
		}else {
		 logger.info("Account Creations Failed...");
		 return new ResponseEntity<>("Account Creations Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserAccForm>> getUsers(){
		 logger.debug(" Fetched User Account  Process Started...");
		 List<UserAccForm> userList=accService.fetchUserAccount();
	     logger.debug("Fetching User Account  Process Completed...");
		 logger.info("Fetching User Account  Success...");

		return new ResponseEntity<>(userList,HttpStatus.OK);

	}

	@GetMapping("/user{userId}")
	public ResponseEntity<UserAccForm> getUser(@PathParam("userId") Integer userId){

         UserAccForm user=accService.getUserAccById(userId);
     	 logger.info("  User Account Fetching   Success...");

         return new ResponseEntity<>(user,HttpStatus.OK);
}

	@PutMapping("/user/{userId}/{status}")
	public ResponseEntity<List<UserAccForm>> updatedUserAcc(@PathVariable("userId") Integer userId,@PathVariable("status") String status){

		 logger.debug("User Account Updated process Started...");
		 accService.changeAccStatus(userId, status);
		 logger.debug("User Account Updated process Completed...");
		 logger.info("User Account Status Updated Successfully...");
		 List<UserAccForm> userList=accService.fetchUserAccount();

		return new ResponseEntity<>(userList,HttpStatus.OK);


	}
}
