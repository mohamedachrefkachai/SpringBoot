package stage.talys.calendrierSpringBoot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stage.talys.calendrierSpringBoot.Entities.User;
import stage.talys.calendrierSpringBoot.Repo.UserRepository;
import stage.talys.calendrierSpringBoot.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api") // localhost:8081/User

public class UserController {

	@Autowired
	UserService userServ;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> listAllUsers() {
		return userServ.listAllUsers();
	}


	@GetMapping("/{id}")
	public Optional<User> GetUserById(@PathVariable Long id) {
		return userServ.getUser(id);
	}


	@PostMapping("/register")
	public User PostAllUser(@RequestBody User u) {
		return userServ.saveUser(u);
	}

	@DeleteMapping("/delete/{id}")
	public void DeleteUser(@PathVariable Long id) {
		userServ.deletUserById(id);
	}

	@PutMapping("/updateUser/{id}")
	public User UpdateUser(@RequestBody User user) {
		return userServ.updateUser(user);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
		// Call the update method in the service and get the updated user
		User updatedUser = userServ.update(user, id);

		if (updatedUser != null) {
			// Return the updated user along with a 200 OK status
			return ResponseEntity.ok(updatedUser);
		} else {
			// Return a 404 Not Found status
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found.");
		}
	}




}
