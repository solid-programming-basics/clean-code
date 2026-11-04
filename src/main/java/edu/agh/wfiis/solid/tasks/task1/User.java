package edu.agh.wfiis.solid.tasks.task1;

public class User {
    private final SolidPoints solidPoints = new SolidPoints();
    private final String name;

    public User(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }
        this.name = name;
    }

    public final void earnPoints(int points) {
        solidPoints.earn(points);
    }


    public final void subtractPoints(int points) {
        solidPoints.substract(points);
        
    }

    @Override 
    public String toString() {
        return name + " has " + solidPoints + " SOLID points.";
    }
}