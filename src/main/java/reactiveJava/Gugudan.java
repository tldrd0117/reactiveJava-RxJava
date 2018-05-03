package reactiveJava;

import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Gugudan {
	public static void main(String[] args) {
//		plainJava();
//		reactiveV1();
//		reactiveV2();
//		reactiveV3();
		usingResultSelector();
	}
	
	private static void plainJava() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		for( int row = 1; row <=9; ++row) {
			System.out.println(dan + " * " + row + " = " + dan*row);
		}
	}
	
	private static void reactiveV1() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		
		Observable<Integer> source = Observable.range(1, 9);
		source.subscribe(row -> System.out.println(dan + " * " + row + " = " + dan * row));
	}
	
	private static void reactiveV2() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		
		Function<Integer, Observable<String>> gugudan = num ->
			Observable.range(1, 9).map(row -> num + " * " + row + " = " + num * row );
		Observable<String> source = Observable.just(dan).flatMap(gugudan);
		source.subscribe(System.out::println);
	}
	
	private static void reactiveV3() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		Observable<String> source = Observable.just(dan)
				.flatMap( num -> Observable.range(1, 9)
						.map(row -> num + " * " + row + " = " + dan * row ));
		source.subscribe(System.out::println);
	}
	
	private static void usingResultSelector() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		Observable<String> source = Observable.just(dan)
				.flatMap(gugu -> Observable.range(1, 9),
						(gugu, i) -> gugu + " * " + i + " = " + gugu*i );
		source.subscribe(System.out::println);
				
	}
}
