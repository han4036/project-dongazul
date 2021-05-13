package com.dongazul.myapp.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@Log4j

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/*-context.xml",
	"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class ServiceTests {
	
	@Autowired
	private ProfileService service;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		assert service != null;
		log.info("\t+ service: " + service);
	} // setup
	
//	@Test
//	public void testGetList() throws Exception {
//		log.debug("testGetList() invoked.");
//		ProfileDTO profile = new ProfileDTO(
//				"arr0998@naver.com",
//				"용돌",
//				20,
//				"M",
//				"일산",
//				"안녕하세요", 
//				"독서"
//				);
//		this.service.craeteProfile(profile);
//				
//	} // testGetList
	
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
}
