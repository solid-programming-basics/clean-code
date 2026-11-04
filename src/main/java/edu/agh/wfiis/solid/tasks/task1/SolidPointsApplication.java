package edu.agh.wfiis.solid.tasks.task1;

public final class SolidPointsApplication {

    private SolidPointsApplication() {
    }

    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer bob = new CodeReviewer();
        PointsViewer charlie = new PointsViewer();

        alice.earnPoints(10);
        System.out.println("Alice's points: " + alice.getTotalPoints());
        alice.earnPoints(20);
        System.out.println("Alice's points: " + alice.getTotalPoints());

        bob.reviewCode(alice, CodeQuality.EXCELLENT);
        System.out.println("Alice's points after review: " + alice.getTotalPoints());

        charlie.viewPoints(alice);

        bob.reviewCode(alice, CodeQuality.BAD);
        System.out.println("Alice's points after bad review: " + alice.getTotalPoints());
    }
}
