package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.SearchOrder;
import model.UserOrder;

@WebServlet(name = "exportExcelServlet", value = "/home-shop/excel")
public class ExportExcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public ExportExcelController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ds_van_don.xls");
		HSSFWorkbook workbook = createExcel();
		workbook.write(response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private HSSFWorkbook createExcel() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("DANH SACH VAN DON");
		sheet.setDefaultColumnWidth(30);
		SearchOrder searchOrder = new SearchOrder();
		List<UserOrder> orders = userOrderDAO.searchOrder(searchOrder);

		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFont(font);

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("MÃ VẬN ĐƠN");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("NỘI DUNG");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("ĐIỂM NHẬN HÀNG");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("ĐIỂM GIAO HÀNG");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("CƯỚI PHÍ");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("NGÀY ĐĂNG");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("TRẠNG THÁI");
		header.getCell(6).setCellStyle(style);

		int rowCount = 1;

		for (UserOrder order : orders) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.setRowStyle(style);
			aRow.createCell(0).setCellValue(order.getId());
			aRow.createCell(1).setCellValue(order.getContent());
			aRow.createCell(2).setCellValue(order.getLat1());
			aRow.createCell(3).setCellValue(order.getLat2());
			aRow.createCell(4).setCellValue(order.getFee());
			aRow.createCell(5).setCellValue(order.getCreatedDate());
			if (order.getStatus() == 1) {
				aRow.createCell(6).setCellValue("thành công");
			} else {
				aRow.createCell(6).setCellValue("đang xử lý");
			}

		}

		return workbook;
	}

}
