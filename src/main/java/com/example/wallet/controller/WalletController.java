package com.example.wallet.controller;

import com.example.wallet.dto.WalletBalanceResponse;
import com.example.wallet.dto.WalletOperationRequest;
import com.example.wallet.exception.InsufficientFundsException;
import com.example.wallet.exception.WalletNotFoundException;
import com.example.wallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallet")
    public ResponseEntity<Void> operate(@Valid @RequestBody WalletOperationRequest request) throws WalletNotFoundException, InsufficientFundsException {
        walletService.operate(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/wallets/{walletId}")
    public ResponseEntity<WalletBalanceResponse> getBalance(@PathVariable UUID walletId) throws WalletNotFoundException {
        Long balance = walletService.getBalance(walletId);
        return ResponseEntity.ok(new WalletBalanceResponse(walletId, balance));
    }
}
