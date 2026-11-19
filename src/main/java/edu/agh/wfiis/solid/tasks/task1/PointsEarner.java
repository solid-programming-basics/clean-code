package edu.agh.wfiis.solid.tasks.task1;


public class PointsEarner extends User {
    public PointsEarner(String name) {
        super(name);
    }

    public int getSolidPoints() {
        return solidPoints;
    }

    public void earnPoints(int points) {
        super.earnPoints(points);
    }

    public void subtractPoints(int points) {
        super.subtractPoints(points);
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