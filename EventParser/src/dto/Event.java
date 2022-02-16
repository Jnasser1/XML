package dto;


import java.time.LocalDateTime;
import java.util.Arrays;

public class Event {
	
	private String id;
	private String name;
	private String description;
	private double ticketPrice;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Organizer organizer;
	private Participant[] array;
	private Venue venue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public void SetArray(Participant[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    // Array of participants. We have atleast 3 participants.
    public Participant[] getArray() {
        return Arrays.copyOf(array, array.length);
    }
    
    
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}