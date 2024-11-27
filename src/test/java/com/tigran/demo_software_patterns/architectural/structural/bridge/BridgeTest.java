package com.tigran.demo_software_patterns.architectural.structural.bridge;

import com.tigran.demo_software_patterns.structural.bridge.impl.AdvancedRemote;
import com.tigran.demo_software_patterns.structural.bridge.abs.Device;
import com.tigran.demo_software_patterns.structural.bridge.impl.Radio;
import com.tigran.demo_software_patterns.structural.bridge.abs.RemoteControl;
import com.tigran.demo_software_patterns.structural.bridge.impl.TV;
import com.tigran.demo_software_patterns.structural.bridge.impl.UniversalRemote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:42 PM
 */
public class BridgeTest {

    private Device tv;
    private Device radio;
    private RemoteControl tvRemote;
    private RemoteControl radioRemote;

    @BeforeEach
    void setUp() {
        // Mock the Device implementations (TV and Radio)
        tv = mock(TV.class);
        radio = mock(Radio.class);

        // Create RemoteControl objects using the mocked devices
        tvRemote = new UniversalRemote(tv);
        radioRemote = new AdvancedRemote(radio);
    }

    @Test
    void testUniversalRemoteWithTV() {
        // Use the UniversalRemote to control the TV
        tvRemote.turnOn();
        tvRemote.volumeUp();
        tvRemote.turnOff();

        // Verify interactions with the TV mock
        verify(tv).turnOn();
        verify(tv).volumeUp();
        verify(tv).turnOff();
    }

    @Test
    void testAdvancedRemoteWithRadio() {
        // Use the AdvancedRemote to control the Radio
        radioRemote.turnOn();
        radioRemote.volumeDown();
        ((AdvancedRemote) radioRemote).mute();
        radioRemote.turnOff();

        // Verify interactions with the Radio mock
        verify(radio).turnOn();
        verify(radio).volumeDown();
        verify(radio).turnOff();

        // Verifying the advanced functionality (mute)
        verifyNoInteractions(tv);
    }
}
