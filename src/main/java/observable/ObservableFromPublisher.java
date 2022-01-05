package observable;

import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;


public class ObservableFromPublisher {
    /*
     *  Observable은 io.reactive
     *  Publisher, Subscriber는 org.reactivestreams
     */
    static Publisher<String> publisher1 = (Subscriber<? super String> s) -> {
        s.onNext("Hello Observable.fromPublisher()");
        s.onComplete();
    };

    // 람다 표현식 안쓴거
    static Publisher<String> publisher2 = new Publisher<String>() {
        @Override
        public void subscribe(Subscriber<? super String> s) {
            s.onNext("Hello Observable.fromPublisher()");
            s.onComplete();
        }
    };

    public static void main(String[] args) {
        Observable<String> source1 = Observable.fromPublisher(publisher1);
        source1.subscribe(System.out::println).dispose();

        Observable<String> source2 = Observable.fromPublisher(publisher2);
        source2.subscribe(System.out::println).dispose();
    }
}
