import java.util.Scanner;
public class Menu {
    public void start() throws java.io.IOException, java.sql.SQLException {
        DatabaseController controller=new DatabaseController();
        boolean key=true;
        while(key) {
            System.out.println("1 - вывести все продукты и товары");
            System.out.println("2 - вывести всех заказчиков с сортировкой по фамилии");
            System.out.println("3 - вывести все заказанные продукты и товары");
            System.out.println("4 - добавить нового заказчика");
            System.out.println("5 - изменить название продукта или товара");
            System.out.println("6 - удалить заказчика");
            System.out.println("7 - выйти");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            switch(num)
            {
                case 1: controller.showProducts(); System.in.read(); break;
                case 2: controller.showClients(); System.in.read(); break;
                case 3: controller.showProductsClients(); System.in.read(); break;
                case 4: controller.addNewClient(); System.in.read(); break;
                case 5: controller.updateNameProduct(); System.in.read(); break;
                case 6: controller.deleteClient(); System.in.read(); break;
                case 7: key=false;
            }
        }
    }
}