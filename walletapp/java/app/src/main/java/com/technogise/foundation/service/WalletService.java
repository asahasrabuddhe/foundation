package com.technogise.foundation.service;

/**
 * Primary service interface for wallet operations.
 * Combines user management, money operations, and balance enquiry capabilities.
 */
public interface WalletService extends UserRegistry, MoneyOps, BalanceEnquiry {
    // All methods are inherited from the extended interfaces
}
