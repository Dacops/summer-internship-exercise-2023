package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    
    int n = matrix.length;
    int cycles = n/2;
    int index = 0;
    int[] snail = new int[n*n];

    for(int i=0; i<cycles; i++) {
      
      // get top snail part
      for(int j=i; j<(n-1)-i; j++) {
        snail[index++] = matrix[i][j];
      }

      // get right snail part
      for(int j=i; j<(n-1)-i; j++) {
        snail[index++] = matrix[j][(n-1)-i];
      }

      // get bottom snail part
      for(int j=(n-1)-i; j>i; j--) {
        snail[index++] = matrix[(n-1)-i][j];
      }

      // get left snail part
      for(int j=(n-1)-i; j>i; j--) {  
        snail[index++] = matrix[j][i];
      }
    }

    // if matrix is odd get the center value
    if(n%2 != 0) {
      snail[index++] = matrix[cycles][cycles];
    }

    CompletableFuture<int[]> completableFuture = new CompletableFuture<>();
    completableFuture.complete(snail);
    return completableFuture;
  };
}
