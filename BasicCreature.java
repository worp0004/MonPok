public class BasicCreature extends Creature {
    public BasicCreature(String name, int health) {
        super(name, health);
    }

    @Override
    public String getAbilities() {
        return "Basic Abilities";
    }
}
