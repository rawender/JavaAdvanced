class Warrior extends Hero {    //Класс воин для создания конкретной реализации героя

    public Warrior(Team team) {
        super(team,"Воин", 250, 250, 50, 0);
    }

    @Override
    void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой который бьет жив, он может ударить
            if (this.health <= 0) {
                return;
            } else {
                hero.causeDamage(damage);
            }
            GameWindow.setTextToArea(this.name + " из команды " + this.getTeam().getTeamName() + " нанес урон герою " + hero.name + " из " + hero.getTeam().getTeamName() + "(осталось " + hero.health + " НР)");
        }
    }

    @Override
    void healing(Team hero) {
        GameWindow.setTextToArea("Войны не умеют лечить!");
    }
}
