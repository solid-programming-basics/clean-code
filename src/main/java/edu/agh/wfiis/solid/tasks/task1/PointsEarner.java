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

    protected void earnPointsValidator(int points) {
        if (points <= 0 || points > this.solidPoints) {
            throw new IllegalArgumentException("Points must be positive.");
        }
    }

    protected void subPointsValidator(int points) {
        if (points >= 0 || points > this.solidPoints) {
            throw new IllegalArgumentException("Points must be positive.");
        }
    }

    public void earnPoints(int points) {
        try {
            earnPointsValidator(points);
            this.solidPoints += points;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void subtractPoints(int points) {
        try {
            subPointsValidator(points);
            this.solidPoints -= points;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error occurred while subtracting points.");
        }
    }

    public int getTotalPoints() {
        return this.solidPoints;
    }


    // Unused methods (I'm keeping them beceuse they might be usefu later :-))
    // public void displayPoints() {
    //     System.out.println("Total SOLID points: " + this.solidPoints);
    // }

    // public void resetPoints() {
    //     this.solidPoints = 0;
    // }
}