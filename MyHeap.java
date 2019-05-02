public class MyHeap{
  public static void pushDown(int[]data,int size,int index){
    int left = index*2+1;
    int right = index*2+2;
    if (right < size && left < size){ //if there are two children
      if (data[right] > data[left]){
        if (data[right] > data[index]){
          int greater = data[right];
          data[right] = data[index];
          data[index] = greater;
          index = right;
          pushDown(data, size, index);
        }
      }
      else{//when left is >= right
        if (data[left] > data[index]){
          int greater = data[left];
          data[left] = data[index];
          data[index] = greater;
          index = left;
          pushDown(data, size, index);
        }
      }
    }
    else if (left < size){
      if (data[left] > data[index]){
        int greater = data[left];
        data[left] = data[index];
        data[index] = greater;
        index = left;
        pushDown(data, size, index);
      }
    }
  }
    /* - size  is the number of elements in the data array.
     - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     - precondition: index is between 0 and size-1 inclusive
     - precondition: size is between 0 and data.length-1 inclusive.*/

public static void pushUp(int[]data,int index){
  while ((index-1)/2 >= 0){ //if there is a parent
    if (index == 0){
      return;
    }
    int parent = data[(index-1)/2];
    if (parent < data[index]){//if parent is smaller, swap
      data[(index-1)/2] = data[index];
      data[index] = parent;
      index = (index-1)/2;
    }
    else{
      return;
    }
  }
}
     /*- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
     - precondition: index is between 0 and data.length-1 inclusive.*/


public static int countSize(int[] data){
  int ans = 0;
  for (int i = 0; i < data.length; i++){
    if (!(data[i]+"").equals("null")){ //if this spot isn't empty
      ans++;
    }
    else{
      return ans;
    }
  }
  return ans;
}

// - convert the array into a valid heap. [ should be O(n) ]
     public static void heapify(int[] data, int size){

       //int size = countSize(data);
       for (int i = size - 1; i >= 0; i--){
         pushDown(data, size, i);
       }
     }

     public static void heapsort(int[] data){
       int size = countSize(data);
       heapify(data, size);
       for (int i = size - 1; i >= 0; i--){
         int largest = data[0];
         data[0] = data[i];
         data[i] = largest;
         pushDown(data, i, 0);
       }
     }
     /*- sort the array [ should be O(nlogn) ] :
     converting it into a heap
     removing the largest value n-1 times (remove places at end of the sub-array). */
}
