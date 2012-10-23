package edu.depaul.se491.opentok;

import com.google.gson.Gson;
import com.opentok.api.OpenTokSDK;
import com.opentok.api.constants.RoleConstants;
import com.opentok.exception.OpenTokException;

public class OpenTokUtil {
	public String getSessionInfo(){
		OpenTokSessionInfo sessionInfo = generateOpenTokSessionInfo();
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
