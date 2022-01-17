package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class InfixParserTester {
	public static void main (String[]args) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(new File("infix.txt"));
		String expression;
		InfixParser i = new InfixParser();
		PrintStream outputFile = new PrintStream("parser_output.txt");
	
		while(inputFile.hasNextLine())
		{
			expression = inputFile.nextLine();
			if(i.isExpression(expression))
			{
				System.out.println(expression + " is valid");
				outputFile.println(expression + " is valid");
			}
			else
			{
				System.out.println(expression +" is NOT valid");
				outputFile.println(expression + " is NOT valid");
			}
			
		}
		inputFile.close();
		outputFile.close();
	}
}
