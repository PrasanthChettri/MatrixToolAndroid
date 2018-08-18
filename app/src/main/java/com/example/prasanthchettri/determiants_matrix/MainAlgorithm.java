package com.example.prasanthchettri.determiants_matrix;
import java.util.Arrays;
public class MainAlgorithm {
        public static int elements[][] ;
        public static int e_lenght ;

        void getdata(int number[][] ) {
            e_lenght = number.length;
            elements = Arrays.copyOf(number, e_lenght);
        }
        //The main algorithm , i still cant believe i thought of this
        //It's elegant isn't it
        //It came to me when i was taking a shit
        public static int deter(int elements[][] , int size , int col , int row ){
            int tempmatr[][] = new int[size-1][size-1] , loci = 0  , locj = 0 ;
            for (int i = 0 ; i < size ; i++) {
                if (i != col) {
                    for (int j = 0; j < size; j++) {
                        if (row != j) {
                            tempmatr[loci][locj] = elements[i][j];
                            locj++;
                        }
                    }
                    loci++;
                    locj = 0;
                }
            }
            if (size == 3)
                return (tempmatr[0][0] * tempmatr[1][1]) - (tempmatr[0][1] * tempmatr[1][0]);
            return mainlooper(tempmatr , size-1);
        }

    public static int mainlooper(int matrix[][] , int length){
        int TemDeterminant = 0 ;
        for (int i = 0 ; i < length ; i++)
            TemDeterminant += Math.pow(-1, 2 + i) * matrix[0][i] * deter(matrix, length,  0, i );
        return TemDeterminant ;
    }

    public static int[][] mainloop_adjont(){
            int[][] innelem = new int[e_lenght][e_lenght];
            for(int i = 0 ; i < e_lenght ;i++)
                    for(int j = 0 ; j < e_lenght ; j++)
                        innelem[j][i] =(int) Math.pow(-1  , i + j) * deter(elements, e_lenght, i , j);
            return innelem;
        }
}
