import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.Callable;

public class ObserverFromCallable {
    // 3초 쉬었다가 "Hello Callable" 반환
    static Callable<String> callable1 = () -> {
        Thread.sleep(3000);
        return "Hello Callable";
    };

    // 람다 표현식 없는 fromCallable 함수
    static Callable<String> callable2 = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "Hello Callable";
        }
    };

    public static void main(String[] args) {
        System.out.println("ObserverFromCallable1");
        Observable<String> source1 = Observable.fromCallable(callable1);
        source1.subscribe(System.out::println).dispose();

        System.out.println("ObserverFromCallable2");
        Observable<String> source2 = Observable.fromCallable(callable1);
        source2.subscribe(System.out::println).dispose();
    }
}
