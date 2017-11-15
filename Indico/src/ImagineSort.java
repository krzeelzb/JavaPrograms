import io.indico.api.utils.IndicoException;

import java.io.IOException;

public class ImagineSort {
    public static void main(String[] args) throws IOException, IndicoException, NotAPhotoInsideDirectory {
        try {
        ImgSort tmp=new ImgSort();
        String key="63518acb5d3b0edd4db938ba2193f047";
        String path="/home/ela/Pulpit/foto";
        tmp.orderDirectory(path,key);
        }catch (Exception e){
        } catch (DirectoryNotExists directoryNotExists) {
            directoryNotExists.printStackTrace();
        } catch (NoInternet noInternet) {
            noInternet.printStackTrace();
        }
    }
}
