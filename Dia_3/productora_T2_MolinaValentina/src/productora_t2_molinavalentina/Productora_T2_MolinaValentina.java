
package productora_t2_molinavalentina;

import java.util.Scanner;

class Conciertos {
    
    public String Karolg;
    public String Cepeda;
    public String Medrano;
    public String Joe;
    public String Pastor;
    
    public Conciertos(String Karolg,String Cepeda,public String Medrano,public String Joe,String Pastor){
        this.Karolg = Karolg; 
    }
    
}

public class Productora_T2_MolinaValentina {

    public static void main(String[] args) {
        
        int opcionMenu=0;
        Scanner scanner = new Scanner(System.in);
        
        while (opcionMenu !=6){
                    System.out.println("----- BIENVENIDO -----");
                    System.out.println("1. Ver conciertos disponibles.");
                    System.out.println("2. Registrar cliente.");
                    System.out.println("3. Comprar ticket.");
                    System.out.println("4. Ver tickets por cliente.");
                    System.out.println("5. Cancelar ticket.");
                    System.out.println("6. Salir");
                    
                    opcionMenu = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (opcionMenu){
                        case 1 ->{
                            System.out.println("Los conciertos disponibles son:");
                        
                        }
                    } 
                    
                    
            }
        }
    }
