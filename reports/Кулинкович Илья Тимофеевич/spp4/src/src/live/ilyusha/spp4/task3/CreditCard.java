package live.ilyusha.spp4.task3;

class CreditCard {

    private String issuer;
    private boolean blocked;
    private int cvv;
    private String number;
    private int expiryDateMonth;
    private int expiryDateYear;

    public CreditCard(String issuer, boolean isBlocked, int cvv, String number, int expiryDateMonth, int expiryDateYear) {
        this.issuer = issuer;
        this.blocked = isBlocked;
        this.cvv = cvv;
        this.number = number;
        this.expiryDateMonth = expiryDateMonth;
        this.expiryDateYear = expiryDateYear;
    }

    /* codegen */

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getExpiryDateMonth() {
        return expiryDateMonth;
    }

    public void setExpiryDateMonth(int expiryDateMonth) {
        this.expiryDateMonth = expiryDateMonth;
    }

    public int getExpiryDateYear() {
        return expiryDateYear;
    }

    public void setExpiryDateYear(int expiryDateYear) {
        this.expiryDateYear = expiryDateYear;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
