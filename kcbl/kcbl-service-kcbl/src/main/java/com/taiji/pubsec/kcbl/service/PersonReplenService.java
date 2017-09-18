package com.taiji.pubsec.kcbl.service;

import java.util.List;

import com.taiji.pubsec.businesscomponent.organization.model.Person;
/**
 * 
 * @author xinfan
 *
 */
public interface PersonReplenService  {
	List<Person> findCheckManbyUnitIds(List<String> unitIds);
}
