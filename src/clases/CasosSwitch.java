package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class CasosSwitch {
	Scanner read = new Scanner(System.in);

	
	
	//SECCION CLIENTES
	public void casoClientes( List<String> datosClientes) {
		datosClientes.clear();
		
		System.out.println("Ingrese su cédula");
		datosClientes.add(read.next());


		
		System.out.println("Ingrese sus Nombres");
		datosClientes.add(read.next());


		System.out.println("Ingrese sus Apellidos");
		datosClientes.add(read.next());


		System.out.println("Ingrese su Telefono");
		datosClientes.add(read.next());


		

		System.out.println("Ingrese su Año de Nacimiento Ejm:2003");
		datosClientes.add(read.next());
		
	}
	
	//SECCION CARROS
	public void casoCarros (List<String> datosCarro) {
		datosCarro.clear();
		
		System.out.println("Ingrese su Placa Ejm: TDL-1234");
		datosCarro.add(read.next());


		
		System.out.println("Ingrese la Marca");
		datosCarro.add(read.next());


		System.out.println("Ingrese el Color");
		datosCarro.add(read.next());


		System.out.println("Ingrese la Hora de Entrada Ejm: 08:10");
		datosCarro.add(read.next());
		
	}
	
	// SECCION SALIDA VEHICULO
	
	public void casoSalidaCarro (List<String> salidaVehiculo) {
		salidaVehiculo.clear();

		System.out.println("Ingrese la hora de salida del vehiculo (Ejm: 09:00)");
		salidaVehiculo.add(read.next());
		
		
	}
	
	
	
	
	// SECCION MUESTRA DATOS
	
	
	
	public void casoImpresionDatos(List<String> cliente, List<String> carro ) {
		System.out.println("------------DATOS DEL CLIENTE------------");
		System.out.println("Ci: "+ cliente.get(0));
		System.out.println("Nombre: "+ cliente.get(1)+cliente.get(2));

		System.out.println("Telefono: "+ cliente.get(3));   
		System.out.println("Edad: "+ Integer.toString(obtenerEdad(cliente.get(4)))  );   
		System.out.println("Grupo: "+ this.obtenerGrupo(Integer.toString(obtenerEdad(cliente.get(4)))));  
		
		System.out.println("------------DATOS DEL CARRO------------");
		
		System.out.println("Marca: "+ carro.get(1));

		System.out.println("Placa: TDL-1234"+ carro.get(0));

		System.out.println("Color: "+ carro.get(2));




	}

	
	//SECCION COBROS
	
	public void casoCobro(List<String> cliente,List<String> carro, String horaSalida) {
		System.out.println("Ingreso: "+ carro.get(3));

		System.out.println("Salida: "+ horaSalida);
		System.out.println("Horas o Fraccion: "+ this.obtenerFraccion(carro.get(3), horaSalida));
		System.out.println("Total: " + this.obtenerPreTotal(Integer.parseInt(this.obtenerFraccion(carro.get(3), horaSalida))));

		System.out.println("Descuento: "+ this.obtenerDescuento(Integer.toString(obtenerEdad(cliente.get(4)))));
		System.out.println("Total a pagar: " + this.obtenerTotal(this.obtenerDescuento(Integer.toString(obtenerEdad(cliente.get(4)))), this.obtenerPreTotal(Integer.parseInt(this.obtenerFraccion(carro.get(3), horaSalida)))));

	}
	
	
	
	
	
	
	//SECCION FUNCIONES
	public int obtenerEdad(String year) {
		
		int resultado = 2022 - Integer.parseInt(year);
		return resultado;
		
	}
	
	public String obtenerGrupo(String edad) {
		if(Integer.parseInt(edad) > 18 && Integer.parseInt(edad) < 29) {
			return "Juevenil";
			
		}else if(Integer.parseInt(edad) > 30 && Integer.parseInt(edad) < 59) {
			return "Señor";
		}else if (Integer.parseInt(edad) > 60) {
			return "Tercera Edad";
		}else {
			return "No cumple ninguna condicion";
		}
		
	}
	
	public String obtenerDescuento(String edad){
		if(Integer.parseInt(edad) > 18 && Integer.parseInt(edad) < 29) {
			return "0";
			
		}else if(Integer.parseInt(edad) > 30 && Integer.parseInt(edad) < 59) {
			return "0";
		}else if (Integer.parseInt(edad) > 60) {
			return "30%";
		}else {
			return "";
		}
	}
	
	public String obtenerFraccion(String hora1, String hora2) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");

		try {
			var date1 = format.parse(hora1);
			var date2 = format.parse(hora2);
			
		
			if(date1.getHours() > date2.getHours()) {
				int respuesta = date1.getHours() -date2.getHours();
				return Integer.toString(respuesta);

				
			}else {
				int respuesta = date2.getHours() -date1.getHours();
				return Integer.toString(respuesta);
				
			}



		} catch (ParseException e) {
			return "0";

			
		}
		
	}
	public double obtenerPreTotal(int fraccion) {
		double resultado = 1.50 * fraccion;
		return resultado;
		
	}
	public double obtenerTotal(String descuento, double obtenerPreTotal ) {
		if(descuento =="30%") {
			var temporalDescuento = (obtenerPreTotal *30)/100;
			var total = obtenerPreTotal - temporalDescuento;
			return total;
			
		}else {
			return obtenerPreTotal;
			
		}
		
	}

	
}













