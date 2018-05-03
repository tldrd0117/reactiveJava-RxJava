package reactiveJava;

import java.util.concurrent.TimeUnit;

import common.CommonUtils;
import common.Log;
import io.reactivex.Observable;

public class IntervalExample {
	public static void main(String[] args) {
//		printNumbers();
		noInitialDelay();
	}
	
	private static void printNumbers() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(data -> (data + 1) * 100)
				.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
	}
	
	private static void noInitialDelay() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
				.map(val -> val + 100)
				.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
	}
}
