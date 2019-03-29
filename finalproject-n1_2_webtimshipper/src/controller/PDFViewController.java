package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.SearchOrder;
import model.UserOrder;

@WebServlet(name = "pdfViewServlet", value = "/home-shop/pdf")
public class PDFViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public PDFViewController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=ds_van_don.pdf");
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			Paragraph title = new Paragraph("DANH SACH VAN DON");
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			PdfPTable table = new PdfPTable(new float[] { 1, 2, 2, 2, 2, 2, 2 });
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell("1");
			table.addCell("2");
			table.addCell("3");
			table.addCell("4");
			table.addCell("7");
			table.addCell("8");
			table.addCell("9");

			SearchOrder searchOrder = new SearchOrder();
			List<UserOrder> orders = userOrderDAO.searchOrder(searchOrder);
			orders.forEach(order -> {
				table.addCell(order.getId().toString());
				table.addCell(order.getContent());
				table.addCell(order.getLat1().toString());
				table.addCell(order.getLat2().toString());
				table.addCell(order.getFee().toString());
				table.addCell(order.getCreatedDate().toString());
				if (order.getStatus() == 1) {
					table.addCell("thành công");
				} else {
					table.addCell("đang xử lý");
				}
			});

			document.add(table);
			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@SuppressWarnings("unused")
	private Document createPDF() throws DocumentException {
		Document document = new Document();
		document.open();
		Paragraph title = new Paragraph("DANH SACH VAN DON");
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		PdfPTable table = new PdfPTable(new float[] { 1, 2, 2, 2, 2, 2, 2 });
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("1");
		table.addCell("2");
		table.addCell("3");
		table.addCell("4");
		table.addCell("7");
		table.addCell("8");
		table.addCell("9");

		SearchOrder searchOrder = new SearchOrder();
		List<UserOrder> orders = userOrderDAO.searchOrder(searchOrder);
		orders.forEach(order -> {
			table.addCell(order.getId().toString());
			table.addCell(order.getContent());
			table.addCell(order.getLat1().toString());
			table.addCell(order.getLat2().toString());
			table.addCell(order.getFee().toString());
			table.addCell(order.getCreatedDate().toString());
			if (order.getStatus() == 1) {
				table.addCell("thanh cong");
			} else {
				table.addCell("that bai");
			}
		});

		document.add(table);
		return document;
	}

}
