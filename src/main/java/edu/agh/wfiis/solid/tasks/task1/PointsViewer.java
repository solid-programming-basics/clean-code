package edu.agh.wfiis.solid.tasks.task1;

public class PointsViewer extends User {
    public PointsViewer(String name) {
        super(name);
    }

    public void viewPoints(PointsEarner earner) {
        System.out.println(earner.getName() + " has " + earner.getTotalPoints() + " points.");
    }
}