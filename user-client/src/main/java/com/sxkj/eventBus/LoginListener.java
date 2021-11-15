package com.sxkj.eventBus;

/*

*/
/**
 * 事件监听
 *//*

@Component
public class LoginListener {
	// 异步方法
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void orderTel(LoginEvent loginEvent) {
        ThreadUtil.sleep(3000L);
        System.out.println("接收到登录消息++发送短信，telePhone="
                + loginEvent.getTelePhone() + ", goodsName=" + loginEvent.getGoodsName()  
				+ "== " + LocalDateTime.now());
    }
}
*/
