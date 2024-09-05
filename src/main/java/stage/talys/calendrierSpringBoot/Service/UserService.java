package stage.talys.calendrierSpringBoot.Service;

import java.util.List;
import java.util.Optional;

import stage.talys.calendrierSpringBoot.Entities.User;

public interface UserService {
	User saveUser(User U);

	User updateUser(User U);

	User update(User user, Long id);

	void deletUserById(Long id);

	User getUserById(Long id);

	Optional<User> getUser(Long id);

	List<User> listAllUsers();

}
