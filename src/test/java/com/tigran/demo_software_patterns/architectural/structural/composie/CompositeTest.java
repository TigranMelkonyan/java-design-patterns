package com.tigran.demo_software_patterns.architectural.structural.composie;

import com.tigran.demo_software_patterns.structural.composite.directory.Directory;
import com.tigran.demo_software_patterns.structural.composite.file.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:05 PM
 */
public class CompositeTest {

    private File file1;
    private File file2;
    private File file3;
    private Directory rootDirectory;

    @BeforeEach
    void setUp() {
        // Setup files
        file1 = new File("file1.txt", 500);
        file2 = new File("file2.jpg", 1500);
        file3 = new File("file3.pdf", 2000);

        // Setup directories and add files to them
        Directory directory1 = new Directory("Documents");
        directory1.addComponent(file1);
        directory1.addComponent(file2);

        Directory directory2 = new Directory("Pictures");
        directory2.addComponent(file3);

        // Create root directory and add subdirectories
        rootDirectory = new Directory("Root");
        rootDirectory.addComponent(directory1);
        rootDirectory.addComponent(directory2);
    }

    @Test
    void testDirectorySize() {
        // The total size should be the sum of all file sizes
        int expectedSize = file1.getSize() + file2.getSize() + file3.getSize();
        assertEquals(expectedSize, rootDirectory.getSize());
    }

    @Test
    void testDisplay() {
        // Capture the output of the display() method to verify it's correct
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        rootDirectory.display("");

        String output = outputStream.toString();

        // Verify the output of the display method
        String expectedOutput = """
                Directory: Root
                  Directory: Documents
                    File: file1.txt (500 bytes)
                    File: file2.jpg (1500 bytes)
                  Directory: Pictures
                    File: file3.pdf (2000 bytes)
                """;
        assertEquals(expectedOutput, output);
    }

    @Test
    void testAddAndRemoveComponent() {
        Directory newDirectory = new Directory("NewDirectory");
        File newFile = new File("newfile.txt", 300);

        // Add and remove components from a directory
        newDirectory.addComponent(newFile);
        newDirectory.addComponent(new Directory("SubDirectory"));

        int initialSize = newDirectory.getSize();

        // Verify the initial size of the directory after adding components
        assertEquals(300, initialSize);
        newDirectory.removeComponent(newFile);

        // Verify that after removing the file, the size is 0
        int finalSize = newDirectory.getSize();
        assertEquals(0, finalSize);
    }
}
