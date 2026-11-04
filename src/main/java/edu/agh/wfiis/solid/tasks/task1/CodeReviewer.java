package edu.agh.wfiis.solid.tasks.task1;

final class CodeReviewer {

    void reviewCodeOf(User author, CodeQuality quality) {
        int pointsChange = quality.pointsChange();
        if (pointsChange > 0) {  /// is this abstraction even needed if we need to use it like this?
            author.earnPoints(pointsChange);
        } else {
            author.losePoints(-pointsChange);
        }
    }
}
