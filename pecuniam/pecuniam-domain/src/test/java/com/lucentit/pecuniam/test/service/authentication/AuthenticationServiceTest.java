package com.lucentit.pecuniam.test.service.authentication;

import com.lucentit.pecuniam.domain.model.User;
import com.lucentit.pecuniam.domain.model.UserSession;
import com.lucentit.pecuniam.domain.repository.UserRepository;
import com.lucentit.pecuniam.domain.repository.UserSessionRepository;
import com.lucentit.pecuniam.domain.service.AuthenticationService;
import com.lucentit.pecuniam.domain.service.impl.AuthenticationServiceImpl;
import static junit.framework.TestCase.assertTrue;
import static org.jmock.AbstractExpectations.returnValue;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationServiceTest {
    private static final String VALID_USERNAME = "testUser";
    private static final String VALID_PASWD = "testPasswd";
    private static final String INVALID_USERNAME = "testUser";
    private static final String INVALID_PASWD = "testPasswd";
    
    private Mockery context;
    private UserRepository userRepoMock;
    private UserSessionRepository userSessionRepoMock;
    private AuthenticationService authService;
    private User user;
    private UserSession userSession;
   
    @Before    
    public void setUp() {
        context = new Mockery();
        userRepoMock = context.mock(UserRepository.class);
        userSessionRepoMock = context.mock(UserSessionRepository.class);
        authService = new AuthenticationServiceImpl(userRepoMock, userSessionRepoMock);        
        user = new User();
        userSession = new UserSession();
    }
    
    @Test
    public void isUserAuthenticatedSuccessTest() {
        context.checking(new Expectations() {{
            oneOf(userRepoMock).returnByUsernameAndPassword(VALID_USERNAME, VALID_PASWD);
            will(returnValue(user));
        }});
        context.checking(new Expectations() {{
            oneOf(userSessionRepoMock).returnActiveSession(user);
            will(returnValue(userSession));
        }});
        boolean isAuth = authService.isUserAuthenticated(VALID_USERNAME, VALID_PASWD);
        context.assertIsSatisfied();        
        assertTrue(isAuth);
    }
    
    @Test
    public void isUserAuthenticatedFailWithValidUserTest() {
        context.checking(new Expectations() {{
            oneOf(userRepoMock).returnByUsernameAndPassword(VALID_USERNAME, VALID_PASWD);
            will(returnValue(user));
        }});
        context.checking(new Expectations() {{
            oneOf(userSessionRepoMock).returnActiveSession(user);
            will(returnValue(null));
        }});
        boolean isAuth = authService.isUserAuthenticated(VALID_USERNAME, VALID_PASWD);
        context.assertIsSatisfied();
        assertTrue(!isAuth);
    }
    
    @Test
    public void isUserAuthenticatedFailWithInvalidUserTest() {
        context.checking(new Expectations() {{
            oneOf(userRepoMock).returnByUsernameAndPassword(INVALID_USERNAME, INVALID_PASWD);
            will(returnValue(null));
        }});        
        boolean isAuth = authService.isUserAuthenticated(INVALID_USERNAME, INVALID_PASWD);
        context.assertIsSatisfied();
        assertTrue(!isAuth);
    }
    
    @Test
    public void authenticationSuccessTest() {                
        context.checking(new Expectations() {{
            oneOf(userRepoMock).returnByUsernameAndPassword(VALID_USERNAME, VALID_PASWD);    
            will(returnValue(user));
        }});
        authService.authenticateUser(VALID_USERNAME, VALID_PASWD);
        context.assertIsSatisfied();
    }
    
    @Test
    public void authenticationFailTest() {
        context.checking(new Expectations() {{
            oneOf(userRepoMock).returnByUsernameAndPassword(INVALID_USERNAME, INVALID_PASWD);
            will(returnValue(null));
        }});
        authService.authenticateUser(INVALID_USERNAME, INVALID_PASWD);
        context.assertIsSatisfied();
    }
}
