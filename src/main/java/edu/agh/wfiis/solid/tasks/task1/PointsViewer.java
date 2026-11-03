package edu.agh.wfiis.solid.tasks.task1;

public final class PointsViewer {
    private final String name; // Reguła 5: Minimalizuj mutowalność[cite: 5]

    public PointsViewer(String name) {
        this.name = name;
    }

    public void viewUserPoints(User user) {
        System.out.println(this.name + " widzi, że " + user.getName() + " ma " + user.getTotalPoints() + " punktów.");
    }
}
// PointsViewer.java – istnienie osobnej klasy tylko do wyświetlenia danych tekstowych łamało zasadę pojedynczej odpowiedzialności
// i tworzyło nadmiarowy szum. Posiadanie metody dziedziczącej rzucającej wyjątek
// lub nic nie robiącej łamało zasadę podstawienia Liskov.