package edu.agh.wfiis.solid.tasks.task1;

public class User {
    protected int solidPoints;
    protected String name;

    public User(String name) {
        this.name = name; // Assign the user's name to the name variable
        this.solidPoints = 0; // Initialize points to zero
    }

    public void earnPoints(int points) {
        try {
            // Additional condition: Check if points are within a valid range
            if (points > 0 && points < 100) { // Assuming the max points that can be earned at once is 100
                this.solidPoints += points; // Add points to the user's total points
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
                this.solidPoints -= points; // Subtract points from the user's total points
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
        return this.solidPoints; // Return the user's total points
    }

    public void displayPoints() {
        // This method prints the user's points
        System.out.println("Total SOLID points: " + this.solidPoints);
    }

    public void resetPoints() {
        this.solidPoints = 0; // Reset the user's points to zero
    }
}
