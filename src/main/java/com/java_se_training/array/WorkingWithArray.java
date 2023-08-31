package com.java_se_training.array;

import java.util.logging.Logger;


public class WorkingWithArray {

      private static final Logger LOGGER = Logger.getLogger(WorkingWithArray.class.getName()); 

      public void singleDimensionArray(){
        int [] numbers = {1,2,3,4,5};

        String[] nickNames = {"cee", "lefty", "mahrez", "mzoefu"};

          // LOGGER.info("Nick name " + nickNames[2]);

        for (int  i=0; i < numbers.length; i+=2) {
          LOGGER.info("Number " + i);
        }

        //printing array position indexes in the number array
        for (int  i=0; i < numbers.length; i++) {
         if(i % 2 != 0){
          LOGGER.info("Index " + numbers[i]);
         }
        }
           
      }


     public void multiDimensionArray(){
       int [][] matrix = {{1,2}, {3,4},{5,6}};

       int[][] matrix2 =new int [3][3];

       matrix2[0][0] = 10;
       matrix2[0][1] = 15;

       matrix2[1][2] = 20;
       

       matrix2[2][0] = 30;
      
       for(int i=0; i<matrix2.length; i++){
        for(int j = 0; j < matrix2[i].length; j++){
          System.out.print(matrix2[i][j] + " ");
        }
        System.out.println();
       }

     }
        

    public static void main(String[] args) {
        WorkingWithArray app = new WorkingWithArray();
        //app.singleDimensionArray();
        app.multiDimensionArray();
    }
    
}
