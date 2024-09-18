public class UsuarioImpresora implements Runnable {
    private ImpresoraCompartida impresora;
    private String documento;

    public UsuarioImpresora(ImpresoraCompartida impresora, String documento) {
        this.impresora = impresora;
        this.documento = documento;
    }

    // Método que se ejecutará cuando el hilo del usuario comience a correr
    @Override
    public void run() {
        impresora.imprimirDocumento(documento); // Intentar imprimir el documento
    }
}
