package reactiveJava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

import common.CommonUtils;
import common.Log;
import common.Shape;
import io.reactivex.Observable;

public class DeferExample {
	private static Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();
	
	private static void marbleDiagram() {
		Callable<Observable<String>> supplier = () -> getObservable();
		Observable<String> source = Observable.defer(supplier);
		
		source.subscribe( val -> Log.i("Subscriber #1:" + val));
		source.subscribe( val -> Log.i("Subscriber #2:" + val));
		source.subscribe( val -> Log.i("Subscriber #3:" + val));
		CommonUtils.exampleComplete();
	}
	
	private static Observable<String> getObservable(){
		if ( colors.hasNext() ) {
			String color = colors.next();
			return Observable.just(
					Shape.getString(color, Shape.BALL),
					Shape.getString(color, Shape.RECTANGLE),
					Shape.getString(color, Shape.PENTAGON));
		}
		return Observable.empty();
	}
	
	private static void notDeferred() {
		Observable<String> source = getObservable();
		source.subscribe(val -> Log.i("Subscriber #1:" + val));
		source.subscribe(val -> Log.i("Subscriber #2:" + val));
	}
	
	public static void main(String[] args) {
//		marbleDiagram();
		notDeferred();
	}
	
}
