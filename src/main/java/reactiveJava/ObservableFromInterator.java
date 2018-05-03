package reactiveJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import io.reactivex.Observable;

public class ObservableFromInterator {
	public static void main(String[] args) {
		listExample();
		setExample();
		blockingQueueExample();
	}
	
	private static void listExample() {
		List<String> names = new ArrayList<>();
		names.add("Jerry");
		names.add("William");
		names.add("Bob");
		
		Observable<String> source = Observable.fromIterable(names);
		source.subscribe(System.out::println);
	}
	
	private static void setExample() {
		Set<String> cities = new HashSet<>();
		cities.add("Seoul");
		cities.add("London");
		cities.add("paris");
		
		Observable<String> source = Observable.fromIterable(cities);
		source.subscribe(System.out::println);
		
		
	}
	
	private static void blockingQueueExample() {
		BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
		orderQueue.add( new Order("ORD-1") );
		orderQueue.add( new Order("ORD-2") );
		orderQueue.add( new Order("ORD-3") );
		
		Observable<Order> source = Observable.fromIterable(orderQueue);
		source.subscribe(order -> System.out.println(order.getId()));
		
	}
}
