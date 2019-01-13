import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonActionListener implements ActionListener {
    private Team team1;
    private Team team2;

    Random randomStep = new Random();
    Random randomHit = new Random();

    public ButtonActionListener(Team teamBlue, Team teamRed) {
        this.team1 = teamBlue;
        this.team2 = teamRed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // выбираем кто будет первый ходить
        int x = randomStep.nextInt(2);
        do {
            if (x == 0) {
                /*System.out.println*/GameWindow.setTextToArea("Очередь команды " + team1.getTeamName() + ".");
                /*System.out.println*/GameWindow.setTextToArea("---------------");
                // проходим по всем участникам команды
                for (int i = 0; i < team1.size(); i++) {
                    // если целитель, то он лечит
                    if (team1.get(i) instanceof Healer) {
                        team1.get(i).healing(team1);
                    } else if (team2.checkHpHeroes()) { // если персонаж не целитель, то он может ударить
                        team1.get(i).hit(team2.get(randomHit.nextInt(3)));
                    } else if (!team2.checkHpHeroes()) {
                        team1.get(i).hit(team2.getLowHpHero());
                    }
                }
                x = 1;
            } else {
                /*System.out.println*/GameWindow.setTextToArea("Очередь команды " + team2.getTeamName() + ".");
                /*System.out.println*/GameWindow.setTextToArea("---------------");
                // проходим по всем участникам команды
                for (int i = 0; i < team2.size(); i++) {
                    // если целитель, то он лечит
                    if (team2.get(i) instanceof Healer) {
                        team2.get(i).healing(team2);
                    } else if (team1.checkHpHeroes()) { // если персонаж не целитель, то он может ударить
                        team2.get(i).hit(team1.get(randomHit.nextInt(3)));
                    } else if (!team1.checkHpHeroes()) {
                        team2.get(i).hit(team1.getLowHpHero());
                    }
                }
                x = 0;
            }
        } while (!checkWin(team1, team2));

        /*System.out.println*/GameWindow.setTextToArea("---------------");

        for (int i = 0; i < team1.size(); i++) {
            team1.get(i).info();
        }

        for (int i = 0; i < team2.size(); i++) {
            team2.get(i).info();
        }
    }

    boolean checkWin (Team team1, Team team2) {
        boolean result = false;
        if (team1.teamDeadCount() == team1.size()) {
            result = true;
            /*System.out.println*/GameWindow.setTextToArea("Победили " + team2.getTeamName());
        } else if (team2.teamDeadCount() == team2.size()) {
            result = true;
            /*System.out.println*/GameWindow.setTextToArea("Победили " + team1.getTeamName());
        } else if (team1.teamDeadCount() == team1.size() && team2.teamDeadCount() == team2.size()) {
            /*System.out.println*/GameWindow.setTextToArea("Ничья");
            result = false;
        }
        return result;
    }
}
