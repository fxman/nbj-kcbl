package com.taiji.pubsec.kcbl.service.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.model.CheckDetailResult;
import com.taiji.pubsec.kcbl.service.BlglService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional(rollbackFor=Exception.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,TransactionDbUnitTestExecutionListener.class })
public class BlglServiceImplTest {
	
    @Resource
	private BlglService BlglServiceImpl;
	
	@Test
	public void testfindBlxxList() throws ParseException {
//		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//		String ksTime = "";
//		String jsTime = "";
//		List<BlxxModel>  list = BlglServiceImpl.findBlxxList("","","", ksTime, jsTime);
//			BlxxModel blxx = (BlxxModel)list.get(0);
//			System.out.println(blxx.getPartyname());
	}
	@Test
	public void test1(){
		//List<BlxxModel> list=BlglServiceImpl.findAllBlxxList();
		//System.out.println(list.get(0).getPartyname());
	}
	@Test
	public void test2(){
		BlxxModel blxx=BlglServiceImpl.findBlxxById("1");
		System.out.println(blxx.getCheckcontents());
	}
	@Test
	public void test3(){
		
	}

}
