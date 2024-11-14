package edu.agh.wfiis.solid.tasks.task1;

final class SolidPoints {
    private static final int MAX_POINTS_PER_ACTION = 100;
    private final Identifiable owner;
    private int points;

    public SolidPoints(Identifiable owner) {
        this.owner = owner;
    }

    public void earnPoints(int points) {
        if (points <= 0 || points > MAX_POINTS_PER_ACTION) {
            throw new IllegalArgumentException("Points must be positive and no more than " + MAX_POINTS_PER_ACTION + ".");
        }
        this.points += points;
    }

    public void subtractPoints(int points) {
        if (points <= 0 || this.points - points < 0) {
            throw new IllegalArgumentException("Points must be positive and cannot result in negative solid points.");
        }
        this.points -= points;
    }

    public int getPoints() {
        return points;
    }

    public String getOwnerIdentity(){
        return owner.identify();
    }
}
