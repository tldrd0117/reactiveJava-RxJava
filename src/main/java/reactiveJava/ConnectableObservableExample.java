package reactiveJava;

import java.util.concurrent.TimeUnit;

import common.CommonUtils;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableExample {
	public static void main(String[] args) {
		marbleDiagram();
	}
	
	private static void marbleDiagram() {
		String[] dt = {"1", "3", "5"};
		Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(i -> dt[i] )
				.take(dt.length);
		ConnectableObservable<String> source = balls.publish();
		source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		source.connect();
		
		CommonUtils.sleep(250);
		source.subscribe(data -> System.out.println("Subscriber #3 => " + data));
		CommonUtils.sleep(100);
	}
}
