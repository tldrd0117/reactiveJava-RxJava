package reactiveJava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ObservableNotifications {
	public static void main(String[] args) {
		Observable<String> source = Observable.just("RED","GREEN","YELLO");
		
		Disposable d = source.subscribe(
				v -> System.out.println("onNext() : value : " + v),
				err -> System.out.println("onError() : err : " + err.getMessage()),
				() -> System.out.println("onComplete")
				);
		
		System.out.println("isDisposed() : " + d.isDisposed());
		
	}
}
