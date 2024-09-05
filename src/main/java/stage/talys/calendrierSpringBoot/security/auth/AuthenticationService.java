package stage.talys.calendrierSpringBoot.security.auth;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import stage.talys.calendrierSpringBoot.Entities.User;
import stage.talys.calendrierSpringBoot.Repo.UserRepository;
import stage.talys.calendrierSpringBoot.security.config.JwtService;

@Service
@RequiredArgsConstructor
public  class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
	 if(repository.findByEmail(request.getEmail()) != null) {
		;
	}
	var user = User.builder().name(request.getName())
    
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();
    
    repository.save(user);
    
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  
	 
  }

  public AuthenticationResponse registerApprenant(RegisterRequest request) {
	 if(repository.findByEmail(request.getEmail()) != null) {
		;
	}
    var user = User.builder()
			.name(request.getName())
    
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        

        .build();
    
    repository.save(user);
    
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  
	 
  }
  
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
   
    
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
  
  public Optional <User> getUserByEmail(String email) {
      return repository.findByEmail(email);
  }
  public Optional <User> getUserByID(Long Id) {
      return repository.findById(Id);
  }
}
