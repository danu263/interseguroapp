package com.interseguro.core.service.impl;

import com.interseguro.core.request.MatrixRequest;
import com.interseguro.core.response.MatrixResponse;
import com.interseguro.core.service.MatrixService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixServiceImplTest {

    private MatrixService matrixService;

    @BeforeEach
    public void setup() {
        matrixService = new MatrixServiceImpl();
    }

    @Test
    public void should_rotateSquareMatrix_When_CallToFunction() {
        // given
        MatrixRequest request2x2 = dummyRequest2x2();
        MatrixRequest request3x3 = dummyRequest3x3();
        int[][] expectedFirstResponse = {{2,4},{1,3}};
        int[][] expectedSecondResponse = {{3,6,9},{2,5,8},{1,4,7}};

        // when
        MatrixResponse actualFirstResponse = matrixService.rotateSquareMatrix(request2x2);
        MatrixResponse actualSecondResponse = matrixService.rotateSquareMatrix(request3x3);

        // then
        assertArrayEquals(expectedFirstResponse, actualFirstResponse.getMatrix());
        assertArrayEquals(expectedSecondResponse, actualSecondResponse.getMatrix());
    }

    private MatrixRequest dummyRequest2x2() {
        MatrixRequest dummy = new MatrixRequest();
        int[][] m = {{1,2},{3,4}};
        dummy.setMatrix(m);
        return dummy;
    }

    private MatrixRequest dummyRequest3x3() {
        MatrixRequest dummy = new MatrixRequest();
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        dummy.setMatrix(m);
        return dummy;
    }
}