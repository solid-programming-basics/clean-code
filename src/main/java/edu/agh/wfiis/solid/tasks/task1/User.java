package edu.agh.wfiis.solid.tasks.task1;

// Reguła 7: Projektuj dla dziedziczenia albo go zabraniaj - klasa finalna zapobiega nadużyciom
public final class User {
    // Reguła 4 i 5: Pola są prywatne, a 'name' jest niemutowalne (final)
    private int solidPoints;
    private final String name;

    public User(String name) {
        this.name = name;
        this.solidPoints = 0;
    }

    public String getName() {
        return name;
    }

    // Reguła 3: Metoda nie jest anemiczna, inkapsuluje logikę przyznawania punktów.
    // Reguła 8: Wyjątki tylko dla sytuacji wyjątkowych (brak bloków try-catch dla zwykłej logiki)
    public void earnPoints(int points) {
        if (points <= 0) {
            throw new IllegalArgumentException("Points must be positive.");
        }
        this.solidPoints += points;
    }

    public void subtractPoints(int points) {
        if (points <= 0 || points > this.solidPoints) {
            throw new IllegalArgumentException("Invalid points amount to subtract.");
        }
        this.solidPoints -= points;
    }

    public int getTotalPoints() {
        return this.solidPoints;
    }
}