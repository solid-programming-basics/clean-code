package edu.agh.wfiis.solid.tasks.task2;

import java.util.List;
import java.util.UUID;

final class Application {

    public static void main(String[] args) {
        ReviewFlow reviewFlow = new ReviewFlow();
        SolidPointsAccount account1;
        SolidPointsAccount account2;

        List<String> validationErrors = User.isCreatableFrom("JohnDoe", "john.doe@example.com" , "password123");
        if(!validationErrors.isEmpty()){
            System.err.println("Validation errors: " + validationErrors);
            return;
        }

        validationErrors = User.isCreatableFrom("JaneSmith", "jane.smith@example.com", "password");
        if(!validationErrors.isEmpty()){
            System.err.println("Validation errors: " + validationErrors);
            return;
        }

        User john = User.create("JohnDoe", "john.doe@example.com", "password123", true);
        SolidPointsAccount johnAccount = new SolidPointsAccount(john);
        System.out.println("User created: " + john.identify());

        User jane = User.create("JaneSmith", "jane.smith@example.com", "password", false);
        SolidPointsAccount janeAccount = new SolidPointsAccount(jane);
        System.out.println("User created: " + jane.identify());

        List<String> commentsForJohn = List.of("SOLID rules preserved", "Good naming", "Readable code");
        UUID reviewIdForJohn = reviewFlow.createReview(johnAccount, commentsForJohn, "Bob");
        reviewFlow.completeReview(reviewIdForJohn, 10, "Great job, keep it up!");

        List<String> commentsForJane = List.of("LSP violated", "Good naming");
        UUID reviewIdForJane = reviewFlow.createReview(janeAccount, commentsForJane, "Bob");
        reviewFlow.updateReview(reviewIdForJane, List.of("I forgot that ISP violation should be fixed too"));
        reviewFlow.completeReview(reviewIdForJane, 1, "Need some improvement!");

        System.out.println("User with better points: " + comparePoints(johnAccount, janeAccount));
    }

    private static String comparePoints(SolidPointsAccount account1, SolidPointsAccount account2) {
        int comparison = account1.compareTo(account2);

        if (comparison > 0) {
            return account1.getOwnerIdentity();
        } else if (comparison < 0) {
            return account2.getOwnerIdentity();
        } else {
            return "Both users have the same points.";
        }
    }
}
