package cn.itcast.itcaststore.utils;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 鍙戦�侀偖浠剁殑宸ュ叿绫�
 */
public class MailUtils {
	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
		// 1.鍒涘缓涓�涓▼搴忎笌閭欢鏈嶅姟鍣ㄤ細璇濆璞� Session
		Properties props = new Properties();
		// 璁剧疆閭欢浼犺緭鍗忚涓篠MTP
		props.setProperty("mail.transport.protocol", "SMTP");
		// 璁剧疆SMTP鏈嶅姟鍣ㄥ湴鍧�
		props.setProperty("mail.host", "smtp.163.com");
		// 璁剧疆SMTP鏈嶅姟鍣ㄦ槸鍚﹂渶瑕佺敤鎴烽獙璇侊紝闇�瑕侀獙璇佽缃负true
		props.setProperty("mail.smtp.auth", "true");
		// 鍒涘缓楠岃瘉鍣�
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("xyx131prince", "DG131prince");
			}
		};
		Session session = Session.getInstance(props, auth);
		// 2.鍒涘缓涓�涓狹essage锛屽畠鐩稿綋浜庢槸閭欢鍐呭
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("xyx131prince@163.com")); // 璁剧疆鍙戦�佽��
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 璁剧疆鍙戦�佹柟寮忎笌鎺ユ敹鑰�
		message.setSubject("用户激活");
		// message.setText("杩欐槸涓�灏佹縺娲婚偖浠讹紝璇�<a href='#'>鐐瑰嚮</a>");
		message.setContent(emailMsg, "text/html;charset=utf-8");
		// 3.鍒涘缓 Transport鐢ㄤ簬灏嗛偖浠跺彂閫�
		Transport.send(message);
	}
}
