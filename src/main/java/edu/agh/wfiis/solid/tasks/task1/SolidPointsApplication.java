package edu.agh.wfiis.solid.tasks.task1;

public class SolidPointsApplication {
    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer reviewer = new CodeReviewer();
        PointsViewer viewer = new PointsViewer();

        try {
            alice.earnPoints(10);
            viewer.viewPoints(alice);
            alice.earnPoints(20);
            viewer.viewPoints(alice);

            reviewer.reviewCode(alice, CodeQuality.EXCELLENT);
            System.out.println("Alice's points after review: ");
            viewer.viewPoints(alice);

            viewer.viewPoints(alice);

            reviewer.reviewCode(alice, CodeQuality.BAD);
            System.out.println("Alice's points after bad review: ");
            viewer.viewPoints(alice);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
