package com.tomtom.patternchecker.IOConsoleStream.Console;

import com.tomtom.patternchecker.IOConsoleStream.IOStream.IInputStream;

import java.util.ArrayList;
import java.util.Scanner;
public class ConsolePrompt implements IInputStream {

	@Override
	public ArrayList<String> promptForInput() {
		System.out.println("Please type <path> <pattern_type>");
		ArrayList<String> args = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		args.add(scanner.next());
		args.add(scanner.next());
//		for (int i = 0; i < 2; i++) {
//			args.add(scanner.nextLine(), "wer");
//		}
	return args;
	}
}
