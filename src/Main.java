import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args){
        List<String> nameList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));
            while (scanner.hasNext()) {
                nameList.add(scanner.next());
            }
            scanner.close();
        } catch(Exception e) {
            System.out.println("Leider konnte keine Textdatei gefunden werden!");
            e.printStackTrace();
            return;
        }

        Collections.shuffle(nameList);

        System.out.println("Die IKS-Verlosung kann beginnen...");
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
        int counter = 1;
        while(readString!=null) {
            if (readString.isEmpty()) {
                System.out.println(counter + ". Gewinner ist:");
                System.out.println(nameList.get(0));
                System.out.println("Herzlichen Glückwunsch " + nameList.get(0) + "!");
                counter++;
                nameList.remove(0);
            }

            if (scanner.hasNextLine() && nameList.size() > 0) {
                readString = scanner.nextLine();
                if (readString.toLowerCase(Locale.ROOT).equals("ende")) {
                    readString = null;
                }
            } else {
                readString = null;
            }
        }
        scanner.close();
    }
}
