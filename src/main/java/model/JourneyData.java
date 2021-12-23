package model;

import java.util.Date;
import java.util.Objects;

public class JourneyData {
    private String destination;

    public JourneyData( String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JourneyData that = (JourneyData) o;
        return Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    @Override
    public String toString() {
        return "JourneyData{" +
                "destination='" + destination + '\'' +
                '}';
    }
}
