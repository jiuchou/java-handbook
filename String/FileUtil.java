import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class FileUtil {
    private final static Logger logger = Logger.getLogger(FileUtil.class.getName());

    /**
     * Save content(String) to file.
     *
     * @param filename
     *          file name
     * @param content
     *          file content
     */
    public void saveFile(String filename, String content) {
        File file = new File(filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.severe("File write content failed!\n".concat(e.toString()));
            System.exit(1);
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                logger.severe("Close FileWriter failed!\n".concat(e.toString()));
                System.exit(1);
            }
        }
    }

    /**
     * Judge whether a file exists. If not exists, create a empty file.
     *
     * @param filename
     *          file name
     */
    public void judgeFileExists(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Yang: File " + filename + " exists!");
        } else {
            System.out.println("Yang: File " + filename + " not exists, create it...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
