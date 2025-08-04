package com.example.wallet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WalletBalanceResponse {
    private UUID walletId;
    private Long balance;

    public WalletBalanceResponse(UUID walletId, Long balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    public WalletBalanceResponse(org.hibernate.validator.constraints.UUID walletId, Long balance) {
    }
}
