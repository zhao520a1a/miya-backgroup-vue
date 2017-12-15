package com.miya;

import com.miya.domain.TbItem;
import com.miya.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringRunner.class)
@SpringBootTest
@RestController
@RequestMapping("/test")
@Slf4j
public class MiyaManageApplicationTests {


	@Autowired
	private ItemService IItemService;


	/*测试商品分页功能*/
	@Test
	public void testItem(){
		TbItem item = IItemService.getItemById(536563L);
		log.info("{}",item.toString());
	}


}
