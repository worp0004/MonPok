public class GameLog implements GameObserver {
    @Override
    public void update(String event) {
        System.out.println("Game Log: " + event);
    }
}
