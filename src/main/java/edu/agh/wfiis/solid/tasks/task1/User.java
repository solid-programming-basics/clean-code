package edu.agh.wfiis.solid.tasks.task1;

final class User implements Identifiable{
    private final String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public String identify() {
        return name;
    }
}
