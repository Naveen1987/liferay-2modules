package com.daffo.DataMigrationUtility_New.portlet;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Generated;

public class ListOfDocType {
private Map<String,String>docType=new HashMap<String,String>();
public ListOfDocType()
{
	/*docType.put("Manuali", "Applicativo,Spec,Titolo,Dimensione,Lingua");
	docType.put("Modulistica in uso", "COD,Titolo,Lingua");
	docType.put("Piano Formativo Annuale", "COD,Titolo,Lingua");
	docType.put("Regolamento", "COD,Titolo,Lingua");
	docType.put("DRG Indicazioni codifica", "COD,Titolo,Lingua");
	docType.put("Pubblicazioni", "COD,Titolo,Lingua");
	docType.put("Monitoraggio Analitico Obbiettivi", "COD,Titolo,Lingua");
	docType.put("Monitoraggio Sintetico Obbiettivi", "COD,Titolo,Lingua");
	docType.put("Giacenze", "COD,Titolo,Lingua");
	docType.put("Acquisti Appalti", "COD,Titolo,Lingua");
	docType.put("Direzioni Mediche", "COD,Titolo,Lingua");
	docType.put("Regole 2016", "COD,Titolo,Lingua");
	docType.put("Regole 2017", "COD,Titolo,Lingua");
	docType.put("Customer Satisfaction", "Anno,Sede,Unità Organizzativa");
	docType.put("Modulistica", "Numero,Modulo");
	docType.put("Regolamenti", "Numero,Modulo");
	docType.put("Servizio Risorse Umane", "COD,Titolo");
	docType.put("Report", "COD,Titolo,Lingua");
	docType.put("Normative", "COD,Titolo,Lingua");
	docType.put("Linee Guida", "COD,Titolo,Lingua");
	docType.put("Codifiche", "COD,Titolo,Lingua");
	docType.put("HLA e Malattie", "COD,Titolo,Lingua");
	docType.put("Accoglienza e Ospitalità", "COD,Titolo,Lingua");
	docType.put("Gestione Beni e Servizi", "COD,Titolo,Lingua");
	docType.put("Abbiategrasso", "COD,Titolo,Lingua");
	docType.put("Cuggiono", "COD,Titolo,Lingua");
	docType.put("Magenta", "COD,Titolo,Lingua");
	docType.put("Legnano", "COD,Titolo,Lingua");
	docType.put("Affari Generali e Legali", "COD,Titolo,Lingua");
	docType.put("Comitato Scientifico", "COD,Titolo,Lingua");
	
	docType.put("Procedurre-Doc. Az.", "COD,Titolo,REV,Lingua");
	docType.put("Documenti di dipartimento", "COD,Titolo,REV,Lingua,Dipartimento");
	docType.put("Sicurezza - Rischio", "COD,Titolo,REV,Lingua");
	docType.put("Note Informative", "COD,Titolo,REV,Lingua");
	
	docType.put("Farmacia", "COD,Titolo,REV,Lingua");
	
	docType.put("SIECIO_CIO", "COD,Titolo,REV,Lingua");
	docType.put("SPP_MC", "COD,Titolo,REV,Lingua");
	docType.put("Direzioni Mediche", "COD,Titolo,REV,Lingua");
	docType.put("SITRA", "COD,Titolo,REV,Lingua");
	docType.put("HRM", "COD,Titolo,REV,Lingua");
	docType.put("Comitati_Gruppi di Miglioramento", "COD,Titolo,REV,Lingua");
	docType.put("Rapporti e Dati", "COD,Titolo,REV,Lingua");
	docType.put("Accrediatmento e Controlli", "COD,Titolo,REV,Lingua");
	docType.put("Cartella Clinica", "COD,Titolo,REV,Lingua");*/
	
	docType.put("Manuali", "Applicativo,Spec,Titolo,Dimensione,Lingua");
	docType.put("Modulistica in uso", "COD,Titolo,Lingua");
	docType.put("Piano Formativo Annuale", "COD,Titolo,Lingua");
	docType.put("Regolamento", "COD,Titolo,Lingua");
	docType.put("DRG Indicazioni codifica", "COD,Titolo,Lingua");
	docType.put("Pubblicazioni", "COD,Titolo,Lingua");
	docType.put("Monitoraggio Analitico Obbiettivi", "COD,Titolo,Lingua");
	docType.put("Monitoraggio Sintetico Obbiettivi", "COD,Titolo,Lingua");
	docType.put("Giacenze", "COD,Titolo,Lingua");
	docType.put("Acquisti Appalti", "COD,Titolo,Lingua");
	docType.put("Direzioni Mediche", "COD,Titolo,Lingua");
	docType.put("Regole 2016", "COD,Titolo,Lingua");
	docType.put("Regole 2017", "COD,Titolo,Lingua");
	docType.put("Customer Satisfaction", "Anno,Sede,Unità Organizzativa");
	docType.put("Modulistica", "Numero,Modulo");
	docType.put("Regolamenti", "Numero,Modulo");
	docType.put("Servizio Risorse Umane", "COD,Titolo");
	docType.put("Report", "COD,Titolo,Lingua");
	docType.put("Normative", "COD,Titolo,Lingua");
	docType.put("Linee Guida", "COD,Titolo,Lingua");
	docType.put("Codifiche", "COD,Titolo,Lingua");
	docType.put("HLA e Malattie", "COD,Titolo,Lingua");
	docType.put("Accoglienza e Ospitalità", "COD,Titolo,Lingua");
	docType.put("Gestione Beni e Servizi", "COD,Titolo,Lingua");
	docType.put("Abbiategrasso", "COD,Titolo,Lingua");
	docType.put("Cuggiono", "COD,Titolo,Lingua");
	docType.put("Magenta", "COD,Titolo,Lingua");
	docType.put("Legnano", "COD,Titolo,Lingua");
	docType.put("Affari Generali e Legali", "COD,Titolo,Lingua");
	docType.put("Comitato Scientifico", "COD,Titolo,Lingua");
	
	docType.put("Procedurre-Doc. Az.", "COD,Titolo,REV,Lingua");
	docType.put("Documenti di dipartimento", "COD,Titolo,REV,Lingua,Dipartimento");
	docType.put("Sicurezza - Rischio", "COD,Titolo,REV,Lingua");
	docType.put("Note Informative", "COD,Titolo,REV,Lingua");
	
	docType.put("Farmacia", "COD,Titolo,REV,Lingua");
	
	docType.put("SIECIO_CIO", "COD,Titolo,REV,Lingua");
	docType.put("SPP_MC", "COD,Titolo,REV,Lingua");
	docType.put("Direzioni Mediche", "COD,Titolo,REV,Lingua");
	docType.put("SITRA", "COD,Titolo,REV,Lingua");
	docType.put("HRM", "COD,Titolo,REV,Lingua");
	docType.put("Comitati_Gruppi di Miglioramento", "COD,Titolo,REV,Lingua");
	docType.put("Rapporti e Dati", "COD,Titolo,REV,Lingua");
	docType.put("Accrediatmento e Controlli", "COD,Titolo,REV,Lingua");
	docType.put("Cartella Clinica", "COD,Titolo,REV,Lingua");
	
	
}
public String getDocType(String doc){
	return docType.get(doc);
}
public static void main(String ag[]){
	System.out.println(new ListOfDocType().getDocType("Customer Satisfaction").split(Pattern.quote(","))[2]);
}
}
