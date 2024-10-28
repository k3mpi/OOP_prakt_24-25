package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.Alert.AlertType;
import ownUtil.MeldungsfensterAnzeiger;

public class BuergeramtModel {
	
	
	  // speichert temporaer ein Objekt vom Typ Buergeramt
    private Buergeramt buergeramt;
    
    
    public void schreibeBuergeraemterInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv", true));
			aus.write(buergeramt.gibBuergeramtZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Bürgerämter wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    public Buergeramt getBuergeramt() {
		return buergeramt;
	}

	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
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
