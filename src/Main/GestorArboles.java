package Main;

import java.sql.Connection;
import java.sql.DriverManager;
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
					String sentenciaInsert = "INSERT INTO  `eh_garden` ( `nombre_comun`, `nombre_cientifico`, `habitat`, `altura`, `origen`) VALUES ('" + nombreArbol + "','"+nombre100+"','"+habitat+"',"+altura+",'"+origen+"')";
					st.execute(sentenciaInsert);
					break;
				case OPCION_DOS:
					System.out.println("Introduce el id del Arbol a eliminar");
					int id = Integer.parseInt(scan.nextLine());
					String sentenciaDelete = "DELETE FROM `eh_garden` WHERE id = "+ id + " ;";
					st.execute(sentenciaDelete);
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
					String sentenciaUpdate = "UPDATE `eh_garden` SET `nombre_comun`='"+nombreArbolm+"',`nombre_cientifico`='"+nombre100m+"',`habitat`='"+habitatm+"',`altura`='"+alturam+"',`origen`=' "+origenm+ "' WHERE id = " + idm +";";
					st.execute(sentenciaUpdate);
					break;
				case OPCION_CUATRO:
					System.out.println("Introduce el id del Arbol a visualizar");
					int idv = Integer.parseInt(scan.nextLine());
					String sentenciaSelect ="SELECT * FROM `eh_garden` WHERE  id = "+idv+"";
					ResultSet result = st.executeQuery(sentenciaSelect);
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
