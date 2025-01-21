public class ThrowExample{
    static void checkAge(int Age){
        if(Age < 18){
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        }
        else{
            System.out.println("Access granted -You are old enough");
        }
    }

    public static void main(String args[]){
        checkAge(15);
    }
}