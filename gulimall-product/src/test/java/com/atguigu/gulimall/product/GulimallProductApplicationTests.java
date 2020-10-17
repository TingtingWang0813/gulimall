package com.atguigu.gulimall.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests  {

	@Autowired
	BrandService brandService;

	@Autowired
	OSSClient ossClient;

	@Test
	public void testUpload() throws FileNotFoundException {
//		// Endpoint以杭州为例，其它Region请按实际情况填写。
//		String endpoint = "oss-us-west-1.aliyuncs.com";
//// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//		String accessKeyId = "LTAI4G3M41o8pBFa6HpUz1zx";
//		String accessKeySecret = "3ck58tlqsagj9SVTtUe5omweAswutx";
//
//// 创建OSSClient实例。
//		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
// 上传文件流。
		InputStream inputStream = new FileInputStream("/Users/wangtingting/Downloads/test.jpg");
		ossClient.putObject("gulimall-wangme", "test.jpg", inputStream);

// 关闭OSSClient。
		ossClient.shutdown();
		System.out.println("上传成功！！！");
	}


	@Test
	public void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("huawei shouji update");
////		brandEntity.setName("华为");
////		brandService.save(brandEntity);
////		System.out.println("save successfully");
//		brandService.updateById(brandEntity);
		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
		list.forEach(System.out::println);
	}

}
