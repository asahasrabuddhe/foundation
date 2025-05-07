package com.technogise.foundation.config;

import com.technogise.foundation.cli.WalletCLI;
import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.InMemoryUserRepository;
import com.technogise.foundation.repository.TransactionStore;
import com.technogise.foundation.repository.UserRepository;
import com.technogise.foundation.service.*;
import com.technogise.foundation.system.WalletSystem;

public class AppConfig {
    public static WalletSystem buildSystem() {
        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore transactionStore = new InMemoryTransactionStore();
        IWalletService walletService = new WalletService(userRepository, transactionStore);
        
        return new WalletSystem(
            new WalletCLI(
                walletService,  // UserRegistry
                walletService,  // MoneyOps
                walletService,  // BalanceEnquiry
                transactionStore // TransactionReader
            )
        );
    }
} 