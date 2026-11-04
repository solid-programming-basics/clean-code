package edu.agh.wfiis.solid.tasks.task1;

public final class PointsViewer {

    private String name;

    public PointsViewer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void viewPoints(User user) {
        System.out.println(name + " views: " + user.getName()
                + " has " + user.getSolidPoints() + " points.");
    }
}
