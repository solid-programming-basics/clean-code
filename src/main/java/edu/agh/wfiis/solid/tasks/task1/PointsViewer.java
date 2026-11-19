package edu.agh.wfiis.solid.tasks.task1;

public class PointsViewer extends User {
    public PointsViewer(String name) {
        super(name);
    }

    @Override
    public void earnPoints(int points) {
    }

    public void viewPoints(PointsEarner earner) {
        System.out.println(earner.getName() + " has " + earner.getTotalPoints() + " points.");
    }
}