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

    public int reviewCode(PointsEarner user, CodeQuality codeQuality) {
        if (codeQuality.equals(CodeQuality.GOOD)) {
            System.out.println("Good code reviewed. Points awarded to " + user.getName() + ".");
            return 10;
        } else if (codeQuality.equals(CodeQuality.EXCELLENT)) {
            System.out.println("Excellent code reviewed. Points awarded to " + user.getName() + ".");
            return 75;
        } else if (codeQuality.equals(CodeQuality.FANTASTIC)) {
            System.out.println("Fantastic code reviewed. Points awarded to " + user.getName() + ".");
            return 100;
        } else if (codeQuality.equals(CodeQuality.ABHORRENT)) {
            System.out.println("Bad code reviewed. Points subtracted from " + user.getName() + ".");
            return -10;
        } else {
            throw new Error("I'm not a java person, linter is angry with me if I don't explicitly prepare it for behaviour that will never occur.");
        }
    }
}
