public class pupil{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void display(){
        System.out.println("The name is :" + name);
    }
}
class mein{
    public static void main(String args[]){
        pupil p=new pupil();
    }

}