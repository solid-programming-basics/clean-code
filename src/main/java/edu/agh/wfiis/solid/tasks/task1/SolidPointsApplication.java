package edu.agh.wfiis.solid.tasks.task1;

public class SolidPointsApplication {
    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer bob = new CodeReviewer("Bob");
        PointsViewer charlie = new PointsViewer("Charlie");

        try {
            alice.earnPoints(10);
            System.out.println("Alice's points: " + alice.getTotalPoints());
            alice.earnPoints(20);
            System.out.println("Alice's points: " + alice.getTotalPoints());

            bob.reviewUserCode(alice, CodeQuality.EXCELLENT);
            System.out.println("Alice's points after review: " + alice.getTotalPoints());

            charlie.viewUserPoints(alice);
            // Viewer Charlie został usunięty (Reguła 9), wywołujemy po prostu getter.
//            System.out.println(alice.getName() + " has " + alice.getTotalPoints() + " points.");

            bob.reviewUserCode(alice, CodeQuality.BAD);
            System.out.println("Alice's points after bad review: " + alice.getTotalPoints());
            charlie.viewUserPoints(alice);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}