package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductsObjectsFromData {
	public static FileInputStream file;
	public static XSSFWorkbook wb;
	

	public static Products writeRowIntoProduct(int r) throws FileNotFoundException, IOException {
		try {
		file = new FileInputStream("Products.xlsx");
		wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("data");
		Row row = sheet.getRow(r);
		Cell cell;
		String name, id, sh_desc, lng_desc;
		double price, weight, handeling;
		boolean tangible;

		Products product = new Products();
		
		// Reading from data set and creating an object of the class Products:

				// field NAME
				cell = row.getCell(0);
				name = cell.toString();
				product.setName(name);

				// field ID
				cell = row.getCell(1);
				id = cell.toString();
				product.setId(id);

				// field short_description
				cell = row.getCell(2);
				sh_desc = cell.toString();
				product.setDescription(sh_desc);

				// field long_description
				cell = row.getCell(3);
				lng_desc = cell.toString();
				product.setLong_description(lng_desc);

				// field price
				cell = row.getCell(4);
				price = cell.getNumericCellValue();
				product.setPrice(price);

				// field tangible y/n
				cell = row.getCell(5);
				tangible = cell.getBooleanCellValue();
				product.setTangible(tangible);

				// field weight
				cell = row.getCell(6);
				weight = cell.getNumericCellValue();
				product.setPrice(weight);

				// field weight
				cell = row.getCell(6);
				handeling = cell.getNumericCellValue();
				product.setPrice(handeling);

				return product;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Products product1 = new Products();
			return product1;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Products product2 = new Products();
			return product2;
			
		} catch (ExceptionInInitializerError e) {
			e.printStackTrace();
			Products product2 = new Products();
			return product2;
		}

		
	}

	

}
