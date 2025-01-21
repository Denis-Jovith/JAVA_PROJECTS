interface pupils{
    public void study();
    public void venue();
}
class cse implements pupils{
    @Override
    public void study() {
        System.out.println("They are studying Mathematics");
    }
    @Override
    public void venue() {
        System.out.println("They are using Sports Hall");
    }
}
class maain{
    public static void main(String args[]){
        cse b=new cse();
        b.study();
        b.venue();
    }
}