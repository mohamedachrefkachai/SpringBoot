package stage.talys.calendrierSpringBoot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import stage.talys.calendrierSpringBoot.Entities.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {

}
