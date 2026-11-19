package edu.agh.wfiis.solid.tasks.task1;

public class SolidPointsApplication {
    public static void main(String[] args) {
        PointsEarner earner1 = new PointsEarner("Alice");
        CodeReviewer reviewer1 = new CodeReviewer("Bob");
        PointsViewer viewer1 = new PointsViewer("Charlie");

        try {
            earner1.earnPoints(10);
            earner1.earnPoints(20);

            reviewer1.reviewCode(earner1, "excellent");
            System.out.println("Alice's points after review: " + earner1.getSolidPoints());

            viewer1.viewPoints(earner1);

            reviewer1.reviewCode(earner1, "bad");
            System.out.println("Alice's points after bad review: " + earner1.getSolidPoints());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}