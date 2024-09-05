package stage.talys.calendrierSpringBoot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stage.talys.calendrierSpringBoot.Entities.Events;
import stage.talys.calendrierSpringBoot.Repo.EventsRepository;
import stage.talys.calendrierSpringBoot.Service.EventsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/eventapi")
public class EventsController {

	@Autowired
	EventsService eventServ;

	@Autowired
	private EventsRepository eventsRepository;

	@PostMapping("/register")
	public ResponseEntity<Events> registerEvent(@RequestBody Events event) {
		Events savedEvent = eventServ.saveEvent(event);
		return ResponseEntity.ok(savedEvent);
	}

	// Get events formatted for FullCalendar
	@GetMapping("/calendar")
	public ResponseEntity<List<Map<String, Object>>> getEventsForCalendar() {
		List<Events> events = eventsRepository.findAll();
		List<Map<String, Object>> eventList = events.stream().map(event -> {
			Map<String, Object> map = new HashMap<>();
			map.put("title", event.getTitle());
			map.put("start", event.getDateDebut().toString()); // Ensure ISO 8601 format
			map.put("end", event.getDateFin().toString()); // Ensure ISO 8601 format
			return map;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(eventList);
	}

}
