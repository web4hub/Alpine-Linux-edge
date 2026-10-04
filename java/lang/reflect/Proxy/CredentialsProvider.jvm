public static class CredentialProxy implements Serializable, InvocationHandler {
  private final Map<String,Object> properties;
  private final String secretName;
  private final transient AcmeConnection connection;
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (args != null || args.length > 0) {
      return null; // (1)
    }
    String n = method.getName();
    if (n.startsWith("get")) {
      n = n.substring(3,4).toLowerCase() + n.substring(4);
    } else if (n.startsWith("is")) {
      n = n.substring(2,3).toLowerCase() + n.substring(3);
    } else {
      return null; // (1)
    }
    if (secretName.equals(n)) {
      if (connection != null) {
        return connection.getSecret(...);
      } else {
        throw new IOException("No connection"); // (2)
      }
    } else {
      return properties.get(n);
    }
  }
}
