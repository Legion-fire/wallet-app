package com.example.wallet.service;

import com.example.wallet.dto.WalletOperationRequest;
import com.example.wallet.entity.Wallet;
import com.example.wallet.exception.InsufficientFundsException;
import com.example.wallet.exception.WalletNotFoundException;
import com.example.wallet.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void operate(WalletOperationRequest request) throws WalletNotFoundException, InsufficientFundsException {
        Wallet wallet = walletRepository.findByIdForUpdate(request.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException(request.getWalletId()));

        if (request.getOperationType() == WalletOperationRequest.OperationType.DEPOSIT) {
            wallet.setBalance(wallet.getBalance() + request.getAmount());
        } else if (request.getOperationType() == WalletOperationRequest.OperationType.WITHDRAW) {
            if (wallet.getBalance() < request.getAmount()) {
                throw new InsufficientFundsException();
            }
            wallet.setBalance(wallet.getBalance() - request.getAmount());
        }
        walletRepository.save(wallet);
    }

    @Transactional(readOnly = true)
    public Long getBalance(UUID walletId) throws WalletNotFoundException {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new WalletNotFoundException(walletId))
                .getBalance();
    }
}
