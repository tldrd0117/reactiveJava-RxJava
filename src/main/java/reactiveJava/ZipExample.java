package reactiveJava;

import common.Log;
import common.Shape;
import io.reactivex.Observable;

public class ZipExample {
	public static void main(String[] args) {
//		marbleDiagram();
		zipNumbers();
	}
	
	private static void marbleDiagram() {
		String[] shapes = {"BALL", "PENTAGON", "STAR"};
		String[] coloredTriangles = {"2-T", "6-T", "4-T"};
		
		Observable<String> source = Observable.zip(
				Observable.fromArray(shapes).map(Shape::getSuffix),
				Observable.fromArray(coloredTriangles).map(Shape::getColor),
				(suffix, color) -> color + suffix
				);
		
		source.subscribe(Log::i);
	}
	
	private static void zipNumbers() {
		Observable<Integer> source = Observable.zip(
				Observable.just(100, 200, 300),
				Observable.just(10,20,30),
				Observable.just(1,2,3),
				(a,b,c) -> a + b+ c
				);
		source.subscribe(Log::i);
	}
	
}
