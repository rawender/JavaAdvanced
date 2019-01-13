import java.util.ArrayList;

public class Team {
    String teamName;
    ArrayList<Hero> heroesTeam;

    public Team( String teamName) {
        this.teamName = teamName;
        this.heroesTeam = new ArrayList <>();
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

    public boolean checkHpHeroes() {
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
            if (this.get(i).health <= this.get(i).getMaxHealth() && this.get(i).health > 0) {
                hero = this.get(i);
            }
        }
        return hero;
    }
}
