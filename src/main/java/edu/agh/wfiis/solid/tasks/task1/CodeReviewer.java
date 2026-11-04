package edu.agh.wfiis.solid.tasks.task1;

public final class CodeReviewer {

    public void reviewCode(User author, CodeQuality quality) {
        author.receiveReview(quality);
        quality.announcementFor(author.getName()).ifPresent(System.out::println);
    }
}
