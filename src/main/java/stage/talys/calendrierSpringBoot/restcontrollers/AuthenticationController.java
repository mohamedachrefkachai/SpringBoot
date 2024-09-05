package stage.talys.calendrierSpringBoot.restcontrollers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import stage.talys.calendrierSpringBoot.Entities.User;
import stage.talys.calendrierSpringBoot.security.auth.AuthenticationRequest;
import stage.talys.calendrierSpringBoot.security.auth.AuthenticationResponse;
import stage.talys.calendrierSpringBoot.security.auth.AuthenticationService;
import stage.talys.calendrierSpringBoot.security.auth.RegisterRequest;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	@PostMapping("/registerUser")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/registerApprenant")
	public ResponseEntity<AuthenticationResponse> registerApprenant(@RequestBody RegisterRequest request) {

		return ResponseEntity.ok(service.registerApprenant(request));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

	@GetMapping("/email/{email}")
	public Optional<User> getUserByEmail(@PathVariable String email) {
		return service.getUserByEmail(email);
	}

	@GetMapping("/id/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return service.getUserByID(id);
	}

}
