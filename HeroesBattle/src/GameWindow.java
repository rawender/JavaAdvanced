import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static Team teamBlue;
    static Team teamRed;
    static JTextArea jta;

    public GameWindow(Team teamBlue, Team teamRed) throws HeadlessException {
        this.teamBlue = teamBlue;
        this.teamRed = teamRed;

        setTitle("HeroesBattle");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int sizeW = 600;
        int sizeH = 600;

        int locationX = (screenSize.width - sizeW) / 2;
        int locationY = (screenSize.height - sizeH) / 2;

        setBounds(locationX, locationY, sizeW, sizeH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        bottomPanel.setPreferredSize(new Dimension(1,300));

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        centerPanel.setLayout(new GridLayout(4,2));
        bottomPanel.setLayout(new BorderLayout());

        Font font = new Font("Verdana", Font.PLAIN, 18);

        /**
         * Создаем заголовок название команды 1
         */
        JLabel team1 = new JLabel(teamBlue.getTeamName());
        team1.setHorizontalAlignment(JLabel.CENTER);
        team1.setFont(font);
        team1.setForeground(Color.BLUE);

        /**
         * Создаем заголовок название команды 2
         */
        JLabel team2 = new JLabel(teamRed.getTeamName());
        team2.setHorizontalAlignment(JLabel.CENTER);
        team2.setFont(font);
        team2.setForeground(Color.RED);

        /**
         * Создаем массив заголовков для боксов с выбором персонажей
         */
        String[] heroes = {"",
                "Воин",
                "Убийца",
                "Волшебник",
                "Целитель"};

        /**
         * Создаем боксы с выбором персонажей
         */
        GameComboBox blue1 = new GameComboBox(heroes, teamBlue, 0);
        blue1.setFont(font);
        blue1.setForeground(Color.BLUE);
        GameComboBox blue2 = new GameComboBox(heroes, teamBlue, 1);
        blue2.setFont(font);
        blue2.setForeground(Color.BLUE);
        GameComboBox blue3 = new GameComboBox(heroes, teamBlue, 2);
        blue3.setFont(font);
        blue3.setForeground(Color.BLUE);
        GameComboBox red1 = new GameComboBox(heroes, teamRed, 0);
        red1.setFont(font);
        red1.setForeground(Color.RED);
        GameComboBox red2 = new GameComboBox(heroes, teamRed, 1);
        red2.setFont(font);
        red2.setForeground(Color.RED);
        GameComboBox red3 = new GameComboBox(heroes, teamRed, 2);
        red3.setFont(font);
        red3.setForeground(Color.RED);

        /**
         * Создаем кнопку "Старт"
         */
        GameButton startButton = new GameButton("Start", teamBlue, teamRed);

        jta = new JTextArea();
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setBounds(5,5,500,300);

        JScrollPane jsp = new JScrollPane(jta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(3,3,500,500);
        bottomPanel.add(jsp, BorderLayout.EAST);

        jta.setPreferredSize(new Dimension(500, 1));

        /**
         * добавляем на центральную панель названия команд
         */
        centerPanel.add(team1);
        centerPanel.add(team2);

        /**
         * добавляем на центральную панель боксы с выбором персонажей в команды
         */
        centerPanel.add(blue1);
        centerPanel.add(red1);
        centerPanel.add(blue2);
        centerPanel.add(red2);
        centerPanel.add(blue3);
        centerPanel.add(red3);

        /**
         * добавляем на нижнюю панель кнопку запуска и окно вывода текста с информацией
         */
        bottomPanel.add(startButton);

        jta.setEditable(false);
        setVisible(true);


    }

    public static void setTextToArea(String text) {
        jta.append(text + "\n");
    }
}
