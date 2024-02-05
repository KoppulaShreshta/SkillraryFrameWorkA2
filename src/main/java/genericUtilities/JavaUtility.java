package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	/**
	 * This class contains reusable methods to perform java related operations
	 * @author MUNI SRI VASTAVA
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_mm_ss");
		return sdf.format(date);
		
		
		
	}

}
