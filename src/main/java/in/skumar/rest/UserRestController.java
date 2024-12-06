package in.skumar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.skumar.bindings.DashbordCard;
import in.skumar.bindings.LoginForm;
import in.skumar.bindings.UserAccForm;
import in.skumar.services.UserServices;

@RestController
public class UserRestController {

	@Autowired
	private UserServices userService;


	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {

		   String status=userService.login(loginForm);

		   if(status.equals("Success")) {

		   return "redirect:/dashbord?email="+loginForm.getEmail();

		   }else {
			   return status;
		   }

	}
	   @GetMapping("/dashboard")
	   public ResponseEntity<DashbordCard> buildDashboard(@RequestParam("email") String email){

		     UserAccForm user=userService.getUserByEmail(email);

		     DashbordCard dashbordCard=userService.fetchDashbordInfo();

		     dashbordCard.setUser(user);

	         return new ResponseEntity<>(dashbordCard,HttpStatus.OK);
	}
}

