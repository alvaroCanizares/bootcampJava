package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import entidad.Coche;
import negocio.GestorCoche;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static GestorCoche gestor = new GestorCoche();
	
	public static void main(String[] args) {
		
		String respuesta ="";
		boolean fin = false;
		
		Coche c = null;
		
		do {
			System.out.println("BIENVENIDO AL CONCESIONARIO, �QU� DESEA?:\n");
			System.out.println("1:Dar de alta\n"
								+"2:Dar de baja\n"
								+"3:Modificar\n"
								+"4:Consultar\n"
								+"5:Listar\n"
								+"6:Imprimir\n"
								+"7:Salir\n");
			respuesta = sc.nextLine();
			
			switch (respuesta) {
			case "1":
				c = new Coche();
				c.setMatricula(pedirString("matricula"));
				c.setMarca(pedirString("marca"));
				c.setModelo(pedirString("modelo"));
				c.setNumeroKm(pedirInt());
				
				comprobar(gestor.alta(c));
				break;
			case "2":
				comprobar(gestor.baja(pedirString("matricula")));
				break;
			case "3":
				c = new Coche();
				c.setMatricula(pedirString("matricula"));
				c.setMarca(pedirString("marca"));
				c.setModelo(pedirString("modelo"));
				c.setNumeroKm(pedirInt());
				
				comprobar(gestor.modificar(c));
				break;
			case "4":
				c = gestor.obtener(pedirString("matricula"));
				System.out.println(c);
				break;
			case "5":
				List<Coche> lista = gestor.listar();
				for (Coche coche : lista) {
					System.out.println(coche);
				}
				break;
			case "6":
				imprimir();
				break;
			case "7":
				fin = true;
				break;

			default:
				System.out.println("Error introduzca el numero indicado");
				break;
			}
			
		}while(!fin);
		System.out.println("ADIOS");
	}
	
	private static void imprimir() {
		List<Coche> lista = gestor.listar();
		
		//Creo la estructura
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Hoja Excel");
		
		//Formato
		String headers [] = new String[] {
				"Matricula","Marca","Modelo","Numero KM"
		};
		CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        //Creacion de la tabla
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }
        int contador = 1;
        	for (Coche coche : lista) {
        		HSSFRow dataRow = sheet.createRow(contador++);

                

                dataRow.createCell(0).setCellValue(coche.getMatricula());
                dataRow.createCell(1).setCellValue(coche.getMarca());
                dataRow.createCell(2).setCellValue(coche.getModelo());
                dataRow.createCell(3).setCellValue(coche.getNumeroKm());
			}
        

 
        FileOutputStream file;
		try {
			file = new FileOutputStream("data.xls");
			 workbook.write(file);
		     file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
	}

	public static String pedirString(String cadena) {
		System.out.println("Introduzca "+cadena);
		String respuesta = sc.nextLine();
		return respuesta;
	}
	
	public static int pedirInt() {
		System.out.println("Introduzca el n� de km");
		int respuesta = sc.nextInt();
		return respuesta;
	}
	public static void comprobar(boolean b) {
		if(b) {
			System.out.println("�xito");
		}else {
			System.out.println("Error");
		}
	}

}
