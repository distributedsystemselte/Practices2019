import java.rmi.registry.*;

public class Client{
	public static void main (String [] args)throws Exception{
		
		String host = "localhost";
		int port = 12345;
		String calculateOneServerName = "calculateOne";
		String calculateTwoServerName = "calculateTwo";		
		Registry registry = LocateRegistry.getRegistry(host,port);
		
		String [] registers = registry.list();
		System.out.println("<--> Registers <-->");
		for(String a :registers)
				System.out.println(a);
		
		System.out.println("<--> Registers End <-->");
			
		CalculatorInterface calculatorOne = 
			(CalculatorInterface)(registry.lookup(calculateOneServerName));
		
		CalculatorInterface calculatorTwo = 
			(CalculatorInterface)(registry.lookup(calculateTwoServerName));
		
		System.out.println("Calculator one div by 10: " + calculatorOne.div(10));
		System.out.println("Calculator one mul by 10: " + calculatorOne.mul(10));
		System.out.println("Calculator one add by 10: " + calculatorOne.add(10));
		System.out.println("Calculator one sub by 10: " + calculatorOne.sub(10));
		calculatorTwo.setNum(20);
		System.out.println("Calculator two settomg value to 20");
		
		System.out.println("Calculator two div by 10: " + calculatorTwo.div(10));
		System.out.println("Calculator two mul by 10: " + calculatorTwo.mul(10));
		System.out.println("Calculator two add by 10: " + calculatorTwo.add(10));
		System.out.println("Calculator two sub by 10: " + calculatorTwo.sub(10));


	}
	
}