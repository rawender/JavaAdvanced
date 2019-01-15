package Game.Heroes;

import Game.Realisation.GameWindow;
import Game.Realisation.Team;
import java.util.Random;

public class Archer extends Hero {
    int cricitalHit;

    Random random = new Random();

    public Archer(Team team) {
        super(team,"Лучник", 100, 100, 80, 0);
        this.cricitalHit = random.nextInt(8 );
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой который бьет жив, он может ударить
            if (health <= 0) {
                return;
            } else {
                if (cricitalHit == 4) {
                    hero.causeDamage(damage * 2);
                } else {
                    hero.causeDamage(damage);
                }
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
