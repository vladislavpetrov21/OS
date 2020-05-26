package lab;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Kernel {
	private ElStack stack;
    private HashMap<Integer, SystemCall> systemCalls = new HashMap<>();

    public Kernel(ElStack stack) {
        this.stack = stack;

        systemCalls.put(1, new SystemCall(new ArgType(123), new ArgType(2.3), new ArgType("str")));
        systemCalls.put(2, new SystemCall(new ArgType(1), new ArgType(2.35)));
        systemCalls.put(3, new SystemCall(new ArgType(69)));
        systemCalls.put(4, new SystemCall(new ArgType(123), new ArgType(2.3), new ArgType("str")));
        systemCalls.put(5, new SystemCall(new ArgType(123), new ArgType(2.3), new ArgType("line"), new ArgType("temp")));

        getSystemCalls();

        System.out.print("исполнить системный вызов по индексу: ");
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

    public void executeSystemCall(int key) {
        if (systemCalls.containsKey(key)) {
            System.out.println("\n[class Core / method executeSystemCall] проверка существования ключа в systemCalls: такой ключ существует");

            boolean flag = true;
            for (int i = systemCalls.get(key).getArgs().size() - 1; i >= 0; i--) {

                if (!stack.pop().equals(systemCalls.get(key).getArgs().get(i).getArgument())) {
                    System.out.println("\n[class Core / method executeSystemCall] проверка равенства stack'а и аргументов в аргументов в systemCall: аргументы не равны");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print("\nвыполнение системного вызова с id: " + key + "\narguments:");
                for (int i = 0; i < systemCalls.get(key).getArgumentsSize(); i++) {
                    System.out.print(" " + systemCalls.get(key).getArgs().get(i).getArgument());
                }
            }
        } else {
            System.out.println("\n[class Core / method executeSystemCall] проверка существования ключа в systemCalls: такой ключ не существует");
        }
    }
}
