package controlador;

import javax.swing.JOptionPane;


public class Aplicacion {
	
	public static void main(String[] args) {
		
		Maquina_Expendedora producto = new Maquina_Expendedora();	
		
				
		do {
			
			if (producto.getContenedor()<=0){
				
				producto.llenarContenedor();
			}

			do {				
				
				switch (producto.seleccionarOpcion()){
			
					case 1: 						
							if(producto.getContenedor()==0){
									
								JOptionPane.showMessageDialog(null, "El contenedor esta vacío");
								
							} else{
							
								producto.setMonedas(Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de monedas a insertar. \n Tiene un máximo de 5 Monedas por giro")));
					 	 	
					 	 		if (producto.getMonedas()>producto.getContenedor()){
								
					 	 			JOptionPane.showMessageDialog(null, "La cantidad de monedas supera la cantidad de " + producto.getNombreProducto() + " en el contenedor."
										                      + "la máxima cantidad a solicitar es de " + producto.getContenedor()+ ". Eyectar monedas");
					 	 			producto.seleccionarOpcion();
					 	 		}
					 	 		
					 	 		JOptionPane.showMessageDialog(null, producto.insertarModenas(producto.getMonedas()));
					 	 	}
					 	 	
					 break;
					 	 	
					case 2:  
							if (producto.getMonedas()==0){
								JOptionPane.showMessageDialog(null, "No hay monedas cargadas");						
							}else{
								JOptionPane.showMessageDialog(null, "La cantidad de "+ producto.getNombreProducto() + " vendidos es: "+ producto.getMonedas() + ".\nPuede tomarlos");
								producto.setContenedor(producto.getMonedas());
								producto.setGanacia(producto.getMonedas());
								producto.setMonedasCero(0);
							}
					break;
						 	
					case 3: 
							if (producto.getMonedas()==0){
								JOptionPane.showMessageDialog(null, "No hay monedas cargadas para eyectar");	 
							}else{
								producto.eyectarMonedas(Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de monedas a eyectar.")));
							}
					break;
					
					case 4: 
							producto.llenarContenedor();
					break;
						 	
					case 5: 
							JOptionPane.showMessageDialog (null,producto.getGanacia());
					break;
					
					case 6: 
						JOptionPane.showMessageDialog(null,"Gracias por elegirnos");
						System.exit(0);
					break;
				}	
			
			}while (producto.getMonedas()<5 || producto.getMonedas()>0 && producto.getContenedor()>0);
			
		}while (producto.getContenedor()<=0);
		
	}

}

