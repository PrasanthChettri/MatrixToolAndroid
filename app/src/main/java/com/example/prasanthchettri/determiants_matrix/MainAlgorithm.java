package com.example.prasanthchettri.determiants_matrix;

import java.util.Arrays;
public class MainAlgorithm {


        public static int elements[][] ;
        public static int e_lenght ;


        void getdata(int number[][] ){
            e_lenght = number.length ;
            elements = Arrays.copyOf(number , e_lenght);
        }

        public static int mainlooper(int matrix[][] , int length){
            int TemDeterminant = 0 ;
            for (int i = 0 ; i < length ; i++)
                TemDeterminant += Math.pow(-1, 2 + i) * matrix[0][i] * deter(matrix, length, i, 0);
            return TemDeterminant ;
        }

        public static int deter(int elements[][] , int size , int row  , int column){
            int tempmatr[][] = new int[size-1][size-1] , loci = 0  , locj = 0 ;
            for (int i = 0 ; i < size ; i++){
                if(column != i) {
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
            if (size ==3)
                return (tempmatr[0][0] * tempmatr[1][1]) - (tempmatr[0][1] * tempmatr[1][0]);

            return mainlooper(tempmatr , size-1);
        }


        public static int[][] mainloop_adjont(){
            for(int i = 0 ; i < 3 ;i++){
                    for(int j = 0 ; j < e_lenght ; j++)
                        elements[i][j] = (int) (Math.pow(-1, 2 + j + i) * deter(elements, e_lenght, i, j));
                }
            return transpose( e_lenght,elements );
        }



        public static int[][] transpose(int size , int elemens[][]){

                int [][] new_matrix = new int[size][size];
                for (int i = 0 ; i < size ;i ++){
                for (int j= 0 ; j < size ; j++) new_matrix[i][j] = elemens[j][i];
            }
            return new_matrix;

        }

}
