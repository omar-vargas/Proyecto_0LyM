import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Proyecto_0 {
	
	static ArrayList<String >po = new ArrayList<>();
	private static String[] li; 

	  public static void main(String [] arg) {
	      File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      	po.add("MOVE");
	    	po.add("RIGHT");
	    	po.add("ROTATE");
	    	po.add("LEFT");
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("./archivo.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	        	 li = linea.split("\\s+");
	         for(int i=0; i<li.length;i++ ){
	        	 if(po.contains(li[i])){
	        		 
	        		 try{
	        		 	if( Integer.parseInt(li[i+1])>=0  ){
	        		 		i= li.length;
	        		 		System.out.println("valido");
	        		 	}else{
	        		 		System.out.println("invalido");
	        		 	}
	        		 	}catch(Exception e){
	        		 		System.out.println("invalido");
	        		 	}
	        	 }
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
	}
