package com.technogise.foundation.system;

import com.technogise.foundation.cli.WalletCLI;
import com.technogise.foundation.service.ITransactionHistoryService;
import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.InMemoryTransactionHistoryService;
import com.technogise.foundation.service.WalletService;

public class WalletSystem {
    public static void main(String[] args) {
        ITransactionHistoryService transactionHistoryService = new InMemoryTransactionHistoryService();
        IWalletService walletService = new WalletService(transactionHistoryService);
        WalletCLI cli = new WalletCLI(walletService, transactionHistoryService);
        cli.start();
    }
}
