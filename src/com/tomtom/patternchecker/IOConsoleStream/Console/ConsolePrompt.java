package com.tomtom.patternchecker.IOConsoleStream.Console;

import com.tomtom.patternchecker.IOConsoleStream.IOStream.IInputStream;

import java.util.ArrayList;
import java.util.Scanner;
public class ConsolePrompt implements IInputStream {

	@Override
	public ArrayList<String> promptForInput() {
		System.out.println("Please type <path> -space- <pattern_type>");
		ArrayList<String> args = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		args.add(scanner.next());
		args.add(scanner.nextLine());
		scanner.close();
		return args;
	}
}
