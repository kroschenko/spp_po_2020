import java.util.Vector;

import Service.mService;

class Laba4{
    public static void main(String[] args) {
        //task 3
        Administrator admin = new Administrator("ADMIN");

        Vector<Service> services = new Vector<>();
        Service serviceSMS = new ServiceSMS();
        Service serviceMMS = new ServiceMMS();
        Service serviceInternet = new ServiceInternet();
        services.add(serviceSMS);
        services.add(serviceMMS);
        services.add(serviceInternet);

        Abonent abonent_1 = new Abonent("KATE", "+375-29-111-99-55", services, admin);
        System.out.println(abonent_1.toString());

        admin.addAbonent(abonent_1);
        
        abonent_1.useService(serviceMMS);
        abonent_1.turnOnService(serviceMMS);
        abonent_1.useService(serviceMMS);
        abonent_1.ring();
        abonent_1.ring();
        
        Bill bill = new Bill();
        abonent_1.payBill(bill);

        abonent_1.turnOffService(serviceSMS);
        abonent_1.changeNumber("+375-33-000-11-87");
        System.out.println(abonent_1.toString());

        admin.blockAbonent(abonent_1);
        abonent_1.ring();
        abonent_1.useService(serviceInternet);
        admin.addAbonent(abonent_1);
        admin.blockAbonent(abonent_1);
        abonent_1.payBill(bill);
        admin.unblockAbonent(abonent_1);
    }
}