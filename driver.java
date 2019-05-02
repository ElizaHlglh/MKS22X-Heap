public class driver{
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
    System.out.println("After pushing up at 6");
    MyHeap.pushUp(list,4);
    HeapPrinter.print(list);
    System.out.println();
  }
}
