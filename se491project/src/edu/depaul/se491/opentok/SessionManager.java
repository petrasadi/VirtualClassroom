package edu.depaul.se491.opentok;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.opentok.api.OpenTokSDK;
import com.opentok.api.constants.RoleConstants;
import com.opentok.exception.OpenTokException;

import edu.depaul.se491.josqlCmds.DaoCmds;

/**
 * Class designed to manage the OpenTok API session information for all classes/courses in progress.
 */
public class SessionManager {
	Map<Long, String> sessionData = new ConcurrentHashMap<Long, String>();
	
	/**
	 * Gets or generates the session info for a particular user
	 * in a particular class
	 * @param classId - a unique identifier for a class/course
	 * @param userOpenId - OpenId identifier of the user
	 * @return the session info serialized to json
	 */
	public String getSessionInfo(Long classId, String userOpenId){
		String sessionId = "";
		String userToken = "";
		String userRole = getUserRole(classId, userOpenId);
		if (sessionData.containsKey(classId)) {
			sessionId = sessionData.get(classId);
			userToken = generateOpenTokUserToken(sessionId, classId, userOpenId, userRole);
		} else {
			sessionId = generateOpenTokSessionId();
			sessionData.put(classId, sessionId);
			
			userToken = generateOpenTokUserToken(sessionId, classId, userOpenId, userRole);
		}
		
		OpenTokSessionInfo sessionInfo = new OpenTokSessionInfo();
		sessionInfo.setApiKey(OpenTok_API_Consts.API_KEY);
		sessionInfo.setSessionId(sessionId);
		sessionInfo.setToken(userToken);
		sessionInfo.setRole(userRole);
		
		String gson = new Gson().toJson(sessionInfo);
		return gson;
	}
	
	
	/**
	 * Generates an OpenTok session id. Used as a box for a particular class  
	 * @return the session id
	 */
	private String generateOpenTokSessionId() {
		OpenTokSDK sdk = new OpenTokSDK(OpenTok_API_Consts.API_KEY, OpenTok_API_Consts.API_SECRET);
		//Generate a basic session
		String sessionId = null;
		try {
			sessionId = sdk.create_session().getSessionId();
		} catch (OpenTokException e) {
			e.printStackTrace();
		}
		return sessionId;
	}
	
	/**
	 * Generates an OpenTok token. Used to identify a particular user in a particular class session
	 * @param sessionId - the session to be joined
	 * @param userRole 
	 * @return the token
	 */
	private String generateOpenTokUserToken(String sessionId, Long classId, String userOpenId, String userRole){
		OpenTokSDK sdk = new OpenTokSDK(OpenTok_API_Consts.API_KEY, OpenTok_API_Consts.API_SECRET);
		// Generate a token. Use the RoleConstants value appropriate for the user.
		String token = null;
		try {
			//FIXME - user token expiration
			String tokenRole = "";
			if (userRole.equals("teacher"))
				tokenRole = RoleConstants.MODERATOR;
			else
				//TODO - publisher role needed for raiseHand event- revise
				tokenRole = RoleConstants.PUBLISHER;
				
			token = sdk.generate_token(sessionId, tokenRole, null);
		} catch (OpenTokException e) {
			e.printStackTrace();
		}
		return token;
	}
	
	/**
	 * Returns the role of the OpenTok user based on the role in class (teacher, student).
	 * The if not student or teacher returns a default subscriber
	 * @param classId
	 * @param userOpenId
	 * @return
	 */
	private String getUserRole(Long classId, String userOpenId){
		if (DaoCmds.isTeacher(userOpenId, classId)){
			return "teacher";
		//TODO - uncomment this once student registration works
/*		} else if (DaoCmds.isStudent(userOpenId, classId)){
			return RoleConstants.PUBLISHER;*/
		} else
			return "student";
	}
}