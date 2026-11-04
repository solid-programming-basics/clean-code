package edu.agh.wfiis.solid.tasks.task1;

public enum CodeReview {
    GOOD(10),
    EXCELLENT(75),
    FANTASTIC(100),
    BAD(-10);

    private final int pointDelta;

    CodeReview(int pointDelta) {
        this.pointDelta = pointDelta;
    }

    int getPointDelta() {
        return pointDelta;
    }

    boolean awardsPoints() {
        return pointDelta > 0;
    }
}
