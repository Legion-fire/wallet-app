package com.example.wallet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class WalletOperationRequest {
    @NotNull
    private UUID walletId;

    @NotNull
    private OperationType operationType;

    @Positive
    private Long amount;

    public enum OperationType {
        DEPOSIT, WITHDRAW
    }
}
