package com.example.wallet.exception;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class WalletNotFoundException extends Exception {
    public WalletNotFoundException(@NotNull UUID walletId) {
    }
}
