package edu.depaul.se491.opentok;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.opentok.api.OpenTokSDK;
import com.opentok.api.constants.RoleConstants;
import com.opentok.exception.OpenTokException;

/**
 * @author petrasadi
 * Class designed to manage the OpenTok API session information for all classes in progress.
 */
public class SessionManager {
	//TODO - move sessionData to persistent storage?
	Map<String, OpenTokSessionInfo> sessionData = new ConcurrentHashMap<String, OpenTokSessionInfo>();

	public String getSessionInfo(String classId){
		OpenTokSessionInfo sessionInfo = null;
		if (sessionData.containsKey(classId))
			sessionInfo = sessionData.get(classId);
		else {
			sessionInfo = generateOpenTokSessionInfo();
			sessionData.put(classId, sessionInfo);
		}
		String gson = new Gson().toJson(sessionInfo);
		return gson;
	}

	private OpenTokSessionInfo generateOpenTokSessionInfo(){
		OpenTokSDK sdk = new OpenTokSDK(OpenTok_API_Consts.API_KEY, OpenTok_API_Consts.API_SECRET);

		//Generate a basic session
		String sessionId = null;
		try {
			sessionId = sdk.create_session().getSessionId();
		} catch (OpenTokException e) {
			e.printStackTrace();
		}

		// Generate a token. Use the RoleConstants value appropriate for the user.
		String token = null;
		try {
			token = sdk.generate_token(sessionId, RoleConstants.PUBLISHER, null);
		} catch (OpenTokException e) {
			e.printStackTrace();
		}

		OpenTokSessionInfo sessionInfo = new OpenTokSessionInfo();
		sessionInfo.setApiKey(OpenTok_API_Consts.API_KEY);
		sessionInfo.setSessionId(sessionId);
		sessionInfo.setToken(token);

		return sessionInfo;

	}
}
