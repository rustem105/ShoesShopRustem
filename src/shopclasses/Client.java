/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopclasses;

/**
 *
 * @author ruste
 */
public class Client {
    private String Name;
    private String Surname;
    private String Mobile;
    private Double Money;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public Double getMoney() {
        return Money;
    }

    public void setMoney(Double Money) {
        this.Money = Money;
    }
    
     @Override
    public String toString() {
        return "Client{" 
                + "Name=" + Name 
                + ", Surname=" + Surname 
                + ", Mobile=" + Mobile 
                + ", Money=" + Money 
                + '}'; 
    }
    
}
