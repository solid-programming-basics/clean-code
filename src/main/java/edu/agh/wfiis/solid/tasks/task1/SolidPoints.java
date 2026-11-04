package edu.agh.wfiis.solid.tasks.task1;

/**
 * Immutable balance of SOLID points. Every operation returns a new instance.
 */
final class SolidPoints {
    static final SolidPoints ZERO = new SolidPoints(0);

    private static final int MAX_POINTS_EARNED_AT_ONCE = 99;

    private final int value;

    private SolidPoints(int value) {
        this.value = value;
    }

    int value() {
        return value;
    }

    SolidPoints earn(int points) {
        if (!isPositiveAndAtMost(points, MAX_POINTS_EARNED_AT_ONCE)) {
            throw new IllegalArgumentException(
                    "Points to earn must be between 1 and " + MAX_POINTS_EARNED_AT_ONCE + ", but was " + points + ".");
        }
        return new SolidPoints(value + points);
    }

    SolidPoints subtract(int points) {
        if (!isPositiveAndAtMost(points, value)) {
            throw new IllegalArgumentException(
                    "Points to subtract must be positive and at most the balance of " + value + ", but was " + points + ".");
        }
        return new SolidPoints(value - points);
    }

    SolidPoints adjustBy(int pointsChange) {
        return new SolidPoints(value + pointsChange);
    }

    private static boolean isPositiveAndAtMost(int points, int limit) {
        return points > 0 && points <= limit;
    }
}
