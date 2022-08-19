package com.interseguro.core.controller;

import com.interseguro.core.request.MatrixRequest;
import com.interseguro.core.response.MatrixResponse;
import com.interseguro.core.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/v1")
public class MatrixController {

    @Autowired
    MatrixService matrixService;

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatrixResponse> rotate(@RequestBody MatrixRequest request) {
        return ResponseEntity.ok(matrixService.rotateSquareMatrix(request));
    }

}
