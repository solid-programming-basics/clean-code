package edu.agh.wfiis.solid.tasks.task1;

public class SolidPoints extends User {

    public SolidPoints(String name) {
        super(name);
    }

    public int getSolidPoints() {
        return solidPoints; // Accessor for solidPoints
    }

    public void earnPoints(int points) {
        if (points > 0 && points < 100) {
            super.earnPoints(points);
        } else {
            throw new IllegalArgumentException("Points must be positive and no more than 100.");
        }
    }

    public void subtractPoints(int points) {
        if (points > 0 && points <= this.solidPoints) {
            super.subtractPoints(points);
        } else {
            throw new IllegalArgumentException("Points must be positive.");
        }
    }
}