package edu.agh.wfiis.solid.tasks.task1;

public class CodeReviewer extends SolidPoints {
    public CodeReviewer(String name) {
        super(name);
    }

    @Override
    public void earnPoints(int points) {
        // This operation is not supported for CodeReviewer
        throw new UnsupportedOperationException("Earning points is not supported for CodeReviewers.");
    }

    public void reviewCode(User user, String codeQuality) {
        if (codeQuality.equals("good")) {
            // Attempting to earn ten points for the user
            user.solidPoints = user.solidPoints + 10; // Ten points are awarded to the user
            System.out.println("Good code reviewed. Points awarded to " + user.name + ".");
        } else if (codeQuality.equals("excellent")) {
            user.solidPoints = user.solidPoints + 75;
        } else if (codeQuality.equals("fantastic")) {
            user.solidPoints = user.solidPoints + 100;
        }else {
            // Attempting to subtract ten points for the user
            user.solidPoints = user.solidPoints - 10;  // Ten points are subtracted from the user
            System.out.println("Bad code reviewed. Points subtracted from " + user.name + ".");

        }
    }
}

