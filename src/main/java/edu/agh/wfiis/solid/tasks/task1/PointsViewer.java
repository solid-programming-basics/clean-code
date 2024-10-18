package edu.agh.wfiis.solid.tasks.task1;

public class PointsViewer extends SolidPoints {
    public PointsViewer(String name) {
        super(name);
    }

    @Override
    public void earnPoints(int points) {
    }

    public void viewPoints(User user) {
        System.out.println(user.name + " has " + getTotalPoints() + " points.");
    }
}

