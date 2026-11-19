package edu.agh.wfiis.solid.tasks.task1;


public class CodeReviewer extends User {
    public enum CodeQuality {
        GOOD,
        EXCELLENT,
        FANTASTIC,
        ABHORRENT
    }

    public CodeReviewer(String name) {
        super(name);
    }

    public void reviewCode(PointsEarner user, CodeQuality codeQuality) {
        if (codeQuality.equals(CodeQuality.GOOD)) {
            user.earnPoints(10);
            System.out.println("Good code reviewed. Points awarded to " + user.getName() + ".");
        } else if (codeQuality.equals(CodeQuality.EXCELLENT)) {
            user.earnPoints(75);
            System.out.println("Excellent code reviewed. Points awarded to " + user.getName() + ".");
        } else if (codeQuality.equals(CodeQuality.FANTASTIC)) {
            user.earnPoints(100);
            System.out.println("Fantastic code reviewed. Points awarded to " + user.getName() + ".");
        } else if (codeQuality.equals(CodeQuality.ABHORRENT)) {
            user.subtractPoints(10);
            System.out.println("Bad code reviewed. Points subtracted from " + user.getName() + ".");
        }
    }
}
