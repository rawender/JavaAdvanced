package Game.Heroes;

import Game.Realisation.Team;

public class Warrior extends Hero {    //Класс воин для создания конкретной реализации героя

    public Warrior(Team team) {
        super(team,"Воин", 240, 240, 60, 0);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой который бьет жив, он может ударить
            if (health <= 0) {
                return;
            } else {
                hero.causeDamage(damage);
            }
            this.damageInfo(hero);
        }
    }

    @Override
    public void healing(Team hero) {
        this.getTeam().getGame().printText("Войны не умеют лечить!");
        System.out.println("Войны не умеют лечить!");
    }
}
