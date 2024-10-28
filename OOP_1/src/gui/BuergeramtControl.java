package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;
import business.BuergeramtModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class BuergeramtControl {

	
	private BuergeramtView view = null;
	private BuergeramtModel model = null;
	
	
	
	public BuergeramtControl(Stage s) {
		System.out.println("ctrl init");
		this.model = new BuergeramtModel();
		this.view = new BuergeramtView(s, this, model);
		
	}
	
	void nehmeBuergeramtAuf(){
    	try{
    		this.model.setBuergeramt(new Buergeramt(
    		this.view.getName(),
   	        this.view.getVon(),
   	        this.view.getBis(),
   	        this.view.getStra�e(),
    		this.view.getDienstleistungen()));
    		zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    void zeigeBuergeraemterAn(){
    	if(this.model.getBuergeramt() != null){
    		this.view.setAnzeige(this.model.getBuergeramt().gibBuergeramtZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
    	}
    }    
		  
    void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.model.setBuergeramt(new Buergeramt(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				Float.parseFloat(zeile[2]), 
      				zeile[3], zeile[4].split("_")));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Die Bürgerämter wurden gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	void schreibeBuergeraemterInCsvDatei() {
		try {
			this.model.schreibeBuergeraemterInCsvDatei();
		}	
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

	
	
	
	
}
