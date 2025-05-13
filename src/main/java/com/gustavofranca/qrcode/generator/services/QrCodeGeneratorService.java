package com.gustavofranca.qrcode.generator.services;

import com.gustavofranca.qrcode.generator.ports.StoragePort;
import org.springframework.stereotype.Service;

@Service
public class QrCodeGeneratorService {
    private final StoragePort storage;

    public QrCodeGeneratorService(StoragePort storage) {
        this.storage = storage;
    }
}
