package lab;

public class Main {
	private ElStack stackOfArg = new ElStack();
    private Kernel kernel;
	public static void main(String[] args) {
        Main main = new Main();
        main.fillingStack();
    }

    public void fillingStack () {

        ArgType firstArgument = new ArgType(123);
        stackOfArg.push((int) firstArgument.getArgument());

        ArgType secondArgument = new ArgType(2.3);
        stackOfArg.push((double) secondArgument.getArgument());

        ArgType thirdArgument = new ArgType("str");
        stackOfArg.push((String) thirdArgument.getArgument());

        kernel = new Kernel(stackOfArg);
    }
}
