package Test;

public class Test_Foo {
    public static void method(int i){

    try{

        if(i>0){

            return;

        }else{

            System.exit(1);

        }

    }finally{

        System.out.println("Finally");

    }

}

    public static void main(String[] args){

        method(5);

        method(-5);

    }
}
