package reactiveJava;

import common.Log;
import io.reactivex.Observable;

public class RangeExample {
	public static void main(String[] args) {
		forLoop();
	}
	private static void forLoop() {
		Observable<Integer> source = Observable.range(1, 10)
				.filter(number -> number % 2 == 0);
		source.subscribe(Log::i);
	}
}
