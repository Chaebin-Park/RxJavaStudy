package observable;

import io.reactivex.rxjava3.core.Observable;

public class FirstExample {
    public void emit() {
        Observable.just("Hello", "RxJava 2!!")
                .subscribe(System.out::println)
                .dispose();
    }

    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}
