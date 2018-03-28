package se.coredev.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParkingSpot {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    protected ParkingSpot(){}

    public ParkingSpot(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Label:%s", id, label);
    }
}
