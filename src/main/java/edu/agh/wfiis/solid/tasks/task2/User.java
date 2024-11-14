package edu.agh.wfiis.solid.tasks.task2;

import java.util.*;

final class User implements Identifiable{
    private final String username;
    private final String email;
    private final String password;
    private final boolean active;

    private User(String username, String email, String password, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public static User create(String username, String email, String password, boolean active) {
        UserValidator validator = new UserValidator();
        List<String> errors = validator.validate(username, email, password);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("User creation failed: " + String.join(", ", errors));
        }

        return new User(username, email, password, active);
    }

    public static List<String> isCreatableFrom(String username, String email, String password) {
        UserValidator validator = new UserValidator();
        List<String> errors = validator.validate(username, email, password);
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String identify() {
        return username;
    }

    private static class UserValidator {
        private static final Set<Character> INVALID_PASSWORD_CHARACTERS =
                Set.of('!', '@', '#', '$', '%', '^', '&', '*');

        public List<String> validate(String username, String email, String password) {
            List<String> errors = new ArrayList<>();
            validateUsername(username, errors);
            validateEmail(email, errors);
            validatePassword(password, errors);
            return errors;
        }

        private void validateUsername(String username, List<String> errors) {
            if (username == null || username.isEmpty()) {
                errors.add("Username cannot be empty.");
            }
        }

        private void validateEmail(String email, List<String> errors) {
            if (email == null || !email.contains("@")) {
                errors.add("Email is invalid.");
            }
        }

        private void validatePassword(String password, List<String> errors) {
            if (password.length() < 8) {
                errors.add("Password must be at least 8 characters long.");
            }
            for (char c : password.toCharArray()) {
                if (INVALID_PASSWORD_CHARACTERS.contains(c)) {
                    errors.add("Password contains an invalid character: " + c);
                }
            }
        }
    }
}
