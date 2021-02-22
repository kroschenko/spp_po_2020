
class Main{
    public static void main(String[] args) {
        //task 1
        Set set = new Set(new Double[]{4.0, 7.0, 8.0});
        set.printSet();
        set = set.mergeSets(new Set(new Double[] {3.0, 4.0, 5.0}));
        set.addElement(5.0);
        set.addElement(1.0);
        set.deleteElement(5.0);
        set.printSet();
        System.out.println(set.equals(new Set(new Double[] {1.0, 3.0, 4.0, 7.0, 8.0})));
        System.out.println(set.equals(new Set(new Double[] {9.0, 4.0, 7.0, 8.0})));
        System.out.println(set.toString());
        
        
        //task 2
        Flat fl1 = new Flat(1, 2, 30.0, 890.09, "street Abracadabra", true);
        db flats = new db();
        flats.addFlat(new Flat(1, 2, 40.0, 600.78, "street 1", false));
        flats.addFlat(new Flat(2, 3, 95.0, 892.19, "street 2", true));
        flats.addFlat(new Flat(3, 1, 30.0, 737.82, "street 3", false));
        flats.addFlat(new Flat(1, 2, 80.0, 123.99, "street 4", true));
        flats.addFlat(new Flat(2, 3, 35.0, 341.32, "street 5", false));
        flats.addFlat(new Flat(3, 1, 20.0, 245.87, "street 6", true));
        flats.addFlat(new Flat(1, 2, 30.0, 540.45, "street 7", false));
        flats.addFlat(new Flat(2, 3, 40.0, 435.91, "street 8", true));
        flats.addFlat(new Flat(3, 2, 35.0, 908.23, "street 9", false));

        flats.print();

        flats.addFlat(fl1);
        flats.print();

        flats.deleteFlat(fl1);
        flats.print();

        System.out.println("List of suitable flats: ");
        flats.printListOfFlats(flats.findSuitableOption(2, 3, 90.0));

        System.out.println("List of flats with superior area:");
        flats.printListOfFlats(flats.getListOfFlatsWithMoreArea(40.0));

        System.out.print("List of flats with num rooms: ");
        flats.printListOfFlats(flats.getListOfFlatsWithNumRooms(2));

        System.out.print("List of flats with num rooms: ");
        flats.printListOfFlats(flats.getListOfFlatsWithNumRoomsAndFloor(2, 3));
        
        System.out.println("List of rented flats: ");
        flats.printListOfFlats(flats.getListOfRentedFlats());

        System.out.println("Moving flat from state empty to state rented.");
        flats.moveFromFreeListToRentedList(fl1);
    
        System.out.println("List of rented flats: ");
        flats.printListOfFlats(flats.getListOfRentedFlats());

        System.out.println("List of free flats: ");
        flats.printListOfFlats(flats.getListOfFreeFlats());

        System.out.println("Moving flat from state rented to state empty.");
        flats.moveFromFreeListToRentedList(fl1);

        System.out.println("List of free flats: ");
        flats.printListOfFlats(flats.getListOfFreeFlats());

        flats.deleteFlat(fl1);
        flats.print();
    }
}
