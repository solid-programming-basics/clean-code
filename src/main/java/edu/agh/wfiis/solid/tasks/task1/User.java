package edu.agh.wfiis.solid.tasks.task1;

public final class User {

    private static final int MAX_POINTS_PER_OPERATION = 100;

    private String name;
    private int solidPoints;

    public User(String name) {
        this.name = name;
        this.solidPoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getSolidPoints() {
        return solidPoints;
    }

    public void earnPoints(int points) {
        validatePointsToEarn(points);
        solidPoints += points;
    }

    public void subtractPoints(int points) {
        validatePointsToSubtract(points);
        solidPoints -= points;
    }

    private void validatePointsToEarn(int points) {
        if (points < 0 || points > MAX_POINTS_PER_OPERATION) {
            throw new IllegalArgumentException(
                    "Points must be between 0 and " + MAX_POINTS_PER_OPERATION + ".");
        }
    }

    private void validatePointsToSubtract(int points) {
        if (points <= 0) {
            throw new IllegalArgumentException("Points to subtract must be positive.");
        }
        if (points > solidPoints) {
            throw new IllegalArgumentException(
                    "Cannot subtract " + points + " points; only " + solidPoints + " available.");
        }
    }
}
