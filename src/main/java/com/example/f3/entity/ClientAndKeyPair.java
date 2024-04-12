package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class ClientAndKeyPair implements Serializable {
    private Client client;
    private CryptoKeyPair cryptoKeyPair;
}
