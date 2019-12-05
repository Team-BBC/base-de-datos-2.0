package BD;
//this class will permit the creation of stributes for display
public class carros {
    //campos de la tabla 
    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private double precio;
    private short seminuevo;
    private String year;

    public carros(String placa, String modelo, String marca, String color, double precio, short seminuevo, String year) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.seminuevo = seminuevo;
        this.year = year;
    }
    
    
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public short getSeminuevo() {
        return seminuevo;
    }

    public void setSeminuevo(short seminuevo) {
        this.seminuevo = seminuevo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    //toString for show
    @Override
    public String toString(){
        return "Carro{"+" Placa= "+placa+", Precio= "+precio+", Seminuevo= "+seminuevo+", Color= "+color+", Modelo= "+modelo+", Marca= "+marca+", Year= "+year+"}";        
    }
}
