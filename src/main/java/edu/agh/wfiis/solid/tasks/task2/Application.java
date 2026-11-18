package edu.agh.wfiis.solid.tasks.task2;

import java.util.ArrayList;
import java.util.List;

class Application {
    public static void main(String[] args) {
        Manager manage = new Manager();
        UserWithCoding user_1 = new UserWithCoding("JohnDoe", "john.doe@example.com", "password123", 100, true);
        UserWithCoding user_2 = new UserWithCoding("jane", "jane.smith@example.com", "pass", 50, false);

        StringBuilder errors = new StringBuilder();
        manage.handle_user_validation(user_1, errors);
        if (errors.length() > 0) {
            System.out.println("Validation errors: " + errors);
        }
        manage.handle_user_validation(user_2, errors);
        if (errors.length() > 0) {
            System.out.println("Validation errors: " + errors);
        }

        List<String> comments = new ArrayList<>();
        comments.add("SOLID rules preserved");
        comments.add("Good naming");
        comments.add("Readable code");

        Review review1 = manage.create_review(user_1, comments, "Bobby");
        manage.process_review_for_user(user_1.id, review1.rev_id, 10, "Great job, keep it up!");
        comments.clear();

        comments.add("LSP violated");
        comments.add("Good naming");
        Review review2 = manage.create_review(user_2, comments, "Bob");
        manage.add_comment_to_review(user_2, new ArrayList<>(){{this.add("I forgot that ISP violation should be fixed too");}});
        manage.process_review_for_user(user_2.id, review2.rev_id, 1, "Need some improvement!");
        comments.clear();

        String betterUser = UserWithCoding.compare_user_points(user_1, user_2);
        System.out.println("User with more points: " + betterUser);
    }
}
