package Work09;

import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum Gender {
    MALE, FEMALE
}

class  Box implements Serializable  
{  
    private int width=1;  
    private int height=1;  
    
    public Box() {
    	
    }
    public Box(int w,int h) {
    	width = w;
    	height = h;
    }    
    public void setWidth(int width){  
        this.width  = width;  
    }  
    public void setHeight(int height){  
        this.height = height;  
    }    
    @Override
    public String toString() {
        return "Box width:"+width+" height:"+height;
    }      
}  

class Person implements Serializable {

    private String name = null;

    private Integer age = null;

    private Gender gender = null;
    
    private Box box = null;

    public Person() {
        System.out.println("none-arg constructor");
    }

    public Person(String name, Integer age, Gender gender,Box box) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.box = box;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + ", " +box +"]";
    }
}


public class SimpleSerial {

    public static void main(String[] args) throws Exception {
        File file = new File("person.out");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person(args[0], Integer.valueOf(args[1]), Gender.MALE,new Box(Integer.valueOf(args[2]),Integer.valueOf(args[3])));
        oos.writeObject(person);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = ois.readObject();
        ois.close();
        System.out.println(newPerson);
    }
}

