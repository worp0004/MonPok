public class FireCreature extends CreatureDecorator {
    public FireCreature(Creature creature) {
        super(creature);
    }

    @Override
    public String getAbilities() {
        return decoratedCreature.getAbilities() + ", Fire Attack";
    }
}
