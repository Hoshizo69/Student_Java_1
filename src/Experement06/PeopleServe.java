package Experement06;

public class PeopleServe {
    public static void main(String[] args) {
        ServeThePeople serveThePeople;
        serveThePeople = new Teacher();
        serveThePeople = new Docter();
        serveThePeople = new Police();
        serveThePeople = new Solder();
        serveThePeople = new Other();
    }
}
interface ServeThePeople{
    void service();
}
class Teacher implements ServeThePeople{
    public Teacher() {
        service();
    }

    @Override
    public void service() {
        System.out.println("Preach,Knowledge,Dispels doubt.");
    }
}
class Docter implements ServeThePeople{
    public Docter() {
        service();
    }

    @Override
    public void service() {
        System.out.println("heal the wounded and rescue the dying.");
    }
}
class Police implements ServeThePeople{
    public Police() {
        service();
    }

    @Override
    public void service() {
        System.out.println("uphold the rule of law.");
    }
}
class Solder implements ServeThePeople{
    public Solder() {
        service();
    }

    @Override
    public void service() {
        System.out.println("protect our homes and defend our country.");
    }
}
class Other implements ServeThePeople{
    public Other() {
        service();
    }

    @Override
    public void service() {
        System.out.println("Do your job.");
    }
}