package reactiveJava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {
	public static void main(String[] args) {
		marbleDiagram();
	}
	
	private static void marbleDiagram() {
		Function<String, Observable<String>> getDoubleDiamonds
		= ball -> Observable.just(ball + "<>", ball + "<>2");
		
		String[] balls = {"1", "3", "5"};
		
		Observable<String> source = Observable.fromArray(balls)
				.flatMap(getDoubleDiamonds);
		source.subscribe(System.out::println);
	}
}
