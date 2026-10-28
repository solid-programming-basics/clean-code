package edu.agh.wfiis.solid.tasks.task1;

public class User {
    protected int solidPoints;
    protected String name;

    public User(String name) {
        this.name = name;
        this.solidPoints = 0; // points should be a positive number and earned in increments of 1-100 points but not more than 100 points at a time
    }

    public void earnPoints(int points) {
        try {
            if (points > 0 && points < 100) {
                this.solidPoints += points;
            } else {
                throw new IllegalArgumentException("Points must be positive and no more than 100.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error occurred while earning points.");
        }
    }


    public void subtractPoints(int points) {
        try {
            if (points > 0 && points <= this.solidPoints) {
                this.solidPoints -= points;
            } else {
                throw new IllegalArgumentException("Invalid points.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error occurred while subtracting points.");
        }
    }

    public int getTotalPoints() {
        return this.solidPoints;
    }

    public void displayPoints() {
        System.out.println("Total SOLID points: " + this.solidPoints);
    }

    public void resetPoints() {
        this.solidPoints = 0;
    }
}
