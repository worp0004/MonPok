public class Main {
    public static void main(String[] args) {
        // Create player and enemy using Factory
        CreatureFactory fireFactory = new FireCreatureFactory();
        Creature playerCreature = fireFactory.createCreature("Flamizard");

        CreatureFactory basicFactory = new BasicCreatureFactory();
        Creature enemyCreature = basicFactory.createCreature("Grassloth");

        // Setup observer and battle system
        GameLog gameLog = new GameLog();
        BattleSystem battleSystem = new BattleSystem();
        battleSystem.addObserver(gameLog);

        // Start battle
        System.out.println("A wild " + enemyCreature.getName() + " appeared!");
        battleSystem.battle(playerCreature, enemyCreature);
    }
}
