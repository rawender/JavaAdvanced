package Game.Realisation;

import Game.Heroes.Healer;
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
                GameWindow.printText("Очередь команды " + team1.getTeamName() + ".");
                System.out.println("Очередь команды " + team1.getTeamName() + ".");
                // проходим по всем участникам команды
                for (int i = 0; i < team1.size(); i++) {
                    // если целитель, то он лечит
                    if (team1.get(i) instanceof Healer) {
                        team1.get(i).healing(team1);
                        // если персонаж не целитель, то он может ударить
                    } else if (team2.checkFullHpHeroes()) { //если у героев команды противников полное здоровье, бьем рандомного противника
                        team1.get(i).hit(team2.get(randomHit.nextInt(3)));
                    } else if (team2.teamDeadCount() == 3) { //если у всех героев команды противников не осталось здоровья, прерываем бой
                        break;
                    } else {
                        team1.get(i).hit(team2.getLowHpHero()); //выбираем противника с меньшим здоровьем
                    }
                }
                x = 1;
                GameWindow.printText("---------------");
                System.out.println("---------------");
            } else {
                GameWindow.printText("Очередь команды " + team2.getTeamName() + ".");
                System.out.println("Очередь команды " + team2.getTeamName() + ".");
                // проходим по всем участникам команды
                for (int i = 0; i < team2.size(); i++) {
                    // если целитель, то он лечит
                    if (team2.get(i) instanceof Healer) {
                        team2.get(i).healing(team2);
                    // если персонаж не целитель, то он может ударить
                    } else if (team1.checkFullHpHeroes()) { //если у героев команды противников полное здоровье, бьем рандомного противника
                        team2.get(i).hit(team1.get(randomHit.nextInt(3)));
                    } else if (team1.teamDeadCount() == 3) { //если у всех героев команды противников не осталось здоровья, прерываем бой
                        break;
                    } else  {
                        team2.get(i).hit(team1.getLowHpHero()); //выбираем противника с меньшим здоровьем
                    }
                }
                x = 0;
                GameWindow.printText("---------------");
                System.out.println("---------------");
            }
        } while (!checkWin(team1, team2));

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
            team1.getGame().printText("Победили " + team2.getTeamName());
            System.out.println("Победили " + team2.getTeamName());
        } else if (team2.teamDeadCount() == team2.size()) {
            result = true;
            team2.getGame().printText("Победили " + team1.getTeamName());
            System.out.println("Победили " + team1.getTeamName());
        }
        return result;
    }
}
