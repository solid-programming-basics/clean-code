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
            // Attempting to earn ten points for the user
            user.solidPoints = user.getSolidPoints() + 10; // Ten points are awarded to the user
            System.out.println("Good code reviewed. Points awarded to " + user.getName() + ".");
        } else if (codeQuality.equals("excellent")) {
            user.solidPoints = user.getSolidPoints() + 75;
        } else if (codeQuality.equals("fantastic")) {
            user.solidPoints = user.getSolidPoints() + 100;
        }else {
            // Attempting to subtract ten points for the user
            user.solidPoints = user.getSolidPoints() - 10;  // Ten points are subtracted from the user
            System.out.println("Bad code reviewed. Points subtracted from " + user.getName() + ".");

        }
    }
}
