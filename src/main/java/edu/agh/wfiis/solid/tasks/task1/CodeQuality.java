package edu.agh.wfiis.solid.tasks.task1;

enum CodeQuality {
    BAD(-10),
    GOOD(10),
    EXCELLENT(75),
    FANTASTIC(100);

    private final int pointsChange;

    CodeQuality(int pointsChange) {
        this.pointsChange = pointsChange;
    }

    int pointsChange() {
        return pointsChange;
    }
}
