package com.interseguro.core.service;

import com.interseguro.core.request.MatrixRequest;
import com.interseguro.core.response.MatrixResponse;

public interface MatrixService {

    MatrixResponse rotateSquareMatrix(MatrixRequest request);
}
