package sample.model;

public class Equipment {

    int id;
    String registrationNumber, typeEquipment, manufacturer, employee, warranty;

    public Equipment(int id, String registrationNumber, String typeEquipment, String manufacturer, String employee, String warranty) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.typeEquipment = typeEquipment;
        this.manufacturer = manufacturer;
        this.employee = employee;
        this.warranty = warranty;
    }

    public Equipment(int id, String registrationNumber, String typeEquipment, String manufacturer, String employee) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.typeEquipment = typeEquipment;
        this.manufacturer = manufacturer;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", typeEquipment='" + typeEquipment + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", employee=" + employee +
                '}';
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTypeEquipment() {
        return typeEquipment;
    }

    public void setTypeEquipment(String typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
