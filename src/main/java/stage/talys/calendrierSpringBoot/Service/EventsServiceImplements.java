package stage.talys.calendrierSpringBoot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stage.talys.calendrierSpringBoot.Entities.Events;
import stage.talys.calendrierSpringBoot.Repo.EventsRepository;

@Service
public class EventsServiceImplements implements EventsService {

	@Autowired
	EventsRepository eventRepository;

	@Override
	public Events saveEvent(Events e) {
		return eventRepository.save(e);
	}

	@Override
	public Events addEvent(Events event) {
		// TODO Auto-generated method stub
		return null;
	}

}
