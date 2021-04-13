package designPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}


abstract class Subject {
    protected List<Observer> observerList = new ArrayList<>();

    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public abstract void notifyObserver();
}

class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体发生改变。。。");
        System.out.println("--------");

        for (Object obs : observerList) {
            ((Observer) obs).response();
        }
    }
}


//观察者
interface Observer {
    void response();
}

class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}

class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}