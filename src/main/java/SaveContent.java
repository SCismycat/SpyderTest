import com.csvreader.CsvWriter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Leslee on 2018/7/20.
 */
//存储相关内容
public class SaveContent {
// 写为txt
    public void saveContent_Txt(List<String> contents) throws IOException{
        File file = new File("E:\\企业地址抽取\\baike.txt");
        FileWriter fileWriter = new FileWriter(file);
        for(int i= 0;i < contents.size();i++){
            fileWriter.write(contents.get(i));
            fileWriter.write("/r/n");
            fileWriter.flush();
        }
    }
    //写为csv
    public void saveContent_Csv(List<String> contents ) throws IOException{
        String csvFile = "E:\\企业地址抽取\\baike.csv";
        try {
            CsvWriter csvWriter = new CsvWriter(csvFile, ' ', Charset.defaultCharset());
            String[] csvHeaders = {"ID","content"};
            csvWriter.writeRecord(csvHeaders);
            String r = RandomStringUtils.random(8);
            r = RandomStringUtils.random(8, new char[] { 'a', 'b', 'c', 'd', 'e',
                    'f', 'g','h','i','1', '2', '3' });
            for (int i=0;i<contents.size();i++){
                r = RandomStringUtils.randomAlphanumeric(8);
                String[] csvContent = {r , contents.get(i)};
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println("------写入完成-------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
