package stage.talys.calendrierSpringBoot.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import stage.talys.calendrierSpringBoot.Entities.User;
import stage.talys.calendrierSpringBoot.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend

public class UserRESTController {

	@Autowired
	UserService userService;

	public UserRESTController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.listAllUsers();
	}


	@RequestMapping(method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
