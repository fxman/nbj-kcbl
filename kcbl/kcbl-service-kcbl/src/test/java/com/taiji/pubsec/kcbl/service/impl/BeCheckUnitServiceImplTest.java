package com.taiji.pubsec.kcbl.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

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
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;
import com.taiji.pubsec.kcbl.service.BeCheckUnitService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional(rollbackFor=Exception.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,TransactionDbUnitTestExecutionListener.class })
public class BeCheckUnitServiceImplTest {
	
    @Resource
	private BeCheckUnitService beCheckUnitServiceImpl;
	
	@Test
	public void testFindBeCheckedUnitServiceById() {
		
		BeCheckedUnit tmpUnit = beCheckUnitServiceImpl.findBeCheckedUnitServiceById("1");
		
		System.out.println(tmpUnit.getDetailAddress());
	}

}
