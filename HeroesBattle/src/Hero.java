abstract class Hero {    //Абстрактный класс родитель для создания героев
    // команда героя
    protected Team team;
    // имя героя
    protected String name;
    // максимальное здоровье героя
    protected int maxHealth;
    // текущее здоровье героя
    protected int health;
    // сколько урона может нанести герой
    protected int damage;
    // сколько здоровья может восстановть герой
    protected int addHeal;

    public Hero(Team team, String name, int maxHealth, int health, int damage, int addHeal) {
        this.team = team;
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    public Team getTeam() {
        return team;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    // метод нанесения удара
    abstract void hit(Hero hero);

    // метод лечения
    abstract void healing(Team hero);

    // метод получения удара
    void causeDamage(int damage) {
        if (this.health <= 0) {
            return;
        } else {
            this.health -= damage;
            if (this.health <= 0)
                GameWindow.setTextToArea(this.getName() + " из команды " + this.getTeam().getTeamName() + " не выдержал удара и пал!");
        }
    }

    // метод для добавления здоровья
    void addHealth(int health) {
        this.health += health;
        if (this.health > this.maxHealth)
            this.health = this.maxHealth;
    }

    void info() {
        GameWindow.setTextToArea(name + " " + (health <= 0 ? "Герой мертвый" : health) + " " + damage);
    }
}
