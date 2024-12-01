package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoredProducts {
	
	private Map<String, ProductDetails> map = new HashMap<>();
	
	ProductDetails livelixir = new ProductDetails("LIVELIXIR SYRUP","200ML","asde358","01/01/2026","3004","140","0%","0%");
	ProductDetails appehill = new ProductDetails("APPEHILL SYRUP","200ML","8bhfh8","01/05/2026","3004","125","0%","0%");
	ProductDetails corezyme = new ProductDetails("COREZYME SYRUP","200ML","7858sdf","21/11/2025","3004","125","0%","0%");
	ProductDetails corezymeplus = new ProductDetails("COREZYME-PLUS","100ML","tysg58","01/05/2026","3004","65","0%","0%");
	ProductDetails ironfitplus = new ProductDetails("IRONFIT-PLUS","200ML","tyDFGH58","01/05/2026","3004","135","0%","0%");
	ProductDetails zemvital1500inj = new ProductDetails("ZEMVITAL-1500-INJ","2ML","tysg58","01/11/2025","3004","45","0%","0%");
	ProductDetails zemvital2500inj = new ProductDetails("ZEMVITAL-2500-INJ","1ML","tysP8","01/12/2025","3004","65","0%","0%");
	ProductDetails rebehilcaps = new ProductDetails("REBEHILL-LS-CAP","10'S","tysYT","01/12/2025","3004","165","0%","0%");
	ProductDetails rebehilldsr = new ProductDetails("REBEHILL-DSR-CAP","10'S","UYT","01/11/2025","3004","95","0%","0%");
	ProductDetails pentohilldsr = new ProductDetails("PENTOHILL-DSR-CAP","10'S","IUYT58","01/05/2026","3004","110","0%","0%");
	ProductDetails amoxichem = new ProductDetails("AMOXICHEM TAB","10'S","RSXD5","01/05/2026","3004","204","0%","0%");
	ProductDetails cefihillotab = new ProductDetails("CEFIHILLO-TAB","10'S","YTFE5","01/05/2026","3004","165","0%","0%");
	ProductDetails utrohillsyrup = new ProductDetails("UTROHILL-SYRUP","200ML","UYTRF","01/05/2026","3004","135","0%","0%");
	ProductDetails tellmehill = new ProductDetails("TELLMIHILL TAB","10'S","IOJGY","01/05/2026","3004","90","0%","0%");
	ProductDetails ceftrihillt = new ProductDetails("CEFTRIHILL-T","VIAL","IUFT","01/05/2026","3004","180","0%","0%");
	ProductDetails ceftrihillsb = new ProductDetails("CEFTRIHILL-SB","VIAL","YGHBT6","01/11/2025","3004","150","0%","0%");
	ProductDetails alkarise = new ProductDetails("ALKARISE-SYRUP","100ML","UHDFT","01/06/2026","3004","85","0%","0%");
	ProductDetails cofilldx = new ProductDetails("COFILL-DX SYRUP","100ML","RTFY7","01/05/2025","3004","85","0%","0%");
	ProductDetails diacloactiveaq= new ProductDetails("DIACLOACTIVE-AQ","1ML","PIT8","01/05/2025","3004","21","0%","0%");
	ProductDetails pyrefixmr = new ProductDetails("PYREFIX-MR TAB","10'S","IKOL58","01/06/2026","3004","85","0%","0%");
	ProductDetails etorihillmr4 = new ProductDetails("ETORIHILL-MR4 TAB","10'S","t5NHK8","01/11/2025","3004","165","0%","0%");
	ProductDetails coldhillds = new ProductDetails("COLDHILL-DS SYRUP","60ML","85698","01/11/2025","3004","60","0%","0%");
	ProductDetails protienkidspow= new ProductDetails("PROTIENKIDS-POW","300GM","OPIY8","01/02/2026","3004","439","0%","0%");
	ProductDetails calziboned3 = new ProductDetails("CALZIBONE-D3-CAP","4'S","KIOL856","01/05/2026","3004","120","0%","0%");
	ProductDetails cofihillls = new ProductDetails("COFIHILL-LS-SYRUP","100ML","ASDF58","01/05/2026","3004","95","0%","0%");
	
	
	
	
	public StoredProducts() {
	  map.put("livelixir", livelixir );
	  map.put("appehill", appehill);
	  map.put("corezyme", corezyme);
	  map.put("corezymeplus", corezymeplus);
	  map.put("ironfitplus", ironfitplus );
	  map.put("zemvital1500inj",  zemvital1500inj);
	  map.put("zemvital2500inj", zemvital2500inj);
	  map.put("rebehilcaps", rebehilcaps );
	  map.put("rebehilldsr", rebehilldsr);
	  map.put("pentohilldsr", pentohilldsr);
	  map.put("amoxichem", amoxichem);
	  map.put("cefihillotab", cefihillotab);
	  map.put("utrohillsyrup", utrohillsyrup);
	  map.put("tellmehill", tellmehill);
	  map.put("ceftrihillt", ceftrihillt);
	  map.put("ceftrihillsb", ceftrihillsb );
	  map.put("alkarise", alkarise);
	  map.put("cofilldx", cofilldx);
	  map.put("diacloactiveaq", diacloactiveaq);
	  map.put("pyrefixmr", pyrefixmr);
	  map.put("etorihillmr4", etorihillmr4);
	  map.put("coldhillds", coldhillds);
	  map.put("protienkidspow", protienkidspow);
	  map.put("calziboned3", calziboned3);
	  map.put("cofihillls", cofihillls);
	  
	 
	
	  
	  
	}
	
	 public ProductDetails getProductDetails(String productName) {
	        return map.get(productName);
	    }
	
}
