abstract class student{
    public abstract void dep();
    public void cse(){
        System.out.println("The first Department");
    }
}
class hod extends student{
    public void dep(){
        System.out.println("Name of HoD is Dr.Mrindoko");
        System.out.println("The department have three programs");
    }
}

class main{
    public static void main(String args[]){
        hod b = new hod();
        b.cse();
        b.dep();

    }
}