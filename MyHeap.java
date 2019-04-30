public class MyHeap{
  //We discussed these 2 methods already:
  private static void pushDown(int[]data,int size,int index){
    while (index*2 <= size-1) { //while it has at least branches/leaves
      if (index*2 + 1 <= size-1){ //if there are two branches/leaves
        int left = data[index * 2];
        int right = data[index*2 + 1];
        if (right - left >= 0){ //if right is == or greater than left
          if (right - data[index] > 0){ // if the right child is greater than parent
            if (right == left){ //switch left with the parent when the childrens are equal
              data[index*2] = data[index];
              data[index] = left;
              index = index*2;
            }
            else{ // switch with right child
              data[index*2+1] = data[index];
              data[index] = right;
              index = index*2+1;
            }
          }
        }
        else{//if left is greater than right
          return;
        }
      }
    }
  }
    /* - size  is the number of elements in the data array.
     - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     - precondition: index is between 0 and size-1 inclusive
     - precondition: size is between 0 and data.length-1 inclusive.*/

private static void pushUp(int[]data,int index){

}
     /*- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
     - precondition: index is between 0 and data.length-1 inclusive.*/


//We will discuss this today:
public static void heapify(int[] data){

}
  /*  - convert the array into a valid heap. [ should be O(n) ]*/

public static void heapsort(int[] data){

}
    /*- sort the array [ should be O(nlogn) ] :
     converting it into a heap
     removing the largest value n-1 times (remove places at end of the sub-array). */

}