package reactiveJava;

import java.util.concurrent.TimeUnit;

import common.CommonUtils;
import common.Log;
import io.reactivex.Observable;

public class IntervalRangeExample {
	public static void main(String[] args) {
//		printNumbers();
		makeWithInterval();
	}
	private static void printNumbers() {
		Observable<Long> source = Observable.intervalRange(1, 5, 100L, 100L, TimeUnit.MILLISECONDS);
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
	}
	
	private static void makeWithInterval() {
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(val -> val + 1)
				.take(5);
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
	}
}
