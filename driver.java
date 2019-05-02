/*public class driver{
  public static void main(String[] args){
    int size = 7;
    int[] list = new int[size];
    //sample 10,15,2
    for (int i = 0; i < size; i++){
      list[i] = i;
    }
    System.out.println("Before");
    HeapPrinter.print(list);
    System.out.println("After pushing down at 0");
    MyHeap.pushDown(list,size,0);
    HeapPrinter.print(list);
    System.out.println();

    for (int i = 0; i < size; i++){
      list[i] = i;
    }
    System.out.println("Before");
    HeapPrinter.print(list);
    System.out.println("After pushing up at 4");
    MyHeap.pushUp(list,4);
    HeapPrinter.print(list);
    System.out.println();

    int[] test = {40,50,63,17,22,68,89,97,89};
    list = new int[test.length];
    size = test.length;
    for (int i = 0; i < size; i++){
      list[i] = test[i];
    }
    System.out.println("Before");
    HeapPrinter.print(list);
    System.out.println("After heapify");
    MyHeap.heapify(list);
    HeapPrinter.print(list);
    System.out.println();

    System.out.println("testing fi null+ '' == null  " +  ((null+"").equals("null")) );
  }
}
*/

import java.util.Arrays;
public class driver{
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        MyHeap.heapsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
