package Demo;

/**
 * @author: fs
 * @date: 2022/4/4 13:37
 * @Description:
 */
public class Person {
    public void eat(){
        System.out.println("aaa");
    }
}

class Student extends Person{
    @Override
    public void eat() {
        System.out.println("bbb");
    }

    public void show(){
        System.out.println("ddd");
    }
}

class Teacher extends Person{
    @Override
    public void eat() {
        System.out.println("ccc");
    }
}

class Main{
    public static void main(String[] args) {
        Person p=new Student();

    }


    public static void eat(Person t){
        System.out.println("");
    }
}