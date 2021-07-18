package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

interface Cap {
	double bookCap(String source, String destination);
}

interface Display {
	int show(String text);
}

@SpringBootApplication
public class DemoSpringAppApplication {
//	int globalParam = 1;
//	static int staticParam = 10;
//
//	public Cap cap = (source, destination) -> {
//		System.out.println("source:" + source + " destination:" + destination);
//		System.out.println(this.globalParam + " " + " " + staticParam);
//		return 100000;
//	};
//
//	public static void main(String[] args) {
//		final int localParam = 100;
//		Cap cap = new DemoSpringAppApplication().cap;
//		double distance = cap.bookCap("ratchaburi", "bangkok");
//		System.out.println("distance:" + distance);
//
//		String text = "Hello";
//		System.out.println("indexOf" + text.indexOf("llo"));
//
//		String myString = "helloworld";
//		Display display = myString::indexOf;
//		System.out.println(display.show("e"));
//
//		Consumer<String> x = (String param) -> System.out.println(param.toUpperCase());
//		x.accept("my_example");
//
//		Consumer<Integer> y = num -> System.out.println((num + num));
//		y.accept(10);
//
//		Consumer<String> nameFunc = name -> System.out.print(name);
//		Consumer<String> upperFunc = name -> System.out.println(" " + name.toUpperCase());
//		List<String> list = Arrays.asList("john", "sam", "linda");
//		list.forEach(myname -> {
//			nameFunc.andThen(upperFunc).accept(myname);
//		});
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringAppApplication.class, args);
	}

}
