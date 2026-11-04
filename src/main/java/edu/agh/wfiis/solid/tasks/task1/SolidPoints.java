package edu.agh.wfiis.solid.tasks.task1;

final class SolidPoints {
    private static final int MAX_POINTS_PER_AWARD = 100;

    private int balance = 0;

    @Override
    public String toString() {
        return Integer.toString(balance);
    }

    public void earn(int points) throws IllegalArgumentException {
        if (points > 0 && points <= MAX_POINTS_PER_AWARD) {
            balance += points;
        } else {
            throw new IllegalArgumentException("Points must be positive and no more than 100.");
        }
    }

    public void substract(int points) throws IllegalArgumentException {
        if (points <= 0) {
            throw new IllegalArgumentException("Points must be positive.");
        }
        if (points > balance) {
            throw new IllegalArgumentException("Not enough points.");
        }
        balance -= points;
    }

    public void reset() {
        balance = 0;
    }
}