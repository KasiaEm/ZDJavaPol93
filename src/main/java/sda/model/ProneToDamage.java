package sda.model;

import sda.exceptions.GameOverException;

public interface ProneToDamage {
    void receiveDamage(int healthPoints) throws GameOverException;
}
