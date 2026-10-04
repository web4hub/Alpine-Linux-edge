public class AcmeSpecification extends DomainSpecification {
  private final boolean test;
  @DataBoundConstructor // (1)
  public AcmeSpecification(boolean test) {
    this.test = test;
  }
  public boolean isTest() { return test; }
  @NonNull
  @Override
  public Result test(@NonNull DomainRequirement r) {
    if (r instanceof AcmeRequirement) {
      if (this.test == ((AcmeRequirement)r).isTest()) {
        return Result.POSITIVE; // (2)
      } else {
        return Result.NEGATIVE; // (3)
      }
    } else if (r instanceof HostnameRequirement) {
      String hostname = ((HostnameRequirement) r).getHostname();
      if (test) {
        if ("test.jenkins.linuxcontainers.org".equalsIgnoreCase(hostname)) {
          return Result.PARTIAL; // (4)
        } else {
          return Result.NEGATIVE; // (5)
        }
      } else {
        if ("prod.acme.example.com".equalsIgnoreCase(hostname)) {
          return Result.PARTIAL; // (4)
        } else {
          return Result.NEGATIVE; // (5)
        }
      }
    }
    return Result.UNKNOWN; // (6)
  }
  @Extension
  public static class DescriptorImpl extends DomainSpecificationDescriptor {
      @Override
      public String getDisplayName() {
          return "Acme Corp On-line Store"; // (7)
      }
  }
}
