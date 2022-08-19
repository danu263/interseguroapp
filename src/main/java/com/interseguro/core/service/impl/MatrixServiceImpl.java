package com.interseguro.core.service.impl;

import com.interseguro.core.exception.InterseguroException;
import com.interseguro.core.request.MatrixRequest;
import com.interseguro.core.response.MatrixResponse;
import com.interseguro.core.service.MatrixService;
import com.interseguro.core.utils.impl.GenericErrorEnum;
import org.springframework.stereotype.Service;

@Service
public class MatrixServiceImpl implements MatrixService {

    @Override
    public MatrixResponse rotateSquareMatrix(MatrixRequest request) {
        validate(request);
        int[][] matrix = request.getMatrix();

        int size = matrix.length;
        int layerCount = size/2;

        // we will swap the elements layer by layer.
        for (int layer = 0; layer < layerCount; layer++) {

            int first = layer;
            int last = size - layer - 1;

            // Swap in N layer
            for (int element = first; element < last; element++) {
                int offset = element - first;

                // Swap elements of each cycle in counter-clockwise direction
                int temp = matrix[first][element];
                matrix[first][element] = matrix[element][last];
                matrix[element][last] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[last - offset][first];
                matrix[last - offset][first] = temp;
            }
        }

        MatrixResponse response = new MatrixResponse();
        response.setMatrix(matrix);
        return response;
    }

    private void validate(MatrixRequest matrixRequest) {
        if (matrixRequest.getMatrix() == null) {
            throw new InterseguroException(GenericErrorEnum.ER0001);
        }
        int[][] m = matrixRequest.getMatrix();

        int size = m.length;
        if (size == 0) throw new InterseguroException(GenericErrorEnum.MT0000);

        int length = m[0].length;
        if (length != size) throw new InterseguroException(GenericErrorEnum.MT0001);
    }
}
