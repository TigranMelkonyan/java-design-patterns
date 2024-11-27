package com.tigran.demo_software_patterns.architectural.structural.flyweight;

import com.tigran.demo_software_patterns.structural.flyweight.CharacterFactory;
import com.tigran.demo_software_patterns.structural.flyweight.CharacterIf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:14 PM
 */
public class FlyWeightTest {

    private CharacterFactory characterFactory;

    @BeforeEach
    void setUp() {
        characterFactory = new CharacterFactory();
    }

    @Test
    void testFlyweightObjectSharing() {
        // Request flyweights with shared attributes
        CharacterIf character1 = characterFactory.getCharacter("Warrior", "Human");
        CharacterIf character2 = characterFactory.getCharacter("Mage", "Elf");
        CharacterIf character3 = characterFactory.getCharacter("Warrior", "Human");

        // Assert that character1 and character3 are the same instance (shared flyweight)
        assertSame(character1, character3, "Character1 and Character3 should be the same instance");

        // Assert that character1 and character2 are different instances (different flyweights)
        assertNotSame(character1, character2, "Character1 and Character2 should be different instances");
    }

    @Test
    void testDisplayMethod() {
        // Create flyweight characters
        CharacterIf character1 = characterFactory.getCharacter("Warrior", "Human");
        CharacterIf character2 = characterFactory.getCharacter("Mage", "Elf");

        // Use the display method to check behavior with extrinsic state (position)
        // In a real test, you could mock System.out or capture the output, but here we're just checking the calls
        character1.display("Position (10, 20)");
        character2.display("Position (20, 30)");
    }
}
