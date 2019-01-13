import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxActionListener implements ActionListener {
    private GameComboBox comboBox;
    private Team team;
    private int indexBox;

    public ComboBoxActionListener(GameComboBox gComboBox, Team team, int indexBox) {
        this.comboBox = gComboBox;
        this.team = team;
        this.indexBox = indexBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Team heroesTeam = new Team("");
        heroesTeam.add(new Warrior(team));
        heroesTeam.add(new Assasin(team));
        heroesTeam.add(new Mage(team));
        heroesTeam.add(new Healer(team));

        String x = comboBox.getSelectedItem().toString();

        if (team.size() <= indexBox) {
            for (int i = 0; i < heroesTeam.size(); i++) {
                if (heroesTeam.get(i).getName().equalsIgnoreCase(x)) {
                    team.add(heroesTeam.get(i));
                }
            }
        } else {
            for (int i = 0; i < heroesTeam.size(); i++) {
                if (heroesTeam.get(i).getName().equalsIgnoreCase(x)) {
                    team.set(indexBox, heroesTeam.get(i));
                }
            }
        }
    }
}
