package lab;

public class Main {
	private ElStack arguments = new ElStack();
    private Kernel kernel;
	public static void main(String[] args) {
        Main main = new Main();
        main.fill();
    }

    public void fill() {
        ArgType Arg1 = new ArgType(1);
        arguments.push((int) Arg1.getArgument());
        ArgType Arg2 = new ArgType(5.6);
        arguments.push((double) Arg2.getArgument());
        ArgType Arg3 = new ArgType("f");
        arguments.push((String) Arg3.getArgument());
        kernel = new Kernel(arguments);
    }
}
