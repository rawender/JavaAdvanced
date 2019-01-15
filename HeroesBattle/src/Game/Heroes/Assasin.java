package Game.Heroes;

import Game.Realisation.Team;
import java.util.Random;

public class Assasin extends Hero {   //Класс убийца для создания конкретной реализации героя
    int cricitalHit;
    Random random = new Random();

    public Assasin(Team team) {
        super(team,"Убийца", 160, 160, 70, 0);
        this.cricitalHit = random.nextInt(5);
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
        this.getTeam().getGame().printText("Убийцы не умеют лечить!");
        System.out.println("Убийцы не умеют лечить!");
    }
}