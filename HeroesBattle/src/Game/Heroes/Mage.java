package Game.Heroes;

import Game.Realisation.Team;

public class Mage extends Hero {

    public Mage(Team team) {
        super(team,"Волшебник", 80, 80, 100, 0);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой который бьет жив, он может ударить
            if (this.health <= 0) {
                return;
            } else {
                hero.causeDamage(damage);
            }
            this.damageInfo(hero);
        }
    }

    @Override
    public void healing(Team hero) {
        this.getTeam().getGame().printText("Волшебники не умеют лечить!");
        System.out.println("Волшебники не умеют лечить!");
    }
}
