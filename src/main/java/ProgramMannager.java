import java.io.*;
import java.util.*;

public class ProgramMannager implements Comparator {
    private String choise, file_destination, origin, next_number;
    private ArrayList<String> result, originalList;

    public ProgramMannager() {
        ConsoleHelper.writeMassege(ConsoleHelperEnum.GREETING);
    }

    public void startProgram() {
        ConsoleHelper.writeMassege(ConsoleHelperEnum.CHOOSE_FILE_DESTINATION);
        file_destination = path_validation();
        if (file_destination != null) iterator_method(file_destination);
        else ConsoleHelper.writeMassege(ConsoleHelperEnum.FILE_DESTINATION_NOT_FOUND);
        make_choice();
    }

    private String path_validation() {
        String path = ConsoleHelper.readMassege();
        if (new File(path).isFile()) return path;
        else return null;
    }

    private void make_choice() {
        ConsoleHelper.writeMassege(ConsoleHelperEnum.MAKE_CHOISE);
        choise = ConsoleHelper.readMassege();
        switch (choise) {
            case ("1"):
                startProgram();
                break;
            case ("0"):
                ConsoleHelper.writeMassege(ConsoleHelperEnum.BYE_BYE);
                System.exit(1);
            default:
                ConsoleHelper.writeMassege(ConsoleHelperEnum.ERROR);
                make_choice();
        }
    }

    private void iterator_method(String file_destination) {
        result = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file_destination), "UTF-8"))) {
            while(reader.ready()) {
                origin = reader.readLine();
                resultList_maker(origin);
            }

            if (result.size() == 0) {
                ConsoleHelper.writeMassege(ConsoleHelperEnum.NUMBER_NOT_FOUND);
                return;
            }
            else ConsoleHelper.writeMassege(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ConsoleHelper.writeMassege(ConsoleHelperEnum.FILE_DESTINATION_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            ConsoleHelper.writeMassege(ConsoleHelperEnum.ERROR);
        }
    }

    private void resultList_maker(String newString){
        originalList = new ArrayList<String>(Arrays.asList(newString.replaceAll("[^0-9]+", " ").trim().split("\\s+")));
        if (originalList.size() == 0  || originalList.get(0).isEmpty()) return;
        Iterator stringIterator = originalList.iterator();
        while(stringIterator.hasNext()) {
            next_number = (String) stringIterator.next();
            if (result.isEmpty()) result.add(next_number);
            else {
                for (int i = 0; i < result.size(); i++) {
                    if (compare(next_number, result.get(i)) > 0) {
                        result.add(i, next_number);
                        break;
                    }
                    else if (i == result.size() - 1) {
                        result.add(next_number);
                        break;
                    }
                }
            }
        }
    }

    //если число o1 больше o2 вернуть 1
    @Override
    public int compare(Object o1, Object o2) {
        int j1 = Integer.parseInt((String)o1);
        int j2 = Integer.parseInt((String)o2);
        if (j1 > j2) return 1;
        else if (j1 == j2) return 0;
        else return -1;
    }
}