package stage.talys.calendrierSpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stage.talys.calendrierSpringBoot.Entities.User;
import stage.talys.calendrierSpringBoot.Repo.UserRepository;

@Service
public class UserServiceImplements implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User U) {
		return userRepository.save(U);
	}

	@Override
	public User updateUser(User U) {
		// TODO Auto-generated method stub

		return userRepository.save(U);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User update(User user, Long id) {
		// Retrieve the existing user by id
		User existingUser = getUserById(id);

		// Update the necessary fields
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		// Add more fields as needed

		// Save and return the updated user
		return userRepository.save(existingUser);
	}


	@Override
	public void deletUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

}
