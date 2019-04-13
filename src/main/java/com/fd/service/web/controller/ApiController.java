package com.fd.service.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		try {
			return Hc.upload("api/upload", Files.readAllBytes(Paths.get("g:/beiju.gif")), "file",
					"cdad0cf489d4cb90e933f1c6c4814ce3_r.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ccc";
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
