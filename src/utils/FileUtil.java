package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FileUtil {
    /**
     * 文件排序列表
     * @param path
     * @return
     * @throws IOException
     */
    public static List<File> listDir(String path) throws IOException{
        Path dirPath = Paths.get(path);
        if(Files.isDirectory(dirPath)){
            Comparator<File> comparing = (o1, o2) -> Collator.getInstance(Locale.CHINESE).compare(o1.getName(),o2.getName());
            return Files.list(dirPath).map(Path::toFile).sorted(comparing).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
