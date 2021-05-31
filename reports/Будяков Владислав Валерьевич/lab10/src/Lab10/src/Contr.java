public class Contr {
        private int id;
        private String name;
        private String adres;
        private String phone;
        public Contr(int id, String name, String adres, String phone) {
            this.id = id;
            this.name = name;
            this.adres = adres;
            this.phone = phone;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAdres() {
            return adres;
        }
        public void setAdres(String adres) {
            this.adres = adres;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
}