package Email;

public class EmailMain {
    public static void main(String[] argv){



        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("krzeczekelzbieta@gmail.com")
                .addTo("elakrz@gmail.com")
                .addSubject("Mail testowy")
                .addcontent("Brak tresci")
                .build();
        wiadomosc.send();
    }
}

