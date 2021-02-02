import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    Subject sub;
    abstract void update();
}


abstract class Subject {

    private List<Observer> listaobserwatorow = new ArrayList<Observer>();
    public abstract int GetState();
    public abstract void SetState(int state);

    public void attach(Observer observer){
        listaobserwatorow.add(observer);
    }

    public void Notify(){
        for (Observer observer : listaobserwatorow) {
            observer.update();
        }
    }
}

class ConcreteSubject extends Subject {

    protected int state;


    @Override
    public int GetState() {
        return state;
    }

    @Override
    public void SetState(int state) {
        this.state = state;
        Notify();
    }
}


class ConcreteObserver extends Observer{

    @Override
    public void update() {
        System.out.println( sub.GetState() );
    }
    public ConcreteObserver(Subject subject){
        this.sub = subject;
        this.sub.attach(this);
    }

}

public class main {
    public static void main(String[] args){
        ConcreteSubject nowy = new ConcreteSubject();
        new ConcreteObserver(nowy);
        nowy.SetState(2);
        nowy.SetState(23);
    }
}