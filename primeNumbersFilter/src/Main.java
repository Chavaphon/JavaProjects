import java.util.Scanner;

//max = 20

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number range:");
        int x = scanner.nextInt();
        System.out.println("Prime numbers within 1 - "+x+":");

        for(int j = 2;j<x+1;j++){
            long fac = 1;
            for(int i = 1;i <= j - 1;i++)
            {
                fac*=i;
            }

            if((fac+1) % j == 0)
            {
                System.out.println(j);
            }

            System.out.println(j+" : "+fac);
        }
    }
}