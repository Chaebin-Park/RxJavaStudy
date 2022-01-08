package single;

import common.Order;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.awt.*;

public class SingleExample {
    static void just() {
        Single<String> source = Single.just("Hello Single");
        source.subscribe(System.out::println).dispose();
    }

    static void fromObservable() {
        // 1. Observable에서 Single 객체로의 변환
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(System.out::println)
                .dispose();

        // 2. single() 함수를 호출해 Single 객체 생성
        Observable.just("Hello Single")
                .single("default item")
                .subscribe(System.out::println)
                .dispose();

        // 3. first() 함수를 호출해 Single 객체 생성
        String[] colors = {"RED", "BLUE", "GOLD"};
        Observable.fromArray(colors)
                .first("default value")
                .subscribe(System.out::println)
                .dispose();

        // 4. empty Observable에서 Single 객체 생성
        Observable.empty()
                .single("default value")
                .subscribe(System.out::println)
                .dispose();

        // 5. take() 함수에서 Single 객체 생성
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default order"))
                .subscribe(System.out::println)
                .dispose();
    }

    static void errorCase() {
        Single<String> source = Observable
                .just("Hello Single", "Error")
                .single("default item");
        source.subscribe(System.out::println).dispose();
    }

    public static void main(String[] args) {
//        just();
//        fromObservable();

        errorCase();
    }
}
