package edu.agh.wfiis.solid.tasks.task1;

public final class SolidPointsApplication {

    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer bob = new CodeReviewer("Bob");
        PointsViewer charlie = new PointsViewer("Charlie");

        try {
            alice.earnPoints(10);
            System.out.println("Alice's points: " + alice.getSolidPoints());

            alice.earnPoints(20);
            System.out.println("Alice's points: " + alice.getSolidPoints());

            bob.reviewCode(alice, CodeReview.EXCELLENT);
            System.out.println("Alice's points after review: " + alice.getSolidPoints());

            charlie.viewPoints(alice);

            bob.reviewCode(alice, CodeReview.BAD);
            System.out.println("Alice's points after bad review: " + alice.getSolidPoints());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
