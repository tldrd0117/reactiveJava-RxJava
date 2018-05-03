package reactiveJava;

import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class ObservableFromCallable {
	public static void main(String[] args) {
		Callable<String> callable = () -> {
			Thread.sleep(1000);
			return "Hello Callable";
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
		
	}
}
