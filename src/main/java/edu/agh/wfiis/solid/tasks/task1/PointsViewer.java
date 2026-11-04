package edu.agh.wfiis.solid.tasks.task1;

public final class PointsViewer {

    public void viewPoints(User user) {
        System.out.println(user.getName() + " has " + user.getTotalPoints() + " points.");
    }
}
