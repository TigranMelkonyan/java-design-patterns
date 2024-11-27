package com.tigran.demo_software_patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:13 PM
 */
public class CharacterFactory {

    private Map<String, CharacterIf> characters;

    public CharacterFactory() {
        characters = new HashMap<>();
    }

    public CharacterIf getCharacter(String characterClass, String race) {
        String key = characterClass + "-" + race;

        if (!characters.containsKey(key)) {
            System.out.println("Creating new character: " + key);
            characters.put(key, new CharacterFlyweight(characterClass, race));
        }

        return characters.get(key);
    }
}