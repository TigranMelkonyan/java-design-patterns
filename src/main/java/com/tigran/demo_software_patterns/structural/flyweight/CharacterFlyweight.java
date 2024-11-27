package com.tigran.demo_software_patterns.structural.flyweight;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:13 PM
 */
public class CharacterFlyweight implements CharacterIf {

    private String characterClass;
    private String race;

    public CharacterFlyweight(String characterClass, String race) {
        this.characterClass = characterClass;
        this.race = race;
    }

    @Override
    public void display(String position) {
        System.out.println("Character [Class: " + characterClass + ", Race: " + race + "] at position: " + position);
    }
}