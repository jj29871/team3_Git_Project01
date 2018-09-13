package download;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.dto.DeptDto;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;



public class NoticeListPdfView extends AbstractPdfView {
	private String fontPath = "c:\\windows\\Fonts\\malgun.ttf";

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<DeptDto> pageRanks = (List<DeptDto>) model.get("noticeList");
		Table table = new Table(3, pageRanks.size() + 1);
		table.setPadding(5);
		
		BaseFont bfKorean = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);

		Font font = new Font(bfKorean);
		Cell cell = new Cell(new Paragraph("Deptno", font));
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("Dname", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("Loc", font));
		table.addCell(cell);
		table.endHeaders();

		for (DeptDto rank : pageRanks) {
			table.addCell(String.valueOf(rank.getDeptno()));
			table.addCell(rank.getDname());
			table.addCell(rank.getLoc());
			
		}
		document.add(table);
	}

	public void setFontPath(String fontPath) {
		this.fontPath = fontPath;
	}

}
