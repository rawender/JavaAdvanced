package Game.Heroes;

import Game.Realisation.GameWindow;
import Game.Realisation.Team;

public class Healer extends Hero { //Класс Целитель для создания конкретной реализации героя

    public Healer(Team team) {
        super(team,"Целитель",130, 130,0,60);
    }

    @Override
    public void hit(Hero hero) {
        System.out.println("Целители не умеют бить!");
    }

    @Override
    public void healing(Team heroes) {
        // если герой жив, он может лечить
        if (this.health <= 0) {
            return;
        } else {
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i).health < heroes.get(i).getMaxHealth() && heroes.get(i).health > 0){
                    heroes.get(i).addHealth(addHeal);
                    if (heroes.get(i) == this) {
                        GameWindow.printText(this.getName() + " из команды " + heroes.getTeamName() + " исцелил себя.");
                        System.out.println(this.getName() + " из команды " + heroes.getTeamName() + " исцелил себя.");
                        break;
                    } else {
                        GameWindow.printText(this.getName() + " из команды " + heroes.getTeamName() + " исцелил союзника " + heroes.get(i).name + ".");
                        System.out.println(this.getName() + " из команды " + heroes.getTeamName() + " исцелил союзника " + heroes.get(i).name + ".");
                    }
                    break;
                } else if (heroes.get(i).health <= 0) {
                    GameWindow.printText(this.getName() + " из команды " + heroes.getTeamName() + " не может исцелить мертвого союзника " + heroes.get(i).name + ".");
                    System.out.println(this.getName() + " из команды " + heroes.getTeamName() + " не может исцелить мертвого союзника " + heroes.get(i).name + ".");
                }
            }
        }
    }
}
