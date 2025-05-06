package com.technogise.foundation.cli.command;

public interface CommandStrategy {
    void execute();
    String getDescription();
}
