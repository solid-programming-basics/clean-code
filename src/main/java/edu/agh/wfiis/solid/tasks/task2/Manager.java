package edu.agh.wfiis.solid.tasks.task2;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Manager {
    private int count = 0;
    Map<UserWithCoding, Review> user_reviews;

    Manager() {
        this.user_reviews = new HashMap<>();
    }

    private void validateBeginReviewForUser(List<String> comments) {
        if (comments == null || comments.isEmpty()) {
            throw new IllegalArgumentException("No comments have been provided");
        }
    }

    Review beginReviewForUser(UserWithCoding revieved_person, List<String> comments, String reviever_name) {
        validateBeginReviewForUser(comments);

        String review_data = "Review for user " + revieved_person.id + ", created at " + Instant.now() + " by " + reviever_name;
        Review rev = new Review(
            this.count,
            false,
            review_data,
            comments);
        this.count++;

        user_reviews.put(revieved_person, rev);

        return rev;
    }

    private void validateAddCommentToReview(UserWithCoding person, List<String> comments) {
        if (comments == null || comments.isEmpty()) {
            throw new IllegalArgumentException("No comments have been provided.");
        }
        if (!this.user_reviews.containsKey(person)) {
            throw new IllegalArgumentException("Person does not exist in revieved users list.");
        }
    }

    void addCommentToReview(UserWithCoding person, List<String> comments) {
        validateAddCommentToReview(person, comments);
        this.user_reviews.get(person).addReviewData(comments, true);
    }

    private boolean doesUserExistWithReviev(String user_id, int review_id) {
        for (UserWithCoding key : this.user_reviews.keySet()) {
            if (key.id == user_id) {
                if (review_id == this.user_reviews.get(key).rev_id) {
                    return true;
                }
            }
        }
        return false;
    }

    private void validateFinishReviewForUser(String user_id, int review_id) {
        if (!doesUserExistWithReviev(user_id, review_id)) {
            throw new IllegalArgumentException("User with ID " + user_id + " does not exist with review ID " + review_id);
        }
    }

    void finishReviewForUser(String user_id, int review_id, int score, String feedback_data) {
        validateFinishReviewForUser(user_id, review_id);

        Review review = null;
        UserWithCoding processed_user = null;

        for (UserWithCoding key : this.user_reviews.keySet()) {
            if (key.id == user_id) {
                Review curr_rev = this.user_reviews.get(key);
                if (review_id == curr_rev.rev_id) {
                    processed_user = key;
                    review = curr_rev;
                }
            }
        }

        review.addReviewData(null, false);
        processed_user.addPoints(score, feedback_data);
        System.out.println("Review completed for " + user_id + ". Points awarded: " + score);
    }
}
