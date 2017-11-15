import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImgSort {
    public void orderDirectory(String _path,String key) throws NotAPhotoInsideDirectory, IndicoException, IOException, DirectoryNotExists, NoInternet {
        File directory = new File(_path);
        if(!directory.exists()){
            throw  new DirectoryNotExists();
        }
        else {
        File[] files = directory.listFiles();
        List<File> photos = new LinkedList<File>();

        for (File f : files) {
            if (f.isFile() && f.getAbsolutePath().matches(".*\\.jpg")) {
                photos.add(f);
            }else
             throw new NotAPhotoInsideDirectory();
        }

        for (File f : photos) {
            if(InetAddress.getLocalHost().isReachable(5)) {
                Indico indico = new Indico(key);
                IndicoResult single = indico.imageRecognition.predict(f);
                Map<String, Double> result = single.getImageRecognition();

                double tmpValue = 0;
                String tmpName = "";

                Set<Map.Entry<String, Double>> entrySet = result.entrySet();
                for (Map.Entry<String, Double> entry : entrySet) {
                    if (entry.getValue() > tmpValue) {
                        tmpValue = entry.getValue();
                        tmpName = entry.getKey();
                    }
                }
                File dir = new File(f.toString());
                File newDir = new File(_path + "/" + tmpName);
                if (!newDir.exists()) {
                    Files.createDirectory(Paths.get(_path + "/" + tmpName));
                    dir.renameTo(new File(_path + "/" + tmpName + "/" + f.getName()));
                } else
                    dir.renameTo(new File(_path + "/" + tmpName + "/" + f.getName()));
            }
            else throw new NoInternet();
        }
        }
    }
}

