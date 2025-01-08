import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleSystem {
    private List<GameObserver> observers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (GameObserver observer : observers) {
            observer.update(event);
        }
    }

    public void battle(Creature playerCreature, Creature enemyCreature) {
        System.out.println(playerCreature.getName() + " vs " + enemyCreature.getName());
        while (playerCreature.getHealth() > 0 && enemyCreature.getHealth() > 0) {
            // Player's turn
            System.out.println("\nYour turn!");
            System.out.println("1. Attack");
            System.out.println("2. Check Status");
            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Player attacks
                enemyCreature.takeDamage(20);
                notifyObservers(playerCreature.getName() + " attacked! " + enemyCreature.getName() + " has " + enemyCreature.getHealth() + " HP left.");
            } else if (choice == 2) {
                // Show player and enemy status
                System.out.println(playerCreature.getName() + " HP: " + playerCreature.getHealth());
                System.out.println(enemyCreature.getName() + " HP: " + enemyCreature.getHealth());
                continue; // Skip enemy's turn to let player decide again
            } else {
                System.out.println("Invalid choice. Try again.");
            }

            // Check if enemy is defeated
            if (enemyCreature.getHealth() <= 0) {
                notifyObservers(playerCreature.getName() + " won the battle!");
                return;
            }

            // Enemy's turn
            System.out.println("\nEnemy's turn!");
            playerCreature.takeDamage(15);
            notifyObservers(enemyCreature.getName() + " attacked! " + playerCreature.getName() + " has " + playerCreature.getHealth() + " HP left.");

            // Check if player is defeated
            if (playerCreature.getHealth() <= 0) {
                notifyObservers(enemyCreature.getName() + " won the battle!");
            }
        }
    }
}
