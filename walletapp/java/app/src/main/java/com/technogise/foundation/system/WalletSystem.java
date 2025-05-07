package com.technogise.foundation.system;

import com.technogise.foundation.cli.WalletCLI;
import com.technogise.foundation.config.AppConfig;

public class WalletSystem {
    private final WalletCLI cli;

    public WalletSystem(WalletCLI cli) {
        this.cli = cli;
    }

    public void start() {
        cli.start();
    }

    public static void main(String[] args) {
        WalletSystem system = AppConfig.buildSystem();
        system.start();
    }
}
