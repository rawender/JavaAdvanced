package Game.Realisation;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private Team teamBlue = new Team("BLUE team", this);
    private Team teamRed = new Team("RED team", this);
    private static JTextArea jta;

    public GameWindow(){
        setTitle("HeroesBattle");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int sizeW = 600;
        int sizeH = 600;

        int locationX = (screenSize.width - sizeW) / 2;
        int locationY = (screenSize.height - sizeH) / 2;

        setBounds(locationX, locationY, sizeW, sizeH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());

        topPanel.setPreferredSize(new Dimension(600,200));
        centerPanel.setPreferredSize(new Dimension(600,100));
        bottomPanel.setPreferredSize(new Dimension(600,300));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new GridLayout(4,2));
        topPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        Font font = new Font("Times New Roman", Font.PLAIN, 18);

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
                "Лучник",
                "Защитник",
                "Целитель",
                "Волшебник"};

        /**
         * Создаем боксы с выбором персонажей
         */
        GameComboBox blue1 = new GameComboBox(heroes, teamBlue, 0);
        blue1.setFont(font);
        blue1.setBorder(BorderFactory.createMatteBorder(5,10,5,10, Color.LIGHT_GRAY));
        blue1.setForeground(Color.BLUE);
        GameComboBox blue2 = new GameComboBox(heroes, teamBlue, 1);
        blue2.setFont(font);
        blue2.setBorder(BorderFactory.createMatteBorder(5,10,5,10, Color.LIGHT_GRAY));
        blue2.setForeground(Color.BLUE);
        GameComboBox blue3 = new GameComboBox(heroes, teamBlue, 2);
        blue3.setFont(font);
        blue3.setBorder(BorderFactory.createMatteBorder(5,10,5,10, Color.LIGHT_GRAY));
        blue3.setForeground(Color.BLUE);
        GameComboBox red1 = new GameComboBox(heroes, teamRed, 0);
        red1.setFont(font);
        red1.setBorder(BorderFactory.createMatteBorder(5,10,5,10, Color.LIGHT_GRAY));
        red1.setForeground(Color.RED);
        GameComboBox red2 = new GameComboBox(heroes, teamRed, 1);
        red2.setFont(font);
        red2.setBorder(BorderFactory.createMatteBorder(5,10,5,10, Color.LIGHT_GRAY));
        red2.setForeground(Color.RED);
        GameComboBox red3 = new GameComboBox(heroes, teamRed, 2);
        red3.setFont(font);
        red3.setBorder(BorderFactory.createMatteBorder(5,10,5,10, Color.LIGHT_GRAY));
        red3.setForeground(Color.RED);

        /**
         * Создаем кнопку "Старт"
         */
        GameButton startButton = new GameButton("Start", teamBlue, teamRed);
        startButton.setFont(font);
        startButton.setBorder(BorderFactory.createMatteBorder(10,250,5,250, Color.LIGHT_GRAY));

        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);

        /**
         * добавляем на верхнюю панель названия команд
         */
        topPanel.add(team1);
        topPanel.add(team2);

        /**
         * добавляем на верхнюю панель боксы с выбором персонажей в команды
         */
        topPanel.add(blue1);
        topPanel.add(red1);
        topPanel.add(blue2);
        topPanel.add(red2);
        topPanel.add(blue3);
        topPanel.add(red3);

        /**
         * добавляем на центральную панель кнопку "Start"
         */
        centerPanel.add(startButton, BorderLayout.CENTER);

        /**
         * добавляем на нижнюю панель окно вывода информации
         */
        bottomPanel.add(jsp, BorderLayout.CENTER);

        jta.setEditable(false);
        setVisible(true);
    }

    public static void printText(String text) {
        jta.append(text + "\n");
    }
}
