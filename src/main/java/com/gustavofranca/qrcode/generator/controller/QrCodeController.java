package com.gustavofranca.qrcode.generator.controller;

import com.gustavofranca.qrcode.generator.dto.QrCodeGenerateRequest;
import com.gustavofranca.qrcode.generator.dto.QrCodeGenerateResponse;
import com.gustavofranca.qrcode.generator.services.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService service;

    public QrCodeController(QrCodeGeneratorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request){
        try{
            QrCodeGenerateResponse response = this.service.generateAndUpLoadQrCode(request.text());

            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }
}
