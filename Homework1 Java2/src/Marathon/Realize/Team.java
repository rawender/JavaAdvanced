package Marathon.Realize;

import Marathon.Competitors.*;

public class Team {
    String name;
    Competitor[] competitors;

    public Team(String name, Competitor[] competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResults(){
        System.out.println("\nРезультаты команды " + name + ":");
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
