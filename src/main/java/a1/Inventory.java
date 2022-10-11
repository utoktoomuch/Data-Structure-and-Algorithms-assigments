package a1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class Inventory<Desc,Bin,Location,Unit,Qty,ReorderQty,Cost,InValue> {

    private String desc;
    private String bin;
    private String location;
    private String unit;
    private Integer qty;
    private Integer rqty;
    private Double cost;
    private Double invalue;

    Inventory( String d, String b, String l, String u, Integer q, Integer r, Double c, Double i){ // Constructor
        desc = d;
        bin = b;
        location = l;
        unit = u;
        qty = q;
        rqty = r;
        cost = c;
        invalue = i;
    }
    //get functions below
    public String d(){
        return desc;
    }
    public String b(){
        return bin;
    }
    public String l(){
        return location;
    }
    public String u() {
        return unit;
    }
    public Integer q(){
        return qty;
    }
    public Integer r(){
        return rqty;
    }
    public Double c(){
        return cost;
    }
    public Double i(){
        return invalue;
    }

    //set functions below
    public void setD(String d){ this.desc = d;}
    public void setB(String b){ this.bin = b;}
    public void setL(String l){ this.location = l;}
    public void setU(String u){ this.unit = u;}
    public void setQ(Integer q){ this.qty = q;}
    public void setR(Integer r){ this.rqty = r;}
    public void setC(Double c){ this.cost = c;}
    public void setI(Double i){ this.invalue = i;}



   /** public static void main(String[] args) {
        Inventory inv = new Inventory("0", "0" , "0", "0", 0, 0, 0.0, 0.0);

        Inventory[] InventoryList;
        InventoryList = new Inventory[11];



        inv.setD("item 3");
        System.out.println(inv.d());
    }*/




    /**public void getData(){
        try {
            FileInputStream file = new FileInputStream(new File("a1/tf16400470_win32.xlsm"));//open the file at specific path
            XSSFWorkbook workbook = new XSSFWorkbook(file); //Create a workbook instance to hold the reference file above
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); //for cells that have formula sheet
            XSSFSheet sheet = workbook.getSheetAt(1); //get the second sheet containing the inventory values

            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator(); //iterate through all columns for each row

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

                    switch(cell.getCellType()){
                        case NUMERIC:
                            //grab the value in that cell
                            break;
                        case STRING:
                            //grab the string value in that cell
                            break;
                        case FORMULA:
                            //grab the formula result in that cell
                            break;
                    }
                }
            }
            file.close();


        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getData1(){

        Inventory[] InventoryList;//instantiate
        InventoryList = new Inventory[11];//allocate 11 objects


        try {
            FileInputStream file = new FileInputStream(new File("src/main/java/a1/tf16400470_win32.xlsm"));//open the file at specific path
            XSSFWorkbook workbook = new XSSFWorkbook(file); //Create a workbook instance to hold the reference file above
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); //for cells that have formula sheet
            XSSFSheet sheet = workbook.getSheetAt(1); //get the second sheet containing the inventory values

            //InventoryList[0] = new Inventory(the 8 records for the row);
            //InventoryList[1] = new Inventory(the 8 records for the row);
            for(int i = 0; i<=11; i++){
                InventoryList[i] = new Inventory(workbook.getSheetAt(1).getRow(i+4).getCell(2),
                        workbook.getSheetAt(1).getRow(i+4).getCell(3),
                        workbook.getSheetAt(1).getRow(i+4).getCell(4),
                        workbook.getSheetAt(1).getRow(i+4).getCell(5),
                        workbook.getSheetAt(1).getRow(i+4).getCell(6),
                        workbook.getSheetAt(1).getRow(i+4).getCell(7),
                        workbook.getSheetAt(1).getRow(i+4).getCell(8),
                        workbook.getSheetAt(1).getRow(i+4).getCell(9)); //take value from Excel file and store it in Inventory object

            }
            System.out.println(InventoryList[0]);
            /**for(int i = 4; i <= 14; i++){//goes down the row
                //Inventory<String, String, String, String, Integer, Integer, Double, Double> myInventory = new Inventory();
                for(int j = 2; j <= 9; j++){//goes through the column
                    InventoryList[i] =  workbook.getSheetAt(1).getRow(i).getCell(j); //assign values to the inventory

                }
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }*/
}

