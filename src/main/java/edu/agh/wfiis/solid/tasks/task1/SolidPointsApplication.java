package edu.agh.wfiis.solid.tasks.task1;

public final class SolidPointsApplication {

    private SolidPointsApplication() {
    }

    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer codeReviewer = new CodeReviewer();
        PointsViewer pointsViewer = new PointsViewer();

        try {
            alice.earnPoints(10);
            System.out.println(alice.pointsSummary());
            alice.earnPoints(20);
            System.out.println(alice.pointsSummary());

            codeReviewer.reviewCode(alice, CodeQuality.EXCELLENT);
            System.out.println(alice.pointsSummaryAfter("review"));

            pointsViewer.viewPoints(alice);

            codeReviewer.reviewCode(alice, CodeQuality.BAD);
            System.out.println(alice.pointsSummaryAfter("bad review"));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
