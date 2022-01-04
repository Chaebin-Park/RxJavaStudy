import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableNotifications {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("RED", "GREEN", "YELLOW");
        Disposable d = source.subscribe(
                v -> System.out.println("OnNext : value : " + v),
                err -> System.err.println("OnError : err : " + err.getMessage()),
                () -> System.out.println("OnComplete")
        );

        System.out.println("isDisposed : " + d.isDisposed());
    }
}
