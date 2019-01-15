package Marathon.Realize;

import Marathon.Competitors.*;
import Marathon.Obstacle.Cross;
import Marathon.Obstacle.Obstacle;
import Marathon.Obstacle.Wall;
import Marathon.Obstacle.Water;

public class Main {
    public static void main(String[] args) {
        // Создаем полосу препятствий
        Course с = new Course(new Obstacle[]{new Cross(80), new Wall(2), new Water(5)});
        // Создаем команду
        Team team = new Team("Team А", new Competitor[]{new Human("Боб"), new Cat("Барсик"), new StrongCat("Барс"), new Dog("Бобик")});
        // Просим команду пройти полосу
        с.start(team);
        // Показываем результаты
        team.showResults();
    }
}
