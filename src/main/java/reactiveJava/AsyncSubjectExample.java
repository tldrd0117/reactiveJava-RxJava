package reactiveJava;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
	public static void main(String[] args) {
		asSubsriber();
		afterComplete();
	}
	
	private static void asSubsriber() {
		Float[] temperature = { 10.1f, 13.4f, 12.5f };
		Observable<Float> source = Observable.fromArray(temperature);
		
		AsyncSubject<Float> subject = AsyncSubject.create();
		subject.subscribe(data -> System.out.println("Subscriber #1 => "  + data));
		
		source.subscribe(subject);
	}
	
	private static void afterComplete() {
		AsyncSubject<Integer> subject = AsyncSubject.create();
		subject.onNext(10);
		subject.onNext(11);
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		subject.onNext(12);
		subject.onComplete();
		subject.onNext(13);
		subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		subject.subscribe(data -> System.out.println("Subscriber #3 => " + data));
	}
}
