package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoredProducts {
	
	private Map<String, ProductDetails> map = new HashMap<>();
	
	ProductDetails livelixir = new ProductDetails("LIVELIXIR","asde358","01/01/2026","3004","140","0%","0%");
	ProductDetails appehill = new ProductDetails("APPEHILL","8bhfh8","01/05/2026","3004","125","0%","0%");
	ProductDetails corezyme = new ProductDetails("corezyme","7858sdf","21/11/2025","3004","125","0%","0%");
	ProductDetails corezymeplus = new ProductDetails("COREZYME-PLUS","tysg58","01/05/2025","3004","65","0%","0%");
	ProductDetails ironfitplus = new ProductDetails("IRONFIT-PLUS","tyDFGH58","01/05/2025","3004","135","0%","0%");
	ProductDetails zemvital1500inj = new ProductDetails("ZEMVITAL-1500-INJ","tysg58","01/05/2025","3004","45","0%","0%");
	ProductDetails zemvital2500inj = new ProductDetails("ZEMVITAL-2500-INJ","tysg58","01/05/2025","3004","65","0%","0%");
	ProductDetails rebehilcaps = new ProductDetails("REBEHILL-LS","tysg58","01/05/2025","3004","165","0%","0%");
	ProductDetails rebehilldsr = new ProductDetails("REBEHILL-DSR","tysg58","01/05/2025","3004","95","0%","0%");
	ProductDetails pentohilldsr = new ProductDetails("PENTOHILL-DSR","tysg58","01/05/2025","3004","110","0%","0%");
	ProductDetails amoxichem = new ProductDetails("AMOXICHEM","tysg58","01/05/2025","3004","204","0%","0%");
	ProductDetails cefihillotab = new ProductDetails("CEFIHILLO-TAB","tysg58","01/05/2025","3004","165","0%","0%");
	ProductDetails utrohillsyrup = new ProductDetails("UTROHILL-SYRUP","tysg58","01/05/2025","3004","135","0%","0%");
	ProductDetails tellmehill = new ProductDetails("TELLMIHILL","tysg58","01/05/2025","3004","90","0%","0%");
	ProductDetails ceftrihillt = new ProductDetails("CEFTRIHILL-T","tysg58","01/05/2025","3004","180","0%","0%");
	ProductDetails ceftrihillsb = new ProductDetails("CEFTRIHILL-SB","tysg58","01/05/2025","3004","150","0%","0%");
	ProductDetails alkarise = new ProductDetails("ALKARISE","tysg58","01/05/2025","3004","85","0%","0%");
	ProductDetails cofilldx = new ProductDetails("COFILL-DX","tysg58","01/05/2025","3004","85","0%","0%");
	ProductDetails diacloactiveaq= new ProductDetails("DIACLOACTIVE-AQ","tysg58","01/05/2025","3004","21","0%","0%");
	ProductDetails pyrefixmr = new ProductDetails("PYREFIX-MR","tysg58","01/05/2025","3004","85","0%","0%");
	ProductDetails etorihillmr4 = new ProductDetails("ETORIHILL-MR4","tysg58","01/05/2025","3004","165","0%","0%");
	ProductDetails coldhillds = new ProductDetails("COLDHILL-DS","tysg58","01/05/2025","3004","60","0%","0%");
	
	
	
	
	
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
	  map.put("pentohilldsr ", pentohilldsr);
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
	 
	
	  
	  
	}
	
	 public ProductDetails getProductDetails(String productName) {
	        return map.get(productName);
	    }
	
}
