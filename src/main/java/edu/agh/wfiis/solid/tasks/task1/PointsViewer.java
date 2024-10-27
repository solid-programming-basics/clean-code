package edu.agh.wfiis.solid.tasks.task1;

final class PointsViewer {
    private final Identifiable viewer;

    public PointsViewer(Identifiable viewer) {
        this.viewer = viewer;
    }

    public void viewPoints(SolidPoints solidPoints) {
        System.out.println("Viewer " + viewer.identify() + " checked that " + solidPoints.getOwnerIdentity() + " has " + solidPoints.getPoints() + " points.");
    }
}
