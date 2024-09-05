package stage.talys.calendrierSpringBoot.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import stage.talys.calendrierSpringBoot.Entities.User;

@CrossOrigin("http://localohost:4200/")
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
