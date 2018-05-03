package reactiveJava;

import java.util.concurrent.TimeUnit;

import common.CommonUtils;
import common.Log;
import common.OkHttpHelper;
import io.reactivex.Observable;

public class RepeatExample {
	private static void marbleDiagram() {
		String[] balls = {"1", "3", "5"};
		Observable<String> source = Observable.fromArray(balls)
				.repeat(3);
		
		source.doOnComplete(() -> Log.d("onComplete"))
			.subscribe(Log::i);
		
	}
	
	private static void heartbeatV1() {
		CommonUtils.exampleStart();
		String serverUrl = "https://api.github.com/zen";
		
		Observable.timer(2, TimeUnit.SECONDS)
			.map(val -> serverUrl)
			.map(OkHttpHelper::get)
			.repeat()
			.subscribe(res -> Log.it("Ping Result : " + res));
		CommonUtils.sleep(10000);
	}
	
	public static void main(String[] args) {
		marbleDiagram();
		heartbeatV1();
	}
	
	
}
