package reactiveJava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import common.CommonUtils;
import common.Log;
import io.reactivex.Observable;

public class TimerExample {
	public static void main(String[] args) {
		showTime();
	}
	
	private static void showTime() {
		CommonUtils.exampleStart();
		Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS)
				.map(notUsed -> {
					return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
							.format(new Date());
				});
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
	}
}
