package socket;

import java.io.IOException;

public interface ClienteServidor {
 public abstract void enviarDatos( Object mensaje );
 public abstract void mostrarMensaje( final String mensajeAMostrar );
 public abstract void cerrarConexion();
 public abstract void obtenerFlujos() throws IOException;
 public abstract void procesarConexion() throws IOException;
// public abstract void establecerCampoTextoEditable( final boolean editable );
 public abstract void ejecutar();
}
