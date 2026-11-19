package edu.agh.wfiis.solid.tasks.task1;


public class PointsEarner extends User {
    protected int solidPoints;

    public PointsEarner(String name) {
        super(name);
        this.solidPoints = 0;
    }

    public int getSolidPoints() {
        return solidPoints;
    }

    protected void pointsValidator(int points) {
        if (points <= 0) {
            throw new IllegalArgumentException("Points must be positive and more than 0.");
        }
    }

    private void fixPointsOutOfRange() {
        if (this.getTotalPoints() < 0) {
            System.out.println("Earner's points exceeded lower limit. Reverting to 0.");
            this.resetPoints();
        } else if (this.getTotalPoints() > 100) {
            System.out.println("Earner's points exceeded upper limit. Reverting to 100.");
            this.setPointsToMax();
        }
    }

    public void earnPoints(int points) {
        pointsValidator(points);
        this.solidPoints += points;
        this.fixPointsOutOfRange();
    }

    public void subtractPoints(int points) {
        pointsValidator(points);
        this.solidPoints -= points;
        this.fixPointsOutOfRange();
    }

    public void earnAnyPoints(int points) {
        if (points > 0) {
            this.earnPoints(points);
        } else {
            this.subtractPoints(Math.abs(points));
        }
    }

    public int getTotalPoints() {
        return this.solidPoints;
    }

    private void resetPoints() {
        this.solidPoints = 0;
    }

    private void setPointsToMax() {
        this.solidPoints = 100;
    }
}