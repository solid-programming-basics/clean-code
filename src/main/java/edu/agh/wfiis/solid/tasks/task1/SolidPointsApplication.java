package edu.agh.wfiis.solid.tasks.task1;

public class SolidPointsApplication {
    public static void main(String[] args) {
        SolidPoints alice = new SolidPoints("Alice");
        CodeReviewer bob = new CodeReviewer("Bob");
        PointsViewer charlie = new PointsViewer("Charlie");

        // Adding points directly for Alice
        try {
            alice.earnPoints(10);
            System.out.println("Alice's points: " + alice.getSolidPoints());
            alice.earnPoints(20);
            System.out.println("Alice's points: " + alice.getSolidPoints());

            // Reviewer Bob reviews code and adds points for Alice
            bob.reviewCode(alice, "excellent"); // Excellent code reviewed
            System.out.println("Alice's points after review: " + alice.getSolidPoints());

            // Viewer Charlie views Alice's points
            charlie.viewPoints(alice);

            // Subtract points for bad review
            bob.reviewCode(alice, "bad"); // Bad code reviewed
            System.out.println("Alice's points after bad review: " + alice.getSolidPoints());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

