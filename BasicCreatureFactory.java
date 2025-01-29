public class BasicCreatureFactory extends CreatureFactory {
    @Override
    public Creature createCreature(String name) {
        return new BasicCreature(name, 100);
    }
}