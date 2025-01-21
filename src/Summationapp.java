import java.util.Scanner;

class Summationapp{
    public static void main(String args[]){
        Scanner b = new Scanner(System.in);
        System.out.println("Enter the year you were born : ");
        int yearborn = b.nextInt();

        System.out.println("Enter the the year we are in now : ");
        int currentyear = b.nextInt();

        System.out.println("Enter your name: ");
        String yourName = b.nextLine();

        int age = currentyear - yearborn;
        System.out.println("Hello " + yourName +" Your age is : "+ age);
    }
}