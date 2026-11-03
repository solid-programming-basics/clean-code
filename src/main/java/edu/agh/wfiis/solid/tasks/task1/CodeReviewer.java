package edu.agh.wfiis.solid.tasks.task1;

// Reguła 6: Faworyzuj kompozycję nad dziedziczeniem. CodeReviewer nie jest już Userem.
public final class CodeReviewer {
    private final String name;

    public CodeReviewer(String name) {
        this.name = name;
    }

    // Reguła 2: Usunięto duplikację logiki walidacji punktów.
    // Reguła 9: Unikanie switch/if-else poprzez przekazanie enuma.
    public void reviewUserCode(User user, CodeQuality codeQuality) {
        int points = codeQuality.getPoints();

        if (points > 0) {
            user.earnPoints(points); // Reguła 3: Zlecenie zmiany stanu samemu obiektowi User
            System.out.println(codeQuality + " code reviewed. Points awarded to " + user.getName() + ".");
        } else {
            user.subtractPoints(Math.abs(points));
            System.out.println(codeQuality + " code reviewed. Points subtracted from " + user.getName() + ".");
        }
    }
}