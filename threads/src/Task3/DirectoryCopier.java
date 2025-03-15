package Task3;

import java.io.*;

public class DirectoryCopier implements Runnable {
    private File sourceDir;
    private File destDir;
    private int fileCount;
    private int dirCount;

    public DirectoryCopier(File sourceDir, File destDir) {
        this.sourceDir = sourceDir;
        this.destDir = destDir;
    }

    @Override
    public void run() {
        try { copyDirectory(sourceDir, destDir); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private void copyDirectory(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdirs();
                dirCount++;
            }
            String[] children = source.list();
            if (children != null) for (String child : children) copyDirectory(new File(source, child), new File(destination, child));
        } else {
            copyFile(source, destination);
            fileCount++;
        }
    }

    private void copyFile(File source, File dest) throws IOException {
        try (InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer)) > 0) out.write(buffer, 0, length);
        }
    }

    public int getFileCount() { return fileCount; }

    public int getDirCount() { return dirCount; }
}
