public class AdventureGame {
    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Arjun"),
            new Mage("Mira"),
            new Archer("Neel")
        };

        startBattle(characters);
    }

    public static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (GameCharacter character : characters) {
            character.performAttack();
            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }
}

class GameCharacter {
    private String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void performAttack() {
        System.out.println(characterName + " performs a basic attack.");
    }
}

class Warrior extends GameCharacter {
    public Warrior(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(getCharacterName() + " swings a mighty sword.");
    }
}

class Mage extends GameCharacter {
    public Mage(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(getCharacterName() + " casts a powerful spell.");
    }
}

class Archer extends GameCharacter {
    public Archer(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(getCharacterName() + " shoots a precise arrow.");
    }
}
