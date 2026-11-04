package edu.agh.wfiis.solid.tasks.task1;

final class User {
    private static final int MAX_POINTS_PER_EARNING = 100;

    private final String name;

    /** Never negative. */
    private int solidPoints;

    User(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    int solidPoints() {
        return solidPoints;
    }

    void earnPoints(int points) {
        if (points <= 0 || points > MAX_POINTS_PER_EARNING) {
            throw new IllegalArgumentException(
                    "Points to earn must be between 1 and " + MAX_POINTS_PER_EARNING + ", got " + points + ".");
        }
        solidPoints += points;
    }

    void losePoints(int points) {
        if (points <= 0) {
            throw new IllegalArgumentException("Points to lose must be positive, got " + points + ".");
        }
        solidPoints = Math.max(0, solidPoints - points);
    }
}
