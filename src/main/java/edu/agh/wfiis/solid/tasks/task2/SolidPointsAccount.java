package edu.agh.wfiis.solid.tasks.task2;

import java.util.Objects;

final class SolidPointsAccount implements Comparable<SolidPointsAccount> {
    private final Identifiable owner;
    private int points;

    SolidPointsAccount(Identifiable owner) {
        this.owner = owner;
        this.points = 0;
    }

    void updatePoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    public String getOwnerIdentity() {
        return owner.identify();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SolidPointsAccount)) return false;
        SolidPointsAccount that = (SolidPointsAccount) o;
        return Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }

    @Override
    public int compareTo(SolidPointsAccount other) {
        return Integer.compare(this.points, other.points);
    }
}
