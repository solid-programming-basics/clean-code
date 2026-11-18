package edu.agh.wfiis.solid.tasks.task2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Manager {
    List<Review> reviews;
    List<UserWithCoding> users_with_coding;

    Manager() {
        this.reviews = new ArrayList<>();
        this.users_with_coding = new ArrayList<>();
    }

    void handle_user_validation(UserWithCoding account, StringBuilder err) {
        if (account.id.isEmpty()) {
            err.append("User key cannot be empty.\n");
        }
        if (!account.email_address.contains("@")) {
            err.append("Client email is invalid.\n");
        }
        if (account.password.length() < 6) {
            err.append("Password must be at least 6 characters long.\n");
        }
        if (!account.is_account_active) {
            err.append("Customer is currently inactive.\n");
        }
        for (char c : account.password.toCharArray()) {
            if (c=='*') {
                err.append("Password contains an invalid character: *\n");
                break;
            }
        }
    }

    Review create_review(UserWithCoding revieved_person, List<String> comments, String reviever_name) {
        if (comments == null || comments.isEmpty()) {
            throw new NullPointerException("No comments have been provided");
        }

        String review_data = "Review for user " + revieved_person.id + ", created at " + Instant.now() + " by " + reviever_name;
        Review rev = new Review(
            reviews.size() + 1,
            false,
            review_data,
            comments);

        reviews.add(rev);
        users_with_coding.add(revieved_person);

        return rev;
    }

    void add_comment_to_review(UserWithCoding person, List<String> comments) {
        if (comments == null || comments.isEmpty()) {
            return;
        }

        int idx = -100;
        for (int i = 0; i < users_with_coding.size(); i++) {
            if (users_with_coding.get(i).id.equals(person.id)) {
                idx = i;
                break;
            }
        }

        if (idx == -100) {
            System.out.println("Cannot update");
            return;
        }

        Review rev;
        rev = reviews.get(idx);
        rev.add_review_data(comments, true);
    }

    void process_review_for_user(String user_id, int review_id, int score, String feedback_data) {
        UserWithCoding processed_user = null;
        Review review = null;

        // Check if review is in reviews
        for (Review rev : reviews) {
            if (rev.rev_id == review_id) {
                review = rev;
                break;
            }
        }
        if (review == null) {
            System.out.println("Review not found with ID: " + review_id);
            return;
        }
        if (review.is_finished()) {
            System.out.println("Review has already been processed. No points will be awarded.");
            return;
        }

        // Check if user_id is in users_with_coding
        for (UserWithCoding user : users_with_coding) {
            if (user.id.equals(user_id)) {
                processed_user = user;
                break;
            }
        }
        if (processed_user == null) {
            System.out.println("User not found with handle: " + user_id);
            return;
        }

        review.add_review_data(null, false);
        processed_user.add_points(score, feedback_data);
        System.out.println("Review completed for " + user_id + ". Points awarded: " + score);
    }
}
