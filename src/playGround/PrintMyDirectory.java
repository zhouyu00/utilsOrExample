package playGround;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PrintMyDirectory {
    public static void main(String[] args) {
        String defaultPath = "E:\\";
        Path root = Paths.get(defaultPath);

        String targetPath = "E:\\target";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String targetName = simpleDateFormat.format(new Date()) + ".txt";
        Path targetDir = Paths.get(targetPath);
        Path target = Paths.get(targetPath, targetName);
        try {
            if(!Files.exists(targetDir))Files.createDirectories(targetDir);
            if(!Files.exists(target)) Files.createFile(target);
            BufferedWriter writer = Files.newBufferedWriter(target, StandardCharsets.UTF_8);
            List<File> fileList = Files.list(root).map(Path::toFile).collect(Collectors.toList());
            for(File file:fileList)
            {
                writer.write(file.getName());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(target.toString());
    }
}
