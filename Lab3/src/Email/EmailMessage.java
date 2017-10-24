package Email;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;



public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional


    protected EmailMessage() {
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public static class Builder {
        public final EmailMessage instance = new EmailMessage();

        public Builder() {
        }

        public Builder addFrom(String from_) {
            instance.from = from_;
            return this;
        }

        public Builder addTo(String to_) {
            if(instance.to==null){
                instance.to= new LinkedList<String>();
            }
            instance.to.add(to_) ;
            return this;
        }

        public Builder addSubject(String subject_) {
            instance.subject = subject_;
            return this;
        }

        public Builder addcontent(String content_) {
            instance.content = content_;
            return this;
        }

        public Builder mimeType(String mimeTypeName) {
            instance.mimeType = mimeTypeName;
            return this;
        }

        public EmailMessage build() {
            return instance;
        }
    }

    public void send(){

        final String username = this.from;

        final String password;
        Scanner ss = new Scanner(System.in);
        System.out.println("Podaj hasło");
        password = ss.nextLine();


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));

            for (String a : this.to) {
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(a));
            }
            message.setSubject(this.subject);
            message.setText(this.content);
            message.isMimeType(this.mimeType);

            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}





