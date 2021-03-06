package com.hotyum.stars.utils;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午1:56:14 
 */
public class MailUtil {
	private MimeMessage mimeMsg; // MIME邮件对象
	private Session session; // 邮件会话对象
	private Properties props; // 系统属性
	private boolean needAuth = false; // smtp是否需要认证
	// smtp认证用户名和密码
	private String username;
	private String password;
	private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象

	private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

	/**
	* Constructor
	* @param smtp 邮件发送服务器
	*/
	public MailUtil(String smtp) {
		setSmtpHost(smtp);
		createMimeMessage();
	}

	/**
	* 设置邮件发送服务器
	* @param hostName String
	*/
	public void setSmtpHost(String hostName) {
		System.out.println("设置系统属性：mail.smtp.host = " + hostName);
		if (props == null)
			props = System.getProperties(); // 获得系统属性对象
		props.put("mail.smtp.host", hostName); // 设置SMTP主机
	}

	/**
	* 创建MIME邮件对象 
	* @return
	*/
	public boolean createMimeMessage() {
		try {
			logger.info("准备获取邮件会话对象！");
			session = Session.getDefaultInstance(props, null); // 获得邮件会话对象
		} catch (Exception e) {
			logger.error("获取邮件会话对象时发生错误！" + e);
			return false;
		}

		logger.info("准备创建MIME邮件对象！");
		try {
			mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
			mp = new MimeMultipart();

			return true;
		} catch (Exception e) {
			logger.error("创建MIME邮件对象失败！" + e);
			return false;
		}
	}

	/**
	* 设置SMTP是否需要验证
	* @param need
	*/
	public void setNeedAuth(boolean need) {
		System.out.println("设置smtp身份认证：mail.smtp.auth = " + need);
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
	}

	/**
	* 设置用户名和密码
	* @param name
	* @param pass
	*/
	public void setNamePass(String name, String pass) {
		username = name;
		password = pass;
	}

	/**
	* 设置邮件主题
	* @param mailSubject
	* @return
	*/
	public boolean setSubject(String mailSubject) {
		logger.info("设置邮件主题！");
		try {
			mimeMsg.setSubject(mailSubject);
			return true;
		} catch (Exception e) {
			logger.error("设置邮件主题发生错误！");
			return false;
		}
	}

	/**
	* 设置邮件正文
	* @param mailBody String
	*/
	public boolean setBody(String mailBody) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent("" + mailBody, "text/html;charset=GBK");
			mp.addBodyPart(bp);

			return true;
		} catch (Exception e) {
			logger.error("设置邮件正文时发生错误！" + e);
			return false;
		}
	}

	/**
	* 添加附件
	* @param filename String
	*/
	public boolean addFileAffix(String filename) {

		System.out.println("增加邮件附件：" + filename);
		try {
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());

			mp.addBodyPart(bp);

			return true;
		} catch (Exception e) {
			logger.error("增加邮件附件：" + filename + "发生错误！" + e);
			return false;
		}
	}

	/**
	* 设置发信人
	* @param from String
	*/
	public boolean setFrom(String from) {
		System.out.println("设置发信人！");
		try {
			mimeMsg.setFrom(new InternetAddress(from)); // 设置发信人
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	* 设置收信人
	* @param to String
	*/
	public boolean setTo(String to) {
		if (to == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	* 设置抄送人
	* @param copyto String 
	*/
	public boolean setCopyTo(String copyto) {
		if (copyto == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress.parse(copyto));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	* 发送邮件
	*/
	public boolean sendOut() {
		try {
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			logger.info("正在发送邮件....");

			Session mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username, password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			if (null != mimeMsg.getRecipients(Message.RecipientType.CC)) {
				transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
			}
			// 设置信件头的发送日期
			mimeMsg.setSentDate(new Date());
			// transport.send(mimeMsg);

			logger.info("发送邮件成功！");
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("邮件发送失败！" + e);
			return false;
		}
	}

	/**
	* 调用sendOut方法完成邮件发送
	* @param smtp
	* @param from
	* @param to
	* @param subject
	* @param content
	* @param username
	* @param password
	* @return boolean
	*/
	public static boolean send(String smtp, String from, String to, String subject, String content, String username,
			String password) {
		MailUtil theMail = new MailUtil(smtp);
		theMail.setNeedAuth(true); // 需要验证
		if (!theMail.setSubject(subject))
			return false;
		if (!theMail.setBody(content))
			return false;
		if (!theMail.setTo(to))
			return false;
		if (!theMail.setFrom(from))
			return false;
		theMail.setNamePass(username, password);
		if (!theMail.sendOut())
			return false;
		return true;
	}

	/**
	* 调用sendOut方法完成邮件发送,带抄送
	* @param smtp
	* @param from
	* @param to
	* @param copyto
	* @param subject
	* @param content
	* @param username
	* @param password
	* @return boolean
	*/
	public static boolean sendAndCc(String smtp, String from, String to, String copyto, String subject, String content,
			String username, String password) {
		MailUtil theMail = new MailUtil(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject))
			return false;
		if (!theMail.setBody(content))
			return false;
		if (!theMail.setTo(to))
			return false;
		if (!theMail.setCopyTo(copyto))
			return false;
		if (!theMail.setFrom(from))
			return false;
		theMail.setNamePass(username, password);

		if (!theMail.sendOut())
			return false;
		return true;
	}

	/**
	* 调用sendOut方法完成邮件发送,带附件
	* @param smtp
	* @param from
	* @param to
	* @param subject
	* @param content
	* @param username
	* @param password
	* @param filename 附件路径
	* @return
	*/
	public static boolean send(String smtp, String from, String to, String subject, String content, String username,
			String password, String filename) {
		MailUtil theMail = new MailUtil(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject))
			return false;
		if (!theMail.setBody(content))
			return false;
		if (!theMail.addFileAffix(filename))
			return false;
		if (!theMail.setTo(to))
			return false;
		if (!theMail.setFrom(from))
			return false;
		theMail.setNamePass(username, password);

		if (!theMail.sendOut())
			return false;
		return true;
	}

	/**
	* 调用sendOut方法完成邮件发送,带附件和抄送
	* @param smtp
	* @param from
	* @param to
	* @param copyto
	* @param subject
	* @param content
	* @param username
	* @param password
	* @param filename
	* @return
	*/
	public static boolean sendAndCc(String smtp, String from, String to, String copyto, String subject, String content,
			String username, String password, String filename) {
		MailUtil theMail = new MailUtil(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject))
			return false;
		if (!theMail.setBody(content))
			return false;
		// if(!theMail.addFileAffix(filename)) return false;
		if (!theMail.setTo(to))
			return false;

		if (StringUtils.isNotEmpty(copyto)) {
			if (!theMail.setCopyTo(copyto))
				return false;
		}

		// System.out.println("------");
		if (!theMail.setFrom(from))
			return false;
		theMail.setNamePass(username, password);
		if (!theMail.sendOut())
			return false;
		return true;
	}

	public static void main(String[] args) {
		String smtp = "smtp.163.com"; // "SMTP服务器";
		String from = "chenyong6301567@163.com"; // "发信人";
		String to = "629584407@qq.com"; // 收信人
		String subject = "你好你好你好"; // "邮件主题";
		String content = "www.hao123.com";// "邮件内容";
		String username = "chenyong6301567@163.com"; // "用户名";
		String password = "ccs13650833856";// "密码";
		send(smtp, from, to, subject, content, username, password);

	}

	/*
	 * public static void main(String[] args) { String smtp = "smtp.163.com"; //
	 * "SMTP服务器"; String from = "hotyum@163.com";// "发信人"; String to =
	 * "629584407@qq.com"; // 收信人 String copyto = "chenyong6301567@163.com";//
	 * "抄送人"; String subject = "這是我的测试邮件這是我的测试邮件這是我的测试邮件這是我的测试邮件"; // "邮件主题";
	 * String content = "這是我的测试邮件這是我的测试邮件這是我的测试邮件";// "邮件内容"; String username =
	 * "hotyum@163.com";// "用户名"; String password = "hyjt2017";// "密码"; String
	 * filename = "d:\\test.jpg";// "附件路径，如：d:\\test.jpg;
	 * MailUtil.sendAndCc(smtp, from, to, copyto, subject, content, username,
	 * password, filename); }
	 */

}
