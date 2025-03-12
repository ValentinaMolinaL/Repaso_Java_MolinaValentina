
package productora_t2_molinavalentina;

import java.util.ArrayList;
import java.util.Scanner;

class Cliente {// Definición de las clases
    int ID;
    String Nombre;
    String Apellido;

    public Cliente(int ID, String Nombre, String Apellido) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre: " + Nombre + ", Apellido" + Apellido;
    }
}



class Concierto {
    int ID;
    String Nombre;
    String Fecha;
    String Lugar;
    double PreBase;

    public Concierto(int ID, String Nombre, String Fecha, String Lugar, double PreBase) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.Lugar = Lugar;
        this.PreBase = PreBase;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre: " + Nombre + ", Fecha: " + Fecha + ", Lugar: " + Lugar + ", Precio Base: $" + PreBase;
    }
}



class Zona {
    int ID;
    String NomZona;
    int Capacidad;
    double PrecioAdicional;

    public Zona(int ID, String NomZona, int Capacidad, double PrecioAdicional) {
        this.ID = ID;
        this.NomZona = NomZona;
        this.Capacidad = Capacidad;
        this.PrecioAdicional = PrecioAdicional;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Zona: " + NomZona + ", Capacidad: " + Capacidad + ", Precio Adicional: $" + PrecioAdicional;
    }
}



final class Ticket {
    int ID;
    Cliente Cliente;
    Concierto Concierto;
    Zona Zona;
    double PreFinal;
    String FechCompra;

    public Ticket(int ID, Cliente Cliente, Concierto Concierto, Zona Zona, String FechCompra) {
        this.ID = ID;
        this.Cliente = Cliente;
        this.Concierto = Concierto;
        this.Zona = Zona;
        this.FechCompra = FechCompra;
        this.PreFinal = calPreFin();
    }

    public double calPreFin() {
        return Concierto.PreBase + Zona.PrecioAdicional;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Cliente: " + Cliente.Nombre + " " + Cliente.Apellido + ", Concierto: " + Concierto.Nombre + ", Zona: " + Zona.NomZona + ", Precio Final: $" + PreFinal + ", Fecha de Compra: " + FechCompra;
    }
}

public class SistemaGestionConciertos {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Concierto> conciertos = new ArrayList<>();
    ArrayList<Zona> zonas = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int sigIdCliente = 1;
    int sigIdConcierto = 1;
    int sigIdZona = 1;
    int sigIdTicket = 1;

    
    public static void main(String[] args) {
        SistemaGestionConciertos sistema = new SistemaGestionConciertos();
        sistema.inicializarDatos();
        sistema.menuPrincipal();
    }

    public void inicializarDatos() {
        clientes.add(new Cliente(sigIdCliente++, "daina", "jaramillo"));
        clientes.add(new Cliente(sigIdCliente++, "cristina", "castillo"));
        clientes.add(new Cliente(sigIdCliente++, "luisa", "lopez"));
        clientes.add(new Cliente(sigIdCliente++, "camila", "mendoza"));
        clientes.add(new Cliente(sigIdCliente++, "sebastian", "vasquez"));
        clientes.add(new Cliente(sigIdCliente++, "Juan", "Pérez"));
        
        conciertos.add(new Concierto(sigIdConcierto++,"Rock en Vivo", "2024-05-20", "Estadio", 50.0));
        conciertos.add(new Concierto(sigIdConcierto++, "Mañana Sera Bonito", "2025-05-20", "parque principal", 60.0));
        conciertos.add(new Concierto(sigIdConcierto++, "Pop Viejo", "2026-05-20", "parcela", 70.0));
        
        zonas.add(new Zona(sigIdZona++, "VIP", 50, 100.0));
        zonas.add(new Zona(sigIdZona++, "VIP", 50, 100.0));
        zonas.add(new Zona(sigIdZona++, "VIP", 50, 100.0));

    }

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- Sistema de Gestión de Conciertos ---");
            System.out.println("1. Ver conciertos disponibles");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Comprar ticket");
            System.out.println("4. Ver tickets por concierto");
            System.out.println("5. Ver conciertos por cliente");
            System.out.println("6. Cancelar ticket");
            System.out.println("7. Calcular ingresos por concierto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarConciertos();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    venderTicket();
                    break;
                case 4:
                    listarTicketsPorConcierto();
                    break;
                case 5:
                    listarConciertosPorCliente();
                    break;
                case 6:
                    cancelarTicket();
                    break;
                case 7:
                    calcularIngresosPorConcierto();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public void listarConciertos() {
        if (conciertos.isEmpty()) {
            System.out.println("No hay conciertos disponibles.");
        } else {
            System.out.println("\n--- Conciertos ---");
            for (Concierto concierto : conciertos) {
                System.out.println(concierto);
            }
        }
    }

    public void registrarCliente() {
        System.out.println("\n--- Registrar Cliente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(sigIdCliente++, nombre, apellido);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado.");
    }

    public void venderTicket() {
        System.out.println("\n--- Vender Ticket ---");
        if (conciertos.isEmpty() || clientes.isEmpty() || zonas.isEmpty()) {
            System.out.println("No hay datos suficientes.");
            return;
        }

        listarConciertos();
        System.out.print("ID del concierto: ");
        int idConcierto = scanner.nextInt();
        Concierto conciertoSeleccionado = buscarConcierto(idConcierto);
        if (conciertoSeleccionado == null) {
            System.out.println("Concierto no encontrado.");
            return;
        }

        listarClientes();
        System.out.print("ID del cliente: ");
        int idCliente = scanner.nextInt();
        Cliente clienteSeleccionado = buscarCliente(idCliente);
        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        listarZonas();
        System.out.print("ID de la zona: ");
        int idZona = scanner.nextInt();
        Zona zonaSeleccionada = buscarZona(idZona);
        if (zonaSeleccionada == null) {
            System.out.println("Zona no encontrada.");
            return;
        }

        Ticket nuevoTicket = new Ticket(sigIdTicket++, clienteSeleccionado, conciertoSeleccionado, zonaSeleccionada, "2024-04-26");
        tickets.add(nuevoTicket);
        System.out.println("Ticket vendido.");
    }

    public void listarTicketsPorConcierto() {
        System.out.println("\n--- Tickets por Concierto ---");
        System.out.print("ID del concierto: ");
        int idConcierto = scanner.nextInt();
        Concierto conciertoSeleccionado = buscarConcierto(idConcierto);
        if (conciertoSeleccionado == null) {
            System.out.println("Concierto no encontrado.");
            return;
        }

        for (Ticket ticket : tickets) {
            if (ticket.Concierto.ID == conciertoSeleccionado.ID) {
                System.out.println(ticket);
            }
        }
    }

    public void listarConciertosPorCliente() {
        System.out.println("\n--- Conciertos por Cliente ---");
        System.out.print("ID del cliente: ");
        int idCliente = scanner.nextInt();
        Cliente clienteSeleccionado = buscarCliente(idCliente);
        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        for (Ticket ticket : tickets) {
            if (ticket.Cliente.ID == clienteSeleccionado.ID) {
                System.out.println(ticket.Concierto);
            }
        }
    }

    public void cancelarTicket() {
        System.out.println("\n--- Cancelar Ticket ---");
        System.out.print("ID del ticket: ");
        int idTicket = scanner.nextInt();

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).ID == idTicket) {
                tickets.remove(i);
                System.out.println("Ticket cancelado.");
                return;
            }
        }

        System.out.println("Ticket no encontrado.");
    }

    public void calcularIngresosPorConcierto() {
        System.out.println("\n--- Ingresos por Concierto ---");
        System.out.print("ID del concierto: ");
        int idConcierto = scanner.nextInt();
        Concierto conciertoSeleccionado = buscarConcierto(idConcierto);
        if (conciertoSeleccionado == null) {
            System.out.println("Concierto no encontrado.");
            return;
        }

        double ingresos = 0;
        for (Ticket ticket : tickets) {
            if (ticket.Concierto.ID == conciertoSeleccionado.ID) {
                ingresos += ticket.PreFinal;
            }
        }

        System.out.println("Ingresos totales: $" + ingresos);
    }

    // Métodos auxiliares

    public Concierto buscarConcierto(int id) {
        for (Concierto concierto : conciertos) {
            if (concierto.ID == id) {
                return concierto;
            }
        }
        return null;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.ID == id) {
                return cliente;
            }
        }
        return null;
    }

    public Zona buscarZona(int id) {
        for (Zona zona : zonas) {
            if (zona.ID == id) {
                return zona;
            }
        }
        return null;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- Clientes ---");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public void listarZonas() {
        if (zonas.isEmpty()) {
            System.out.println("No hay zonas registradas.");
        } else {
            System.out.println("\n--- Zonas ---");
            for (Zona zona : zonas) {
                System.out.println(zona);
            }
        }
    }
}