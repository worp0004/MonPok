public class FireCreatureFactory extends CreatureFactory {
    @Override
    public Creature createCreature(String name) {
        return new FireCreature(new BasicCreature(name, 100));
    }
}