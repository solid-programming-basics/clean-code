package edu.agh.wfiis.solid.tasks.task1;

public final class User {
    private final String name;
    private SolidPoints solidPoints = SolidPoints.ZERO;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return solidPoints.value();
    }

    public void earnPoints(int points) {
        solidPoints = solidPoints.earn(points);
    }

    public void subtractPoints(int points) {
        solidPoints = solidPoints.subtract(points);
    }

    void receiveReview(CodeQuality quality) {
        solidPoints = solidPoints.adjustBy(quality.pointsChange());
    }
}
