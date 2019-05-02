public class MyHeap{
  //We discussed these 2 methods already:
  public static void pushDown(int[]data,int size,int index){
    while (index*2+1 <= size-1) { //while it has at least branches/leaves
      //System.out.println("index = " + index);
      int left = data[index * 2 + 1];
      if (index*2 + 2 <= size-1){ //if there are two branches/leaves
        int right = data[index*2 + 2];
        if (data[index] > left && data[index] > right){//check if greater to see if there is a need to continue
          return;
        }
        if (right >= left){ //if right is == or greater than left
          if (right > data[index]){ // if the right child is greater than parent
            if (right == left){ //switch left with the parent when the childrens are equal
              data[index*2+1] = data[index];
              data[index] = left;
              index = index*2+1;
            }
            else{ // switch with right child
              data[index*2+2] = data[index];
              data[index] = right;
              index = index*2+2;
            }
          }
        }
        else{//if left is greater than right
          if (left - data[index] > 0){ // if the lrft child is greater than parent
            data[index*2+1] = data[index];
            data[index] = left;
            index = index*2+1;
          }
        }
      }
      else{//if there is only left child
        if (left - data[index] > 0){//replace parent with left if left is greater
          data[index*2+1] = data[index];
          data[index] = left;
          index = index*2+1;
        }
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

     public static void heapifyHelp(int[]data, int size, int index){
       //assumed that the bottom is legal
       int parent = index;
       int leftC = 0;
       int rightC = 0;
       if (index*2 + 1 < size){
         leftC = index*2+1;
       }
       if (index*2 + 2 < size){
         rightC = index*2+2;
       }
       if (leftC != 0 && rightC != 0){ //if have both children
         if (data[leftC] >= data[rightC]){ // if left is greater than right
           if (data[leftC] > data[parent]){
             parent = leftC;
           }
         }
         else{
           if (data[rightC] > data[parent]){
             parent = rightC;
           }
         }
       }
       else if (leftC != 0){//if there is a left child
         if (data[leftC] > data[parent]){
           parent = leftC;
         }
       }
       if (parent != index){//there is a child with larger value
         //parent is the location for the largest value right now
         int larger = data[parent];
         data[parent] = data[index];
         data[index] = larger;
         //after swaping the larger child with the parent, int parent is now the location for the switched parent
         //use recursion to check the value underneath the newly switched off parent.
         heapifyHelp(data, size, parent);
       }
       //if the parent stay the same, no change needed.
     }


//We will discuss this today:
public static void heapify(int[] data){
  int size = countSize(data);
  for (int i = size-1; i >= 0; i--){
    heapifyHelp(data,size, i);
  }
}

  /*  - convert the array into a valid heap. [ should be O(n) ]*/

  public static void heapy(int[] data, int size){
    for (int i = size-1; i >= 0; i--){
      heapyHelp(data,size, i);
    }
  }

  public static void heapyHelp(int[]data, int size, int index){
    //assumed that the bottom is legal
    for (int i = size-1; i >= 0; i--){
      pushDown2(data, size, i);
    }
  }

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

public static void heapsort(int[] data){
  int[] ans = new int[data.length];
  int size = countSize(data);
  heapy(data, size);
  for (int i = size -1; i >= 0; i--){
    int largest = data[0];
    data[0] = data[i];
    data[i] = largest;
    /*System.out.println("data after for loop");
    for (int k = 0; k < data.length; k++){
      System.out.print(data[k] + ", ");
    }*/
    heapy(data, i);
  }
  /*System.out.println("data after for loop");
  for (int i = 0; i < data.length; i++){
    System.out.print(data[i] + ", ");
  }*/

/*  for (int z = size - 1; z >= 0; z--){
    ans[size-z-1] = data[z];
  }*/

  /*for (int i = 0; i < data.length; i++){
    data[i] = ans[i];
  }*/

  /*System.out.println("ans after for loop");
  for (int i = 0; i < ans.length; i++){
    System.out.print(ans[i] + ", ");
  }
  System.out.println();*/
}
    /*- sort the array [ should be O(nlogn) ] :
     converting it into a heap
     removing the largest value n-1 times (remove places at end of the sub-array). */


     public static void pushDown2(int[]data,int size,int index){
       int left = index*2+1;
       int right = index*2+2;
       if (right < size && left < size){ //if there are two children
         if (data[right] > data[left]){
           if (data[right] > data[index]){
             int greater = data[right];
             data[right] = data[index];
             data[index] = greater;
             index = right;
             pushDown2(data, size, index);
           }
         }
         else{//when left is >= right
           if (data[left] > data[index]){
             int greater = data[left];
             data[left] = data[index];
             data[index] = greater;
             index = left;
             pushDown2(data, size, index);
           }
         }
       }
       else if (left < size){
         if (data[left] > data[index]){
           int greater = data[left];
           data[left] = data[index];
           data[index] = greater;
           index = left;
           pushDown2(data, size, index);
         }
       }
     }

     public static void heapify2(int[] data, int size){
       //int size = countSize(data);
       for (int i = size - 1; i >= 0; i--){
         pushDown2(data, size, i);
       }
     }

     public static void heapsort2(int[] data){
       int size = countSize(data);
       heapify2(data, size);
       for (int i = size - 1; i >= 0; i--){
         int largest = data[0];
         data[0] = data[i];
         data[i] = largest;
         pushDown2(data, i, 0);
       }
     }
}
