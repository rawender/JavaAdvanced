import java.util.Random;

class Assasin extends Hero {    //Класс убийца для создания конкретной реализации героя
    int cricitalHit;
    Random random = new Random();

    public Assasin(Team team) {
        super(team,"Убийца", 160, 160, 70, 0);
        this.cricitalHit = random.nextInt(5);
    }

    @Override
    void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой который бьет жив, он может ударить
            if (this.health <= 0) {
                return;
            } else {
                if (cricitalHit == 4) {
                    hero.causeDamage(damage * 2);
                } else {
                    hero.causeDamage(damage);
                }

            }
            GameWindow.setTextToArea(this.name + " из команды " + this.getTeam().getTeamName() + " нанес урон герою " + hero.name + " из " + hero.getTeam().getTeamName() + "(осталось " + hero.health + " НР)" );
        }
    }

    @Override
    void healing(Team hero) {
        GameWindow.setTextToArea("Убийцы не умеют лечить!");
    }
}