package cyTest;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xerial.snappy.Snappy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Files;
import com.hotyum.stars.SpringBootMain;
import com.hotyum.stars.biz.manager.NoticeManager;
import com.hotyum.stars.biz.manager.PersonDocumentManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.NoticeVO;
import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.DateUtil;

/**
 * @author cy
 * @Description 
 * @date 2018年1月7日下午2:39:41 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CyTest {

	@Autowired
	private UserManager userManager;

	@Autowired
	private NoticeManager registerNoticeManager;

	@Autowired
	private PersonDocumentManager personDocumentManager;

	@Test
	public void testLogin() {
		TokenInfoVO tokenInfoVO = userManager.login("15700191306", "123456", "", 2);
		System.out.println(JSON.toJSONString(tokenInfoVO) + "'=========================");

	}

	/*
	 * public static void main(String[] args) { // String readLine =
	 * "2017-03-29 10:46:55"; String readLine =
	 * "缪佳旗舰店:布偶猫(2017-03-31 23:53:26): [卡片]"; String readLine2 =
	 * "缪佳旗舰店:蓝猫(2017-03-29 10:46:55):  亲 买一送一是需要专区内单笔拍下两件及两件以上不同款，收到无需退换后，五星评价联系在线客服退订单内最低金额那件（注：1.主图没有显示买一送一的款式不参加此活动。2.同款不参加此活动。3.买一送一不可使用优惠券及任何其他优惠）专区传送门：https://meidian.play.m.jaeapp.com/?iid=344416&cpp=0亲 您先看下规则哦"
	 * ; Pattern patternDate = Pattern.compile(
	 * "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))"
	 * );
	 * 
	 * Matcher matcher = patternDate.matcher(readLine); if (matcher.find()) {
	 * System.out.println("================================"); }
	 * 
	 * }
	 */

	public static void main(String[] args) throws IOException {
		byte[] contents = Files.toByteArray(new File("C:\\Users\\Administrator\\Desktop\\test2.snappy"));
		String content = new String(Snappy.uncompress(contents), "utf-8");
		System.out.println(content);
		String[] str = content.split("\n");
		for (int i = 0; i < str.length; i++) {
			JSONObject jsonObject = JSONObject.parseObject(str[i]);
			String message = jsonObject.getString("message");
			System.out.println("消息=" + message);
			JSONObject jsonMessage = JSONObject.parseObject(message);
			// 聊天时间
			String msgTime = jsonMessage.getString("svrtime");
			System.out.println("聊天时间===" + DateUtil.parseDate(Long.valueOf(msgTime)));

			String extendInfo = jsonMessage.getString("extinfo");
			JSONObject jsonOtherInfo = JSONObject.parseObject(extendInfo);
			String otherInfo = jsonOtherInfo.getString("others");
			// System.out.println(otherInfo);
			OtherInfo info = JSON.parseObject(otherInfo, OtherInfo.class);
			System.out.println("发送人====" + info.getRealFromId() + "=============接收人=" + info.getRealToId());
			JSONArray jsonArray = JSONArray.parseArray(jsonMessage.getString("msgbody"));
			JSONObject jsonContent = jsonObject.parseObject(jsonArray.getString(0));
			String msg = jsonContent.getString("value");
			System.out.println(msg);

			// 根据cid来区分买家还是卖家
			String cidStr = jsonMessage.getString("cid");
			CustomerDto customerDto = JSON.parseObject(cidStr, CustomerDto.class);
			if (info.getRealFromId().contains(customerDto.getNick())) {
				System.out.println("这个是买家===" + info.getRealFromId());
			} else {
				System.out.println("买家是====" + info.getRealToId());
			}

		}

	}

	static class OtherInfo implements Serializable {
		private static final long serialVersionUID = 1L;
		private String realFromId;
		private String realToId;

		public String getRealFromId() {
			return realFromId;
		}

		public void setRealFromId(String realFromId) {
			this.realFromId = realFromId;
		}

		public String getRealToId() {
			return realToId;
		}

		public void setRealToId(String realToId) {
			this.realToId = realToId;
		}

	}

	static class CustomerDto implements Serializable {
		private static final long serialVersionUID = 1L;
		private String nick;
		private String display;
		private String appkey;
		private String portrait;
		private int type;
		private int status;

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public String getDisplay() {
			return display;
		}

		public void setDisplay(String display) {
			this.display = display;
		}

		public String getAppkey() {
			return appkey;
		}

		public void setAppkey(String appkey) {
			this.appkey = appkey;
		}

		public String getPortrait() {
			return portrait;
		}

		public void setPortrait(String portrait) {
			this.portrait = portrait;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

	@Test
	public void test() {
		List<NoticeVO> noticeVOList = registerNoticeManager.getNoticeByUserId(3);
		System.out.println(JSON.toJSONString(noticeVOList));
	}

	@Test
	public void getMaxIndexByUserId() {
		Integer index = personDocumentManager.getMaxIndexByUserId(5);
		System.out.println(index);
	}

	@Test
	public void getuser() {
		User user = userManager.getUserByPhone("18668440650");
		System.out.println(user.toString());
	}

}
