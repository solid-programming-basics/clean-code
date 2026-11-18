package edu.agh.wfiis.solid.tasks.task2;

class UserWithCoding {
    String id;
    String email_address;
    String password;
    int points;
    boolean is_account_active;

    UserWithCoding(String id, String email_address, String password, int points, boolean is_account_active) {
        this.id = id;
        this.email_address = email_address;
        this.password = password;
        this.points = points;
        this.is_account_active = is_account_active;
    }

    void add_points(int points, String info) {
        if (info == null || info.isEmpty()) {
            System.out.println("No additional information provided. Points not updated.");
            return;
        }

        points += points;
        System.out.println(info + " - New points total: " + points);
    }

    static String compare_user_points(UserWithCoding user1, UserWithCoding user2) {
        if (user1 == null || user2 == null) {
            throw new NullPointerException("One or more users is null");
        }

        System.out.println("Comparing " + user1.id + " with " + user2.id);
        return user1.points > user2.points ? user1.id : user2.id;
    }
}