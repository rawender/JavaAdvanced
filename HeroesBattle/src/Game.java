class Game {
    public static void main(String[] args) {

        Team teamBlue = new Team("Team BLUE");
        Team teamRed = new Team("Team RED");

        new GameWindow(teamBlue, teamRed);

    }
}
