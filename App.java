package com.epam.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.util.logging.Level; 
//import java.util.logging.Logger;

interface House {

public void build();
}
class Normal_House implements House {

public void build() {
System.out.print("House:\n");
}

}

class House_Model implements House {

protected House House;

public House_Model(House h){
this.House=h;
}


public void build() {
this.House.build();
}

}
 class Villa extends House_Model {

public Villa(House h) {
super(h);
}


public void build(){
super.build();
System.out.print("Viewing new Villa.\n");
}
}
 class Apartment extends House_Model {

public Apartment(House h) {
super(h);
}


public void build(){
super.build();
System.out.print("Viewing the Apartment.\n");
}
}


public class App
{
	private static final Logger LOGGER = LogManager.getLogger(App.class);
   
    public static void main( String[] args )
    {
       LOGGER.log(null, null, Level.INFO,"use of memento,behaviour patterns and decorate,structural patterns.\n");
       House villa = new Villa(new Normal_House());
       House apartment =new Apartment(new Normal_House());
villa.build();
                apartment.build();
System.out.println("\n*****");

House villa_Apartment = new Villa(new Apartment(new Normal_House()));
villa_Apartment.build();
       LOGGER.log(null, null, Level.INFO,"program terminated.\n");
       
    }
}
