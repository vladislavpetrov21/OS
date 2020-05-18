package lab;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ElStack stack = new ElStack();
		Kernel kernel = new Kernel(stack);
		while(true){
			String line = scanner.nextLine();
			if (line.equals("all_calls")){
				kernel.Calls();
			}
			else {
				String[] lineSplit = line.split(" ");
				if (!lineSplit[0].equals("system_call")) {
					System.out.print("Неверная команда\n");
				} else {
					int id = Integer.parseInt(lineSplit[1]);
					for (int i = 2; i < lineSplit.length; i++) {
					stack.push(lineSplit[i]);
				}
				kernel.ExecuteCall(id);			
				}
			}
		}
	}
}
