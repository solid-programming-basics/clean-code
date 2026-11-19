package edu.agh.wfiis.solid.tasks.task1;

import edu.agh.wfiis.solid.tasks.task1.CodeReviewer.CodeQuality;

public class SolidPointsApplication {
    public static void main(String[] args) {
        PointsEarner earner1 = new PointsEarner("Alice");
        CodeReviewer reviewer1 = new CodeReviewer("Bob");
        PointsViewer viewer1 = new PointsViewer("Charlie");

        earner1.earnAnyPoints(10);
        System.out.println(earner1.getName() + "'s points: " + earner1.getSolidPoints());
        earner1.earnAnyPoints(20);
        System.out.println(earner1.getName() + "'s points: " + earner1.getSolidPoints());

        int earnedpoints = reviewer1.reviewCode(earner1, CodeQuality.EXCELLENT);
        earner1.earnAnyPoints(earnedpoints);
        System.out.println("Alice's points after review: " + earner1.getSolidPoints());

        viewer1.viewPoints(earner1);

        earnedpoints = reviewer1.reviewCode(earner1, CodeQuality.ABHORRENT);
        earner1.earnAnyPoints(earnedpoints);
        System.out.println("Alice's points after bad review: " + earner1.getSolidPoints());
    }
}
