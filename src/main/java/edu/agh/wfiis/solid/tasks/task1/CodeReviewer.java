package edu.agh.wfiis.solid.tasks.task1;

public final class CodeReviewer {

    private String name;

    public CodeReviewer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void reviewCode(User user, CodeReview quality) {
        applyPointChange(user, quality);
        printReviewOutcome(user, quality);
    }

    private void applyPointChange(User user, CodeReview quality) {
        int delta = quality.getPointDelta();
        if (quality.awardsPoints()) {
            user.earnPoints(delta);
        } else {
            user.subtractPoints(Math.abs(delta));
        }
    }

    private void printReviewOutcome(User user, CodeReview quality) {
        if (quality.awardsPoints()) {
            System.out.println(quality + " code reviewed by " + name
                    + ". Points awarded to " + user.getName() + ".");
        } else {
            System.out.println("Bad code reviewed by " + name
                    + ". Points subtracted from " + user.getName() + ".");
        }
    }
}
