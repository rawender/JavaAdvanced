package Game.Heroes;

import Game.Realisation.GameWindow;
import Game.Realisation.Team;

public class Guardian extends Hero {

    public Guardian(Team team) {
        super(team, "Защитник", 200, 200, 50, 0);
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
        GameWindow.printText("Убийцы не умеют лечить!");
        System.out.println("Убийцы не умеют лечить!");
    }
}
