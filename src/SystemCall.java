import java.util.Arrays;
import java.util.List;

public class SystemCall {
	private String Name;
    private List<String> Arguments;

    public SystemCall(String name, String... args) {
        Name = name;
        Arguments = Arrays.asList(args);
    }

    public String getName(){
        return Name;
    }

    public List getArgs(){
        return Arguments;
    }

    public String Execute(int id){
        String string = "Call: " +  id + " - " + Name + " - ";
        for (String i:Arguments) {
            string += i + " ";
        }
        return string + "\n";
    }

    public String List()
    {
        String string = Name + " : ";
        for (String i: Arguments) {
            string += i + " ";
        }
        return string + "\n";
    }
}
