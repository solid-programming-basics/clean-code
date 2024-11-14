package edu.agh.wfiis.solid.tasks.task2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

final class Review {
    private final UUID id;
    private final List<String> comments;
    private boolean processed;

    public Review(List<String> comments, String reviewedBy, String reviewee) {
        assertComments(comments);
        this.id = UUID.randomUUID();
        this.comments = new ArrayList<>(comments);
        this.processed = false;
    }

    public void process(){
        assertNotProcessed("Cannot process a processed review.");
        processed = true;
    }

    public void addComments(List<String> newComments) {
        assertNotProcessed("Cannot update a processed review.");
        assertComments(newComments);
        this.comments.addAll(newComments);
    }

    private void assertNotProcessed(String message) {
        if (processed) {
            throw new IllegalStateException(message);
        }
    }

    public UUID getId() {
        return id;
    }

    public boolean isProcessed(){
        return processed;
    }
    
    private void assertComments(List<String> comments) {
        for (String comment : comments) {
            if (comment.length() > 100) {
                throw new IllegalArgumentException("Comment exceeds the maximum length of 100 characters: " + comment);
            }
        }
    }
}
