package com.tigran.demo_software_patterns.architectural.behavioral.command;

import com.tigran.demo_software_patterns.behavioral.command.Command;
import com.tigran.demo_software_patterns.behavioral.command.Light;
import com.tigran.demo_software_patterns.behavioral.command.RemoteControl;
import com.tigran.demo_software_patterns.behavioral.command.TurnLightOffCommand;
import com.tigran.demo_software_patterns.behavioral.command.TurnLightOnCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:15 PM
 */
public class CommandTest {

    private Light light;
    private Command turnLightOn;
    private Command turnLightOff;
    private RemoteControl remoteControl;

    @BeforeEach
    void setUp() {
        light = mock(Light.class);
        turnLightOn = new TurnLightOnCommand(light);
        turnLightOff = new TurnLightOffCommand(light);
        remoteControl = new RemoteControl();
    }

    @Test
    void testTurnLightOnCommand() {
        remoteControl.setCommand(turnLightOn);
        remoteControl.pressButton();
        verify(light, times(1)).turnOn();
    }

    @Test
    void testTurnLightOffCommand() {
        remoteControl.setCommand(turnLightOff);
        remoteControl.pressButton();
        verify(light, times(1)).turnOff();
    }

    @Test
    void testUndoLastCommand() {
        remoteControl.setCommand(turnLightOn);
        remoteControl.pressButton();
        verify(light, times(1)).turnOn();

        remoteControl.pressUndo();
        verify(light, times(1)).turnOff();
    }
}
