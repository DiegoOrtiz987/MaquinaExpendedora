package controlador;

import javax.swing.JOptionPane;

public class Maquina_Expendedora extends Producto{

	private int contenedor=0;
	private int monedas=0;
	private int ganacia=0;
	
	// Métodos del Contenedor
	
	public  int getContenedor() {
		return contenedor;
	}
	
	public void setContenedor(int contenedor) {
		this.contenedor-= contenedor;
	}
	
	// Llenar el contenedor
	public void llenarContenedor() {
		
		int menu=0;
		int add=0,add2=0;
		
		

		 if (contenedor==50){
			 
			 JOptionPane.showMessageDialog(null, "El contenedor esta Lleno");		
		
		 }else if (contenedor==0) {
		
				do{
					
					menu=0;
					
					JOptionPane.showMessageDialog(null, "PRODUCTO AGOTADO. \n\nEl contenedor esta vacio.");
					setNombreProducto(JOptionPane.showInputDialog("Digite el nombre del producto a contener: "));
					add= Integer.parseInt (JOptionPane.showInputDialog("Maximo 50 unidades. Digite la cantidad de " + getNombreProducto() + " a cargar: "));
							
					
					if ((contenedor + add)>50 || (contenedor+add)==0){
						
						menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Excede la capacidad del contenedor o la carga es igual a Cero (0).\n\n1. Vuelva a ingresar la información. \n 2. Cargar en otra ocasión"));
						if (menu==2){
							
							JOptionPane.showMessageDialog(null, "Contenedor vacio");
							add=0;
						}
					} 
								
				} while ( menu==1);
				
				
				this.contenedor+=add;
				JOptionPane.showMessageDialog(null, "Se cargo el contenedor con la cantidad de " + add + " "+ getNombreProducto() + " para un total de " + contenedor + " "+ getNombreProducto());
				
		} else if (contenedor<50){
			
			do{
				
				this.contenedor-=add2;
				add2= Integer.parseInt (JOptionPane.showInputDialog("Maximo " + (50-this.contenedor) + " unidades a cargar.\n Digite la cantidad de " + getNombreProducto() + ": "));
			
			 
				if(add2<=(50-this.contenedor)){
						
						this.contenedor+=add2;
						
				}else{
					
					JOptionPane.showMessageDialog(null, "La cantidad ingresada supera el máximo permitido siendo este de " + (50-this.contenedor) + " unidades máximo");
					this.contenedor+=add2;
				}
			 }while (add2>50-(this.contenedor-add2));
			 
			JOptionPane.showMessageDialog(null, "Se cargo el contenedor con la cantidad de " + add2 + " unidades para un total de " + contenedor + " "+ getNombreProducto());
		}
		
	}

	// Métodos para las Monedas
	
	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas += monedas;
	}
	
	public void setMonedasCero(int monedas) {
		this.monedas = monedas;
	}
	
	//Inserción de monedas

	public String insertarModenas (int monedas){

		
		if (monedas>5){
			
			return ("Excedio la cantidad de monedas permitidas. Debe eyectar las monedas");
					
		}else if (monedas <=0){
			
			return ("No ha insertado ninguna moneda");
					
		}else if (monedas==5){
			
			return ("              CON MONEDA. \nAlcanzo el maximo de monedas. Puede girar la manivela. ");
		}else{
			
			return ("              CON MONEDA \npuede girar la manivela o insertar otra moneda");
		}
		
	}
	
	
	// Eyección de las monedas
	
		public void eyectarMonedas(int monedas) {
			
			if (this.monedas<monedas){
				
				JOptionPane.showMessageDialog(null, "Excede la cantidad de monedas insertadas. Monedas insertadas: " + this.monedas);
				
			} else {
				
				this.monedas-= monedas;
				JOptionPane.showMessageDialog(null, "La cantidad de monedas eyectadas es: "+ monedas);
				
			}
		}
	
	
		//Método de las ganacias
		
		public String getGanacia() {
			
			return  "La ganancia a la fecha es de: "+ ganacia +"monedas";
		}

		public void setGanacia(int ganacia) {
			this.ganacia += ganacia;
		}
		
		
		
	
	// Método para mostrar el menú 
	
	public int seleccionarOpcion(){
		
		int accion=0;
		boolean control=false;
		
		if(this.monedas>5 || this.monedas>this.contenedor){
			
			do{
				
				if(control){
					
					JOptionPane.showMessageDialog(null, "Opcion no existente.");
				}
				
				accion= Integer.parseInt(JOptionPane.showInputDialog("               *****  BIENVENIDO   ******* "
						+ "\nCantidad de " + getNombreProducto() + " en el contenedor " + this.contenedor
						+ "\n Cantidad de monedas insertadas: " + this.monedas
						+ "\n\nSeleccione la acción a realizar: "
						+ "\n3. Eyectar monedas "+ "\n 4. Cargar contenedor" + "\n5. Ganancias" + "\n6. Salir"));
				
				control=true;
				
			}while(accion<3 || accion>6);
				
			
		}else if (this.monedas==5){
			
			do{ 
				
				if(control){
					
					JOptionPane.showMessageDialog(null, "Opcion no existente.");
				}
				
				
				accion= Integer.parseInt(JOptionPane.showInputDialog("          ***** BIENVENIDO   ******* "
						+ "\nCantidad de " + getNombreProducto() + " en el contenedor " + this.contenedor
						+ "\n Cantidad de monedas insertadas: " + this.monedas
						+ "\n\nSeleccione la acción a realizar: "
						+ "\n 2. Girar manivela " + "\n 3. Eyectar monedas "+ "\n 4. Cargar contenedor " + "\n5. Ganancias" + "\n6. Salir"));
			
				control=true;
			}while(accion<2 || accion>6);
			
		}else {
			
			do{ 
				
				if(control){
					
					JOptionPane.showMessageDialog(null, "Opcion no existente.");
				}
			
			accion= Integer.parseInt(JOptionPane.showInputDialog("        ***** BIENVENIDO   ******* "
					+ "\nCantidad de " + getNombreProducto() + " en el contenedor " + this.contenedor
					+ "\n Cantidad de monedas insertadas: " + this.monedas
				    + "\n\nSeleccione la acción a realizar: "
					+ "\n 1. Insertar monedas " + "\n 2. Girar manivela " + "\n 3. Eyectar monedas "+ "\n 4. Cargar contenedor " + "\n5. Ganancias" + "\n6. Salir"));
			
				control=true;
				
			}while(accion<1 || accion>6);
			
		}
		
		return accion;
	}



	
}
