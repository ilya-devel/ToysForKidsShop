package Control;

import Classes.Toy;
import View.GetAns;
import View.Show;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Application {
    static String fileName = "ListPrize_" + GetCurrentDateTime() + ".txt";
    public static void RunApp() {
        PriorityQueue<Toy> lstToys = new PriorityQueue<>();
        int answer;
        do {
            answer = GetAns.GetMenuChoice();
            switch (answer) {
                case 1 -> GetToys(lstToys);
                case 2 -> {
                    Toy getToy = GetRandomToy(lstToys);
                    if (getToy != null) {
                        Show.ShowMessage("Вы взяли " + getToy.getName() + "\n");
                        WriteLogToGetPrize(fileName, "Вы взяли " + getToy.getName() + "\n");
                    }
                    else {
                        Show.ShowMessage("Призы закончились\n");
                        WriteLogToGetPrize(fileName, "Призы закончились\n");
                    }
                }
                case 0 -> Show.ShowMessage("Завершение программы\n");
            }
        } while (answer != 0);
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
                System.out.println("Список сформирован\n");
                break;
            }
            lstToys.add(tmpToy);
            WriteLogToGetPrize(fileName, tmpToy.howMuch());
        }
    }

    public static Toy GetRandomToy(PriorityQueue<Toy> lstToys) {
        LinkedList<Toy> bagToys = BagToysGenerate(lstToys);
        if (bagToys.size() == 0) {
            return null;
        }
        Random rn = new Random();
        int ind = rn.nextInt(0, bagToys.size());
        Toy tmpToy = bagToys.get(ind);
        for (Toy toy : lstToys) {
            if (toy.getId() == tmpToy.getId() && toy.getName().equals(tmpToy.getName()) && toy.getWeight() > 0) {
                toy.getToy();
            }
        }
        return tmpToy;
    }

    public static LinkedList<Toy> BagToysGenerate(PriorityQueue<Toy> lstToys) {
        LinkedList<Toy> bag = new LinkedList<>();
        for (Toy toy : lstToys) {
            for (int i = 0; i < toy.getWeight(); i++) {
                bag.add(new Toy(toy.getId(), toy.getName(), 1));
            }
        }
        return bag;
    }

    public static void WriteLogToGetPrize(String fileName, String row) {
        File file = new File(fileName);
        try (FileOutputStream out = new FileOutputStream(file, true)) {
            byte[] forWrite = row.getBytes();
            out.write(forWrite);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String GetCurrentDateTime () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
