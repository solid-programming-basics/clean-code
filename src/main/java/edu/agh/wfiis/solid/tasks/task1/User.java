package edu.agh.wfiis.solid.tasks.task1;

final class User {

    private static final int MAX_POINTS_PER_EARNING = 100;

    private final String name;
    private int solidPoints;

    User(String name) {
        this.name = name;
    }

    void earnPoints(int points) {
        if (!isValidEarning(points)) {
            throw new IllegalArgumentException(
                    "Points must be positive and less than " + MAX_POINTS_PER_EARNING + ".");
        }
        solidPoints += points;
    }

    void applyReviewResult(int pointsChange) {
        solidPoints += pointsChange;
    }

    int getTotalPoints() {
        return solidPoints;
    }

    String getName() {
        return name;
    }

    String pointsSummary() {
        return name + "'s points: " + solidPoints;
    }

    String pointsSummaryAfter(String event) {
        return name + "'s points after " + event + ": " + solidPoints;
    }

    private static boolean isValidEarning(int points) {
        return points > 0 && points < MAX_POINTS_PER_EARNING;
    }
}
