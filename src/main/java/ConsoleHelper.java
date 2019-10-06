import java.io.*;
import java.util.Iterator;
import java.util.List;

public class ConsoleHelper implements ConsoleHelperEnum {
    private static StringBuilder result_string;
    private static String massege;

    public static String readMassege() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            massege = bufferedReader.readLine();
        }
        catch(IOException e) {
            ConsoleHelper.writeMassege(ERROR);
            readMassege();
        }
        catch(Exception e){
            new RuntimeException();
        }
        return massege;
    }

    public static void writeMassege(String massege) {
        System.out.println(massege);
    }

    public static void writeMassege(List list) {
        result_string = new StringBuilder();
        Iterator<List> iterator = list.iterator();
        while(iterator.hasNext()) result_string.append(" " + iterator.next());
        System.out.println(result_string.toString().trim() + "\n---------------------------------------------");
    }
}
