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

    public static Toy GetToysInfo() {
        System.out.print("--> ");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if (!ans.equals("")) {
            try {
                String[] answer = ans.strip().split(" ", 3);
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
            catch (Exception ex) {
                return null;
            }
        }
        else {
            return new Toy(0,"-",0);
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
