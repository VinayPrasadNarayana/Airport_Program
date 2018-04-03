/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

/**
 *
 * @author vinay
 */
public class Passenger {
    String FirstName;
    String SurName;
    int secondsInQueue;
    
    public void setFirstName(String Firstname){
        FirstName = Firstname;
    }
    
    public void setSurName(String Surname){
        SurName = Surname;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public String getSurName(){
        return SurName;
    }
    
    public void setSecondsInQueue(int secondsInQueue){
        this.secondsInQueue = secondsInQueue;
    }
    
    public int getSecondsInQueue(){
        return this.secondsInQueue;
    }
    
}
