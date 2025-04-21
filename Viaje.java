
public class Viaje {
    private String origen = "Universidad de las Américas Puebla (UDLAP)";
    private String destino;
    private Conductor conductor;

    public Viaje(String destino, Conductor conductor) {
        this.destino = destino;
        this.conductor = conductor;
    }

    public String getDetalles() {
        return "Origen: " + origen + "\nDestino: " + destino + "\nConductor: " + conductor.getNombre() + "\nVehículo: " + conductor.getVehiculo();
    }
}