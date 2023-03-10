package View;

import java.util.Scanner;

public class GetAns {
    public static int GetMenuChoice () {
        int answer;
        Show.MainMenu();
        Scanner in = new Scanner(System.in);
        answer = in.nextInt();
        return answer;
    }
}
