import java.util.ArrayList;

class Task_2{
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Cat("Matroskin", "fine"));
        pets.add(new Dog("Sharik", "good"));
        pets.add(new Parrot("Kesha", "excelent"));

        for(Pet pet : pets){
            pet.callPet();
            System.out.println();
        }
    }
}