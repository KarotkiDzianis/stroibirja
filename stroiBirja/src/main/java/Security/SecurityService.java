package Security;

public interface SecurityService {
String findLoggedInOrgName();
void autoLogin (String name, String password);
}
