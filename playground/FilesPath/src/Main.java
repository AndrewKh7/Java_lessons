import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Main {
    final static String ext = ".txt";

    public static void main(String... args)  {
        Path path = Paths.get(args[0]);
        List<Path> files = null;
        try {
            files = getTextFileListFrom(path,ext);
        } catch (IOException e) {
            System.err.println("Directory not found");
        }

        files.sort((p1,p2) -> p1.getFileName().compareTo(p2.getFileName()));

        files.forEach(v -> {
            System.out.println(v.getFileName() + " -> " + v);
        });


        Path resultFile = Paths.get("./resultFile.txt");
//        if (!Files.exists(resultFile)) Files.createFile(resultFile);
        try( OutputStream out = Files.newOutputStream(resultFile, StandardOpenOption.CREATE)) {
            files.forEach(v -> {
                try (InputStream in = Files.newInputStream(v, StandardOpenOption.READ)) {
                    in.transferTo(out);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.err.println("failed to create result file.");
        }
    }

    static List<Path> getTextFileListFrom(Path folder, String ext) throws IOException {
        List<Path> files = new ArrayList<>();
        Path res = Files.walkFileTree(folder, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(ext))
                    files.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
        return files;
    }
}
