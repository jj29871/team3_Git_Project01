package download;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.dto.DeptDto;



public class NoticeListExelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"pagerank.xls\";");

		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		List<DeptDto> noticelist = (List<DeptDto>) model.get("noticeList");
		int rowNum = 1;
		for (DeptDto rank : noticelist) {
			createPageRankRow(sheet, rank, rowNum++);
		}
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("Deptno");
		cell = firstRow.createCell(1);
		cell.setCellValue("Dname");
		cell = firstRow.createCell(2);
		cell.setCellValue("loc");
		
	}

	private void createPageRankRow(HSSFSheet sheet, DeptDto rank, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getDeptno());

		cell = row.createCell(1);
		cell.setCellValue(rank.getDname());
		
		cell = row.createCell(2);
		cell.setCellValue(rank.getLoc());

	}

}
