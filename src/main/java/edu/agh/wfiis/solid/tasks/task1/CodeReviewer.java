package edu.agh.wfiis.solid.tasks.task1;

public class CodeReviewer {
    public void reviewCode(User user, CodeQuality codeQuality) throws IllegalArgumentException {
        if (codeQuality == null) {
            throw new IllegalArgumentException("Code quality must not be null.");
        }
        final int change;

        switch (codeQuality) {
            case GOOD:
                change = 10;
                break;
            case EXCELLENT:
                change = 75;
                break;
            case FANTASTIC:
                change = 100;
                break;
            case BAD:
                change = -10;
                break;
            default:
                throw new IllegalArgumentException("Unknown code quality: " + codeQuality);
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
