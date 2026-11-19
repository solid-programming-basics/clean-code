package edu.agh.wfiis.solid.tasks.task1;

public class CodeReviewer extends User {
    public CodeReviewer(String name) {
        super(name);
    }

    @Override
    public void earnPoints(int points) {
        // This operation is not supported for CodeReviewer
        throw new UnsupportedOperationException("Earning points is not supported for CodeReviewers.");
    }

    public void reviewCode(PointsEarner user, String codeQuality) {
        if (codeQuality.equals("good")) {
            user.earnPoints(10);
            System.out.println("Good code reviewed. Points awarded to " + user.getName() + ".");
        } else if (codeQuality.equals("excellent")) {
            user.earnPoints(75);
            System.out.println("Excellent code reviewed. Points awarded to " + user.getName() + ".");
        } else if (codeQuality.equals("fantastic")) {
            user.earnPoints(100);
            System.out.println("Fantastic code reviewed. Points awarded to " + user.getName() + ".");
        }else {
            user.subtractPoints(10);
            System.out.println("Bad code reviewed. Points subtracted from " + user.getName() + ".");
        }
    }
}
