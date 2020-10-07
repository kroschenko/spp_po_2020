import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

class db{
    private List<Flat> mListOfFlats;

    public db(){
        mListOfFlats = new ArrayList<>();
    }

    public boolean addFlat(Flat fl){
        return mListOfFlats.add(fl);
    }

    public boolean deleteFlat(Flat fl){
        return mListOfFlats.remove(fl);
    }
    
    public List<Flat> getListOfFlatsWithMoreArea(Double area){
        List<Flat> listOfFlatsWithMoreArea = new ArrayList<>();
        for(Flat flat : mListOfFlats){
            if(flat.getArea() > area){
                listOfFlatsWithMoreArea.add(flat);
            }
        }
        return listOfFlatsWithMoreArea;
    }
    
    public List<Flat> getListOfFlatsWithNumRooms(int numRooms){
        System.out.println(numRooms);

        List<Flat> listOfFlatsWithMoreArea = new ArrayList<>();
        for(Flat flat : mListOfFlats){
            if(flat.getNumRooms() == numRooms){
                listOfFlatsWithMoreArea.add(flat);
            }
        }
        return listOfFlatsWithMoreArea;
    }
    
    public List<Flat> getListOfFlatsWithNumRoomsAndFloor(int numRooms, int floor){
        System.out.print(numRooms);
        System.out.print(" and floor: ");
        System.out.println(floor);

        List<Flat> listOfFlatsWithMoreArea = new ArrayList<>();
        for(Flat flat : mListOfFlats){
            if(flat.getNumRooms() == numRooms
            && flat.getFloor() == floor){
                listOfFlatsWithMoreArea.add(flat);
            }
        }
        return listOfFlatsWithMoreArea;
    }
    
    public void print(){
        System.out.println("List of all flats: ");

        for(Flat flat : mListOfFlats){
            flat.printFlat();
        }
    }
    
    public void moveFromRentedListToFreeList(Flat fl){
        for(Flat flat : mListOfFlats){
            if(flat.equals(fl)){
                flat.setIsRented(false);
            }
        }
    }
    
    public void moveFromFreeListToRentedList(Flat fl){
        for(Flat flat : mListOfFlats){
            if(flat.equals(fl)){
                flat.setIsRented(true);
            }
        }
    }
    
    public List<Flat> findSuitableOption(int floor, int numRooms, Double area){
        List<Flat> listOfSuitableFlats = new ArrayList<>();

        for(Flat flat : this.getListOfFreeFlats()){
            if(flat.getNumRooms() == numRooms &&
            flat.getFloor() == floor){
                if(flat.getArea() - area >= 0 && flat.getArea() - area <= 10 
                || area - flat.getArea() >= 0 && area - flat.getArea() <= 10) {
                    listOfSuitableFlats.add(flat);
                    break;
                }
            }
        }

        return listOfSuitableFlats;
    }
    
    public List<Flat> getListOfFreeFlats(){
        List<Flat> listOfFreeFlats = new ArrayList<>();
        for(Flat flat : mListOfFlats){
            if(flat.getIsForRent()){
                listOfFreeFlats.add(flat);
            }
        }
        return listOfFreeFlats;
    } 
    
    public List<Flat> getListOfRentedFlats(){
        List<Flat> listOfRentedFlats = new ArrayList<>();
        for(Flat flat : mListOfFlats){
            if(!flat.getIsForRent()){
                listOfRentedFlats.add(flat);
            }
        }
        return listOfRentedFlats;
    } 
    
    public void printListOfFlats(List<Flat> listOflats){
        for(Flat flat : listOflats){
            flat.printFlat();    
        }
    }
}