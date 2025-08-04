package com.example.wallet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    private UUID id;

    @Column(nullable = false)
    private Long balance;

    public Wallet(UUID id, Long balance) {
        this.id = id;
        this.balance = balance;
    }

    public Wallet() {

    }

}
