package com.frandom;

import com.frandom.api.User;
import com.frandom.api.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: amrit
 * Date: 5/11/14
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChatInitiatorServlet extends HttpServlet {

    public static final String FB_USER_ID_PARAM = "fbUserID";
    public static final String FB_USER_NAME_PARAM = "fbUserName";
    public static final String FB_FRIENDS_ID_LIST_PARAM = "fbFriends";
    public static final String DISPLAY_NAME = "FRandom user";

    private SecureRandom random = new SecureRandom();
    private UserManager userManager = new UserManagerImpl();

    public String nextUserId() {
        return new BigInteger(130, random).toString(32);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException {

        String fbUserID = request.getParameter(FB_USER_ID_PARAM);
        String fbUserName = request.getParameter(FB_USER_NAME_PARAM);
        String [] fbFriends = request.getParameterValues(FB_FRIENDS_ID_LIST_PARAM);
        Set<String> friendsIDs = new HashSet<String>();
        Set<String> fbFriendIDs = new HashSet<String>();
        boolean error = true;
        if (fbUserID != null && fbUserName != null) {
            error = false;
            if (fbFriends != null) {
                for (String fbID : fbFriends) {
                    friendsIDs.add(userManager.getUserByFbID(fbID).getID());
                    fbFriendIDs.add(fbID);
                }
            }
            User user = new UserImpl(DISPLAY_NAME, fbUserName, nextUserId(), fbUserID, "", friendsIDs, fbFriendIDs);
            userManager.addOnlineUser(user);
        }
        response.setContentType("text/html");
        try {
            PrintWriter out = response.getWriter();

            if (!error) {
                out.println(fbUserID);
            } else {
                out.println("Error : Data Insufficient");
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
