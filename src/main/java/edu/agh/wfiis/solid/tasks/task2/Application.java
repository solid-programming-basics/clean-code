package edu.agh.wfiis.solid.tasks.task2;

import java.util.ArrayList;
import java.util.List;

class Application {
    public static void main(String[] args) {
        Manager manage = new Manager();
        UserWithCoding user1 = new UserWithCoding("JohnDoe", "john.doe@example.com", "password123", 100, true);
        UserWithCoding user2 = new UserWithCoding("jane", "jane.smith@example.com", "pass", 50, false);

        StringBuilder errors = new StringBuilder();
        user1.validateUser(errors);
        if (errors.length() > 0) {
            System.out.println("Validation errors: " + errors);
        }
        user2.validateUser(errors);
        if (errors.length() > 0) {
            System.out.println("Validation errors: " + errors);
        }

        List<String> comments = new ArrayList<>();
        comments.add("SOLID rules preserved");
        comments.add("Good naming");
        comments.add("Readable code");

        Review review1 = manage.beginReviewForUser(user1, comments, "Bobby");
        manage.finishReviewForUser(user1.id, review1.rev_id, 10, "Great job, keep it up!");
        comments.clear();

        comments.add("LSP violated");
        comments.add("Good naming");
        Review review2 = manage.beginReviewForUser(user2, comments, "Bob");
        manage.addCommentToReview(user2, new ArrayList<>(){{this.add("I forgot that ISP violation should be fixed too");}});
        manage.finishReviewForUser(user2.id, review2.rev_id, 1, "Need some improvement!");
        comments.clear();

        // Make a method relating instance, not static
        String betterUser = user1.compareUserPoints(user2);
        System.out.println("User with more points: " + betterUser);
    }
}
