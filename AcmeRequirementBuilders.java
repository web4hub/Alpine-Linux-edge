public static class AcmeRequirementBuilder {
  private boolean test;
  private AcmeRequirementBuilder() {} // (1)
  @NonNull
  public AcmeRequirementBuilder create() { // (1)
    return new AcmeRequirementBuilder();
  }
  @NonNull
  public AcmeRequirementBuilder withTestServer(boolean test) { // (1)
    this.test = test;
    return this;
  }
  @NonNull
  public List<DomainRequirement> build() {
    List<DomainRequirement> result = new ArrayList<>();
    result.add(new AcmeRequirement(test)); // (2)
    result.addAll(URIRequirementBuilder.create() // (3)
        .withUri(test
            ? "https://test.acme.example.com/"
            : "https://prod.acme.example.com/")
        .build();
    );
    return result;
  }
}
