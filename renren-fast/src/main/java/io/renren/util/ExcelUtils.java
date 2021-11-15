package io.renren.util;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lf
 * @描述 Excel工具类
 * @date 2020-9-26 20:33:43
 */
public class ExcelUtils {

    /**
     *  导出Excel
     * @param map 表头说明
     * @param list 要导出的数据
     * @param response
     * @param fileName 文件名字
     * @throws IOException
     */
    public static void export(Map<String, String> map, List<?> list, HttpServletResponse response, String fileName) throws IOException {

        Workbook workbook = new SXSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("导出数据");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // Create a Row
        Row headerRow = sheet.createRow(0);

        final Integer[] count = {0};

        // Create cells
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 设置表头样式
        for (Map.Entry<String, String> entry : entries) {
            Cell cell = headerRow.createCell(count[0]);
            cell.setCellValue(entry.getValue());
            cell.setCellStyle(headerCellStyle);
            ++count[0];
        }

        Set<String> mapKey = map.keySet();

        Class<?> aClass = list.get(0).getClass();

        int size = list.size();

        // 设置内容的样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        for (int i = 0; i < size; i++) {
            int j = 0;

            Row row = sheet.createRow(i + 1);

            for (String r : mapKey) {
                try {
                    Cell cell = row.createCell(j);
                    cell.setCellStyle(cellStyle);

                    //String name = "get" + r.substring(0, 1).toUpperCase() + r.substring(1).toLowerCase();
                    String name = "get" + r;
                    Method method = aClass.getDeclaredMethod(name);
                    Object object = list.get(i);

                    Object value = method.invoke(object);

                    // 去除值为null的字段数据
                    if (null == value || "null".equals(value)) {
                        value = "";
                    }else {
                        // 日期格式的进行转换
                        Type type = method.getGenericReturnType();
                        if (type.getTypeName().equals("java.util.Date")) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            value = sdf.format(value);
                        }
                    }

                    cell.setCellValue(String.valueOf(value));
                    j++;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < map.keySet().size(); i++) {
            //sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, 20 * 256);
        }


        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName.trim(), "UTF-8") + ".xlsx");
        OutputStream outputStream = response.getOutputStream();

        workbook.write(outputStream);

        outputStream.flush();
        outputStream.close();
        workbook.close();

    }

    /**
     * 下载Excel表格
     * @param res
     * @param path Excel文件所在的路径
     * @param fileName 文件的名称
     */
    public static void downloadExcel(HttpServletResponse res,String path,String fileName){
        String exampleFilePath = path + fileName;
        File excelFile = new File(exampleFilePath);
        res.setCharacterEncoding("UTF-8");
        res.setHeader("content-type", "application/octet-stream;charset=UTF-8");
        res.setContentType("application/octet-stream;charset=UTF-8");
        //加上设置大小下载下来的.xlsx文件打开时才不会报“Excel 已完成文件级验证和修复。此工作簿的某些部分可能已被修复或丢弃”
        res.addHeader("Content-Length", String.valueOf(excelFile.length()));
        try {
            res.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName.trim(), "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(exampleFilePath)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
          /* throw new BusinessException("下载io异常： " + e.getMessage());*/
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
        }
    }

    private static final String XLS = "xls";
    private static final String XLSK = "xlsx";

    /**
     * 导入文件
     * @param file
     * @return
     * @throws Exception
     */
    public static Sheet importExcel(MultipartFile file) {
        Workbook workbook = null;
        String fileName = file.getOriginalFilename();
        if(fileName.endsWith(XLS)) {
            //2003
            try {
                workbook = new HSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                //throw new BusinessException("2003 初始化异常");
            }
        }else if(fileName.endsWith(XLSK)) {
            try {
                //2007
                workbook = new XSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                /*throw new BusinessException("2007 初始化异常");*/
            }
        }else {
            //throw new BusinessException("文件不是Excel文件");
        }
        return workbook.getSheet("Sheet1");
    }

    public static String getCellValue(Cell cell) {
        String value = "";
        if(cell != null) {
            //以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC://数字
                    value = cell.getNumericCellValue() + "";
                    if(HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if(date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        }else {
                            value = "";
                        }
                    }else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: //字符串
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: //boolean
                    value = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: //公式
                    value = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: //空值
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: //故障
                    // 非法字符
                    value = "";
                    break;
                default:
                    // 未知类型
                    value = "";
                    break;
            }
        }
        return value.trim();
    }

}
