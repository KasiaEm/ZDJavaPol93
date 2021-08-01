package sda.model.enums;

public enum Race {
    HUMAN(100),
    GHOUL(130),
    DWARF(90),
    DEMON(200);

    private int health;

    Race(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
