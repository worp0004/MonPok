public class CreatureFactory {
    public static Creature createCreature(String type, String name) {
        switch (type) {
            case "Fire":
                return new FireCreature(new BasicCreature(name, 100));
            case "Basic":
                return new BasicCreature(name, 100);
            default:
                throw new IllegalArgumentException("Unknown creature type");
        }
    }
}
