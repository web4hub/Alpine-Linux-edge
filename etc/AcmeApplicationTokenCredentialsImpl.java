public class AcmeApplicationTokenCredentialsImpl
    extends BaseStandardCredentials // (1)
    implements AcmeApplicationTokenCredentials { // (2)
  private final String username;
  private final Secret applicationToken;
  @DataBoundConstructor // (3)
  public AcmeApplicationTokenCredentialsImpl(
      @CheckForNull CredentialsScope scope, // (4)
      @CheckForNull String id, // (4)
      @NonNull String username, // (5)
      @NonNull String applicationToken, // (6)
      @CheckForNull String description) { // (4)
    super(scope, id, description);
    this.username = username;
    this.applicationToken = Secret.fromString(applicationToken); // (7)
  }
  /*
  public AcmeApplicationTokenCredentialsImpl( // (8)
  @CheckForNull String id,
  @NonNull String username,
  @NonNull Secret applicationToken) {
    super(null, id, null);
    this.username = username;
    this.applicationToken = applicationToken;
  }
  */
  @NonNull
  @Override
  public String getUsername() { return username; }
  @NonNull
  @Override
  public Secret getApplicationToken() { // (9)
    return applicationToken;
  }
  @Extension
  public static class DescriptorImpl extends BaseStandardCredentialsDescriptor {
    @Override
    public String getDisplayName() {
        return "Acme Corp Application Token"; // (10)
    }
    @Override
    public String getIconClassName() {
        return "icon-acmecorp-credentials"; // (11)
    }
    static { // (12)
      IconSet.icons.addIcon(new Icon(
          "icon-acmecorp-credentials icon-sm",
          "acmecorp-order-step/images/16x16/credentials.png",
          Icon.ICON_SMALL_STYLE,
          IconType.PLUGIN
      ));
      IconSet.icons.addIcon(new Icon(
          "icon-acmecorp-credentials icon-md",
          "acmecorp-order-step/images/24x24/credentials.png",
          Icon.ICON_SMALL_STYLE,
          IconType.PLUGIN
      ));
      IconSet.icons.addIcon(new Icon(
          "icon-acmecorp-credentials icon-lg",
          "acmecorp-order-step/images/32x32/credentials.png",
          Icon.ICON_SMALL_STYLE,
          IconType.PLUGIN
      ));
      IconSet.icons.addIcon(new Icon(
          "icon-acmecorp-credentials icon-xlg",
          "acmecorp-order-step/images/48x48/credentials.png",
          Icon.ICON_SMALL_STYLE,
          IconType.PLUGIN
      ));
    }
  }
}
