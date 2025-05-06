package com.technogise.foundation.cli.command;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ExitCommandTest {
    @Test
    void shouldSetExitFlagAndPrintMessage() {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        ExitCommand command = new ExitCommand(out);
        command.execute();

        assertTrue(command.shouldExit());
        assertTrue(outStream.toString().contains("Exiting..."));
    }
} 