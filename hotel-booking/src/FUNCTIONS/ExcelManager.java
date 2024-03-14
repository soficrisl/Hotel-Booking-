package FUNCTIONS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

    private final String path;
    /**
     * Orden:
     * 1. Cedula
     * 2. Nombre
     * 3. Apellido
     * 4. Email
     * 5. Género
     * 6. TipoHab
     * 7. Llegada
     * 8. Salida
     */
    public List reservas;
    /**
     * Orden
     */
    public List habitaciones;
    /**
     * Orden
     */
    public List estados;
    /**
     * Orden
     */
    public List historicos;

    public ExcelManager() {
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "database" + File.separator + "Booking_hotel.xlsx";
        reservas = new LinkedList();
        habitaciones = new LinkedList();
        estados = new LinkedList();
        historicos = new LinkedList();
    }

    public void readExcel() {
        XSSFWorkbook book = null;

        try {
            // Leer excel
            FileInputStream stream;
            stream = new FileInputStream(path);
            book = new XSSFWorkbook(stream);

            // Recorrer excel
            int sheets = book.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {

                // Ubicar la hoja
                XSSFSheet sheet = book.getSheetAt(i);

                // Obtener el nombre de la hoja
                String sheetName = sheet.getSheetName().toLowerCase();

                // Mandar hoja a sus respectivas funciones de tratamiento de datos
                if (null != sheetName) {
                    switch (sheetName) {
                        case "reservas" ->
                            treatReservas(sheet);
                        case "habitaciones" ->
                            treatHabitaciones(sheet);
                        case "estado" ->
                            treatEstado(sheet);
                        case "historico" ->
                            treatHistorico(sheet);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: No se cargó el Excel! Verificar archivo");
        }
    }

    public void treatReservas(XSSFSheet sheet) {
        // Empezar desde la fila con datos. La 0 no contiene datos sino el título
        int firstRow = 1;
        
        // Terminar hasta la fila que contiene datos
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i < lastRow + 1; i++) {
            Row rowSheet = sheet.getRow(i);
            int cellIndexStart = rowSheet.getFirstCellNum();
            int cellIndexEnd = rowSheet.getLastCellNum();

            List reserva = new LinkedList();
            
            for (int j = cellIndexStart; j < cellIndexEnd; j++) {
                Cell cellSheet = rowSheet.getCell(j);
                
                // Nombre, apellido, correo, género, tipo_hab, celular
                if ("STRING".equals(cellSheet.getCellType().toString())) {
                    // System.out.println("string: " + cellSheet.getStringCellValue());
                    reserva.add(cellSheet.getStringCellValue());

                    // Salida
                } else if ("FORMULA".equals(cellSheet.getCellType().toString())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date b = cellSheet.getDateCellValue();
                    String date = sdf.format(b);
                    // System.out.println("salida: " + date);
                    reserva.add(date);

                    // Cédula, llegada
                } else if ("NUMERIC".equals(cellSheet.getCellType().toString())) {

                    // Llegada
                    if (DateUtil.isCellDateFormatted(cellSheet)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date b = cellSheet.getDateCellValue();
                        String date = sdf.format(b);
                        reserva.add(date);
                        // System.out.println("llegada: " + date);

                    } // Cedula
                    else {
                        String value = String.valueOf(cellSheet.getNumericCellValue());
                        value = value.replace(".", "");
                        value = value.replace("E7", "");
                        reserva.add(value);
                        // System.out.println("cedula: " + value);
                    }
                }
            }
            
            reservas.add(reserva);
        }
    }

    public void treatHabitaciones(XSSFSheet sheet) {
        // Empezar desde la fila con datos. La 0 no contiene datos sino el título
        int firstRow = 1;
        
        // Terminar hasta la fila que contiene datos
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i < lastRow + 1; i++) {
            Row rowSheet = sheet.getRow(i);
            int cellIndexStart = rowSheet.getFirstCellNum();
            int cellIndexEnd = rowSheet.getLastCellNum();

            List habitacion = new LinkedList();
            
            for (int j = cellIndexStart; j < cellIndexEnd; j++) {
                Cell cellSheet = rowSheet.getCell(j);
                
                //tipo_hab
                if ("STRING".equals(cellSheet.getCellType().toString())) {
                    //System.out.println("string: " + cellSheet.getStringCellValue());
                    habitacion.add(cellSheet.getStringCellValue());

                    // num_hab, piso
                } else if ("NUMERIC".equals(cellSheet.getCellType().toString())) {
                    String value = String.valueOf(cellSheet.getNumericCellValue());
                        value = value.replace(".0", "");
                        habitacion.add(value);
                        //System.out.println("num: " + value);
   
                }
            }
            
            habitaciones.add(habitacion);
        }
    }

    public void treatEstado(XSSFSheet sheet) {
        // Empezar desde la fila con datos. La 0 no contiene datos sino el título
        int firstRow = 1;
        
        // Terminar hasta la fila que contiene datos
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i < lastRow + 1; i++) {
            Row rowSheet = sheet.getRow(i);
            int cellIndexStart = rowSheet.getFirstCellNum();
            int cellIndexEnd = rowSheet.getLastCellNum();

            List estado = new LinkedList();
            
            for (int j = cellIndexStart; j < cellIndexEnd; j++) {
                Cell cellSheet = rowSheet.getCell(j);
                
                // Nombre, apellido, correo, género
                if ("STRING".equals(cellSheet.getCellType().toString())) {
                    //System.out.println("string: " + cellSheet.getStringCellValue());
                    estado.add(cellSheet.getStringCellValue());

                    // llegada
                } else if ("FORMULA".equals(cellSheet.getCellType().toString())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date b = cellSheet.getDateCellValue();
                    String date = sdf.format(b);
                    //System.out.println("llegada: " + date);
                    estado.add(date);

                    // celular,  llegada
                } else if ("NUMERIC".equals(cellSheet.getCellType().toString())) {

                    // Llegada
                    if (DateUtil.isCellDateFormatted(cellSheet)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date b = cellSheet.getDateCellValue();
                        String date = sdf.format(b);
                        estado.add(date);
                        //System.out.println("llegada: " + date);

                    } // num_hab
                    else {
                        String value = String.valueOf(cellSheet.getNumericCellValue());
                        value = value.replace(".0", "");
                        estado.add(value);
                        //System.out.println("numhab: " + value);
                    }
                }
            }
            
            estados.add(estado);
        }
    }

    public void treatHistorico(XSSFSheet sheet) {
        // Empezar desde la fila con datos. La 0 no contiene datos sino el título
        int firstRow = 1;
        
        // Terminar hasta la fila que contiene datos
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i < lastRow + 1; i++) {
            Row rowSheet = sheet.getRow(i);
            int cellIndexStart = rowSheet.getFirstCellNum();
            int cellIndexEnd = rowSheet.getLastCellNum();

            List historico = new LinkedList();
            
            for (int j = cellIndexStart; j < cellIndexEnd; j++) {
                Cell cellSheet = rowSheet.getCell(j);
                
                // Nombre, apellido, correo, género
                if ("STRING".equals(cellSheet.getCellType().toString())) {
                    //System.out.println("string: " + cellSheet.getStringCellValue());
                    historico.add(cellSheet.getStringCellValue());

                    // llegada
                } else if ("FORMULA".equals(cellSheet.getCellType().toString())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date b = cellSheet.getDateCellValue();
                    String date = sdf.format(b);
                    //System.out.println("llegada: " + date);
                    historico.add(date);

                    // Cédula, llegada, num_hab
                } else if ("NUMERIC".equals(cellSheet.getCellType().toString())) {

                    // Llegada
                    if (DateUtil.isCellDateFormatted(cellSheet)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date b = cellSheet.getDateCellValue();
                        String date = sdf.format(b);
                        historico.add(date);
                        //System.out.println("llegada: " + date);

                    } // Cedula, num_hab
                    else {
                        String value = String.valueOf(cellSheet.getNumericCellValue());
                        value = value.replace(".0", "");
                        value = value.replace(".", "");
                        value = value.replace("E7", "");
                        historico.add(value);
                        //System.out.println("numeric: " + value);
                    }
                }
            }
            
            historicos.add(historico);
        }
    }
}
