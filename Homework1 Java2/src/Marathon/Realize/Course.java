package Marathon.Realize;

import Marathon.Competitors.Competitor;
import Marathon.Obstacle.Obstacle;

public class Course {
    Obstacle[] course;

    public Course(Obstacle[] course) {
        this.course = course;
    }

    public void start(Team team){
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
