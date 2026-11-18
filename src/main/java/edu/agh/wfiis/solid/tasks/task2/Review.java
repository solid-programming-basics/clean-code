package edu.agh.wfiis.solid.tasks.task2;

import java.util.List;

class Review {
    int rev_id;
    boolean is_processed;
    String review_data;
    List<String> comments;

    Review(int rev_id, boolean is_processed, String review_data, List<String> comments) {
        this.rev_id = rev_id;
        this.is_processed = is_processed;
        this.review_data = review_data;
        this.comments = comments;
    }

    void add_review_data(List<String> list, boolean update_only) {
        if (!update_only && is_processed) {
            throw new IllegalArgumentException("Review with ID " + rev_id + " has already been processed. Cannot process again.");
        }
        if (!update_only) {
            is_processed = true;
            System.out.println("Review with ID " + rev_id + " has been processed.");
            return;
        }

        for (String rev_data : list) {
            System.out.println("Comment: " + rev_data);
            if (rev_data.length() > 100) {
                System.out.println("Too long!");
            } else {
                comments.add(rev_data);
            }
        }
    }

    Boolean is_finished() {
        return is_processed ? true : false;
    }
}