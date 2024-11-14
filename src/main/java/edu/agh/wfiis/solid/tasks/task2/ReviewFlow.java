package edu.agh.wfiis.solid.tasks.task2;

import java.util.*;

final class ReviewFlow {

    private final Map<SolidPointsAccount, List<Review>> reviewsByAccount = new HashMap<>();

    public UUID createReview(SolidPointsAccount account, List<String> comments, String reviewedBy) {
        Review review = new Review(comments, reviewedBy, account.toString());

        List<Review> reviewList = Optional.ofNullable(reviewsByAccount.get(account))
                .orElseGet(() -> {
                    List<Review> newList = new ArrayList<>();
                    reviewsByAccount.put(account, newList);
                    return newList;
                });

        reviewList.add(review);

        System.out.println("Review with ID " + review.getId() + " created for " + account.getOwnerIdentity() + " by " + reviewedBy + " with comments: '" + String.join(", ", comments) + "'");
        return review.getId();
    }

    public void completeReview(UUID reviewId, int points, String feedback) {
        findReviewById(reviewId)
                .ifPresent(review -> {
                    if (review.isProcessed()) {
                        throw new IllegalStateException("Review " + reviewId + " has already been processed. Cannot be updated.");
                    }
                    SolidPointsAccount solidPointsAccount = findSolidPointsAccountByReview(review)
                            .orElseThrow(() -> new IllegalStateException("No account found for the provided review."));
                    review.process();
                    solidPointsAccount.updatePoints(points);
                    System.out.println("Review with ID " + reviewId + " completed for " + solidPointsAccount.getOwnerIdentity() + ". " + points + " points awarded. Feedback: " + feedback);
                });
    }

    public void updateReview(UUID reviewId, List<String> additionalComments) {
        findReviewById(reviewId)
                .ifPresent(review -> {
                    if (review.isProcessed()) {
                        throw new IllegalStateException("Review " + reviewId + " has already been processed. No points will be added.");
                    } else {
                        review.addComments(additionalComments);
                        System.out.println("Review with ID " + reviewId + " supplemented with comments: '" + String.join(", ", additionalComments) +"'");
                    }
                });
    }

    private Optional<Review> findReviewById(UUID reviewId) {
        return reviewsByAccount.values().stream()
                .flatMap(List::stream)
                .filter(review -> review.getId().equals(reviewId))
                .findFirst();
    }

    private Optional<SolidPointsAccount> findSolidPointsAccountByReview(Review review) {
        return reviewsByAccount.entrySet().stream()
                .filter(entry -> entry.getValue().contains(review))
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
