package dev.agwenchez.runnerz.run;

import javax.xml.stream.Location;
import java.time.Duration;
import java.time.LocalDateTime;

public class Run {
    private Integer id;
    private String title;
    private LocalDateTime startedOn;
    private LocalDateTime completedOn;
    private Integer miles;
    private Location location;

    public Run(Location location, Integer miles, LocalDateTime completedOn, LocalDateTime startedOn, String title, Integer id) {
        this.location = location;
        this.miles = miles;
        this.completedOn = completedOn;
        this.startedOn = startedOn;
        this.title = title;
        this.id = id;

        if(!this.completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed on must be after started on");
        }
    }

    public Integer getId() {
        return id;
    }

    public Duration getDuration(){
        return Duration.between(startedOn, completedOn);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getAvgPace(){
        return Math.toIntExact(this.getDuration().toMinutes()/miles);
    }
}
