package edu.agh.wfiis.solid.tasks.task1;

import java.util.Optional;

public enum CodeQuality {
    GOOD(10, "Good code reviewed. Points awarded to %s."),
    EXCELLENT(75),
    FANTASTIC(100),
    BAD(-10, "Bad code reviewed. Points subtracted from %s.");

    private final int pointsChange;
    private final String announcementTemplate;

    CodeQuality(int pointsChange) {
        this(pointsChange, null);
    }

    CodeQuality(int pointsChange, String announcementTemplate) {
        this.pointsChange = pointsChange;
        this.announcementTemplate = announcementTemplate;
    }

    int pointsChange() {
        return pointsChange;
    }

    Optional<String> announcementFor(String authorName) {
        return Optional.ofNullable(announcementTemplate)
                .map(template -> String.format(template, authorName));
    }
}
