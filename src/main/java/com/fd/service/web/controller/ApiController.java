package com.fd.service.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fd.microSevice.helper.Hc;
import com.fd.service.web.controller.base.BaseController;

/**
 * 对外开放接口
 * 
 * @author 符冬
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {
	@RequestMapping("/helloworld")
	public String helloworld() {
		/**
		 * 调用内部微服务
		 */
		return Hc.get("home/hello");
	}

	@RequestMapping("/saveuser")
	public String saveuser(String username) {
		return Hc.postForm("home/saveUser", new String[] { "username", username });
	}

	@RequestMapping("/saveorder")
	public String saveorder(String orderNo, String username) {
		return Hc.postForm("home/saveOrder", new String[] { "username", username, "orderNo", orderNo });
	}

	@RequestMapping("/getusername")
	public String getusername() {
		return Hc.postForm("home/getusername");
	}
}
