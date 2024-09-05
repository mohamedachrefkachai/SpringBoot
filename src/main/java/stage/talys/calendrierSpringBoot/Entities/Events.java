package stage.talys.calendrierSpringBoot.Entities;

import java.io.Serializable;
import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@JsonPOJOBuilder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Events implements Principal, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_event;

	private String title;
	private String description;
	private String location;

	@JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm") // Ensure correct format
	private LocalDateTime start;

	@JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm") // Ensure correct format
	private LocalDateTime end;

	@ManyToOne
	private User user; // Assuming this is just a reference and not a relationship

	// Getters and Setters
	public Long getId() {
		return id_event;
	}

	public void setId(Long id) {
		this.id_event = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebut() {
		return start;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.start = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return end;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.end = dateFin;
	}



	@Override
	public String getName() {
		return title; // This is just an example. You can return a different value if needed.
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Events events = (Events) o;

		return id_event != null ? id_event.equals(events.id_event) : events.id_event == null;
	}

	@Override
	public int hashCode() {
		return id_event != null ? id_event.hashCode() : 0;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
