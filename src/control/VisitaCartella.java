/*
 * VisitaCartella.
 */
package control;

import java.io.File;

/**
 *
 * @author Sandro
 */
public class VisitaCartella {
    
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    visita(new File(".."));
  }
  
  public static void visita(File f){
    visita(f,0);
  }
  private static void visita(File f, int livello){
    if (f.isFile()){
       stampaNodo(f,livello,"file: ");
    }
    else {
      if (f.isDirectory()){
        for (File figlio:f.listFiles()){
          //tratta solo i file
          if (figlio.isFile()){
            visita(figlio,livello+1);
          }
        }
        for (File figlio:f.listFiles()){
          //tratta solo le cartelle
          if (figlio.isDirectory()){  
            visita(figlio,livello+1);
          }
        }
        stampaNodo(f,livello,"cartella: ");
     }
    }
  }
  private static void stampaNodo(File f, int livello, String msg){
        for (int i = 0; i < livello; i++) {
            System.out.print("\t");            
        }
        System.out.println(msg+f.getName());
  }
}
