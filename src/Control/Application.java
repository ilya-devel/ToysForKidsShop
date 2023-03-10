package Control;

import Classes.Toy;
import View.GetAns;
import View.Show;

import java.util.PriorityQueue;
import java.util.Queue;

public class Application {
    public static int RunApp() {
        PriorityQueue<Toy> lstToys = new PriorityQueue<>();
        while (true) {
            int answer = GetAns.GetMenuChoice();
            switch (answer) {
                case 1:
                    GetToys(lstToys);
                    for (Toy t : lstToys) System.out.println(t.getName());
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Завершение программы");
                    return 0;
            }
        }
    }

    public static void GetToys(PriorityQueue<Toy> lstToys) {
        Show.PutToyMessage();
        while (true) {
            Toy tmpToy = GetAns.GetToysInfo();
            if (tmpToy == null) {
                Show.ShowUnvalidData();
                continue;
            }
            if (tmpToy.getName().equals("-")) {
                System.out.println("Список сформирован");
                break;
            }
            lstToys.add(tmpToy);
        }

    }
}
