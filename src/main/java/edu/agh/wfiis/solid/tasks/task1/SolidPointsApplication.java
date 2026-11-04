package edu.agh.wfiis.solid.tasks.task1;

public final class SolidPointsApplication {

    private SolidPointsApplication() {
    }

    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer bob = new CodeReviewer();
        PointsViewer charlie = new PointsViewer();

        alice.earnPoints(10);
        System.out.println("Alice's points: " + alice.solidPoints());
        alice.earnPoints(20);
        System.out.println("Alice's points: " + alice.solidPoints());

        bob.reviewCodeOf(alice, CodeQuality.EXCELLENT);
        System.out.println("Alice's points after review: " + alice.solidPoints());

        charlie.viewPoints(alice);

        bob.reviewCodeOf(alice, CodeQuality.BAD);
        System.out.println("Alice's points after bad review: " + alice.solidPoints());
    }
}
