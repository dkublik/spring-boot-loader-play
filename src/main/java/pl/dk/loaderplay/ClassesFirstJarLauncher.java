package pl.dk.loaderplay;

import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.archive.Archive;

import java.net.MalformedURLException;
import java.util.List;

public class ClassesFirstJarLauncher extends JarLauncher {

    @Override
    protected void postProcessClassPathArchives(List<Archive> archives) throws MalformedURLException {
        for (int i = archives.size() - 1; i >= 0; i++) {
            Archive archive = archives.get(i);
            if (archive.getUrl().getPath().endsWith("/classes!/")) {
                archives.remove(archive);
                archives.add(0, archive);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new ClassesFirstJarLauncher().launch(args);
    }

}
