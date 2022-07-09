import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.CasosSwitch;


public class main {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		CasosSwitch casos = new CasosSwitch();

		boolean salirMenu = false;
		String opcionElegida ="";
		
		List<String> datosClientes = new ArrayList();
		List<String> datosCarro = new ArrayList();
		List<String> salidaVehiculo = new ArrayList();

//		String time1 = "16:00";
//		String time2 = "19:00";
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		while (salirMenu ==false) {
			System.out.println("-------Menu------");
			System.out.println("1. Ingreso de Datos Cliente");
			System.out.println("2. Ingreso del Vehículo");
			System.out.println("3. Salida del Vehículo");
			System.out.println("4. Impresión de datos");
			System.out.println("5. Cobro del cliente");
			System.out.println("6. Salir");
			opcionElegida = read.nextLine();

			
			switch (opcionElegida) {
			case "1":
				casos.casoClientes(datosClientes);
				break;
			case "2":
				casos.casoCarros(datosCarro);
				break;
			case "3":
				casos.casoSalidaCarro(salidaVehiculo);
				break;
			case "4":
				casos.casoImpresionDatos(datosClientes, datosCarro);
				break;
			case "5":
				casos.casoCobro(datosClientes, datosCarro, salidaVehiculo.get(0));


				break;
				
			case "6":
				salirMenu = true;
				break;
				
			default:
				System.out.println("Ninguno seleccionado");
				break;
			
			}
			
			
		
}
		
		
		
		
	
		
		
	}

}
