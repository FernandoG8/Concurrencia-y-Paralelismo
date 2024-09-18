public class MainCombinado {
    public static void main(String[] args) {
        // Crear una impresora compartida, con un semáforo que permite un acceso a la vez
        ImpresoraCompartida impresoraCompartida = new ImpresoraCompartida(1); 

        // Crear varios usuarios que quieren imprimir documentos
        Thread usuario1 = new Thread(new UsuarioImpresora(impresoraCompartida, "Documento_1.pdf"), "Usuario 1");
        Thread usuario2 = new Thread(new UsuarioImpresora(impresoraCompartida, "Documento_2.pdf"), "Usuario 2");
        Thread usuario3 = new Thread(new UsuarioImpresora(impresoraCompartida, "Documento_3.pdf"), "Usuario 3");

        // Iniciar los hilos
        usuario1.start();
        usuario2.start();
        usuario3.start();
    }
}
