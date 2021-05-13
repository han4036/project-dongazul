package com.dongazul.myapp.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongazul.myapp.domain.ProfileDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@Log4j

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/*-context.xml",
	"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class SampleTXServiceTests {
	
	@Setter(onMethod_={@Autowired})
	private ProfileService service;
	
	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.service != null;
		
		log.info("\t+ service: " + service);
	} // setup


	@Test
	public void testXXX() throws Exception {
		log.debug("testXXX() invoked.");
		ProfileDTO profile = new ProfileDTO();
		
		profile.setEmail("arr1234@naver.com");
		profile.setAge(23222222);
		profile.setGender("W");
		profile.setNickname("용돌");
		profile.setIntroduce("안녕하세요");
		profile.setZone("서울");
		profile.setHobby1("독서");
		profile.setHobby2("");
		profile.setHobby3("");
		
		this.service.craeteProfile(profile);
		
	} // testXXX
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
}
