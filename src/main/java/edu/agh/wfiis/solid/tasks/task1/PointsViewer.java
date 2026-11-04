package edu.agh.wfiis.solid.tasks.task1;

final class PointsViewer {

    void viewPoints(User user) {
        System.out.println(user.name() + " has " + user.solidPoints() + " points.");
    }
}
