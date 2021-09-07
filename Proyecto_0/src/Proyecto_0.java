import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Proyecto_0 {
	
  public static class fun{
		  
		  int contador;
		  String nombre;
		  
		  public fun(String pnombre){
			  nombre= pnombre;
			 contador=0; 
		  }
		  
		  public void sumar(){
			  contador++;
		  }
		  public String setName(){
			  return nombre;
		  }
	  
	  }

	
	static ArrayList<String >po = new ArrayList<>();
	static ArrayList<String >lo = new ArrayList<>();
	static ArrayList<String >complex = new ArrayList<>();
	private static String[] li; 
	static boolean valido;
	static boolean validadaLinea;
	static ArrayList<String >variableslocales = new ArrayList<>();
	static ArrayList<String >variablesglobales = new ArrayList<>();
	static  ArrayList<fun >variablesfunciones = new ArrayList<>();
	
	public static void verificar( String linea, BufferedReader br ) throws IOException
	{
		
		 li = linea.split(" ");	
   
     for(int i=0;!validadaLinea && i<li.length;i++ ){

    	 if(po.contains(li[i])){
    		
    		 verificarFacil(li);
    		 i++;
    		 
    	 }else if(li[i].equals("LOOK")){
    		 verificarFacil2(li);
    		 i++;
    	 }else if(li[i].equals("CHECK")){
    		 verificarFacil3(li);
    		 i++;
    	 }
    	 else if(li[i].equals("NOP")){
    		 verificarFacil4(li);
    		 i++;
    	 }
    	 else if(li[i].length()>1){
    		 for (int j = 0; j < variablesfunciones.size(); j++) {
				if(variablesfunciones.get(j).setName().equals(li[i])){
					verificarFacil5(li);
				}
			}
    		 
    	 }
    	 else 
    	 {
    		
    		 verificarComplejos(li,br);
    	 }
     	}
	}
	
	public static void verificarTodo()
	{
		 File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      
	      
	      
	      try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File ("./archivo.txt");
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);

		         // Lectura del fichero
		         String linea;
		        
		         for (linea = br.readLine(); linea != null && valido; linea = br.readLine()) {
		        	
		        	
		        	validadaLinea=false;
		        	
					verificar(linea,br);
					
		        	 
		        	 
		        	
		        
		         
		      }
	      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
	      
	      
	}
	

	
	  
	  
	  public static void verificarFacil(String[]in) 
	  {
		 
		  try{
  		 	if( Integer.parseInt(in[1])>=0  ){
  		 		
  		 		
  		 	}else{
  		 		boolean encontro= false;
  		 		for(int i=0; i<variableslocales.size();i++){
  		 			if(variableslocales.get(i).equals(in[1])){
  		 				encontro=true;
  		 			}
  		 			}
  		 		for(int i=0; i<variablesglobales.size()&& !encontro;i++){
  		 			if(variablesglobales.get(i).equals(in[1])){
  		 				encontro=true;
  		 				
  		 			}
  		 			if(encontro){
  		 				
  		 			}else{
  		 				
  		 				valido= false;
  		 			}
  		 			
  		 		}
  		 		
  		 		
  		 	}
  		 	}catch(Exception e){
  		 		valido= false;
  		 		
  		 	}
	  }
	  
	  
	  
	  public static void verificarFacil2(String[]in) 
	  {
		
		  try{
  		 	if(in[1].equals("N") ||in[1].equals("E") || in[1].equals("W" )||in[1].equals("S")){
  		 		
  		 		
  		 	}else{
  		 	
  		 		valido= false;
  		 	}
  		 	}catch(Exception e){
  		 		valido= false;
  		 		
  		 	}
	  }
	  
	  
	  public static void verificarFacil3(String[]in) 
	  {
		  
		  try{
  		 	if( in[1].equals("C") || in[1].equals("B") ){
  		 		if( Integer.parseInt(in[2])>=0  ){
  		 			
  		 		
  		 		}else{
  		 			
  		 			valido= false;
  		 		}
  		 		
  		 		
  		 	}else{
  		 		
  		 		valido= false;
  		 	}
  		 	}catch(Exception e){
  		 		
  		 		valido= false;
  		 	}
	  }
	  
	  
	  
	  public static void verificarFacil4(String[]in) 
	  {
		 
		  try{
  		 	if(in[0].equals("NOP")){
  		 		
  		 		
  		 	}else{
  		 		
  		 		valido= false;
  		 	}
  		 	}catch(Exception e){
  		 		
  		 		valido= false;
  		 	}
	  }
	  
	  public static void verificarFacil5(String[]in) 
	  {
	
		  try{
			  fun ver=null;
			  boolean encontro= false;
			  for(int i=0;i <variablesfunciones.size();i++){
				  if(variablesfunciones.get(i).setName().equals(in[0])){
					  encontro=true;
					  ver= variablesfunciones.get(i);
					  break;
				  }
			  }
			  if(!encontro){
				  	valido= false;
			  }
			  else if(!(in.length-1==ver.contador)){
					valido= false;
			  }
  		 
  		 	}catch(Exception e){
  		 	
  		 	}
	  }
	  
	  
	  
	  
	  
	  public static void verificarComplejos( String[] in, BufferedReader br) throws IOException
	  {
		
	  	if(in[0].equals("(BLOCK"))
	  	{
	  		boolean encontreFinal = false;
	  
	  		br.mark(0);
	  		for (int i = 0;br.lines()!=null &&  i < 100000 && !encontreFinal; i++) {
	  			String lecturaFinalBlock = br.readLine();
	  
				if(lecturaFinalBlock!= null && lecturaFinalBlock.equals(")"))
				{
					encontreFinal = true;
				}
			}
	  		if(!encontreFinal)
	  		{
	  			valido = false;
	  	
	  		}
	  		br.reset();
	  	}
	  	else if(in[0].equals("REPEAT"))
	  	{
	  		
	  		if(Integer.parseInt(in[1])>=0)
	  		{
	  			
	  		}
	  		if(in[2].equals("["))
	  		{
	  		
	  		}
	  		else
	  		{
	  			valido = false;
	  		}
	  		if(valido)
	  		{
	  			boolean encontreFinal = false;
		  	
		  		br.mark(0);
		  		for (int i = 0;   i < 100000 && !encontreFinal; i++) {
					if(br.readLine().equals("]"))
					{
						encontreFinal = true;
					}
				}
		  		if(!encontreFinal)
		  		{
		  			valido = false;
		  		   
		  		}
		  		br.reset();
		  		validadaLinea=true;
	  		}
	  		
	  	}
	  	else if(in[0].equals("IF"))
	  	{
	  		if(in[1].equals("BLOCKEDP")||in[1].equals("!BLOCKEDP")){
	  			
	  			
	  		}else{
	  		  valido=false;	
	  		}
	  		if(in[2].equals("["))
	  		{
	  			
	  		}
	  		else
	  		{
	  			valido=false;
	  		}
	  	}
	  	else if(in[0].equals("DEFINE"))
	  	{
	  		if(in[1]!=null)
	  		{
	  			variableslocales.add(in[1]);
	  		}
	  		if(Integer.parseInt(in[2])>=0)
	  		{
	  		
	  		}
	  		else
	  		{
	  			valido=false;
	  		}
	  	}
	  	else if( in[0].equals("TO")    ){
	  		String pnombre = in[1];
	  		fun pr = new fun(pnombre);

	  		for(int i=2;i< in.length;i++ ){
	  			if(in[i].contains(":")){
	  				
	  				pr.sumar();
	  				
	  			}else{
	  				valido=false;
	  			}
	  			
	  			
	  		}
	  		boolean encontreFinal = false;
	  		boolean encontreInicio = false;
	  	
	  		br.mark(0);
	  		
	  		for (int i = 0;br.lines()!=null &&  i < 100000 && !encontreInicio; i++) {
	  			String lecturaInicialBlock = br.readLine();
	  			if(lecturaInicialBlock== null )
				{
					
				}
	  			else if( lecturaInicialBlock.equals("OUTPUT"))
				{
					encontreFinal = true;
				}
	  		
	  			
	  			
	  		}
	  		if(!encontreFinal)
	  		{
	  			valido = false;
	  		  
	  		}
	  		
	  		for (int i = 0;br.lines()!=null &&  i < 100000 && !encontreFinal; i++) {
	  			String lecturaFinalBlock = br.readLine();
	  			
				if(lecturaFinalBlock!= null && lecturaFinalBlock.equals("END"))
				{
					encontreFinal = true;
				}
			}
	  		if(!encontreFinal)
	  		{
	  			valido = false;
	  		   
	  		}
	  		br.reset();
	  	}
	  		
	  	}
	  	
	  	

	  
	  
	  public static void main(String [] arg) {
		    String val= "yes" ; 
	      	po.add("MOVE");
	    	po.add("RIGHT");
	    	po.add("ROTATE");
	    	po.add("LEFT");
	    	po.add("DROP");
	    	po.add("FREE");
	    	po.add("PICK");
            po.add("POP");
            lo.add("LOOK");
	    	complex.add("(BLOCK");
	    	complex.add("REPEAT");
	    	complex.add("IF");
	    	complex.add("DEFINE");
	    	valido = true;
	    	verificarTodo();
	    	if(!valido){
	    		val= "no";
	    	}
	    	System.out.println( val );
	    	
	    	
	   
	   }
	  
	
}
