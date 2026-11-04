package edu.agh.wfiis.solid.tasks.task1;

enum CodeQuality {
    GOOD(10, "Good code reviewed. Points awarded to %s."),
    EXCELLENT(75, "Excellent code reviewed. Points awarded to %s."),
    FANTASTIC(100, "Fantastic code reviewed. Points awarded to %s."),
    BAD(-10, "Bad code reviewed. Points subtracted from %s.");

    private final int pointsChange;
    private final String messageTemplate;

    CodeQuality(int pointsChange, String messageTemplate) {
        this.pointsChange = pointsChange;
        this.messageTemplate = messageTemplate;
    }

    int getPointsChange() {
        return pointsChange;
    }

    String reviewMessageFor(String userName) {
        return String.format(messageTemplate, userName);
    }
}
