package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestorArboles {
	private static final String HOST = "localHost";
	private static final String BBDD = "prueba";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		try {
			
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/prueba","root",""); //Abrir conexion
			
			Statement st = (Statement) con.createStatement();
			
			//String sentenciaInsert = "INSERT INTO prueba ('"+ nombreTabla + "') VALUES ('"+ nombreAnimal + "')";
			//st.execute(sentenciaInsert);
			//INSERT INTO prueba (nombre) VALUES ('Perico');
			
			//String SentenciaUpdate = "UPDATE `prueba` SET `nombre`='[perro]' WHERE 1";
			//st.executeUpdate(sentenciaInsert);
			
			//String SentenciaDelete = "DELETE FROM nombreTabla WHERE nombre = 'gato'";
			//st.execute(SentenciaDelete);
			
			//PreparedStatement preparedSt = con.prepareStatement(BBDD);
			//preparedSt.setString(1, "Ecualipto");
			//preparedSt.execute();
			
			
			final int OPCION_UNO = 1;
			final int OPCION_DOS = 2;
			final int OPCION_TRES = 3;
			final int OPCION_CUATRO = 4;
			final int SALIR = 0;
			
		
			int opcion_menu;
			
			do {
				System.out.println("------MENU-------");
				System.out.println(OPCION_UNO +". insertar árbol");
				System.out.println(OPCION_DOS + ". eliminar árbol");
				System.out.println(OPCION_TRES + ". modificar información del árbol");
				System.out.println(OPCION_CUATRO + ". visualizar árboles");
				System.out.println(SALIR + ". Salir");
				System.out.println("Elije una de las opciones");
				opcion_menu = Integer.parseInt(scan.nextLine());
				
	
				switch (opcion_menu) {
				case OPCION_UNO:
					String nombreTabla = "eh_garden";
					System.out.println("introduce nombre del arbol");
					String nombreArbol  = scan.nextLine();
					System.out.println("introduce nombre cientifico");
					String nombre100 = scan.nextLine();
					System.out.println("introduce habitat");
					String habitat = scan.nextLine();
					System.out.println("introduce altura");
					int altura = Integer.parseInt(scan.nextLine());
					System.out.println("introduce origen");
					String origen = scan.nextLine();
					PreparedStatement preparedSt = con.prepareStatement("INSERT INTO  eh_garden ( nombre_comun, nombre_cientifico, habitat, altura, origen) VALUES (?,?,?,?,?);");
					preparedSt.setString(1, nombreArbol );
					preparedSt.setString(2, nombre100 );
					preparedSt.setString(3, habitat );
					preparedSt.setInt(4, altura );
					preparedSt.setString(5, origen );
					preparedSt.execute();
					break;
				case OPCION_DOS:
					System.out.println("Introduce el id del Arbol a eliminar");
					int id = Integer.parseInt(scan.nextLine());
					PreparedStatement preparedStel = con.prepareStatement("DELETE FROM eh_garden WHERE id = ? ;");
					preparedStel.setInt(1, id );
					preparedStel.execute();
					break;
				case OPCION_TRES:
					String nombreTablam = "eh_garden";
					System.out.println("Introduce el id del Arbol a modificar");
					int idm = Integer.parseInt(scan.nextLine());
					System.out.println("introduce nuevo nombre del arbol");
					String nombreArbolm  = scan.nextLine();
					System.out.println("introduce nuevo nombre cientifico");
					String nombre100m = scan.nextLine();
					System.out.println("introduce nuvo habitat");
					String habitatm = scan.nextLine();
					System.out.println("introduce nueva altura");
					int alturam = Integer.parseInt(scan.nextLine());
					System.out.println("introduce nuevo origen");
					String origenm = scan.nextLine();
					PreparedStatement preparedStModify = con.prepareStatement("UPDATE eh_garden SET nombre_comun= (?),nombre_cientifico= (?),habitat= (?),altura= (?),origen= (?) WHERE id = (?);");
					preparedStModify.setInt(6, idm );
					preparedStModify.setString(1, nombreArbolm );
					preparedStModify.setString(2, nombre100m );
					preparedStModify.setString(3, habitatm );
					preparedStModify.setInt(4, alturam );
					preparedStModify.setString(5, origenm );
					preparedStModify.execute();
					break;
				case OPCION_CUATRO:
					System.out.println("Introduce el id del Arbol a visualizar");
					int idv = Integer.parseInt(scan.nextLine());
					PreparedStatement preparedStvi = con.prepareStatement("SELECT * FROM eh_garden WHERE id = ?");
					preparedStvi.setInt(1, idv );
					ResultSet result = preparedStvi.executeQuery();
					
					while(result.next()) {
						System.out.println(result.getString(2) + "-" + result.getString(3) + "-" + result.getString(4) + "-" + result.getInt(5) +"-"+result.getString(6));
					}
					break;
				case SALIR:
					System.out.println("ADIOS");
					break;
				default:
					System.out.println("Opcion incorrecta!");
				}

			} while (opcion_menu != SALIR);
			scan.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}