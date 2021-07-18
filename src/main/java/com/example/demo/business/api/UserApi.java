package com.example.demo.business.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


public interface UserApi {


	@GetMapping(path="/users")
	public @ResponseBody String getRole(@RequestParam("username") String username) ;
}
