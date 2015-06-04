/**
 * This class will generate relative path to this project.
 * @author Phryxia
 *
 */
public class RelativePath
{
	public static String getAbsolutePath(String filename)
	{
		return System.getProperty("user.dir") + "\\" + filename;
	}
}
