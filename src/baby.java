public class baby{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
//
private int age;
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    //
    private String gender;
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public void display(){
        System.out.println("The name is :" +name);
        System.out.println("The name is :" +age);
        System.out.println("The name is :" +gender);
    }
}
class meiin{
    public static void main(String args[]){
        baby b=new baby();
        b.setName("Aisha");
        b.setAge(20);
        b.setGender("Female");
        b.display();
    }

}