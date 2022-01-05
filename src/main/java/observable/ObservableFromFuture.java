package observable;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ObservableFromFuture {
    // 3초 쉬고 Hello Future 반환
    static Future<String> future = Executors.newSingleThreadExecutor().submit(()->{
        Thread.sleep(3000);
        return "Hello Future";
    });

    public static void main(String[] args) {
        System.out.println("ObserverFromFuture");
        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(System.out::println).dispose();
    }
}
