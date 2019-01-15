package Game.Realisation;

import Game.Heroes.Hero;
import java.util.ArrayList;

public class Team {
    String teamName;
    ArrayList<Hero> heroesTeam;
    GameWindow game;

    public Team( String teamName, GameWindow game) {
        this.teamName = teamName;
        this.heroesTeam = new ArrayList <>();
        this.game = game;
    }

    public GameWindow getGame() {
        return game;
    }

    public String getTeamName() {
        return teamName;
    }

    public void add(Hero hero) {
        heroesTeam.add(hero);
    }

    public int size() {
        return heroesTeam.size();
    }

    public Hero get(int index) {
        return heroesTeam.get(index);
    }

    public void set(int index, Hero hero) {
        heroesTeam.set(index, hero);
    }

    public int teamDeadCount () {
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getHealth() <= 0) {
                count++;
            }
        }
        return count;
    }

    public boolean checkFullHpHeroes() {
        boolean result = true;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).health < this.get(i).getMaxHealth()) {
                result = false;
            }
        }
        return result;
    }

    public Hero getLowHpHero() {
        Hero hero = null;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).health > 0 && this.get(i).health <= this.get(i).getMaxHealth()) {
                hero = this.get(i);
            }
        }return hero;
    }
}
