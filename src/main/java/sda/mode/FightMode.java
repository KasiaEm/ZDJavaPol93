package sda.mode;

import sda.model.*;

import java.util.Random;

public class FightMode {
    private Hero hero;
    private Enemy enemy;

    public FightMode(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void fight() {
        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            //enemy attack
            int enemyAttackPoints = 0;
            if (enemy instanceof Bandit) {
                Bandit bandit = (Bandit) enemy;
                if (bandit.getWeapon() != null) {
                    enemyAttackPoints = bandit.getWeapon().getDamagePoints();
                } else {
                    enemyAttackPoints = bandit.getDamage();
                }
            } else if (enemy instanceof Monster) {
                Monster monster = (Monster) enemy;
                int randomDamage = monster.getDamage() * new Random().nextInt(21) / 100;
                enemyAttackPoints = monster.getDamage() + randomDamage;
            }
            hero.receiveDamage(enemyAttackPoints);
            System.out.println("Hero's health: " + hero.getHealth());
            if (hero.getHealth() <= 0) {
                break;
            }

            //hero attack
            int heroAttackPoints = 0;
            if (hero instanceof Hero) {
                Hero h = (Hero) hero;
                heroAttackPoints = h.getDamage();
            } else if (hero instanceof Warrior) {
                Warrior w = (Warrior) hero;
                if (w.getWeapon() != null) {
                    heroAttackPoints = w.getWeapon().getDamagePoints();
                } else {
                    heroAttackPoints = w.getDamage();
                }
            }
            enemy.receiveDamage(heroAttackPoints);
            System.out.println("Enemy's health: " + enemy.getHealth());
        }
        if (enemy.getHealth() <= 0 && enemy instanceof Bandit) {
            hero.addToInventory(((Bandit) enemy).getWeapon());
        }
    }
}
