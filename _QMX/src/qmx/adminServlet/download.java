package qmx.adminServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import qmx.jdbc.MysqlConnection;
import qmx.service.adminService;



/**
 * Servlet implementation class download
 */
@WebServlet("/download")
public class download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HSSFWorkbook wb =  new HSSFWorkbook();
		String headers[] = { "姓名", "学号", "学院", "专业","QQ号","联系方式","性别","组别"};// 标题
        adminService adminService = new adminService();
        ResultSet rs = null;
        MysqlConnection MyConn = new MysqlConnection();
        Connection connection = null;
		try {
			connection = MyConn.getConnection();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        rs = adminService.doDownload(connection);
        try {
			fillExcelData(rs, wb, headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
			export(response, wb, "order.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
     * 导出用户
     * 
     * @throws Exception
     */
    public void fillExcelData(ResultSet rs, HSSFWorkbook wb, String[] headers)
            throws Exception {
        int rowIndex = 0; // 第一行
        Sheet sheet = wb.createSheet(); // 创建sheet页
        Row row = sheet.createRow(rowIndex++);
        // 创建标题
        CellStyle style =  wb.createCellStyle();
        HSSFFont font = wb.createFont();
        font.setColor((short) 0);
        font.setFontHeightInPoints((short) 14);
        font.setFontName("宋体");
        style.setFont(font);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);   
        for (int i = 0; i < headers.length; i++) {
        	row.setHeight((short)350);
            row.createCell(i).setCellValue(headers[i]);
            row.getCell(i).setCellStyle(style); 
        }
        
        // 导出数据库中的数据
        CellStyle style1 =  wb.createCellStyle();
        HSSFFont font1 = wb.createFont();
        font1.setFontHeightInPoints((short) 14);
        font1.setFontName("宋体");
        style1.setFont(font1);
        while (rs.next()) {
            row = sheet.createRow(rowIndex++);
            for (int i = 0; i < headers.length; i++) {
            	row.setHeight((short)350);
            	sheet.setColumnWidth((short)i,(short)6000);
                row.createCell(i).setCellValue(rs.getObject(i + 1).toString());
                row.getCell(i).setCellStyle(style1); 
                //rs.getObject(i + 1)得到一个对象，即数据库中一行的结果，每一列就是属性凑成一行变成对象。因为id是从1开始，所以要+1。
            }
        }
    }
    
    /**
     * 把数据放入到.xls文件中并下载到本地
     * 
     * @param response
     * @param wb
     * @param fileName
     * @throws Exception
     */
    public void export(HttpServletResponse response, HSSFWorkbook wb,
            String fileName) throws Exception {
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(fileName.getBytes("utf-8"), "iso8859-1"));// 设置头信息
        response.setContentType("application/ynd.ms-excel;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        wb.write(out);// 进行输出，下载到本地
        out.flush();
        out.close();
    }
}
