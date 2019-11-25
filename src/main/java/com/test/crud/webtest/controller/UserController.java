package com.test.crud.webtest.controller;


import com.test.crud.webtest.entity.PageResult;
import com.test.crud.webtest.entity.Result;
import com.test.crud.webtest.entity.StatusCode;
import com.test.crud.webtest.pojo.User;
import com.test.crud.webtest.service.UserService;
import com.test.crud.webtest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;


	@RequestMapping(path = "/findAll2", method = RequestMethod.POST)
	public Result findAll2(@RequestBody Map<String, Object> params) {
		System.out.println(params);
		int page= (int) params.get("pagenum");
		int size= (int) params.get("pagesize");
		Map searchMap = new HashMap();
		searchMap.put("nickname", params.get("query"));
		searchMap.put("email", params.get("email"));
		searchMap.put("username", params.get("username"));

		Page<User> pageList = userService.findSearch(searchMap, page, size);

		return new Result(true, StatusCode.OK, "搜索查询ok" ,new PageResult<User>(pageList.getTotalElements(), pageList.getContent()));

	}
	//更改用户状态
	@RequestMapping(value="/user/{id}/{bo}",method=RequestMethod.PUT)
	public Result changeBo( @PathVariable String id, @PathVariable boolean bo){

		userService.updateBo(id,bo);

		return new Result(true, StatusCode.OK, "更改状态ok" );

	}

	//登陆
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody User user) {
		User login = userService.login(user);
		if (login != null) {

			String token = jwtUtil.createJWT(login.getId(), login.getNickname(), "user");
			//String token = jwtUtil.createJWT(login.getId(), login.getNickname(), "admin");
			Map<String, Object> map = new HashMap<>();
			map.put("token", token);
			map.put("role", "user");

			return new Result(true, StatusCode.OK, login.getNickname() + "user登陆ok", map);
		} else {
			return new Result(false, StatusCode.ERROR, "密码错误或用户未注册");

		}

	}


	// 分页findAllByPage

	@RequestMapping(value="/findAllByPage/{page}/{size}",method=RequestMethod.GET)
	public Result findAllByPage( @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findAllByPage(page, size);
		return  new Result(true,StatusCode.OK,"分页findAll查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}
	//findAll
	@RequestMapping(value = "/findAll",method= RequestMethod.GET)
	public Result findAll(){

		Map<String, Object> map23 = new HashMap<>();

		return new Result(true, StatusCode.OK,"查询成功",userService.findAll());
	}


	//findList  只用一张表手写的侧边栏数据
	@RequestMapping(value = "/findList",method= RequestMethod.GET)
	public Result findList(){



//        用户
		Map map = new HashMap();
		map.put("id",20 );
		map.put("name","用户信息" );
		map.put("path","user" );


		Map map2 = new HashMap();
		map2.put("id",21 );
		map2.put("name","用户信息2" );
		map2.put("path","user2" );
//  权利
        Map mapql1 = new HashMap();
        mapql1.put("id",20 );
        mapql1.put("name","权利1" );
        mapql1.put("path","power1" );


        Map mapql2 = new HashMap();
        mapql2.put("id",21 );
        mapql2.put("name","权利2" );
        mapql2.put("path","power2" );

//3
		Map map22 = new HashMap();
		map22.put("id1",map2 );
		map22.put("id2",map );


        Map mapql = new HashMap();
        mapql.put("id1",mapql2 );
        mapql.put("id2",mapql1 );


//22
		Map map11 = new HashMap();
		map11.put("id",10 );
		map11.put("name","用户管理" );
		map11.put("children",map22 );


		Map map112 = new HashMap();
		map112.put("id",11 );
		map112.put("name","用户权利" );
        map112.put("children",mapql );


//1

		Map map223 = new HashMap();
		map223.put("id",map112);
		map223.put("id1",map11 );



		return new Result(true, StatusCode.OK,"查询列表成功",map223);

	}

	//findById
	@RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",userService.findById(id));
	}



	 // 分页+多条件查询

	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	//条件查询
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",userService.findSearch(searchMap));
    }

	//add
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result add(@RequestBody User user  ){
		userService.add(user);
		return new Result(true,StatusCode.OK,"增加成功");
	}

	//update没用这个
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody User user, @PathVariable String id ){
		user.setId(id);

		userService.update(user);
		return new Result(true,StatusCode.OK,"修改成功");
	}

	//update用了
	@RequestMapping(value="/update",method= RequestMethod.PUT)
	public Result update(@RequestBody User user ){


		userService.updateUser(user);
		return new Result(true,StatusCode.OK,"修改成功");
	}

	//delete
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		userService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}



}
