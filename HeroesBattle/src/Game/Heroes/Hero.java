package Game.Heroes;

import Game.Realisation.Team;
import java.util.Random;

public abstract class Hero {    //Абстрактный класс родитель для создания героев
    // команда героя
    protected Team team;
    // имя героя
    protected String name;
    // максимальное здоровье героя
    protected int maxHealth;
    // текущее здоровье героя
    public int health;
    // сколько урона может нанести герой
    protected int damage;
    // сколько здоровья может восстановть герой
    protected int addHeal;
    Random random = new Random();

    public Hero(Team team, String name, int maxHealth, int health, int damage, int addHeal) {
        this.team = team;
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    public Team getTeam() {
        return team;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    // метод нанесения удара
    public abstract void hit(Hero hero);

    // метод лечения
    public abstract void healing(Team hero);

    // метод получения удара
    public void causeDamage(int damage) {
        int evasion = random.nextInt(3);
        int block = random.nextInt(8);
        if (name.equalsIgnoreCase("Лучник")) {
            if (evasion == 1) {
                this.getTeam().getGame().printText(this.getName() + " из команды " + this.getTeam().getTeamName() + " успешно уклонился!");
                System.out.println(this.getName() + " из команды " + this.getTeam().getTeamName() + " успешно уклонился!");
            } else {
                resultDamage(damage);
            }
        } else if (name.equalsIgnoreCase("Защитник")) {
            if (block == 1) {
                this.getTeam().getGame().printText(this.getName() + " из команды " + this.getTeam().getTeamName() + " успешно блокировал!");
                System.out.println(this.getName() + " из команды " + this.getTeam().getTeamName() + " успешно блокировал!");
            } else {
                resultDamage(damage);
            }
        } else {
            resultDamage(damage);
        }

    }

    // метод для добавления здоровья
    void addHealth(int health) {
        this.health += health;
        if (this.health > this.maxHealth)
            this.health = this.maxHealth;
    }

    public void info() {
        this.getTeam().getGame().printText(this.getTeam().getTeamName() + " " + name + " " + (health <= 0 ? "Герой мертвый" : health) + ".");
        System.out.println(this.getTeam().getTeamName() + " " + name + " " + (health <= 0 ? "Герой мертвый" : health) + ".");
    }

    private void resultDamage( int dmg) {
        health -= dmg;
        if (this.health <= 0) {
            this.getTeam().getGame().printText(this.getName() + " из команды " + this.getTeam().getTeamName() + " не выдержал удара и пал!");
            System.out.println(this.getName() + " из команды " + this.getTeam().getTeamName() + " не выдержал удара и пал!");
        }
    }

    protected void damageInfo(Hero hero){
        this.getTeam().getGame().printText(this.name + " из команды " + this.getTeam().getTeamName() + " атаковал героя " + hero.name + " из " + hero.getTeam().getTeamName() + "(осталось " + hero.health + " НР)");
        System.out.println(this.name + " из команды " + this.getTeam().getTeamName() + " атаковал героя " + hero.name + " из " + hero.getTeam().getTeamName() + "(осталось " + hero.health + " НР)");
    }
}
