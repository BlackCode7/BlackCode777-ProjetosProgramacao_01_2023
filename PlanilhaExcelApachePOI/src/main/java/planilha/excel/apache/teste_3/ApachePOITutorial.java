package planilha.excel.apache.teste_3;

import java.io.IOException;
import java.util.List;

import planilha.excel.apache.model.Usuario;

public class ApachePOITutorial {

	public static void main(String[] args) throws IOException {
		
		ApachePOITutorial_Metodo gerenciador = new ApachePOITutorial_Metodo();
		List<Usuario> usuarios = gerenciador.criar();		

		gerenciador.imprimir(usuarios);
		
	}

}
