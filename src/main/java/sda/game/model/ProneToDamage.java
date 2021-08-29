package sda.game.model;

import sda.game.exceptions.GameOverException;

public interface ProneToDamage {
    void receiveDamage(int healthPoints) throws GameOverException;
}
