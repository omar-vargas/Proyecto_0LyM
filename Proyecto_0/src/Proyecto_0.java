import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Proyecto_0 {

	
	static ArrayList<String >po = new ArrayList<>();
	static ArrayList<String >complex = new ArrayList<>();
	private static String[] li; 
	static boolean valido;
	static boolean validadaLinea;
	
	
	
	public static void verificar( String linea, BufferedReader br ) throws IOException
	{
		
		 li = linea.split(" ");	
   
     for(int i=0;!validadaLinea && i<li.length;i++ ){
    	 System.out.println(li[i]);
    	 if(po.contains(li[i])){
    		
    		 verificarFacil(li);
    		 i++;
    		 
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
		  System.out.println("entre al facil");
		  try{
  		 	if( Integer.parseInt(in[1])>=0  ){
  		 		
  		 		System.out.println("valido");
  		 	}else{
  		 		System.out.println("invalido");
  		 	}
  		 	}catch(Exception e){
  		 		System.out.println("invalido");
  		 	}
	  }
	  
	  public static void verificarComplejos( String[] in, BufferedReader br) throws IOException
	  {
		
	  	if(in[0].equals("(BLOCK"))
	  	{
	  		boolean encontreFinal = false;
	  		System.out.println("valide el block");
	  		br.mark(0);
	  		for (int i = 0;br.lines()!=null &&  i < 100000 && !encontreFinal; i++) {
	  			String lecturaFinalBlock = br.readLine();
	  			System.out.println(lecturaFinalBlock);
				if(lecturaFinalBlock!= null && lecturaFinalBlock.equals(")"))
				{
					encontreFinal = true;
				}
			}
	  		if(!encontreFinal)
	  		{
	  			valido = false;
	  		    System.out.println("no encontro final del block");
	  		}
	  		br.reset();
	  	}
	  	else if(in[0].equals("REPEAT"))
	  	{
	  		
	  		if(Integer.parseInt(in[1])>=0)
	  		{
	  			System.out.println("el siguiente del repeat si es un numero");
	  		}
	  		if(in[2].equals("["))
	  		{
	  			System.out.println("seguido del numero va el  [");
	  		}
	  		else
	  		{
	  			valido = false;
	  		}
	  		if(valido)
	  		{
	  			boolean encontreFinal = false;
		  		System.out.println("valide el REPEAT");
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
		  		    System.out.println("invalido");
		  		}
		  		br.reset();
		  		validadaLinea=true;
	  		}
	  		
	  	}
	  	else if(in[0].equals("IF"))
	  	{
	  		if(in[2].equals("["))
	  		{
	  			System.out.println("seguido del booleano va el  [ en el IF");
	  		}
	  		else
	  		{
	  			valido=false;
	  		}
	  	}
	  	else if(in[0].equals("DEFINE"))
	  	{
	  		if(in[1].equals("["))
	  		{
	  			System.out.println("seguido del booleano va el  [ en el IF");
	  		}
	  		if(Integer.parseInt(in[2])>=0)
	  		{
	  			System.out.println("el siguiente del define  si es un numero");
	  		}
	  		else
	  		{
	  			valido=false;
	  		}
	  	}
	  }
	  
	  public static void main(String [] arg) {
		     
	      	po.add("MOVE");
	    	po.add("RIGHT");
	    	po.add("ROTATE");
	    	po.add("LEFT");
	    	po.add("DROP");
	    	po.add("FREE");
	    	po.add("PICK");
            po.add("POP");
	    	complex.add("(BLOCK");
	    	complex.add("REPEAT");
	    	complex.add("IF");
	    	complex.add("DEFINE");
	    	valido = true;
	    	verificarTodo();
	    	
	    	
	    	
	   
	   }
}
