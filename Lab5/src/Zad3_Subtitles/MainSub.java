package Zad3_Subtitles;

public class MainSub {
    public static void main(String[] args) throws NegativeFrameAfterShift, InvalidSubtitleLineFormat, SubtitleEndBeforeStart {
        MicroDvdSubtitles subtitles_ = new MicroDvdSubtitles("/home/ela/Pulpit/gravity.txt", "1.txt");
        try {
            subtitles_.delay("/home/ela/Pulpit/gravity.txt", "/home/ela/Pulpit/1.txt", 300, 25);
        }catch (Exception e){
        } catch (InvalidSubtitleLine invalidSubtitleLine) {
            invalidSubtitleLine.printStackTrace();
        }
    }
}
