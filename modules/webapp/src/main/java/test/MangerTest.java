package test;


import com.mw.utils.FileUtils;
import com.mysql.jdbc.TimeUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class MangerTest {

    public static  final  void main(String[] arg ) throws Exception {



        List<Map>  dataList=new ArrayList<>();
        List<String>  keyList=new ArrayList<>();


        keyList.add("sn");
        keyList.add("archivalcode");
        keyList.add("documentnumber");
        keyList.add("author");
        keyList.add("title");
        keyList.add("filedate");
        keyList.add("securityclassification");
        keyList.add("amountofpages");
        keyList.add("annotation");
        keyList.add("retentionperiod");
        keyList.add("copies");

        for (int i = 0; i <30 ; i++) {
            Map dataMap=new HashMap<>();
            dataMap.put("sn","sn"+i);
            dataMap.put("archivalcode","archivalcode-ww-2019"+i);
            dataMap.put("documentnumber","documentnumber"+i);
            dataMap.put("author","李抚原"+i);
            dataMap.put("title","就是很长的意思测试题目很长就是很长的意思就是很长的意1234567890就是很长的意思测试题目很长就是很长的意思就是很长的意1234567890"+i);
            dataMap.put("filedate","2019-01-01");
            dataMap.put("securityclassification","securityclassification"+i);
            dataMap.put("amountofpages","amountofpages"+i);
            dataMap.put("annotation","annotation"+i);
            dataMap.put("retentionperiod",i+"年");
            dataMap.put("copies","c"+i/8);

            dataMap.put("fondscode","fondscode"+i);
            dataMap.put("fondsname","fondsname"+i);
            dataMap.put("archivingyear","archivingyear"+i);
           // dataMap.put("retentionperiod","retentionperiod"+i);
            dataMap.put("deptabbname","deptabbname"+i);




            dataList.add(dataMap);
        }

         Map  paramsMap=new HashMap();
        paramsMap.put("retentionperiod","retentionperiod");
        paramsMap.put("copies","copies");



         String  filePath="E:\\Solr\\测试数据.xls";




         String  copyFilePath="E:\\Solr\\测试数据new"+TimeUtil.getCurrentTimeNanosOrMillis()+".xls";

        File oldFile=new  File(filePath);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String  time=df.format(new Date());// new Date()为获取当前系统时间



        File fileCopy=new  File(copyFilePath);


        FileUtils.copy( oldFile, fileCopy );

        Workbook hssfWorkbook = null;


        try{
            hssfWorkbook = new HSSFWorkbook(new FileInputStream(filePath));

        }catch ( Exception e){
            hssfWorkbook = new XSSFWorkbook(new FileInputStream(filePath));

        }


          int startRowIndex=0;
        Sheet s=null;



        //=========pages==============

        int nameNumbers=   hssfWorkbook.getNumberOfNames();

        Map  keyColnumMap=new HashMap();

        for (int i = 0; i <nameNumbers ; i++) {
            Name aNamedCell = hssfWorkbook.getNameAt(i);
            AreaReference[] arefs  = AreaReference.generateContiguous(aNamedCell.getRefersToFormula());
            org.apache.poi.ss.util.CellReference crefs = arefs[0].getFirstCell();

            String  key=    aNamedCell.getNameName();
            keyColnumMap.put(key,crefs);//储存字段的列位置
        }
        List<String> appendingList=new ArrayList(keyColnumMap.keySet());

        Sheet pagesSheet= hssfWorkbook.getSheet("封面");

        CellStyle pagesStyle = hssfWorkbook.createCellStyle();//创建格式
        Font fontPages = hssfWorkbook.createFont();
        fontPages.setColor(Font.COLOR_NORMAL);
        fontPages.setFontName("宋体");
        fontPages.setFontHeightInPoints((short) 23);
          pagesStyle.setFont(fontPages);
        for (String colKey : appendingList) {

            org.apache.poi.ss.util.CellReference aref=(org.apache.poi.ss.util.CellReference)keyColnumMap.get(colKey);

            Row row =pagesSheet.getRow(aref.getRow());
            Cell cell =row.createCell(aref.getCol()) ;
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
          cell.setCellStyle(pagesStyle);

            String value=(String) dataList.get(0).get(colKey);
            cell.setCellValue(value);


        }
        //=========pages end==============


        s = hssfWorkbook.getSheet("归档文件目录");

         String title="归  档  文  件  目  录";
        List<String>  columnNameList=new ArrayList<>();
//        List<String>  paramNameList=new ArrayList<>();


        columnNameList.add("序\r\n号");
        columnNameList.add("档   号");
        columnNameList.add("文  号");
        columnNameList.add("责任者");
        columnNameList.add("题   名");
        columnNameList.add("日\r\n期");
        columnNameList.add("密\r\n级");
        columnNameList.add("页\r\n数");
        columnNameList.add("备\r\n注");

        CellStyle titleStyle = hssfWorkbook.createCellStyle();//创建格式
        Font fontTitle = hssfWorkbook.createFont();
        fontTitle.setColor(Font.COLOR_NORMAL);
        fontTitle.setFontHeightInPoints((short) 23);
       // fontTitle.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

        titleStyle.setFont(fontTitle);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);


        CellStyle columnStyle = hssfWorkbook.createCellStyle();//创建格式
          columnStyle.setWrapText(true);
        Font columnFont = hssfWorkbook.createFont();
        columnFont.setColor(Font.COLOR_NORMAL);
        columnFont.setFontHeightInPoints((short) 15);
        // fontTitle.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

        columnStyle.setFont(columnFont);
        columnStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        columnStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        columnStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        columnStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        columnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        columnStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font font2 = hssfWorkbook.createFont();
        //font2.setFontName("仿宋_GB2312");
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font2.setFontHeightInPoints((short) 14);//设置字体大小
        columnStyle.setFont(font2);

        CellStyle  paramsStyle=hssfWorkbook.createCellStyle();

        paramsStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        paramsStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        for ( int i=0; i<dataList.size();i++) {

            if (i==0||i%8==0){
//            s.createRow((short) startRowIndex+1);
//            s.createRow((short) startRowIndex+2);
                Row  titleRow=      s.createRow((short) startRowIndex+1);

                  for ( int t=0; t<columnNameList.size()-1;t++) {
                       titleRow.createCell(t);
                  }
                    s.addMergedRegion(new CellRangeAddress(startRowIndex+1,startRowIndex+1,0,8));
                Cell        cell = titleRow.createCell(0);
                  cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                  cell.setCellStyle(titleStyle);
                  cell.setCellValue(title);
                startRowIndex=startRowIndex+2;
            }
            if (i==0||(i!=1&&i%8==0)){

                Row  colNameRow=      s.createRow((short) startRowIndex);
                for ( int t=0; t<columnNameList.size();t++) {
                    //String colKey =columnNameList.get(t);

                     if (t==columnNameList.size()-2){
                         s.addMergedRegion(new CellRangeAddress(startRowIndex,startRowIndex,columnNameList.size()-4,columnNameList.size()-3));
                         Cell  cell = colNameRow.createCell(columnNameList.size()-4);
                         cell.setCellStyle(paramsStyle);

                         String value="  ";
                          if (null!= dataList.get(i).get("retentionperiod")){
                              value=(String) dataList.get(i).get("retentionperiod");
                          }

                         cell.setCellValue("期限:"+value);

                     }
                     if (t==columnNameList.size()-1){

                         s.addMergedRegion(new CellRangeAddress(startRowIndex,startRowIndex,columnNameList.size()-2,columnNameList.size()-1));

                         Cell  cell = colNameRow.createCell(columnNameList.size()-2);
                         cell.setCellStyle(paramsStyle);

                         String value="  ";
                         if (null!= dataList.get(i).get("copies")){
                             value=(String) dataList.get(i).get("copies");
                         }

                        cell.setCellValue("盒号:"+value);
                     }

                }


                startRowIndex=startRowIndex+1;
            }


            if (i==0||(i!=1&&i%8==0)){
                Row  colNameRow=      s.createRow((short) startRowIndex);

                    for ( int t=0; t<columnNameList.size();t++) {
                        String colKey =columnNameList.get(t);
                    Cell  cell = colNameRow.createCell(t);
                    cell.setCellStyle(columnStyle);

                    cell.setCellValue(colKey);
                }
              startRowIndex=startRowIndex+1;
            }

            Map itemMap=dataList.get(i);
            Row row = s.createRow((short) startRowIndex);


            CellStyle cellStyle = hssfWorkbook.createCellStyle();
            // 水平方向上居中对齐
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);




            //cellStyle.setFont(new F\);

            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle.setWrapText(true);
            CellStyle minColumnStyle = hssfWorkbook.createCellStyle();
            // 水平方向上居中对齐
            minColumnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            minColumnStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);


            minColumnStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            minColumnStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            minColumnStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            minColumnStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            minColumnStyle.setWrapText(true);
            // List<String>  KeyList= new   ArrayList(itemMap.keySet());

            for (int t=0;t<columnNameList.size();t++) {

                String colKey= keyList.get(t) ;
                String value=(String) itemMap.get(colKey) ;
                Cell cell = row.createCell((short) t);

                // 定义单元格为字符类型，也可以指定为日期类型、数字类型
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                  if ("sn".equals(colKey)){
                     value=i+1+"";
                  }

                  if ("title".equals(colKey)){
                    row.setHeightInPoints(60);
                  }


                if ("sn".equals(colKey)||"securityclassification".equals(colKey)||"amountofpages".equals(colKey)||"annotation".equals(colKey)){
                    cell.setCellStyle(minColumnStyle);
                   s.setColumnWidth(t, 8*256);
                }else{

                    if ("documentnumber".equals(colKey)) {

                        s.setColumnWidth(t,20*256);
                    }
                    else if ("author".equals(colKey)) {

                        s.setColumnWidth(t, 12*256);
                    }
                    else if ("filedate".equals(colKey)) {

                        s.setColumnWidth(t, 12*256);
                    }

                    else if ("archivalcode".equals(colKey)) {

                        s.setColumnWidth(t, 23*256);
                    }
                   else  if ("title".equals(colKey)) {

                        s.setColumnWidth(t, 40*256);
                    }

                    cell.setCellStyle(cellStyle);
                }




                cell.setCellValue(value);

            }
            startRowIndex=startRowIndex+1;
        }


        FileOutputStream  out= new  FileOutputStream(fileCopy.getAbsoluteFile());

        hssfWorkbook.write(out);

        out.close();

    }

     public void execPages(){

     }


}
