public class driver{
  public static void main(String[] args){
    int[] list = new int[10];
    //sample 10,15,2
    list[0] = 10;
    list[1] = 2;
    list[2] = 15;
    list[3] = 1;
    list[4] = 0;
    list[5] = 11;
    list[6] = 13;
    int size = 7;
    System.out.println("Before");
    for (int i = 0; i < list.length; i++){
      if (i < size){
        System.out.print(list[i] + ", ");
      }
      else{
        System.out.print("null, ");
      }
    }
    System.out.println();
    System.out.println("After");
    MyHeap.pushDown(list,size,0);
    for (int i = 0; i < list.length; i++){
      if (i < size){
        System.out.print(list[i] + ", ");
      }
      else{
        System.out.print("null, ");
      }
    }
    System.out.println();
    System.out.println(-1/2);
  }
}
