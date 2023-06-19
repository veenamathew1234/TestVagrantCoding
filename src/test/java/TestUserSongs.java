import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestUserSongs {
	
	UserSongs us=new UserSongs();
	String user="";
	Map<String,List<String>> usersongpairs=null;
	// constructor to initialise values
	public TestUserSongs(){
	usersongpairs=new HashMap<String, List<String>>();
	usersongpairs.put("U1", Arrays.asList("S1","S2","S3","S4"));
	user="U1";
	}

@Test
	public void testUserSongsCompleteFlow() {
		us.manageUserSongs();
	}
@Test
	public void testRetrieveSongsForUser() {
		List<String> songs=new ArrayList<String>();
		int fl=0;
		//Check whether the user chosen is in the list
		Iterator<String> iterator = usersongpairs.keySet().iterator();
	    while (iterator.hasNext()) {
	        String key = iterator.next();
	        if(key.equalsIgnoreCase(user))
	        	fl=1;
	        	break;
	        
	    }
	    Assert.assertEquals("user not in the list", 1,fl);
		songs=us.retrieveSongsForUser(usersongpairs, user);
		Assert.assertEquals("Songs retrieved dont match",Arrays.asList("S1","S2","S3","S4"), songs);
	}


}
