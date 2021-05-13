package com.dongazul.myapp.mapper;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongazul.myapp.domain.ChatDTO;
import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@NoArgsConstructor

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
         "file:src/main/webapp/WEB-INF/spring/root-context.xml"
   })
public class MapperTests {

   
   @Autowired
   MemberMapper mapper;
   
   @Autowired
   ChatMapper mapper2;
   
   @Before
   public void setup() {
      log.debug("setup() invoked.");
 
   }
   
   
//   @Test(timeout=1000)
//   public void testProfile() throws Exception {
//      log.debug("testInsert() invoked.");
//      
//      ProfileDTO dto = 
//            new ProfileDTO();
//      
//      dto.setEmail("arr0998@naver.com");
//      dto.setNickname("김용석");
//      dto.setGender("M");
//      dto.setZone("33");
//      dto.setAge(20);
//      dto.setIntroduce("222222222222");
//      dto.setIname("야구");
//      mapper.insertProfile(dto);
//      mapper.insertInterests(dto);
//   
//      
//   }  // testInsert
   
   @Test
	public void testSelectUser() throws Exception {
		log.debug("testSelectUser() invoked.");
		
		LoginDTO dto = new LoginDTO();
		dto.setEmail("arr0998@naver.com");
		dto.setPasswd("123");
	
		
		MemberVO user = this.mapper.select(dto);
		
		Objects.requireNonNull(user);
		log.info("\t+ user: " + user);
	} // testSelectUser
   
   @Test
  	public void testInsertChatroom() throws Exception {
  		log.debug("testSelectUser() invoked.");
  		
  		ChatDTO dto = new ChatDTO();
  
  		dto.setEmail("arr0998@naver.com");
  		dto.setRoomname("함 들어오세요");
  		
  		this.mapper2.addChatroom(dto);
  		
  	
  		
  	} // testSelectUser
   
   @Test
 	public void testselectget() throws Exception {
 		log.debug("testSelectUser() invoked.");
 		
 		List<ChatDTO> list = this.mapper2.getChatroom();
 		
 		
 		list.forEach(log::info);
 	
 		
 	} // testSelectUser
   
   @Test
	public void testUpdateUserWithRememberMe() throws Exception {
		log.debug("testUpdateUserWithRememberMe() invoked.");
		
		String 	email = "arr0998@naver.com";
		String 	rememberme = "675B87099142DE651ED43EFF4C34D68B";
		Date	rememberage = new Date(); 
		
//		String 	rememberMe = null;
//		Date	rememberAge = null;
		
		int affectedLines = 
			this.
				mapper.
				updateMemberWithRememberMe(email, rememberme, rememberage);
		
		log.info("\t+ affectedLines: " + affectedLines);
	} // testUpdateUserWithRememberMe
   
   
   @After
   public void tearDown() {
      log.debug("tearDown() invoked.");
      
   } // tearDown
   
} // end class
 