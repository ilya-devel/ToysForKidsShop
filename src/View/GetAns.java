package View;

import Classes.Toy;

import javax.swing.text.View;
import java.util.Scanner;

public class GetAns {
    public static int GetMenuChoice() {
        int answer = -1;
        Show.MainMenu();
        while (answer < 0) {
            System.out.print("--> ");
            Scanner in = new Scanner(System.in);
            try {
                answer = in.nextInt();
                if (answer < 0 || answer > 3) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                Show.ShowUnvalidData();
                answer = -1;
            }
        }
        return answer;
    }

    public static Toy GetToys() {
        Show.PutToyMessage();
        Scanner in = new Scanner(System.in);
        String[] answer = in.nextLine().strip().split(" ", 3);
        int id = GetIntValues(answer[0]);
        int weight = GetIntValues(answer[1]);
        String name = answer[2];
        if (id != -1 && weight != -1) {
            return new Toy(id, name, weight);
        }
        else {
            return null;
        }
    }
    public static int GetIntValues(String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (Exception ex) {
//            Show.ShowUnvalidData();
            return -1;
        }
    }
}
