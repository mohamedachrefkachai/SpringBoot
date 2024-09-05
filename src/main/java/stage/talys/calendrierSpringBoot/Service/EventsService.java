package stage.talys.calendrierSpringBoot.Service;

import stage.talys.calendrierSpringBoot.Entities.Events;

public interface EventsService {

	Events addEvent(Events event);

	Events saveEvent(Events event);
}
