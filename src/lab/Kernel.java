package lab;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Kernel {
	private ElStack stack;
    private HashMap<Integer, SystemCall> systemCalls = new HashMap<>();

    public Kernel(ElStack stack) {
        this.stack = stack;

        systemCalls.put(0, new SystemCall(new ArgType(1), new ArgType(5.6), new ArgType("f")));
        systemCalls.put(1, new SystemCall(new ArgType(2), new ArgType(2)));
        systemCalls.put(2, new SystemCall(new ArgType(3)));
        systemCalls.put(3, new SystemCall(new ArgType(4), new ArgType(1.34), new ArgType("s")));
        systemCalls.put(4, new SystemCall(new ArgType(5), new ArgType(2.2), new ArgType("d"), new ArgType("o")));

        getSystemCalls();

    	Scanner scanner = new Scanner(System.in);
        executeSystemCall(scanner.nextInt());
    }

    public void getSystemCalls() {
        for (int key : systemCalls.keySet()) {
            System.out.print("\nid: " + key + "\narguments: ");

            for (int i = 0; i < systemCalls.get(key).getArgumentsSize(); i++) {
                System.out.print(systemCalls.get(key).getArgs().get(i).getArgument() + " ");
            }
            System.out.print("\n");
        }
    }

    public void executeSystemCall(int id) {
        if (systemCalls.containsKey(id)) {
            boolean flag = true;
            for (int i = systemCalls.get(id).getArgs().size() - 1; i >= 0; i--) {
                if (!stack.pop().equals(systemCalls.get(id).getArgs().get(i).getArgument())) {
                    System.out.println("аргументы не равны");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print("выполнение системного вызова с id: " + id + "arguments:");
                for (int i = 0; i < systemCalls.get(id).getArgumentsSize(); i++) {
                    System.out.print(" " + systemCalls.get(id).getArgs().get(i).getArgument());
                }
            }
        } else {
            System.out.println("такой ключ не существует");
        }
    }
}
