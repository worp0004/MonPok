# Pokémon Battle Game

## Design Patterns
### 1. Decorator Pattern
  - **Creatie van FireCreature**: Het `CreatureDecorator` patroon wordt gebruikt om extra functionaliteit toe te voegen aan een bestaand wezen, zoals het toevoegen van de "Fire Attack" vaardigheid in de `FireCreature` klasse. 
   - **Code**: `FireCreature` breidt `CreatureDecorator` uit en voegt extra vaardigheden toe aan een bestaand `Creature` object zonder de originele klasse aan te passen.

   ```java
   public class FireCreature extends CreatureDecorator {
       public FireCreature(Creature creature) {
           super(creature);
       }

       @Override
       public String getAbilities() {
           return decoratedCreature.getAbilities() + ", Fire Attack";
       }
   }
   ```


### 2. Factory Pattern
   - **Factory method pattern**:  Dit patroon maakt het mogelijk om verschillende soorten wezens te creëren (`BasicCreature` en `FireCreature`) zonder directe afhankelijkheden in de code. We gebruiken een Factory Method binnen afzonderlijke fabrieken (`BasicCreatureFactory` en `FireCreatureFactory`).
   - **Code**: De `CreatureFactory` is een abstracte klasse met een factory method (`createCreature`), die wordt overschreven in de concrete subklassen (`FireCreatureFactory` en `BasicCreatureFactory`).

   ```java
   public abstract class CreatureFactory {
       public abstract Creature createCreature(String name);
   }

   public class FireCreatureFactory extends CreatureFactory {
       @Override
       public Creature createCreature(String name) {
           return new FireCreature(new BasicCreature(name, 100));
       }
   }
   ```
### Waarom is dit een Factory Method Pattern?

- Elke concrete factory implementeert de createCreature() methode op zijn eigen manier.

= Dit voorkomt directe afhankelijkheden in de code en maakt uitbreiding eenvoudig.

- De client (Main) gebruikt een factory zonder te weten welke specifieke implementatie erachter zit.

### 3. Observer Pattern
   - **GameObserver**: Het `Observer Pattern` wordt gebruikt om het gevecht bij te houden en gebeurtenissen in realtime te loggen. Elke keer als er een belangrijke gebeurtenis plaatsvindt, zoals een aanval of het winnen van een gevecht, wordt een update verzonden naar de geregistreerde observers. De `GameLog` klasse implementeert de `GameObserver` interface en toont de updates in de console.
   - **Code**: De `BattleSystem` klasse heeft de verantwoordelijkheid om de juiste updates te sturen naar de observers tijdens het gevecht.

   ```java
   public class GameLog implements GameObserver {
       @Override
       public void update(String event) {
           System.out.println("Game Log: " + event);
       }
   }
   ```

## Kenmerken
- Interactief spel op basis van de console.
- Spelers kunnen acties kiezen tijdens hun beurt.
- Dynamische updates met gezondheidveranderingen en strijdresultaten.


## Samenwerking
- Mitchell Boxhoorn werkte aan de implementatie van de Creatures en het gevechtssysteem.
- Ricardo werkte aan de Factory en Observer-functionaliteit.
- Taken zijn gelijk verdeeld en elk design pattern is gezamenlijk besproken. we hebben dit samen op school gemaakt op 1 laptop zodat we dingen konden bespreken waarom we het zo deden etc daarom is het 1 push geworden


---

