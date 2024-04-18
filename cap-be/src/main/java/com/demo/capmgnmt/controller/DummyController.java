package com.demo.capmgnmt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hanan Al-Hajri 2024/04/04

 */

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> createArticle(@RequestPart("image") MultipartFile image) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}