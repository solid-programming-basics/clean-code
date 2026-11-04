package edu.agh.wfiis.solid.tasks.task1;

public class CodeReviewer {
    public void reviewCode(User user, String codeQuality) throws IllegalArgumentException {
        final int change;

        if ("good".equals(codeQuality)) {
            change = 10;
        } else if ("excellent".equals(codeQuality)) {
            change = 75;
        } else if ("fantastic".equals(codeQuality)) {
            change = 100;
        } else if ("bad".equals(codeQuality)) {
            change = -10;
        } else {
            throw new IllegalArgumentException("Unknown code quality.");
        }

        if (change > 0) {
            user.earnPoints(change);
        } else {
            user.subtractPoints(-change);
        }

        System.out.printf(
            "Review applied: quality=%s, change=%+d | %s%n",
            codeQuality, change, user
        );
    }
}