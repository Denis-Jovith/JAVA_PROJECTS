
public class Mainiii {
    public static void main(String args[]){
        CoICT coict = new CoICT();
        CSE cse = new CSE();
        IF ifu = new IF();
        IST ist = new IST();
        Telecom telecom = new Telecom();

        coict.study();
        cse.study();
        ifu.study();
        ist.study();
        telecom.study();
    }
}

class CoICT{
     public void study(){

         System.out.println( "COICT study COICT");
    }
}

class CSE extends CoICT{
    @Override
    public void  study(){

        System.out.println("CSE study math") ;
    }
}

class IF extends CoICT{
    @Override
    public void study(){

        System.out.println("IF study computing") ;
    }
}

class IST extends CoICT{
    @Override
    public void  study(){

        System.out.println("IST study software development") ;
    }
}

class Telecom extends CoICT{
    @Override
    public void study(){

        System.out.println("Telecom study electronics");
    }
    }