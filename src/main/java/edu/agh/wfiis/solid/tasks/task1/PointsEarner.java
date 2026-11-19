package edu.agh.wfiis.solid.tasks.task1;


public class PointsEarner extends User {

    public PointsEarner(String name) {
        super(name);
    }

    public int getSolidPoints() {
        return solidPoints;
    }

    public void earnPoints(int points) {
        System.out.println(this.getName() + "'s points: " + getSolidPoints());
        super.earnPointsValidator(points);
        super.earnPoints(points);
    }

    public void subtractPoints(int points) {
        super.subPointsValidator(points);
        super.subtractPoints(points);
    }
}