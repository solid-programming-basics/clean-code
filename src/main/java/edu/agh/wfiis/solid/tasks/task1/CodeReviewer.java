package edu.agh.wfiis.solid.tasks.task1;

final class CodeReviewer {

    void reviewCode(User author, CodeQuality quality) {
        author.applyReviewResult(quality.getPointsChange());
        System.out.println(quality.reviewMessageFor(author.getName()));
    }
}
