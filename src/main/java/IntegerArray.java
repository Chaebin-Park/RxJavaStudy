import io.reactivex.rxjava3.core.Observable;
import java.util.stream.IntStream;

public class IntegerArray {
    private static Integer[] toIntegerArray(int[] intArray) {
        // boxed() 메서드는 int[] 배열의 각 요소를 Integer로 변환해 Integer[] 배열의 스트림으로 만든다.
        // toArray() 메서드는 이 스트림을 Integer[] 배열로 만든다.
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int[] intArray = {400, 500, 600};
        Observable<Integer> source = Observable.fromArray(toIntegerArray(intArray));
        source.subscribe(System.out::println).dispose();
    }
}
