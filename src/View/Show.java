package View;

import Classes.Toy;

public class Show {
    public static void MainMenu() {
        System.out.println("""
                1. Положить призы в корзину
                2. Извлечь случайный приз из корзины
                0. Выйти
                """);
    }

    public static void PutToyMessage() {
        System.out.println("""
                Введите тип игрушки и её количество.
                В форме (порядковый номер) (количество) (название).\s
                Например:\s
                \t1 7 Robot""");
        System.out.println("Для выхода нажмите ENTER без ввода данных");
    }

    public static void HowMuchGetPrize() {
        System.out.println("Введите количество призов для взятия: ");
    }

    public static void ShowResult(Toy toy) {
        System.out.println(toy.getName());
    }

    public static void ShowUnvalidData() {
        System.out.println("Не верные данные, попробуйте снова");
    }
    public static void UsingBeforeList() {
        System.out.println("Загружен предыдущий список");
    }

    public static void ShowMessage (String msg) {
        System.out.println(msg);
    }
}
