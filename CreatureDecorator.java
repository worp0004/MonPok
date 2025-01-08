public abstract class CreatureDecorator extends Creature {
    protected Creature decoratedCreature;

    public CreatureDecorator(Creature creature) {
        super(creature.name, creature.health);
        this.decoratedCreature = creature;
    }

    @Override
    public String getAbilities() {
        return decoratedCreature.getAbilities();
    }
}
