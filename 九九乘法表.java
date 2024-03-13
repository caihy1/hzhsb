class Multable{
    public void nine() {
        for( int i=1;i<=9;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(i+"*"+j+"="+i*j);
                System.out.print(" ");
            }
        System.out.println();
        }
    }
}
public class java4 {
   public static void main(String[] args) {
      Multable mul=new Multable();
      mul.nine();
   }
}
