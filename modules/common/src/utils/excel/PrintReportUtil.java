package utils.excel;


import com.mw.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建:林党宏
 * 日期: 2017/11/6 15:52
 * 注释：打印导出工具类
 * **/

public class PrintReportUtil {

    public static byte[] export(ReportData report,String[]  msgTitle) throws Exception {
        byte[] bytes = null;
        // add code here .
        if (report != null) {

            //输出的文件名
            String fileName = report.getFileName();

            //所有需要输出的key项
            List<String> keys = report.getExportMetaKeys();

            //所有项标题
            Map metas = report.getMetas();
            //所有需要输出的数据
            List<Map> datalist = report.getData();

//            XSSFWorkbook workBook = new XSSFWorkbook();//创建工作薄

//            String  tempDirPath="E:";
            String tempDirPath = "e:";


            Workbook workBook = null;
//            try {
//                workBook = new XSSFWorkbook(new FileInputStream(tempDirPath));
//            } catch (Exception ex) {
//                try {
                    workBook = new HSSFWorkbook();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

            Sheet sheet = workBook.createSheet();
            initHeaders(workBook, sheet,msgTitle);

            insertData(workBook, sheet, datalist, keys);



            File tempDir = new File(tempDirPath);
            File file = FileUtils.createFile(tempDir, report.getFileName());
            FileOutputStream outStream = new FileOutputStream(file);
            workBook.write(outStream);




            outStream.flush();
            outStream.close();

            bytes = IOUtils.read(new FileInputStream(file));
            file.getAbsoluteFile().delete();

        }
        return bytes;
    }


    private static void setValue(Cell cell, CellStyle style, short alignment, Object value) {
        cell.setCellValue((String)value);
       // cell.setCellType(XSSFCell.CELL_TYPE_STRING);
      //  style.setAlignment(alignment);
        cell.setCellStyle(style);
    }

    /**
     * 初始化标题头部

     */
    private static void initHeaders(Workbook workBook, Sheet sheet, String[]  msgTitle) {
       String title="轨道交通执法大队执法文书印制计划表";
        workBook.setSheetName(0, title);//工作簿名称
       Font font = workBook.createFont();
        font.setColor(Font.COLOR_NORMAL);
        //font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

        CellStyle cellStyle = workBook.createCellStyle();//创建格式
        cellStyle.setFont(font);
       // cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
       // cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        Cell cell;

//        String[] msgTitle ={"批次号","","编制人","","","编制时间",""};
        int colCount = msgTitle.length;
        //创建第一行标题
        Row titleRow1 = sheet.createRow((short) 0);
        titleRow1.setHeightInPoints(30);
        cell = titleRow1.createCell(0, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(title);
        //sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
        String[] titles2 ={"序号","文书名称","计划印制数量（本）","开始编号","结束编号","单价（元）","合计（元）"};
        int colCount2 = titles2.length;
        //创建第二行标题
       Row titleRow2 = sheet.createRow((short) 1);


        for (int col = 0; col < colCount; col++) { //创建第1行标题单元格
            if (col==1){
                sheet.setColumnWidth(col, 11000);
            }
            else if (col==2){
                sheet.setColumnWidth(col, 5000);

            }
            else if (col==6){
                sheet.setColumnWidth(col, 5000);

            }
            else{
                sheet.setColumnWidth(col, 3000);
            }
            cell = titleRow2.createCell(col);
            cell.setCellStyle(cellStyle);
           // cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            String key =msgTitle[col];
            cell.setCellValue(key);

        }

        //创建第三行标题
        Row titleRow3 = sheet.createRow((short) 2);//第一行标题
        for (int col = 0; col < colCount2; col++) { //创建第1行标题单元格
            if (col==1){
                sheet.setColumnWidth(col, 11000);
            }
           else if (col==2){
                sheet.setColumnWidth(col, 5000);

            }
           else  if (col==6){
                sheet.setColumnWidth(col, 5000);

            }
            else{
                sheet.setColumnWidth(col, 3000);
            }
            cell = titleRow3.createCell(col);
            cell.setCellStyle(cellStyle);
            //cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            String key =titles2[col];
            cell.setCellValue(key);

        }

    }

    /**
     * 开始插入数据
     */
    private static void insertData(Workbook workBook, Sheet sheet, List<Map> data,
                                   List<String> keys) {
        //从第二行开始写入数据
        //注：此处如果数据过多，会抛出java.lang.IllegalStateException异常：The maximum number of cell styles was exceeded.
        //You can define up to 4000 styles in a .xls workbook。这是是由于cell styles太多create造成，故一般可以把cellstyle设置放到循环外面

        CellStyle style = workBook.createCellStyle();//创建格式
        Row xssRow;
        Cell xssCell;
        if (data != null && data.size() > 0) {
            final int columnCount = keys.size();
            List<ExcelRowModel> cell;

            int beginRow =3;

            for (int row = 0; row < data.size(); row++) {
                xssRow = sheet.createRow(beginRow);

                Map map = data.get(row);

                for (int col = 0; col < columnCount; col++) {
                   // 在上面行索引0的位置创建单元格

                    xssCell = xssRow.createCell((short) col);

//                    if (col == 0){
//                        setValue(xssCell, style, XSSFCellStyle.ALIGN_CENTER, row+1);
//                    }else {
                        Object value = map.get(keys.get(col)) == null?"":map.get(keys.get(col));
                        setValue(xssCell, style, XSSFCellStyle.ALIGN_CENTER, value);
//                    }
                }
                beginRow++;
            }
        }
    }

    /**
     * @param bytes
     * @return
     */
    public ReportData imp(byte[] bytes) throws IOException {
        ReportData rd = new ReportData();
        XSSFWorkbook workBook = new XSSFWorkbook(new ByteArrayInputStream(bytes));//创建工作薄
        XSSFSheet sheet = workBook.getSheetAt(0);
        Row xssRow = sheet.getRow(0);
        Map meta = new LinkedHashMap();
        int maxCols = xssRow.getLastCellNum();
        for (int i = 0; i < maxCols; i++) {
            meta.put("col" + i, xssRow.getCell(i));
        }
        rd.setMetas(meta);
        List<Map> data = new ArrayList<>();
        int len = sheet.getLastRowNum();
        Map d;
        for (int i = 1; i <= len; i++) {
            xssRow = sheet.getRow(i);
            d = new LinkedHashMap();
            for (int l = 0; l < maxCols; l++) {
                d.put("col" + l, getStrValue(xssRow.getCell(l)));
            }
            data.add(d);
        }
        rd.setData(data);
        return rd;
    }

    private String getStrValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        String s = cell.getStringCellValue();
        return (s == null) ? "" : cell.toString();
    }
}
