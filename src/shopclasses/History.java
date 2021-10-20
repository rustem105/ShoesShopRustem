/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopclasses;

import java.util.Date;

/**
 *
 * @author ruste
 */
public class History {
    private Client client;
    private Model model;
    private Date givendate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Date getGivendate() {
        return givendate;
    }

    public void setGivendate(Date givendate) {
        this.givendate = givendate;
    }
    
    @Override
    public String toString() {
        return "History{" 
                + "client=" + client 
                + ", model=" + model 
                + ", givendate=" + givendate 
                + '}'; 
    }
    
}
