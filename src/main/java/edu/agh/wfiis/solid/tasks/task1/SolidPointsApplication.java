package edu.agh.wfiis.solid.tasks.task1;

import java.text.MessageFormat;

public class SolidPointsApplication {

    public static void main(String[] args) {
        SolidPoints alicePoints = new SolidPoints(new User("Alice"));
        CodeReviewer bob = new CodeReviewer(new User("Bob"));
        PointsViewer charlie = new PointsViewer(new User("Charlie"));

        try {
            alicePoints.earnPoints(10);
            alicePoints.earnPoints(20);

            bob.reviewCode("excellent", alicePoints);
            charlie.viewPoints(alicePoints);
            bob.reviewCode("bad", alicePoints);
        } catch (IllegalArgumentException e) {
            System.err.println(MessageFormat.format("Error: {0}", e.getMessage()));
        }
    }
}
